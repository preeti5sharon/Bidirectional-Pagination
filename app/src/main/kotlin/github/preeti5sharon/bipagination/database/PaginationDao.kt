package github.preeti5sharon.bipagination.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PaginationDao {

    @Query("select * from item_list limit: limit offset: offset")
    suspend fun fetchItems(limit: Int, offset: Int): List<ItemClass>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(item: Int)
}
