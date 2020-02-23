package com.hnineiphyu.daweidirectory.ui.educationdetail

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.viewmodel.SelectedDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_education_detail.*


/**
 * A simple [Fragment] subclass.
 */

class EducationDetailFragment : Fragment() {

    lateinit var selectedDetailViewModel: SelectedDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedDetailViewModel =
            ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

        selectedDetailViewModel.getSelectedDetail().observe(
            viewLifecycleOwner, Observer<InfosItem> { infosItem ->
                Picasso.get()
                    .load(infosItem.photo)
                    .into(education_detail_image)
                education_phoneno.text = infosItem.phoneno
                education_address.text = infosItem.address
                education_map.text = infosItem.location
            }
        )

        education_phoneno_card.setOnClickListener {

            var number = education_phoneno.text.toString()

            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + number)
            val result =
                ContextCompat.checkSelfPermission(context!!, Manifest.permission.CALL_PHONE)
            if (result == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent)
            }

        }

        card_map_education.setOnClickListener {

            var latlong = education_map.text.toString()

            education_map.text = "Open in maps"

            val gmmIntentUri: Uri = Uri.parse("geo: $latlong")

            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            mapIntent.setPackage("com.google.android.apps.maps")

            startActivity(mapIntent)
        }
    }
}
