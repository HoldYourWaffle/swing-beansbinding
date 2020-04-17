package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Byte} type.
 * @see ValueProperty
 */
public class ByteProperty extends ValueProperty<Byte> {

	public ByteProperty(Byte initialValue, boolean readable, boolean writeable) {
		super(Byte.class, initialValue, readable, writeable);
	}

	public ByteProperty(Byte initialValue, boolean accessible) {
		super(Byte.class, initialValue, accessible);
	}

	public ByteProperty(Byte initialValue) {
		super(Byte.class, initialValue);
	}

}
