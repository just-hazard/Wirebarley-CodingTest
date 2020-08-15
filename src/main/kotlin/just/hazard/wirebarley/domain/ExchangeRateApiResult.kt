package just.hazard.wirebarley.domain

import com.google.gson.annotations.SerializedName

data class ExchangeRateApiResult(
        @SerializedName("source")
        var source: String,
        @SerializedName("quotes")
        var quotes: List
) {
    data class List (
        @SerializedName("USDKRW")
        var USDKRW: String,

        @SerializedName("USDJPY")
        var USDJPY: String,

        @SerializedName("USDPHP")
        var USDPHP: String
    )
}