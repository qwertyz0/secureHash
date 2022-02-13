import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


class SHA256_LB2 {
    public static byte[] getstringSHA(String input) throws NoSuchAlgorithmException
    {
        // Статичний метод getInstance викликається з хешуванням SHA
        MessageDigest digestMess = MessageDigest.getInstance("SHA-256");

        // Метод digest(), викликаний для обчислення дайджесту повідомлення вхідного
        // та повернутого масиву байтів
        return digestMess.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        // Перетворіть масив байтів у подання знаків
        BigInteger number = new BigInteger(1, hash);

        // Перетворіть дайджест повідомлення в шістнадцяткове значення
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Панель із провідними нулями
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public static void main(String args[])
    {
        try
        {
            System.out.println("HashCode SHA-256:");

            String s1 = "..ANYWORD..";
            System.out.println("\n" + s1 + " : " + toHexString(getstringSHA(s1)));

            String s2 = "01AA";
            System.out.println("\n" + s2 + " : " + toHexString(getstringSHA(s2)));
        }
        // Для визначення неправильних алгоритмів дайджесту повідомлень
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }
}
