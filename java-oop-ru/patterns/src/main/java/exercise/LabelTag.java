package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String parameter;
    private TagInterface tag;

    public LabelTag(String parameter, TagInterface tag) {
        this.parameter = parameter;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" + this.parameter + this.tag.render() + "</label>";
    }
}
// END
