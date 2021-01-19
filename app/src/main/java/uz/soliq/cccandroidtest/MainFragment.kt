package uz.soliq.cccandroidtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import uz.soliq.cccandroidtest.databinding.MainLayoutBinding

class MainFragment : Fragment() {

    private lateinit var mViewModel: EstimateViewModel
    private var binding: MainLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        mViewModel = ViewModelProvider(this).get(EstimateViewModel::class.java)

        return inflater.inflate(R.layout.main_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainLayoutBinding.bind(view)
        mViewModel.estimatedLiveData.observe(this, {
            binding?.addressTv?.text = it.address
            binding?.companyTv?.text = it.company
            binding?.createdValueTv?.text = it.created_date?.split(" ")?.get(0)
            binding?.createdByTitle?.text = it.created_by?.first_name
            binding?.contactValueTv?.text = it.contact?.first_name
            binding?.requesterValueTv?.text = it.requested_by?.first_name

        })
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()

    }
}