package org.jdesktop.beansbinding;

/**
 * Base class for a mutable {@link SourcelessProperty sourceless} {@link Property}.
 * Wraps the {@link #getValue()} and {@link #setValue(T)} methods with a check for
 * {@link #readable} and {@link #writeable} (respectively).
 * <p>
 * Naturally the {@link #isReadable()} and {@link #isWriteable()} methods
 * are implemented as well.
 *
 * @param <T> the type of value that this {@link Property} represents
 *
 * @see ValueProperty
 * @see SourcelessProperty
 * @see PropertyHelper
 *
 * @author Rafaël van Rooijen
 */
public abstract class MutableProperty<T> extends SourcelessProperty<T> {

	protected boolean readable, writeable;

	public MutableProperty(boolean readable, boolean writeable) {
		this.readable = readable;
		this.writeable = writeable;
	}

	public MutableProperty() {
		this(true, true);
	}


	@Override
	public final T getValue() {
		if (!readable) {
			throw new UnsupportedOperationException("Unreadable");
		}
		return get();
	}
	protected abstract T get();


	@Override
	public final void setValue(T value) {
		if (!writeable) {
			throw new UnsupportedOperationException("Unwriteable");
		}
		set(value);
	}
	protected abstract void set(T value);


	@Override
	public boolean isReadable() {
		return readable;
	}

	@Override
	public boolean isWriteable() {
		return writeable;
	}

}
