package github.preeti5sharon.bipagination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.bidirectionalpagination.databinding.FragmentPaginationBinding
import github.preeti5sharon.bipagination.pagination.PaginationPagingAdapter
import kotlinx.coroutines.launch

class PaginationFragment : Fragment() {
    private var binding: FragmentPaginationBinding? = null
    private val paginationAdapter = PaginationPagingAdapter()
    private val paginationViewModel: PaginationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPaginationBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRV()
    }

    private fun setUpRV() {
        binding?.recyclerView?.adapter = paginationAdapter
        lifecycleScope.launch {
            paginationViewModel.getItemsFromDB().collect {
                paginationAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
