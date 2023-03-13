package github.preeti5sharon.bipagination

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ItemClass::class],
    version = 1,
)
abstract class PaginationDB : RoomDatabase() {
    abstract fun getPaginationDao(): PaginationDao
}
