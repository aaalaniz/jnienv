package com.twilio.jnienv;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class JniEnvTest {
    String DUMMY_ENV_KEY = "DUMMY_ENV";
    String DUMMY_ENV_VALUE1 = "DUMMY_ENV_VALUE1";
    String DUMMY_ENV_VALUE2 = "DUMMY_ENV_VALUE2";

    @Test
    public void shouldSetEnvVariable() {
        JniEnv.set(InstrumentationRegistry.getContext(), DUMMY_ENV_KEY, DUMMY_ENV_VALUE1, true);
        assertEquals(DUMMY_ENV_VALUE1, JniEnv.get(InstrumentationRegistry.getContext(),
                DUMMY_ENV_KEY));
    }

    @Test
    public void shouldOverwriteJniEnvValue() {
        JniEnv.set(InstrumentationRegistry.getContext(), DUMMY_ENV_KEY, DUMMY_ENV_VALUE1, true);
        assertEquals(DUMMY_ENV_VALUE1, JniEnv.get(InstrumentationRegistry.getContext(),
                DUMMY_ENV_KEY));
        JniEnv.set(InstrumentationRegistry.getContext(), DUMMY_ENV_KEY, DUMMY_ENV_VALUE2, true);
        assertEquals(DUMMY_ENV_VALUE2, JniEnv.get(InstrumentationRegistry.getContext(),
                DUMMY_ENV_KEY));
    }

    @Test
    public void shouldNotOverwriteJniEnvValue() {
        JniEnv.set(InstrumentationRegistry.getContext(), DUMMY_ENV_KEY, DUMMY_ENV_VALUE1, true);
        assertEquals(DUMMY_ENV_VALUE1, JniEnv.get(InstrumentationRegistry.getContext(),
                DUMMY_ENV_KEY));
        JniEnv.set(InstrumentationRegistry.getContext(), DUMMY_ENV_KEY, DUMMY_ENV_VALUE2, false);
        assertEquals(DUMMY_ENV_VALUE1, JniEnv.get(InstrumentationRegistry.getContext(),
                DUMMY_ENV_KEY));
    }
}
