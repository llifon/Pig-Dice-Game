package com.llifon.pigdice;

/**
 * A null-able wrapper which allows the presence of values to be checked
 * before consumption.

 */
public class Nullable<T> {

    /**
     * The value being stored.
     */
    private final T value;

    /**
     * A flag indicating whether or not
     * the value this object contains
     * has an actual value or is null.
     */
    private final boolean hasValue;

    /**
     * Constructs a null-able object which a value
     * and a flag indicating whether or not the value
     * is null.
     *
     * @param value The value to store.
     * @param hasValue A flag indicating if the value is null or not.
     */
    public Nullable(T value, boolean hasValue)
    {
        this.value = value;
        this.hasValue = hasValue;
    }

    /**
     * @return true if a real value is enclosed; otherwise false.
     */
    public boolean hasValue()
    {
        return this.hasValue;
    }

    /**
     * @return The value being checked for.
     */
    public T value()
    {
        return this.value;
    }
}
