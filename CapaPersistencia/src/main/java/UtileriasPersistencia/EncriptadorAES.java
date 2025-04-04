/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtileriasPersistencia;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase utilitaria para encriptar y desencriptar texto usando AES.
 *
 * @author Daniel Miribe
 */
public class EncriptadorAES {

    // Clave de 16 caracteres (128 bits). 
    private static final String CLAVE_SECRETA = "ITSONnainari2025";

    /**
     * Encripta una cadena de texto usando AES.
     *
     * @param texto Texto plano a encriptar.
     * @return Texto encriptado en base64.
     * @throws Exception si ocurre un error durante la encriptacion.
     */
    public static String encriptar(String texto) throws Exception {
        SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * Desencripta un texto encriptado en base64.
     *
     * @param textoEncriptado Texto encriptado.
     * @return Texto plano.
     * @throws Exception si ocurre un error durante la desencriptacion.
     */
    public static String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(textoEncriptado);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted);
    }
}
