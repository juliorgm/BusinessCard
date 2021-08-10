package br.com.cuiadigital.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val dao: BusinessCardDao) {
    fun insert(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(businessCard)
        }
    }

    fun update(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.update(businessCard)
        }
    }

    fun delete(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.delete(businessCard)
        }
    }

    fun getAllByName(name: String = "", company: String = "") = dao.getAllByName(name, company)

    fun getAll() = dao.getAll()
}