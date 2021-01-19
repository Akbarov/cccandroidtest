package uz.soliq.cccandroidtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.soliq.cccandroidtest.dao.AppDataBase
import uz.soliq.cccandroidtest.databinding.ActivityMainBinding
import uz.soliq.cccandroidtest.pojo.Estimate
import uz.soliq.cccandroidtest.pojo.Person
import uz.soliq.cccandroidtest.repository.EstimateRepository
import uz.soliq.cccandroidtest.repository.PersonRepository

class MainActivity : AppCompatActivity() {
    private val db = AppDataBase.getInstance()
    private val estimateRepository = EstimateRepository(db.getEstimateDao())
    private val personRepository = PersonRepository(db.getPersonDao())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addData()
        supportFragmentManager.beginTransaction().replace(R.id.baseContainer, MainFragment())
            .commit()
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

}
