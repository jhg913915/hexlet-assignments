package exercise;

import java.util.List;
import java.util.Map;

public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<%s%s>", getName(), stringifyAttributes()));
        for (Tag child : children) {
            sb.append(child.toString());
        }
        sb.append(body);
        sb.append(String.format("</%s>", getName()));
        return sb.toString();
    }
}