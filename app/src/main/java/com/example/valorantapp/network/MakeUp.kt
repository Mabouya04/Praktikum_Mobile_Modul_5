package com.example.valorantapp.network

import com.squareup.moshi.Json

data class MakeUp(

	@Json(name="name")
	val nameMakeup: String? = null,

	@Json(name="description")
	val descriptionMakeUp: String? = null,

	@Json(name="image_link")
	val makeUpLink: String? = null

)