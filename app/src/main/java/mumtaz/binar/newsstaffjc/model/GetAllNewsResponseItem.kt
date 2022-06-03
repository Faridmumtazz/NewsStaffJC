package mumtaz.binar.newsstaffjc.model

import java.io.Serializable

data class GetAllNewsResponseItem(
    val author: String,
    val createdAt: String,
    val description: String,
    val id: String,
    val image: String,
    val title: String
) : Serializable