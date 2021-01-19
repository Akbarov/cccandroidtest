package uz.soliq.cccandroidtest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import retrofit2.http.Path
import uz.soliq.cccandroidtest.pojo.Estimate
import uz.soliq.cccandroidtest.pojo.Person

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Estimate>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<Estimate>)

    @Query("select * from Person where id=:id")
    suspend fun getById(@Path("id") id: String): Person


    @Query("select * from Person")
    suspend fun getList(): List<Person>
}