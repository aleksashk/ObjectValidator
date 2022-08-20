package gmail.com.aleksandrphilimonov;

import gmail.com.aleksandrphilimonov.annotations.Max;
import gmail.com.aleksandrphilimonov.annotations.Min;
import gmail.com.aleksandrphilimonov.annotations.NotEmpty;
import gmail.com.aleksandrphilimonov.annotations.NotNull;
import gmail.com.aleksandrphilimonov.annotations.Regexp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

public class Validator {
    public static boolean validate(Object obj) throws IllegalAccessException {
        Class<?> claz = obj.getClass();

        Field[] fields = claz.getDeclaredFields();//получаем поля класса
        for (Field field : fields) {
            field.setAccessible(true);//открываем доступ к полям
            Object objectField = field.get(obj);

            Annotation[] annotations = field.getDeclaredAnnotations();//формируем массив аннотаций
            //которые расположены над каждым полем

            for (Annotation an : annotations) {//перебираем все аннотации конкретного поля
                Class<?> annotationType = an.annotationType();
                if (annotationType.isAssignableFrom(NotNull.class)) {//проверяем, совпадает ли аннотация над полем с аннотацией NotNull
                    if (objectField == null) {//проверяем поле на null, если null, то объект не валиден
                        return false;
                    }
                }
                if (annotationType.isAssignableFrom(Regexp.class) && objectField instanceof String) {
                    Regexp regexpAnnotation = (Regexp) an;
                    if (!((String)objectField).matches(regexpAnnotation.regExp())) {
                        return false;
                    }
                }
                if (annotationType.isAssignableFrom(Max.class) && objectField instanceof Number) {
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(objectField));
                    Max maxAnnotation = (Max) an;
                    if (bigDecimal.compareTo(new BigDecimal(String.valueOf(maxAnnotation.max()))) > 0) {
                        return false;
                    }
                }
                if (annotationType.isAssignableFrom(Min.class) && objectField instanceof Number) {
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(objectField));
                    Min minAnnotation = (Min) an;
                    if (bigDecimal.compareTo(new BigDecimal(String.valueOf(minAnnotation.min()))) < 0) {
                        return false;
                    }
                }
                if (annotationType.isAssignableFrom(NotEmpty.class) && objectField instanceof Collection<?>) {
                    if (((Collection<?>) objectField).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
