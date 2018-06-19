package Config;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * create by wjwang on ${date}
 */
@Target({TYPE,METHOD})
@Retention(RUNTIME)
public @interface DataSource {
    String name() default "mytestdb";
}
