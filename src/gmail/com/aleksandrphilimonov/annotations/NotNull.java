package gmail.com.aleksandrphilimonov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    boolean isNull() default false;//надо ли прописывать, и если надо, то как этим пользоваться в валидаторе?
}
