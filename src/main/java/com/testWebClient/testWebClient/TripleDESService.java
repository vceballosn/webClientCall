package com.testWebClient.testWebClient;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import org.springframework.stereotype.Service;

@Service
public class TripleDESService {

    private static final String ALGORITHM = "DESede";
    private static final String TRANSFORMATION = "DESede/CBC/PKCS5Padding";
    private static final String IV = "5zco4xa6";
    private final SecretKeySpec secretKey;
    private final IvParameterSpec ivParameterSpec;

    public TripleDESService() throws Exception {
        // Usar directamente la clave en formato de texto ASCII
        String keyString = "04578a8f0be3a7109d9e5e86";
        this.secretKey = new SecretKeySpec(keyString.getBytes("UTF-8"), ALGORITHM);

        // Crear el IV (vector de inicialización)
        this.ivParameterSpec = new IvParameterSpec(IV.getBytes("UTF-8"));
    }

    // Método para encriptar
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encryptedText = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedText);
    }

    // Método para desencriptar
    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decodedText = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedText = cipher.doFinal(decodedText);
        return new String(decryptedText, "UTF-8");
    }
}
