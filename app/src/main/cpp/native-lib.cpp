#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_rsr_covid_119_network_NativeCaller_getBaseUrl(JNIEnv *env, jobject) {
    std::string url = "https://covid19.mathdro.id/api/";
    return env->NewStringUTF(url.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_rsr_covid_119_network_NativeCaller_getOverviewUrl(JNIEnv *env, jobject) {
    std::string url = "https://corona.lmao.ninja/v2/";
    return env->NewStringUTF(url.c_str());
}