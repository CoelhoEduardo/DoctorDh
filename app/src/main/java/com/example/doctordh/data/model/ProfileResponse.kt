package com.example.doctordh.data.model

import android.text.Editable

data class ProfileResponse(val results: List<ProfileItem>)
data class ProfileItem(val name: ProfileName, val phone: String, val registered: ProfileRegistered, val location: ProfileLocation, val picture: ProfilePicture)
data class ProfileName(val first: String, val last: String)
data class ProfileRegistered( val date: String)
data class ProfileLocation(val city: String)
data class ProfilePicture(val thumbnail: String)
