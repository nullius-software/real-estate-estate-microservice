package com.nullius_real_estate.estate_microservice.controller

import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class EstateControllerTest {

 @Autowired
 lateinit var mockMvc: MockMvc

 @Test
 fun `should retrieve all estates`() {
  mockMvc.get("/api/estate").andExpect {
   status { isOk() }
   content { contentType("application/json") }
   jsonPath("$") { hasSize<EstateEntity>(3) }
  }
 }

 @Test
 fun `should create a estate`() {
  val estateJson = """
            {
                "name": "depto 3 amb",
                "price": 3000
            }
        """

  mockMvc.post("/api/estate") {
   contentType = MediaType.APPLICATION_JSON
   content = estateJson
  }.andExpect {
   status { isCreated() }
   content { contentType("application/json") }
   jsonPath("$.name") { value("depto 3 amb") }
   jsonPath("$.price") { value(3000) }
  }
 }
}