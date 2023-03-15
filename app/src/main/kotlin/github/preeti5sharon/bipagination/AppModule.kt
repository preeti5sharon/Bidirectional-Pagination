package github.preeti5sharon.bipagination

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import github.preeti5sharon.bipagination.database.PaginationDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PaginationDB::class.java, "pagination_db").build()

    @Provides
    @Singleton
    fun provideRepository(database: PaginationDB) = PaginationRepository(database)

    @Provides
    @Singleton
    fun provideDAO(paginationDB: PaginationDB) = paginationDB.getPaginationDao()
}
