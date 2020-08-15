package just.hazard.wirebarley.service

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExchangeRateServiceTest(
        @Autowired private val exchangeRateService: ExchangeRateService
){
    @Test
    fun apiResponse() {

        // given
        val apiUrl = "http://api.currencylayer.com/live?access_key=c74683c5d52c71180884d8683bab65b6"

        // when
        val (request, response, result) = apiUrl
                .httpGet()
                .responseString()

        when(result) {
            is Result.Failure -> {
                Assertions.fail()
            }
            is Result.Success -> {
                Assertions.assertEquals(apiUrl, response.url.toString())
            }
        }
    }

    @Test
    fun generateExchangeRate() {
        // given
        val apiUrl = "http://api.currencylayer.com/live?access_key=c74683c5d52c71180884d8683bab65b6"

        // when
        val result = exchangeRateService.exchangeRateRequest();

        // then
        Assertions.assertEquals("USD",result.component1()!!.source)
        Assertions.assertNotNull(result.component1()!!.quotes.USDKRW)
        Assertions.assertNotNull(result.component1()!!.quotes.USDJPY)
        Assertions.assertNotNull(result.component1()!!.quotes.USDPHP)
    }

}