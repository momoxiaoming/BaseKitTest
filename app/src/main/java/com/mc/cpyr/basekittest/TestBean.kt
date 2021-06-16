package com.mc.cpyr.basekittest

import kotlinx.serialization.SerialName
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class TestBean(
    @SerializedName("age") var age: Int,
    @SerializedName("name") var name: String
)


fun main() {
    val data = TestBean(1, "hello")

    val str2 = Json.encodeToString(data)


    print("str-->$str2")
}