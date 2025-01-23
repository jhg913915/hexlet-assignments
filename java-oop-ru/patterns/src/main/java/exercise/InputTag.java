package exercise;

// BEGIN
public class InputTag implements TagInterface {
    private String typeParameter;
    private String valueParameter;

    public InputTag(String typeParameter, String valueParameter) {
        this.typeParameter = typeParameter;
        this.valueParameter = valueParameter;
    }

    @Override
    public String render() {
        return "<input type=\"" + this.typeParameter + "\" value=\"" + this.valueParameter + "\">";
    }
}
// END
