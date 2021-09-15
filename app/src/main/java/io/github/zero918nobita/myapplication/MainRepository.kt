package io.github.zero918nobita.myapplication

class MainRepository {
    init {
        System.loadLibrary("native-lib")
    }

    external fun getStr(): String
}
