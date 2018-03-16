package tests

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import pump.Application
import pump.model.Repository
import pump.providers.RestProvider

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
class RestControllerTest {
    @Autowired
    lateinit var restProvider : RestProvider

    @Test
    fun testGetRepository() {
        val repository : Repository = restProvider.getRepository("WonderfulFalcon", "sportstat")

        Assert.assertEquals("sportstat", repository.name)
    }
}