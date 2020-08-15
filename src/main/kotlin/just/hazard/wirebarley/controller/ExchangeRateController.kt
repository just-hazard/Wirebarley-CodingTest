package just.hazard.wirebarley.controller

import just.hazard.wirebarley.service.ExchangeRateService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model

@Controller
class ExchangeRateController(
        private val service: ExchangeRateService
) {

    @GetMapping("/exchange-rate")
    fun requestApi(model: Model): String {
        var result = service.exchangeRateRequest()
        result.component1()!!.quotes.USDKRW = decimalSubString(result.component1()!!.quotes.USDKRW)
        result.component1()!!.quotes.USDJPY = decimalSubString(result.component1()!!.quotes.USDJPY)
        result.component1()!!.quotes.USDPHP = decimalSubString(result.component1()!!.quotes.USDPHP)

        model.addAttribute("result",result.component1())
        return "page"
    }

    fun decimalSubString(str: String): String {
        var list : List<String> = str.split(".")
        var result : String = list[0] + "."
        result += list[1].substring(0,2)
        return result
    }
}