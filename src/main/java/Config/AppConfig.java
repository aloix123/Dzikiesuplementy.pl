package Config;

import javax.annotation.PreDestroy;

public class AppConfig {
    @PreDestroy
    public void destroy() {
        System.out.println("Destroyed");
    }
}
