package com.testdevlab.numbertapper.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.testdevlab.numbertapper.R
import com.testdevlab.numbertapper.common.openFragment
import com.testdevlab.numbertapper.databinding.FragmentMenuBinding
import timber.log.Timber

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        Timber.d("MenuFragment inflated")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            openGameButton.setOnClickListener {
                openFragment(R.id.navigation_lingo)
            }
        }
    }
}
