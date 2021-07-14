package br.com.cuiadigital.businesscard.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import br.com.cuiadigital.businesscard.R
import br.com.cuiadigital.businesscard.databinding.FragmentListCardBinding


class ListCardFragment : Fragment() {

    private lateinit var binding: FragmentListCardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentListCard = this
    }

    fun goToFormCard(){
        Log.d("ListCardFragment","goToFormCard()")
        findNavController().navigate(R.id.action_listCardFragment_to_formCardFragment)
    }

}