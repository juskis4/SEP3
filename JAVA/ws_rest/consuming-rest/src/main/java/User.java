
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class User {
    private String type;
    private JsonIgnoreProperties.Value value;

    public User(){
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonIgnoreProperties.Value getValue(){
        return value;
    }

    public void setValue(JsonIgnoreProperties.Value value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' + "Value= " + value + '\'' +
                '}';
    }
}
