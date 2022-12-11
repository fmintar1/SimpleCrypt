package Crypto.src;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Character cs;
    Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }
    ROT13() {
    }

    public String crypt(String text) throws UnsupportedOperationException {
        String result = "";
        for (Character i : text.toCharArray()) {
            String temp = i.toString();
            if (temp.matches("[a-z]")) result += (char)(((i - (97 - (this.cf - this.cs))) % 26) + 97);
            if (temp.matches("[A-Z]")) result += (char) (((i - (65 - (this.cf - this.cs))) % 26) + 65);
            if (!temp.matches("[a-zA-Z]")) result += temp;
        }
        return result;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        return s.substring(s.indexOf(c)) + s.substring(0, s.indexOf(c));
    }
}
