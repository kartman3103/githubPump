package pump.providers

import org.apache.http.client.fluent.Request
import org.apache.http.client.fluent.Response
import org.springframework.stereotype.Component

@Component
open class RequestProvider {
    fun provideGet(url : String) : Response {
        val request = Request.Get(url)
        try {
            return request.execute()
        } catch (e : Exception) {
            throw e
        }
    }
}