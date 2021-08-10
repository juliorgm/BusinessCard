package br.com.cuiadigital.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.cuiadigital.businesscard.data.BusinessCard
import br.com.cuiadigital.businesscard.data.BusinessCardRepository

class ListBusinessCardViewModel(private val businessCardRepository: BusinessCardRepository): ViewModel() {
    fun getAll(): LiveData<List<BusinessCard>> = businessCardRepository.getAll()

    fun insert(businessCard: BusinessCard){
        businessCardRepository.insert(businessCard)
    }
}

class ListBusinessCardViewModelFactory(private val repository: BusinessCardRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListBusinessCardViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ListBusinessCardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}