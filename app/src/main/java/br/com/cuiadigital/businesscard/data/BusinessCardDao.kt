package br.com.cuiadigital.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BusinessCardDao {
    @Query("SELECT * FROM businesscard")
    fun getAll(): LiveData<List<BusinessCard>>

    @Query("SELECT * FROM businesscard WHERE name LIKE :name OR company LIKE :company ")
    fun getAllByName(name: String, company: String): LiveData<List<BusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)

    @Update
    suspend fun update(businessCard: BusinessCard)

    @Delete
    suspend fun delete(businessCard: BusinessCard)
}