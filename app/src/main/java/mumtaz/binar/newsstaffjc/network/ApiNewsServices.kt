package mumtaz.binar.newsstaffjc.network

import mumtaz.binar.newsstaffjc.model.GetAllNewsResponseItem
import retrofit2.http.GET

interface ApiNewsServices {
    @GET("news")
    suspend fun getAllUser(): List<GetAllNewsResponseItem>
}