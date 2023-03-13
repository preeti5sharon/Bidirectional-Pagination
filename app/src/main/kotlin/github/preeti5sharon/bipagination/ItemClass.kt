package github.preeti5sharon.bipagination

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_list")
data class ItemClass(
    @PrimaryKey val item: Int,
)
