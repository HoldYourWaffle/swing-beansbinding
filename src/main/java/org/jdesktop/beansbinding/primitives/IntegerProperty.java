package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Integer} type.
 * @see ValueProperty
 */
public class IntegerProperty extends ValueProperty<Integer> {

	public IntegerProperty(Integer initialValue, boolean readable, boolean writeable) {
		super(Integer.class, initialValue, readable, writeable);
	}

	public IntegerProperty(Integer initialValue, boolean accessible) {
		super(Integer.class, initialValue, accessible);
	}

	public IntegerProperty(Integer initialValue) {
		super(Integer.class, initialValue);
	}

}
