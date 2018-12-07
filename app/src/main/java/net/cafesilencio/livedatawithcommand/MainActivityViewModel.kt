package net.cafesilencio.livedatawithcommand

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created on 12/5/18.
 */
class MainActivityViewModel: ViewModel() {

    val viewUpdates = MutableLiveData<List<ActivityStateCmd<MyActivity>>>()

    fun respondToSomeUserAction() {
        val userData = getUserDataFromRepo()
        viewUpdates.value = listOf( getUpdateNameFieldsCmd(userData) , getSnackBarCmd(R.string.welcome))
    }
}