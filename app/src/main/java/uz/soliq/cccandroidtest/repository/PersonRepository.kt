package uz.soliq.cccandroidtest.repository

import androidx.annotation.WorkerThread
import uz.soliq.cccandroidtest.dao.EstimateDao
import uz.soliq.cccandroidtest.dao.PersonDao
import uz.soliq.cccandroidtest.pojo.Estimate
import uz.soliq.cccandroidtest.pojo.Person

class PersonRepository(private val personDao: PersonDao) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(person: Person) {
        personDao.insert(person)
    }
    suspend fun getById(id:String) = personDao.getById(id)

    suspend fun getList() = personDao.getList()

}