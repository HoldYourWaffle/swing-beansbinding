package org.jdesktop.beansbinding;

import org.jdesktop.beansbinding.primitives.*;

/**
 * A {@link org.jdesktop.beansbinding.Property Property} that's {@link MutableProperty mutable}, {@link org.jdesktop.beansbinding.SourcelessProperty sourceless}
 * and contains a single value.
 *
 * @param <T> the type of the value stored in this property
 *
 * @see MutableProperty
 * @see SourcelessProperty
 * @see PropertyHelper
 *
 * @see BooleanProperty
 * @see ByteProperty
 * @see CharProperty
 * @see DoubleProperty
 * @see FloatProperty
 * @see IntegerProperty
 * @see LongProperty
 * @see ShortProperty
 * @see StringProperty
 *
 * @author Rafaël van Rooijen
 */
public class ValueProperty<T> extends MutableProperty<T> {

	private T value;
	private final Class<? extends T> clazz;

	public ValueProperty(Class<? extends T> clazz, T initialValue, boolean readable, boolean writeable) {
		super(readable, writeable);
		this.value = initialValue;
		this.clazz = clazz;
	}

	public ValueProperty(Class<? extends T> clazz, T initialValue, boolean accessible) {
		this(clazz, initialValue, accessible, accessible);
	}

	public ValueProperty(Class<? extends T> clazz, T initialValue) {
		this(clazz, initialValue, true);
	}


	@Override
	public T get() {
		return value;
	}

	@Override
	public void set(T value) {
		this.value = value;
	}


	@Override
	public Class<? extends T> getWriteType() {
		return clazz;
	}

}
