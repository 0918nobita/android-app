package io.github.zero918nobita.myapplication.repository

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(): MainRepository {
    init {
        System.loadLibrary("native-lib")
    }

    external override fun getStr(): String
}
