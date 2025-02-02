import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123"; // Replace with the password you want to encode
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded password: " + encodedPassword);
    }
}