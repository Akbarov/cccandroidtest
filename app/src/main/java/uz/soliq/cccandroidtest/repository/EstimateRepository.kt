package uz.soliq.cccandroidtest.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import uz.soliq.cccandroidtest.dao.EstimateDao
import uz.soliq.cccandroidtest.pojo.Estimate

class EstimateRepository(private val estimateDao: EstimateDao) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(estimate: Estimate) {
        estimateDao.insert(estimate)
    }

    suspend fun getById(id: String) = estimateDao.getWithId(id)


    suspend fun getList() = estimateDao.getList()

    val  getListFlow:Flow<List<Estimate>> = estimateDao.getListFlow()

}