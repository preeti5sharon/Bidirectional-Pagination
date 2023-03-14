package github.preeti5sharon.bipagination.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import github.preeti5sharon.bipagination.database.ItemClass
import github.preeti5sharon.bipagination.database.PaginationDao

class PaginationPagingSource(
    private val paginationDao: PaginationDao,
) : PagingSource<Int, ItemClass>() {
    override fun getRefreshKey(state: PagingState<Int, ItemClass>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemClass> {
        val offset = params.key ?: 1000
        val loadSize = params.loadSize
        val items = paginationDao.fetchItems(loadSize, offset)

        return LoadResult.Page(
            data = items,
            prevKey = if (offset == 0) {
                null
            } else {
                offset - 1
            },
            nextKey = if (offset<2000) {
                offset + 1
            } else {
                null
            },
        )
    }
}
