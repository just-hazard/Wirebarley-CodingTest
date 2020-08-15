package just.hazard.wirebarley.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
class ExchangeRateControllerTest(
        @Autowired private val webApplicationContext: WebApplicationContext
){
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun controllerTest() {
        // given/when
        mockMvc.perform(get("/exchange-rate")
        // then
        .accept(MediaType.TEXT_HTML))
        .andExpect(status().isOk)
        .andExpect(view().name("page"))
        .andExpect(model().attributeExists("result"))
        .andReturn()
    }
}