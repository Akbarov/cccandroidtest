package uz.soliq.cccandroidtest

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import uz.soliq.cccandroidtest.dao.AppDataBase

class MyApplication: Application() {
    companion object {
        lateinit var instance: Application
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        AppDataBase.getInstance(context)
    }
}