package github.preeti5sharon.bipagination

import github.preeti5sharon.bipagination.database.ItemClass
import github.preeti5sharon.bipagination.database.PaginationDB

class PaginationRepository(private val paginationDB: PaginationDB) {

    suspend fun insertItem(item: ItemClass) = paginationDB.getPaginationDao().insertItems(item)
}
