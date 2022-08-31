package hello.advanced.framework.utils;

import hello.advanced.framework.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
class RSAUtilTest {

    @Autowired
    AppProperties appProperties;

    @Test
    public void decodeTest() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        log.info("mode: {}", appProperties.getMode());
        log.info("privateKey: {}", appProperties.getPrivateKey());
        PrivateKey privateKey = RSAUtil.getPrivateKeyFromBase64Encrypted(appProperties.getPrivateKey());
        String encoded = "fKEDhEYCJLTXzlKHuOuQCUtngofxzCUsCbqhYP/QbcFDQd+TnFvfHTffJiC0ZpIs0QyaKBTkrXfjQ5r5HQYL+2mE30lM1KDe9/lbQycEd+ydUB/MX4S18++O3hjIBLz8zA52UuWVErERP++f+QpNAPIPGM+ow6V3Dh/T6YC1QGsNfzxgTwaofubFd+eIXwvWPPqoHd3csnpRyMC/Quprt2JuhLAqlOqCon2YGpW7/xrvWn2emptiAOYcpz+BtaoandKogKgcka8U7R2hY/HHyOOzq48/F1dgqdMQ+Hi4x+WJLKP4S+PGtFmn/KkZOhYgJoFM8vld5ZuUfL29UvJmTw==";
        String decrypted = RSAUtil.decryptRSA(encoded, privateKey);
        log.info("decrypted: {}", decrypted);
    }

}