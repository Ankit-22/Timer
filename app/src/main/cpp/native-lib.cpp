#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_ankit_paint_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject ) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
jstring Java_com_ankit_paint_MainActivity_stringFromAnkit(JNIEnv* env,jobject)
{
    std::string hello = " and Ankit";
    return env->NewStringUTF(hello.c_str());
}