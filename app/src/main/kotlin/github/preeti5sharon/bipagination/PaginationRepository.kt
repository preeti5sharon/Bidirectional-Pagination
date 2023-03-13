package github.preeti5sharon.bipagination

import androidx.paging.PagingConfig

class PaginationRepository(private val paginationDB: PaginationDB) {

    private val pagingConfig =
        PagingConfig(10, 10, false, 20)

    suspend fun insertItem(item: Int) = paginationDB.getPaginationDao().insertItems(item)
}
