package com.sudk.crypto.encryption;

import javax.crypto.Cipher;
import java.security.*;

public class AsymmetricEncryption {

private static final String RSA = "RSA";

public static KeyPair generateKeyPair() throws  Exception {
    SecureRandom secureRandom = new SecureRandom();
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
    keyPairGenerator.initialize(4096,secureRandom);
    return keyPairGenerator.generateKeyPair();
}

public static byte[] performRSAEncryption(String plainText, PrivateKey privateKey) throws Exception{
    Cipher cipher = Cipher.getInstance(RSA);
    cipher.init(Cipher.ENCRYPT_MODE,privateKey);
    return cipher.doFinal(plainText.getBytes());
}

public static String performRSADecryption(byte[] cypherText, PublicKey publicKey) throws Exception {
    Cipher cipher = Cipher.getInstance(RSA);
    cipher.init(Cipher.DECRYPT_MODE,publicKey);
    return new String(cipher.doFinal(cypherText));
}

}
