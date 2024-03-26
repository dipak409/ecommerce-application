package com.ekart.loginmodule.util;

import com.ekart.loginmodule.constants.ApiConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;


@Slf4j
public class AESEncryptionDecryption {

    private Cipher encryptionCipher;
    private Cipher decryptionCipher;



    private String encode(byte[] byteText) {
        return Base64.getEncoder().encodeToString(byteText);
    }
    private byte[] decode(String encryptedStringText) {
        return Base64.getDecoder().decode(encryptedStringText);
    }
    public String encrypt(String text) {
        try {
            if (!StringUtils.hasLength(text)) {
                log.error("Text is empty or null");
                throw new NullPointerException();
            }
            log.info("Data Encryption started");
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ApiConstants.KEY_VAL);
            KeySpec spec = new PBEKeySpec(ApiConstants.PASSWORD_KEY.toCharArray(), ApiConstants.SALT_VAL.getBytes(), 65536, 256);
            SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ApiConstants.ENCRYPTION_METHOD);
            IvParameterSpec ivSpec = new IvParameterSpec(ApiConstants.INITIALIZATION_VECTOR);
            byte[] messageInBytes = text.getBytes();
            encryptionCipher = Cipher.getInstance(ApiConstants.CIPHER_ALGO);
            encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKey,ivSpec);
            byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
            log.info("Data Encryption is completed");
            return encode(encryptedBytes);
        } catch (Exception e) {
            log.error("Error while encrypting the data", e);
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String encryptedText) {
        try {
            log.info("Data Decryption started");
            byte[] messageInBytes = decode(encryptedText);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ApiConstants.KEY_VAL);
            KeySpec spec = new PBEKeySpec(ApiConstants.PASSWORD_KEY.toCharArray(), ApiConstants.SALT_VAL.getBytes(), 65536, 256);
            SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ApiConstants.ENCRYPTION_METHOD);
            decryptionCipher = Cipher.getInstance(ApiConstants.CIPHER_ALGO);
            IvParameterSpec ivSpec = new IvParameterSpec(ApiConstants.INITIALIZATION_VECTOR);
            decryptionCipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
            log.info("Data Decryption Completed");
            return new String(decryptedBytes);
        } catch (Exception e) {
            log.error("Error while decrypting the data", e);
            throw new RuntimeException(e);
        }
    }

}
