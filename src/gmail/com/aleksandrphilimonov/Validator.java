package s13;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Collection;

public class Validator {
    public static boolean validate(Object obj) throws IllegalAccessException {
        Class<?> claz = obj.getClass();

        Field[] fields = claz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation an : annotations) {
                if (an.annotationType().isAnnotationPresent(NotNull.class)) {
                    if (field.get(obj) == null) {
                        return false;
                    }
                }
                if (an.annotationType().isAnnotationPresent(Regexp.class) && field.get(obj) instanceof String) {
                    if (!field.get(obj).toString().matches("[A-Z]{2}\\d{7}")) {
                        return false;
                    }
                }
                if (an.annotationType().isAnnotationPresent(Max.class) && field.get(obj) instanceof Number) {
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(field.get(obj)));
                    if (bigDecimal.compareTo(new BigDecimal(String.valueOf(10000))) < 0) {
                        return false;
                    }
                }
                if (an.annotationType().isAnnotationPresent(Min.class) && field.get(obj) instanceof Number) {
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(field.get(obj)));
                    if (bigDecimal.compareTo(new BigDecimal(String.valueOf(10000))) < 0) {
                        return false;
                    }
                }
                if (an.annotationType().isAnnotationPresent(NotEmpty.class) && field.get(obj) instanceof Collection<?>) {
                    if (((Collection<?>) field.get(obj)).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
