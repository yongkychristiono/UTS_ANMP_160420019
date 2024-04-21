package com.example.uts_anmp_160420019.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_anmp_160420019.model.Profile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class profileViewModel(application: Application): AndroidViewModel(application) {
        val profileLD = MutableLiveData<Profile>()
        val profileLoadErrorLD = MutableLiveData<Boolean>()
        val loadingLD = MutableLiveData<Boolean>()

        val TAG = "yongky"
        private var queue: RequestQueue? = null

        fun fetch() {
            loadingLD.value = true
            profileLoadErrorLD.value = false
            queue = Volley.newRequestQueue(getApplication())
            val url = "https://my-json-server.typicode.com/yongkychristiono/json_anmp/profile"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
                    val sType = object : TypeToken<Profile>() { }.type
                    val result = Gson().fromJson<Profile>(it, sType)
                    profileLD.value = result
                    loadingLD.value = false

                    Log.d("showvoley", result.toString())
                },
                {
                    Log.d("showvoley", it.toString())
                    profileLoadErrorLD.value = false
                    loadingLD.value = false
                })

            stringRequest.tag = TAG
            queue?.add(stringRequest)
        }
    }