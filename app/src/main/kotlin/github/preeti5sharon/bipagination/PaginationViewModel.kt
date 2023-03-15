package github.preeti5sharon.bipagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import github.preeti5sharon.bipagination.database.ItemClass
import github.preeti5sharon.bipagination.database.PaginationDao
import github.preeti5sharon.bipagination.pagination.PaginationPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaginationViewModel @Inject constructor(
    private val paginationDao: PaginationDao,
    private val paginationRepository: PaginationRepository,
) : ViewModel() {

    private val pagingConfig =
        PagingConfig(10, 10, false, 10)

    fun getItemsFromDB() = Pager(pagingConfig, 1000) {
        PaginationPagingSource(paginationDao)
    }.flow

    init {
        generateItems()
    }

    private fun generateItems() {
        viewModelScope.launch(Dispatchers.IO) {
            for (i in 0..2000) {
                paginationRepository.insertItem(ItemClass(i))
            }
        }
    }
}
