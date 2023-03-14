package github.preeti5sharon.bipagination.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "item_list")
data class ItemClass(
    @PrimaryKey val item: Int,
    val data: String = UUID.randomUUID().toString(),
)
