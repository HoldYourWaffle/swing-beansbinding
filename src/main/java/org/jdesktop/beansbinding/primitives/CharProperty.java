package org.jdesktop.beansbinding.primitives;

import org.jdesktop.beansbinding.ValueProperty;

/**
 * Represents a basic {@link ValueProperty} with a {@code Character} type.
 * @see ValueProperty
 */
public class CharProperty extends ValueProperty<Character> {

	public CharProperty(Character initialValue, boolean readable, boolean writeable) {
		super(Character.class, initialValue, readable, writeable);
	}

	public CharProperty(Character initialValue, boolean accessible) {
		super(Character.class, initialValue, accessible);
	}

	public CharProperty(Character initialValue) {
		super(Character.class, initialValue);
	}

}
