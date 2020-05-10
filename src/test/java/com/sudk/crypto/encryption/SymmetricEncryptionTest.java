package com.sudk.crypto.encryption;


import org.junit.jupiter.api.Test;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;


import static org.junit.jupiter.api.Assertions.*;

class SymmetricEncryptionTest {

    @Test
    void createAESKey() throws Exception{
        SecretKey secretKey = SymmetricEncryption.createAESKey();
        assertNotNull(secretKey);
        System.out.println(DatatypeConverter.printHexBinary(secretKey.getEncoded()));
    }

    @Test
    void testAESEncryption() throws Exception{
        SecretKey secretKey = SymmetricEncryption.createAESKey();
        byte[] intializationVector = SymmetricEncryption.createInitializationVector();
        String plainText = " Hello World";
        byte[] cipherText = SymmetricEncryption.performAESEncryption(plainText, secretKey, intializationVector);
        assertNotNull(cipherText);
        System.out.println(DatatypeConverter.printHexBinary(cipherText));
        String decryptText = SymmetricEncryption.performAESDecryption(cipherText,secretKey, intializationVector);
        assertEquals(plainText, decryptText);
        System.out.println(decryptText);
    }

}