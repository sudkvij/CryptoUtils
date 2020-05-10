package com.sudk.crypto.hashing;

import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilsTest {

    @Test
    void createSHA2Hash() throws Exception {
        byte[] salt = HashUtils.generateSalt();
        byte[] hashValue = HashUtils.createSHA2Hash("Hello World", salt);
        assertNotNull(hashValue);
        System.out.println(DatatypeConverter.printHexBinary(hashValue));
    }
}