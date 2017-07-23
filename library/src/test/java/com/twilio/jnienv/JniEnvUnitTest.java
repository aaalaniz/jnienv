package com.twilio.jnienv;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JniEnvUnitTest {
    @Mock Context context;

    @Test(expected = RuntimeException.class)
    public void noInstancesAllowed() {
        new JniEnv();
    }

    @Test(expected = NullPointerException.class)
    public void set_shouldFailWithNullContext() {
        JniEnv.set(null, "FOO", "BAR", false);
    }

    @Test(expected = NullPointerException.class)
    public void set_shouldFailWithNullName() {
        JniEnv.set(context, null, "BAR", false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_shouldFailWithEmptyName() {
        JniEnv.set(context, "", "BAR", false);
    }

    @Test(expected = NullPointerException.class)
    public void set_shouldFailWithNullValue() {
        JniEnv.set(context, "FOO", null, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_shouldFailWithEmptyValue() {
        JniEnv.set(context, "FOO", "", false);
    }

    @Test(expected = NullPointerException.class)
    public void get_shouldFailWithNullContext() {
        JniEnv.get(null, "FOO");
    }

    @Test(expected = NullPointerException.class)
    public void get_shouldFailWithNullName() {
        JniEnv.get(context, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_shouldFailWithEmptyName() {
        JniEnv.get(context, "");
    }
}
