package gmail.com.aleksandrphilimonov;

import gmail.com.aleksandrphilimonov.annotations.Max;
import gmail.com.aleksandrphilimonov.annotations.Min;
import gmail.com.aleksandrphilimonov.annotations.NotEmpty;
import gmail.com.aleksandrphilimonov.annotations.NotNull;
import gmail.com.aleksandrphilimonov.annotations.Regexp;

import java.util.List;

public class Student {

    @Regexp
    @NotNull
    private String strField;

    @Min
    @Max
    private Float numberField;

    @NotEmpty
    private List<Double> listField;

    public Student(String strField, Float numberField, List<Double> listField) {
        this.strField = strField;
        this.numberField = numberField;
        this.listField = listField;
    }

    public String getStrField() {
        return strField;
    }

    public void setStrField(String strField) {
        this.strField = strField;
    }

    public Float getNumberField() {
        return numberField;
    }

    public void setNumberField(Float numberField) {
        this.numberField = numberField;
    }

    public List<Double> getListField() {
        return listField;
    }

    public void setListField(List<Double> listField) {
        this.listField = listField;
    }
}
