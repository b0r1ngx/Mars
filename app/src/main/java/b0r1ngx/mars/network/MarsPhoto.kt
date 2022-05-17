package b0r1ngx.mars.network

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String,

    @Json(name = "img_src")
    val imgUrl: String
)