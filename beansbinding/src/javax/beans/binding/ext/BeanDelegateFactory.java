/*
 * Copyright (C) 2006-2007 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 */

package javax.beans.binding.ext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * {@code BeanDelegateFactory} is a factory used to look up property
 * delegates. See {@code BeanDelegateProvider} for details.
 * 
 * 
 * 
 * @author sky
 * @see BeanDelegateProvider
 */
public final class BeanDelegateFactory {
    private static final BeanDelegateFactory INSTANCE =
            new BeanDelegateFactory(null);
    private final Map<Object, List<VendedDelegate>> vendedDelegates;
    private final List<BeanDelegateProvider> providers;
    private final Set<ClassLoader> classLoaders;
    private final Set<URL> serviceURLs;
    private boolean providedInConstructor;
    
    /**
     * Returns the property delegate for the specified object and property.
     *
     * @param source the object to return the property delegate for
     * @param property the property
     * @return the property delegate for the specified object and property pair,
     *         or {@code null} if a property delegate does not exist for the
     *         specified pair
     * @throws IllegalArgumentException if either argument is {@code null}
     */
    public static Object getPropertyDelegate(Object source, String property) {
        return INSTANCE.getPropertyDelegate0(source, property);
    }
    
    /**
     * Returns a {@code List} of the classes of the property delegates for
     * the specified class. If no delegates exist, an empty {@code List} is
     * returned.
     *
     * @param type the class to return the property delegate class of
     * @return a list of types of property delegates for the specified class
     *
     * @throws IllegalArgumentException if {@code type} is {@code null}
     */
    public static List<Class<?>> getPropertyDelegateClass(Class<?> type) {
        return INSTANCE.getPropertyDelegateClass0(type);
    }

    public BeanDelegateFactory(List<BeanDelegateProvider> providers) {
        if (providers == null) {
            providedInConstructor = false;
            this.providers = new ArrayList<BeanDelegateProvider>();
            classLoaders = new HashSet<ClassLoader>();
            serviceURLs = new HashSet<URL>();
        } else {
            providedInConstructor = true;
            classLoaders = null;
            serviceURLs = null;
            this.providers = providers;
        }

        vendedDelegates = new WeakHashMap<Object, List<VendedDelegate>>();
    }
    
    private void loadProvidersIfNecessary() {
        if (providedInConstructor) {
            return;
        }

        ClassLoader currentLoader = Thread.currentThread().getContextClassLoader();
        if (!classLoaders.contains(currentLoader)) {
            classLoaders.add(currentLoader);
            loadProviders(currentLoader);
        }
    }
    
    private void loadProviders(ClassLoader classLoader) {
        // PENDING: this needs to be rewriten in terms of ServiceLoader
        String serviceName = "META-INF/services/" + 
                BeanDelegateProvider.class.getName();
        try {
            Enumeration<URL> urls = classLoader.getResources(serviceName);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (!serviceURLs.contains(url)) {
                    serviceURLs.add(url);
                    addProviders(url);
                }
            }
        } catch (IOException ex) {
        }
    }
    
    private void addProviders(URL url) {
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = url.openStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    providers.add((BeanDelegateProvider)Class.forName(line).newInstance());
                } catch (IllegalAccessException ex) {
                } catch (InstantiationException ex) {
                } catch (ClassNotFoundException ex) {
                }
            }
        } catch (UnsupportedEncodingException ex) {
        } catch (IOException ex) {
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ex) {
            }
        }
    }
    
    public Object getPropertyDelegate0(Object source, String property) {
        if (source == null || property == null) {
            throw new IllegalArgumentException();
        }
        loadProvidersIfNecessary();
        property = property.intern();
        BeanDelegateProvider provider = getProvider(source, property);
        if (provider != null) {
            List<VendedDelegate> delegates = vendedDelegates.get(source);
            if (delegates != null) {
                for (int i = delegates.size() - 1; i >= 0; i--) {
                    VendedDelegate vendedDelegate = delegates.get(i);
                    Object delegate = vendedDelegate.getDelegate();
                    if (delegate == null) {
                        vendedDelegates.remove(i);
                    } else if (vendedDelegate.getProvider() == provider && vendedDelegate.getProperty() == property) {
                        return delegate;
                    }
                }
            } else {
                delegates = new ArrayList<VendedDelegate>(1);
                vendedDelegates.put(source, delegates);
            }
            Object delegate = provider.createPropertyDelegate(source, property);
            delegates.add(new VendedDelegate(property, provider, delegate));
            return delegate;
        }
        return null;
    }
    
    private BeanDelegateProvider getProvider(Object source, String property) {
        Class<?> type = source.getClass();
        for (BeanDelegateProvider provider : providers) {
            if (provider.providesDelegate(type, property)) {
                return provider;
            }
        }
        return null;
    }
    
    private List<Class<?>> getPropertyDelegateClass0(Class<?> type) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Type must be non-null");
        }
        loadProvidersIfNecessary();
        List<Class<?>> pdTypes = null;
        for (BeanDelegateProvider provider : providers) {
            Class<?> pdType = provider.getPropertyDelegateClass(type);
            if (pdType != null) {
                if (pdTypes == null) {
                    pdTypes = new ArrayList<Class<?>>(1);
                }
                pdTypes.add(pdType);
            }
        }
        if (pdTypes == null) {
            pdTypes = Collections.emptyList();
        }
        return pdTypes;
    }

    
    
    private static final class VendedDelegate {
        private final BeanDelegateProvider provider;
        private final String property;
        private final WeakReference<Object> delegate;

        public VendedDelegate(String property, BeanDelegateProvider provider, Object delegate) {
            this.property = property;
            this.delegate = new WeakReference<Object>(delegate);
            this.provider = provider;
        }

        public Object getDelegate() {
            return delegate.get();
        }

        public String getProperty() {
            return property;
        }
        
        public BeanDelegateProvider getProvider() {
            return provider;
        }
    }

}