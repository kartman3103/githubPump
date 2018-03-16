package tests

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import pump.Application
import pump.providers.RequestProvider

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
class RequestTest {
    @Autowired
    lateinit var requestProvider : RequestProvider

    @Test
    fun testConnection() {
        val response = requestProvider.provideGet("https://api.github.com")
        Assert.assertTrue(response.returnResponse().statusLine.statusCode == 200)
    }

    @Test
    fun testUser() {
        val response = requestProvider.provideGet("https://api.github.com/users/kartman3103")
        Assert.assertTrue(response.returnResponse().statusLine.statusCode == 200)
    }

    @Test
    fun testRepo() {
        val response = requestProvider.provideGet("https://api.github.com/repos/WonderfulFalcon/sportstat")
        Assert.assertTrue(response.returnResponse().statusLine.statusCode == 200)
    }

    @Test
    fun testIssues() {
        val response = requestProvider.provideGet("https://api.github.com/repos/WonderfulFalcon/sportstat/issues")
        Assert.assertTrue(response.returnResponse().statusLine.statusCode == 200)
    }
}