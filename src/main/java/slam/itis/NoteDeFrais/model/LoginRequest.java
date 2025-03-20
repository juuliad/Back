package slam.itis.NoteDeFrais.model;

public class LoginRequest {
    private String username;
    private String password;

    // Getter pour le nom d'utilisateur
    public String getUsername() {
        return username;
    }

    // Setter pour le nom d'utilisateur
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter pour le mot de passe
    public String getPassword() {
        return password;
    }

    // Setter pour le mot de passe
    public void setPassword(String password) {
        this.password = password;
    }
}