package com.example.weatherforecast.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.google.common.base.Preconditions


/**
 * This provides methods to help Activities load their UI.
 */
object ActivityUtils {
    /**
     * The `fragment` is added to the container view with id `frameId`. The operation is
     * performed by the `fragmentManager`.
     */
    fun addFragmentToActivity(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int
    ) {
        Preconditions.checkNotNull<FragmentManager>(fragmentManager)
        Preconditions.checkNotNull<Fragment>(fragment)
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }
}