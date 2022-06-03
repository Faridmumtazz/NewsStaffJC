package mumtaz.binar.newsstaffjc.network

import mumtaz.binar.newsstaffjc.model.GetAllStaffResponseItem
import retrofit2.http.GET

interface ApiStaffServices {
    @GET("staf")
    suspend fun getAllStaff(): List<GetAllStaffResponseItem>
}