package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Long} type.
 * @see ValueProperty
 */
public class LongProperty extends ValueProperty<Long> {

	public LongProperty(Long initialValue, boolean readable, boolean writeable) {
		super(Long.class, initialValue, readable, writeable);
	}

	public LongProperty(Long initialValue, boolean accessible) {
		super(Long.class, initialValue, accessible);
	}

	public LongProperty(Long initialValue) {
		super(Long.class, initialValue);
	}

}
