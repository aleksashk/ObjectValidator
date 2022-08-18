package gmail.com.aleksandrphilimonov;

import gmail.com.aleksandrphilimonov.entity.Driver;
import gmail.com.aleksandrphilimonov.entity.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task01 {
    public static void main(String[] args) throws IllegalAccessException {
        Student student1 = new Student("ER124", 21.1455f, Arrays.asList(2.36, 5.02, 6.54775));
        Student student2 = new Student("75488AA", 11455f, Collections.EMPTY_LIST);

        Driver driver1 = new Driver("DF2314578", 2445, List.of("F", "D", "B"));
        Driver driver2 = new Driver("DF2314578", 12, List.of("F", "D"));
        Driver driver3 = new Driver("DF1500004", 17, List.of("F", "D"));
        Driver driver4 = new Driver("", 12, List.of("F", "D"));

        System.out.println("is student1 valid? - " + Validator.validate(student1));
        System.out.println("is student2 valid? - " + Validator.validate(student2));
        System.out.println("is driver1 valid? - " + Validator.validate(driver1));
        System.out.println("is driver2 valid? - " + Validator.validate(driver2));
        System.out.println("is driver3 valid? - " + Validator.validate(driver3));
        System.out.println("is driver4 valid? - " + Validator.validate(driver4));
    }
}
