package uz.soliq.cccandroidtest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.soliq.cccandroidtest.dao.AppDataBase
import uz.soliq.cccandroidtest.pojo.Estimate
import uz.soliq.cccandroidtest.pojo.EstimateWithLink
import uz.soliq.cccandroidtest.pojo.Person
import uz.soliq.cccandroidtest.repository.EstimateRepository
import uz.soliq.cccandroidtest.repository.PersonRepository

class MainActivity : AppCompatActivity() {
    private val db = AppDataBase.getInstance(MyApplication.context)
    private val estimateRepository = EstimateRepository(db.getEstimateDao())
    private val personRepository = PersonRepository(db.getPersonDao())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addData()
        getEstimateWithLink()
    }

    private fun addData() {

        val estimate =
            Estimate(
                id = "c574b0b4-bdef-4b92-a8f0-608a86ccf5ab",
                created_by = "85a57f85-a52d-4137-a0d1-62e61362f716",
                contact = "85a57f85-a52d-4137-a0d1-62e61362f716",
                created_date = "2020-08-22 15:23:54",
                revision_number = 3,
                address = "32 Commissioners Road East",
                company = "Placebo Secondary School",
                number = 32,
                requested_by = "85a57f85-a52d-4137-a0d1-62e61362f716"
            )
        val person = Person(
            id = "85a57f85-a52d-4137-a0d1-62e61362f716",
            first_name = "Joseph",
            last_name = "Sham",
            email = "joseph.sham@fake.fake",
            phone_number = "123-456-7890"
        )


        GlobalScope.launch {
            personRepository.insert(person)
            estimateRepository.insert(estimate)
        }

    }

    private fun getEstimateWithLink() {
        GlobalScope.launch {
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

        }
    }

}
