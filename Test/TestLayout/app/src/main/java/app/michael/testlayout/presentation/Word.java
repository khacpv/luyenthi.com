package app.michael.testlayout.presentation;

/**
 * Created by michael on 12/10/15.
 */
public class Word {
    private int type =0;// 0 - text, 1 -> mathjax, 2 --> answer
    private String value = " Example ";

    public Word(int type, String value) {
        this.setType(type);
        this.setValue(value);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
