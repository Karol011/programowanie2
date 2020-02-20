package pl.sdacademy.prog.encryption;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AESEncryptionService {

    public void executeAESOperation(final String sourcePAth, final String outputPath,
                                    final int operationMode, final int keyGenerationSeed) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        final byte[] keyValue = new byte[32];
        new Random(keyGenerationSeed).nextBytes(keyValue);
        final SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
        final Cipher cipher = Cipher.getInstance("AES");
        cipher.init(operationMode, key);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourcePAth)){};
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
