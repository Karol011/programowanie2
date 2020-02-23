package pl.sdacademy.prog.chainOfResponsibility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class Demo {
    public static void main(String[] args) {

        final UserCredentialsRepository repository = new UserCredentialsRepository();
        final UserCredentialsService serviceB = new UserCredentialsService(repository, new BCryptPasswordEncoder());
        final UserCredentialsService serviceS = new UserCredentialsService(repository, new SCryptPasswordEncoder());
        final UserCredentialsService serviceN = new UserCredentialsService(repository, NoOpPasswordEncoder.getInstance());

        final AuthenticationService lastElement = new AuthenticationService(serviceN);
        final AuthenticationService middleElement = new AuthenticationService(serviceS, lastElement);
        final AuthenticationService firstElement = new AuthenticationService(serviceB, middleElement);


        serviceB.createCredentials("andrzej", "haslo_123");
        serviceS.createCredentials("januszek", "qwerty");
        serviceN.createCredentials("grazynka", "12345");

        final boolean andrzejResult = firstElement.authenticate("andrzej", "haslo_123");
        System.out.println(andrzejResult);
        final boolean januszResult = firstElement.authenticate("janusz", "qwerty");
        System.out.println(januszResult);

    }
}
