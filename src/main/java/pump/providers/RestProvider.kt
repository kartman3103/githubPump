package pump.providers

import org.apache.http.client.fluent.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pump.json.JsonParser
import pump.model.Repository

@Component
class RestProvider {
    @Autowired
    lateinit var requestProvider : RequestProvider

    @Autowired
    lateinit var jsonParser : JsonParser

    fun getRepository(owner : String, repo : String) : Repository {
        val request : Response = requestProvider.provideGet("https://api.github.com/repos/${owner}/${repo}")
        val repository : Repository = jsonParser.parseRepository(request.returnContent().asString())

        return repository
    }
}