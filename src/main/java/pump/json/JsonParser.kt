package pump.json

import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.stereotype.Component
import pump.model.Repository

@Component
class JsonParser {
    val objectMapper : ObjectMapper = ObjectMapper()

    fun parseRepository(json : String) : Repository {
        val parsed : JsonNode = objectMapper.readTree(json)
        return Repository(
                parsed.get("id").longValue,
                parsed.get("name").asText())
    }
}