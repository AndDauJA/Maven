package lt.daujotas.Task1;

import com.github.javafaker.Faker;
import com.github.pemistahl.lingua.api.*;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;

import static com.github.pemistahl.lingua.api.Language.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        // fakeFake();
        login();
    }

    public static void fakeFake() {
        Faker faker = new Faker();
        System.out.println("Whichers names:");
        // Miss Samanta Schmidt

        //String streetAddress = faker.address().streetAddress();
        for (int i = 0; i < 10; i++) {
            String witcher = faker.witcher().witcher();
            System.out.println(witcher);
        }
    }


    public static void detectLAnguage() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("iveskite zodi patikrinimui");
            String sc = scanner.nextLine();
            final LanguageDetector detector = LanguageDetectorBuilder.fromLanguages(ENGLISH, FRENCH, GERMAN, SPANISH).build();
            final Language detectedLanguage = detector.detectLanguageOf(sc);
            System.out.println(detectedLanguage);

        }
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> loginData = new HashMap<>();
        String userName;
        String password;

        String sha256hex = DigestUtils.sha256Hex("tesas");

        System.out.println(sha256hex);

        while (true) {
            System.out.println("=====Pasirinkite ivedima=====" + "\n 1.Naudoto vardas ir slaptazodis" + "\n 2.ivesti duomenys");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Iveskite naudoto varda:  ");
                    String scannerVardas = scanner.next();
                    System.out.print("Iveskite slaptazodi:  ");
                    String scannerPasw = scanner.next();
                    loginData.put(scannerVardas, scannerPasw);
                    System.out.print("Iveskite slaptazodi dar karta:  ");
                    String paswcheck = scanner.next();
                    //Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");  // regex patikrinti jei yra emailas
                    Pattern pattern = Pattern.compile(scannerPasw);
                    //Matcher matcher = pattern.matcher(paswcheck);
                    if (loginData.containsKey(scannerVardas) && loginData.get(scannerVardas).equals(paswcheck)) {
                        System.out.println("Slaptazodis ATITIKO.");
                    } else {
                        System.out.println("Slaptazodis NEatitiko.");
                    }
                    break;
                case 2:

                   // if (loginData.containsValue(scannerPasw) && loginData.get(scannerPasw).equals(paswcheck)) {
                        System.out.println("atitiko");
                   /////// } else {
                        System.out.println("gaidys neatitiko :)");
                    //}
                    //boolean isEmailValid = pattern.matcher(paswcheck).matches();
                    break;
                case 3:
                    for (Map.Entry<String, String> duomenys : loginData.entrySet()) {
                        userName = duomenys.getKey();
                        password = duomenys.getValue();
                        System.out.println("Ivesti duomeny yra" + "\n Naudotojo Vardas: " + userName + "\n Slaptazodis: " + password);

                    }
                    break;

            }
        }
    }
}



