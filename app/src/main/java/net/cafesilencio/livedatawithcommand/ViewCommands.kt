package net.cafesilencio.livedatawithcommand

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView

/**
 * Created on 12/5/18.
 */
typealias ActivityStateCmd<T> = (activity: T) -> Unit

fun getSnackBarCmd(resourceId: Int): ActivityStateCmd<Activity> = { activity ->
    activity.findViewById<View>(R.id.rootView)?.let {
        Snackbar.make(it, resourceId, Snackbar.LENGTH_LONG).show()
    }
}

fun getUpdateNameFieldsCmd(userData: MyUserData): ActivityStateCmd<MyActivity> = { activity ->
    activity.findViewById<TextView>(R.id.firstName).text = userData.firstName
    activity.findViewById<TextView>(R.id.lastName).text = userData.lastName
}
