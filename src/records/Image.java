package records;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Image{

    private int width;
    private int height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return StringUtils.join("Image{width=",this.width,", height=",this.height,"}");
    }


}