package uz.soliq.cccandroidtest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path
import uz.soliq.cccandroidtest.pojo.Estimate
import uz.soliq.cccandroidtest.pojo.EstimateWithLink

@Dao
interface EstimateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(estimate: Estimate)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Estimate>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<Estimate>)

    @Query("select * from Estimate where id=:id")
    suspend fun getWithId(@Path("id") id: String): Estimate

    @Query("select * from Estimate")
    suspend fun getList(): List<Estimate>

    @Query("select * from Estimate")
    fun getListFlow(): Flow<List<Estimate>>


}