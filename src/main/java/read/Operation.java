package read;

import java.util.List;

public class Operation {
    String type;
    List<String> parameters;

    public Operation(String type, List<String> parameters) {
        this.type = type;
        this.parameters = parameters;
    }

    public String getType() {
        return type;
    }

    public List<String> getParameters() {
        return parameters;
    }
}
