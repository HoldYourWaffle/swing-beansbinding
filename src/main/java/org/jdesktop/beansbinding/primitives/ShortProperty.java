package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Short} type.
 * @see ValueProperty
 */
public class ShortProperty extends ValueProperty<Short> {

	public ShortProperty(Short initialValue, boolean readable, boolean writeable) {
		super(Short.class, initialValue, readable, writeable);
	}

	public ShortProperty(Short initialValue, boolean accessible) {
		super(Short.class, initialValue, accessible);
	}

	public ShortProperty(Short initialValue) {
		super(Short.class, initialValue);
	}

}
