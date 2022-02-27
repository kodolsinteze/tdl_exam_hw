package com.testdevlab.numbertapper.common

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.testdevlab.numbertapper.R

fun Fragment.openFragment(id: Int) = activity?.findNavController(R.id.nav_host)?.run {

    if (!popBackStack(id, false)) {
        navigate(id)
    }

    // with back-button: A, B and after navigating back just A
    // with navigate(id): A, B and after navigating - A, B, A
}
