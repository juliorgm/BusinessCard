package br.com.cuiadigital.businesscard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.cuiadigital.businesscard.App
import br.com.cuiadigital.businesscard.R
import br.com.cuiadigital.businesscard.data.BusinessCard
import br.com.cuiadigital.businesscard.databinding.FragmentFormCardBinding
import br.com.cuiadigital.businesscard.util.text
import yuku.ambilwarna.AmbilWarnaDialog
import yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener

class FormCardFragment : Fragment() {

    private lateinit var binding: FragmentFormCardBinding
    private var mDefaultColor = 1

    private val viewModel: ListBusinessCardViewModel by viewModels {
        ListBusinessCardViewModelFactory((activity?.application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    fun setClickListener() {
        binding.btnSave.setOnClickListener {
            if (validateItems()) {
                val businessCard = getCardFromForm()
                viewModel.insert(businessCard)

                Toast.makeText(requireContext(), getString(R.string.sucess), Toast.LENGTH_SHORT)
                    .show()

                findNavController().navigate(R.id.action_formCardFragment_to_listCardFragment)
            }
        }

        binding.tilColor?.setOnClickListener {
            val colorPicker =
                AmbilWarnaDialog(requireContext(), mDefaultColor, object : OnAmbilWarnaListener {
                    override fun onCancel(dialog: AmbilWarnaDialog?) {}

                    override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                        mDefaultColor = color;
                        binding.tilColor.setBackgroundColor(mDefaultColor)
                    }
                })

            colorPicker.show();
        }
    }

    private fun getCardFromForm(): BusinessCard {
        return BusinessCard(
            name = binding.tilName.text,
            phoneNumber = binding.tilPhoneNumber.text,
            company = binding.tilCompanyName.text,
            email = binding.tilEmail.text,
            cardColor = mDefaultColor,
        )
    }

    private fun validateItems(): Boolean {
        return true
    }

}