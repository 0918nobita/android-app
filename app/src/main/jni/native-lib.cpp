#include <jni.h>

extern "C" JNIEXPORT jstring JNICALL Java_io_github_zero918nobita_myapplication_repository_MainRepositoryImpl_getStr(JNIEnv* env) {
    return env->NewStringUTF("Hello from C++");
}
