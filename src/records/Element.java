package records;

import java.util.Objects;

import enums.ElementType;
import org.apache.commons.lang3.StringUtils;

public class Element<T> {

    private String url;

    private T properties;

    private ElementType elementType;

    public Element(final String url, final T properties, final ElementType elementType) {
        this.url = url;
        this.properties = properties;
        this.elementType = elementType;
    }

    public String getUrl() {
        return url;
    }

    public T getProperties() {
        return properties;
    }

    public ElementType getElementType() {
        return elementType;
    }

    @Override
    public String toString() {
        return StringUtils.join("Element{url=", this.url, ", properties=", this.properties.toString(), "}");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Element<?> that = (Element<?>) o;
        return Objects.equals(this.url,that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url);
    }

}