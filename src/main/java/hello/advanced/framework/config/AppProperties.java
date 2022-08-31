package hello.advanced.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app")
public class AppProperties {
    private String mode;
    private String host;
    private String publicKey;
    private String privateKey;
}
