package com.catan.democatanserver.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import static java.util.Collections.shuffle;

public class ShuffledAccessor<T> implements Iterable<T> {

    int[] shuffledIndices;
    T[] original;

    public ShuffledAccessor(T[] array) {

        original = array;
        shuffledIndices = new int[array.length];
        for (int i = 0; i < array.length; i++)
            shuffledIndices[i] = i;
        for (int i = 0; i < array.length; i++) {
            int j = i + ((int) (Math.random() * (array.length - i)));
            int temp = shuffledIndices[i];
            shuffledIndices[i] = shuffledIndices[j];
            shuffledIndices[j] = temp;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < shuffledIndices.length;
            }

            @Override
            public T next() {
                return original[shuffledIndices[i++]];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (Integer i : shuffledIndices)
            action.accept(original[i]);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    public static <E> ShuffledAccessor<E> of(E[] array) {
        return new ShuffledAccessor<>(array);
    }

}
