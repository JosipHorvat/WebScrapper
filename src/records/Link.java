package records;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Link {

    private String text;

    public Link(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return StringUtils.join("Link{text=", this.text, "}");
    }


}