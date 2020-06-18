package com.example.poi.common.note;

import java.lang.annotation.*;

/**
 * @author hyy
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateLogNote {
    String value() default "";
}
