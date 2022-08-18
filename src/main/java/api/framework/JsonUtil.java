package api.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public final class JsonUtil {

    public static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public static String objectToJson(Object object){
        return mapper.writeValueAsString(object);
    }

    @SneakyThrows
    public static String prettyObjectToJson(Object object){
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
