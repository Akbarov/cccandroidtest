package uz.soliq.cccandroidtest.repository

import androidx.annotation.WorkerThread
import uz.soliq.cccandroidtest.dao.EstimateDao
import uz.soliq.cccandroidtest.pojo.Estimate

class EstimateRepository(private val estimateDao: EstimateDao) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(estimate: Estimate) {
        estimateDao.insert(estimate)
    }

    suspend fun getById(id: String) = estimateDao.getWithId(id)

    suspend fun getListWithLink(id: String) = estimateDao.getListWithLink(id)

    suspend fun getList() = estimateDao.getList()

}