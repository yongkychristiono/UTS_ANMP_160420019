package com.example.uts_anmp_160420019.model

data class Berita(
    var id:String?,
    var judul:String?,
    var namaPembuat:String?,
    var description:String?,
    var detail:String?,
    var photo:String?
)

data class Profile(
    var id:String?,
    var username:String?,
    var password:String?,
    var namaDepan:String?,
    var namaBelakang:String?,
)
