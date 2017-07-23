package com.twilio.jnienv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.getkeepsafe.relinker.ReLinker;

public class JniEnv {
    private static final String LIBRARY_NAME = "jnienv";

    public static void set(@NonNull Context context,
                           @NonNull String name,
                           @NonNull String value,
                           boolean overwrite) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(name, "Name must not be null");
        Preconditions.checkArgument(!name.isEmpty(), "Name must not be empty");
        Preconditions.checkNotNull(value, "Value must not be null");
        Preconditions.checkArgument(!value.isEmpty(), "Value must not be empty");

        ReLinker.loadLibrary(context, LIBRARY_NAME);
        nativeSet(name, value, overwrite);
    }

    public static String get(@NonNull Context context, @NonNull String name) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(name, "Name must not be null");
        Preconditions.checkArgument(!name.isEmpty(), "Name must not be empty");

        ReLinker.loadLibrary(context, LIBRARY_NAME);
        return nativeGet(name);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    JniEnv() {
        throw new RuntimeException("No instances of JniEnv allowed");
    }

    static native void nativeSet(String name, String value, boolean overwrite);
    static native String nativeGet(String name);
}
