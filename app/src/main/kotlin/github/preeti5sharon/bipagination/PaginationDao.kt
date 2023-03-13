package github.preeti5sharon.bipagination

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PaginationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(item: Int)
}
