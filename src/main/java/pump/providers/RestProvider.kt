package pump.providers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pump.model.Repository

@Component
class RestProvider {
    @Autowired
    lateinit var requestProvider : RequestProvider

    fun getRepository(owner : String, repo : String) : Repository {
//        val request = Request.

        return Repository(1, "")
    }
}