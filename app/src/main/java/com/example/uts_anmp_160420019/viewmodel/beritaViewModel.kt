package com.example.uts_anmp_160420019.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_anmp_160420019.model.Berita
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class beritaViewModel(application: Application): AndroidViewModel(application){
    val accountLD = MutableLiveData<Berita>()
    val accountLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "yongky"
    private var queue: RequestQueue? = null

    fun fetch() {
        loadingLD.value = true
        accountLoadErrorLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://my-json-server.typicode.com/yongkychristiono/json_anmp/berita"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Berita>() { }.type
                val result = Gson().fromJson<Berita>(it, sType)
                accountLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())
                Log.d("showvoley", url)
            },
            {
                Log.d("showvoley", it.toString())
                accountLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}