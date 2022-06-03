package mumtaz.binar.newsstaffjc.model

data class GetAllStaffResponseItem(
    val createdAt: String,
    val description: String,
    val director: String,
    val email: String,
    val id: String,
    val image: String,
    val name: String
)