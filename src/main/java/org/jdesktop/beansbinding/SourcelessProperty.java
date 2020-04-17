package org.jdesktop.beansbinding;

/**
 * Base class for {@link Property Properties} that contain their own value,
 * rather than serving as an 'accessor' (i.e. a {@code Void} source type).
 * <p>
 * This base class implements all methods that are provided a ({@code Void}) {@code source}
 * parameter and delegates them to new (abstract) parameter-less equivalents.
 *
 * @param <T> the type of value that this {@link Property} represents
 *
 * @see ValueProperty
 * @see MutableProperty
 * @see PropertyHelper
 *
 * @author Rafaël van Rooijen
 */
public abstract class SourcelessProperty<T> extends PropertyHelper<Void, T> {

	@Override
	public final T getValue(Void source) {
		return getValue();
	}

	/** Parameter-less wrapper for {@link #getValue(Void)}*/
	public abstract T getValue();


	@Override
	public final void setValue(Void source, T value) {
		setValue(value);
	}

	/** Parameter-less wrapper for {@link #setValue(Void, T)}*/
	public abstract void setValue(T value);


	@Override
	public final boolean isReadable(Void source) {
		return isReadable();
	}

	/** Parameter-less wrapper for {@link #isReadable(Void)}*/
	public abstract boolean isReadable();


	@Override
	public final boolean isWriteable(Void source) {
		return isWriteable();
	}

	/** Parameter-less wrapper for {@link #isWriteable(Void)}*/
	public abstract boolean isWriteable();


	@Override
	public final Class<? extends T> getWriteType(Void source) {
		return getWriteType();
	}

	/** Parameter-less wrapper for {@link #getWriteType(Void)}*/
	public abstract Class<? extends T> getWriteType();

}
