package madhoma.test

import io.reactivex.Single
import madhoma.test.models.BaseResponse
import madhoma.test.models.State
import retrofit2.http.GET

interface StateApi {
    @GET("state/get/USA/all")
    fun getState(): Single<BaseResponse<List<State>>>
}