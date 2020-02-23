package pl.sdacademy.prog.chainOfResponsibility;

import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sdacademy.prog.streams.SdaException;

import java.util.Optional;

public class UserCredentialsService implements Authenticator {

    private final UserCredentialsRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserCredentialsService(final UserCredentialsRepository repository, final PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    //tworzac credentiale upewnij sie ze uzytkownik ich jeszcze nie ma
    public void createCredentials(final String username, final String password) {
        repository.getPassword(username)
                .ifPresent((pwd) -> {
                    throw new SdaException("User already has password");
                });
        repository.add(new UserCredentials(username, passwordEncoder.encode(password)));
    }

    public void removeAccount(final String username) {
        repository.getPassword(username)
                .orElseThrow(() -> new SdaException("Cannot delete non existing user"));
        repository.delete(username);
    }

    //Aktualizujac credentiale upewnij sie ze nowe haslo jest rozne od starego
    public void updateCredentials(final String username, final String newPassword) {
        final String oldPassword = repository.getPassword(username).orElseThrow(() ->
                new SdaException("Cannot update non existing user"));
        if (passwordEncoder.matches(newPassword, oldPassword)) {
            throw new SdaException("Cannot change password to old one");
        }
        repository.update(new UserCredentials(username, passwordEncoder.encode(newPassword)));
    }

    @Override
    public boolean matches(final String username, final String password) {
        final Optional<String> hashedPassword = repository.getPassword(username);
        if (hashedPassword.isEmpty()) {
            return false;
        }
        try {
            return passwordEncoder.matches(password, hashedPassword.get());
        } catch (final Exception exp) {
            return false;
        }
    }
}
