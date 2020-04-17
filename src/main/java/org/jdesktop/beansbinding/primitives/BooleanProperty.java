package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Boolean} type.
 * @see ValueProperty
 */
public class BooleanProperty extends ValueProperty<Boolean> {

	public BooleanProperty(Boolean initialValue, boolean readable, boolean writeable) {
		super(Boolean.class, initialValue, readable, writeable);
	}

	public BooleanProperty(Boolean initialValue, boolean accessible) {
		super(Boolean.class, initialValue, accessible);
	}

	public BooleanProperty(Boolean initialValue) {
		super(Boolean.class, initialValue);
	}

}
