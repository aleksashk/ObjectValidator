package s13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task01 {
    public static void main(String[] args) throws IllegalAccessException {
        Student student1 = new Student("someStr", 1.1455f, Arrays.asList(2.36, 5.02, 6.54775));
        Student student2 = new Student("75488AA", 11455f, Collections.EMPTY_LIST);

        Driver driver1 = new Driver("DF2314578", 12445, List.of("F", "D", "B"));
        Driver driver2 = new Driver("12", 2, List.of());

        System.out.println("is student1 valid? - " + Validator.validate(student1));
        System.out.println("is student2 valid? - " + Validator.validate(student2));
        System.out.println("is driver1 valid? - " + Validator.validate(driver1));
        System.out.println("is driver2 valid? - " + Validator.validate(driver2));
    }
}
