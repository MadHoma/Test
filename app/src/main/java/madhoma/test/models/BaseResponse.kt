package madhoma.test.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<Data>(@SerializedName("RestResponse") val response: RestResponse<Data>) {


    class RestResponse<Data>(@SerializedName("result") val result: Data)
}