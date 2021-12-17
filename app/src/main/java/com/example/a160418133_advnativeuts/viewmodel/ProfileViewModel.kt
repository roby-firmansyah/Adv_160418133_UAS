package com.example.a160418133_advnativeuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418133_advnativeuts.model.Users

class ProfileViewModel: ViewModel() {
    val profile = MutableLiveData<Users>()

    fun fetch(username:String) {
        val user = Users(username,"Roby Firmansyah","29 November 1999","081330946701","https://i.pinimg.com/originals/66/3f/8a/663f8aa43335c509f0f85294ef039567.jpg")
        profile.value = user
    }
}