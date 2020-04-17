package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Double} type.
 * @see ValueProperty
 */
public class DoubleProperty extends ValueProperty<Double> {

	public DoubleProperty(Double initialValue, boolean readable, boolean writeable) {
		super(Double.class, initialValue, readable, writeable);
	}

	public DoubleProperty(Double initialValue, boolean accessible) {
		super(Double.class, initialValue, accessible);
	}

	public DoubleProperty(Double initialValue) {
		super(Double.class, initialValue);
	}

}
