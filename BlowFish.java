
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import javax.crypto.spec.IvParameterSpec;
import java.math.BigInteger;
import javax.xml.bind.DatatypeConverter;
public class BlowFish {
    public static String blowfish(String msg,String mode) throws Exception{
        byte[] key	= "secret".getBytes();
        String IV  	= "12345678";
        SecretKeySpec keySpec = new SecretKeySpec(key, "Blowfish"); 
        Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding"); 
        String out = null;
        String msgg = new String();
        if ( mode.equals("e") ){
            String secret = msg;
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new javax.crypto.spec.IvParameterSpec(IV.getBytes())); 
            byte[] encoding = cipher.doFinal(secret.getBytes());
            msgg = DatatypeConverter.printBase64Binary(encoding);
            return msgg;
        } 
        else{
            SecureRandom random = new SecureRandom();
            byte[] ivBytes = new byte[8];
            random.nextBytes(ivBytes); // randomly generates bytes that fill the array
            IvParameterSpec iv = new IvParameterSpec(ivBytes);
            byte[] ciphertext = DatatypeConverter.parseBase64Binary(msg);
            System.out.println("CipherRecived");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
            System.out.println("CipherInit");
            System.out.println(ciphertext.toString());
            byte[] message = cipher.doFinal(ciphertext);
            System.out.println("MessageMad");
            msgg = new String(message);
            System.out.println("MessageConverted");
            return msgg;
        }
    }
}	