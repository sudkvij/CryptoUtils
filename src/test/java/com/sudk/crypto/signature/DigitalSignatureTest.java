package com.sudk.crypto.signature;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;

import com.sudk.crypto.encryption.*;

import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {

    @Test
    public void signVerifySignature()  throws Exception  {
        URL uri = getClass().getClassLoader().getResource("HelloWorld.txt");
        Path path = Paths.get(uri.toURI());
        byte[] input = Files.readAllBytes(path);

        KeyPair keyPair = AsymmetricEncryption.generateKeyPair();
        byte[] signature = DigitalSignature.createSignature(input, keyPair.getPrivate());
        System.out.println(DatatypeConverter.printHexBinary(signature));
        assertTrue(DigitalSignature.verifySignature(input, signature, keyPair.getPublic()));
        }
}