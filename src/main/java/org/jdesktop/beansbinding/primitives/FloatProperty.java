package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Float} type.
 * @see ValueProperty
 */
public class FloatProperty extends ValueProperty<Float> {

	public FloatProperty(Float initialValue, boolean readable, boolean writeable) {
		super(Float.class, initialValue, readable, writeable);
	}

	public FloatProperty(Float initialValue, boolean accessible) {
		super(Float.class, initialValue, accessible);
	}

	public FloatProperty(Float initialValue) {
		super(Float.class, initialValue);
	}

}
