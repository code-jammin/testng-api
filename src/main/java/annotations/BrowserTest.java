package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An annotation that indicates a test uses a web browser
 *
 * @author steve
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface BrowserTest {

}
