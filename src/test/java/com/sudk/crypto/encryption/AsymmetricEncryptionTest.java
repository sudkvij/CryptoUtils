package com.sudk.crypto.encryption;

import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;
import java.security.PrivateKey;

import static org.junit.jupiter.api.Assertions.*;

class AsymmetricEncryptionTest {

    @Test
    void generateKeyPair() {
    }

    @Test
    void testRSAEncryption() throws Exception  {
        String plainText = "Hello World";
        KeyPair keyPair = AsymmetricEncryption.generateKeyPair();
        byte[] cipherText = AsymmetricEncryption.performRSAEncryption(plainText, keyPair.getPrivate());
        assertNotNull(cipherText);
        System.out.println(DatatypeConverter.printHexBinary(cipherText));
        String decryptText = AsymmetricEncryption.performRSADecryption(cipherText,keyPair.getPublic());
        assertEquals(plainText,decryptText);
    }


}