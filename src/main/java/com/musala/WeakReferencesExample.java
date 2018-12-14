package com.musala;

import java.lang.ref.WeakReference;

public class WeakReferencesExample {

    public static void main(String[] args) {

        WeakReference<StringBuilder> ref = new WeakReference<>(new StringBuilder());

        ref.get().append("hello");
        System.gc();

        System.out.println(ref.get());
    }
}
