#include <string.h>
#include <jni.h>
#include <stdlib.h>

JNIEXPORT void JNICALL
Java_com_twilio_jnienv_JniEnv_nativeSet(JNIEnv *env,
                                 jclass type,
                                 jstring j_name,
                                 jstring j_value,
                                 jboolean j_overwrite) {
    const char *name = (*env)->GetStringUTFChars(env, j_name, 0);
    const char *value = (*env)->GetStringUTFChars(env, j_value, 0);

    setenv(name, value, j_overwrite);

    (*env)->ReleaseStringUTFChars(env, j_name, name);
    (*env)->ReleaseStringUTFChars(env, j_value, value);
}

JNIEXPORT jstring JNICALL
Java_com_twilio_jnienv_JniEnv_nativeGet(JNIEnv *env, jclass type, jstring j_name) {
    const char *name = (*env)->GetStringUTFChars(env, j_name, 0);
    const char *value = getenv(name);

    (*env)->ReleaseStringUTFChars(env, j_name, name);

    return (*env)->NewStringUTF(env, value);
}
