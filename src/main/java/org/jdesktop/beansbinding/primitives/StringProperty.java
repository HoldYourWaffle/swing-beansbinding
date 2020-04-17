package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code String} type.
 * @see ValueProperty
 */
public class StringProperty extends ValueProperty<String> {

	public StringProperty(String initialValue, boolean readable, boolean writeable) {
		super(String.class, initialValue, readable, writeable);
	}

	public StringProperty(String initialValue, boolean accessible) {
		super(String.class, initialValue, accessible);
	}

	public StringProperty(String initialValue) {
		super(String.class, initialValue);
	}

}
