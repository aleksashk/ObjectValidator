package gmail.com.aleksandrphilimonov.entity;

import gmail.com.aleksandrphilimonov.annotations.Max;
import gmail.com.aleksandrphilimonov.annotations.Min;
import gmail.com.aleksandrphilimonov.annotations.NotEmpty;
import gmail.com.aleksandrphilimonov.annotations.NotNull;
import gmail.com.aleksandrphilimonov.annotations.Regexp;

import java.util.List;

public class Driver {

    @NotNull
    @Regexp(regExp = "[^A-Za-z]")
    private String stringField;

    @Max
    @Min
    private int numberField;

    @NotNull
    @NotEmpty
    private List<String> collectionField;

    public Driver(String stringField, int numberField, List<String> collectionField) {
        this.stringField = stringField;
        this.numberField = numberField;
        this.collectionField = collectionField;
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public int getNumberField() {
        return numberField;
    }

    public void setNumberField(int numberField) {
        this.numberField = numberField;
    }

    public List<String> getCollectionField() {
        return collectionField;
    }

    public void setCollectionField(List<String> collectionField) {
        this.collectionField = collectionField;
    }
}
