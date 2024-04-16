package org.example.oenskesky.Services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class RandomIDGenerator {
    //Variables written in upper case according to convention as they're constants.
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$&*()_+-=[]?";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER;
    private static SecureRandom random = new SecureRandom();

    //Will generate password, with length dependent on argument provided in main method,
    //using randomly selected character from String DATA_FOR_RANDOM_STRING.
    public static String generateRandomID(int length) {
        if (length < 1) throw new IllegalArgumentException("Password length must be at least 1");

        //StringBuilder allows for dynamic modification of Strings - the length of the String is defined by an argument.
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            //Generates random integer between index 0 and n from DATA_FOR_RANDOM_STRING.length
            int randomIndex = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            //A random char gets added(appended) to stringBuilder for each loop.
            stringBuilder.append(DATA_FOR_RANDOM_STRING.charAt(randomIndex));
        }
        //Since the current content of stringBuilder is an array of chars,
        //it needs to be converted to a String in order to be returned as such.
        return stringBuilder.toString();
    }
}