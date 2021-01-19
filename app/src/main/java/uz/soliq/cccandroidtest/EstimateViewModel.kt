package uz.soliq.cccandroidtest

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import uz.soliq.cccandroidtest.dao.AppDataBase
import uz.soliq.cccandroidtest.pojo.Estimate
import uz.soliq.cccandroidtest.pojo.EstimateWithLink
import uz.soliq.cccandroidtest.repository.EstimateRepository
import uz.soliq.cccandroidtest.repository.PersonRepository

class EstimateViewModel() : ViewModel() {

    private val db = AppDataBase.getInstance()
    private val estimateRepository = EstimateRepository(db.getEstimateDao())
    private val personRepository = PersonRepository(db.getPersonDao())

    private var _estimateData = MutableLiveData<EstimateWithLink>()
    val estimatedLiveData: LiveData<EstimateWithLink> get() = _estimateData

    init {
        getEstimateWithLink()
    }

    private fun getEstimateWithLink() {
        viewModelScope.launch {
            val estimate = estimateRepository.getById("c574b0b4-bdef-4b92-a8f0-608a86ccf5ab")
            val createdBy = personRepository.getById(estimate.created_by)
            val requestedBy = personRepository.getById(estimate.requested_by)
            val contact = personRepository.getById(estimate.contact)
            val estimateWithLink = EstimateWithLink(
                id = estimate.id,
                company = estimate.company,
                address = estimate.address,
                number = estimate.number,
                created_date = estimate.created_date,
                created_by = createdBy,
                requested_by = requestedBy,
                contact = contact
            )
            _estimateData.postValue(estimateWithLink)
        }
    }


}