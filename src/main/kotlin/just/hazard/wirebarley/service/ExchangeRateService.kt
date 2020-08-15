package just.hazard.wirebarley.service

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import just.hazard.wirebarley.domain.ExchangeRateApiResult
import org.springframework.stereotype.Service

@Service
class ExchangeRateService {

    fun exchangeRateRequest(): Result<ExchangeRateApiResult, FuelError> {
        val (_, _, result)
                = "http://api.currencylayer.com/live?access_key=c74683c5d52c71180884d8683bab65b6"
                .httpGet()
                .responseObject<ExchangeRateApiResult>()
        return result
    }
}