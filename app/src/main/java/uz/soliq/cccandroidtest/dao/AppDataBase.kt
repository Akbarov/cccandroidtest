package uz.soliq.cccandroidtest.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.soliq.cccandroidtest.MyApplication
import uz.soliq.cccandroidtest.pojo.Estimate
import uz.soliq.cccandroidtest.pojo.Person

@Database(entities = [Estimate::class, Person::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getEstimateDao(): EstimateDao
    abstract fun getPersonDao(): PersonDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(): AppDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(MyApplication.context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): AppDataBase {

            val dbName = "default.db"
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, dbName
            )
                .build()
        }
    }
}