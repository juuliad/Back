package test1.java;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import slam.itis.notedefrais.model.Visiteur;
import slam.itis.notedefrais.service.VisiteurService;

@SpringBootTest
class VisiteurServiceTest {
    private final VisiteurService visiteurService = new VisiteurService();

    @Test
    void testIsValidPasswordLength() {
        // Test un mot de passe valide
        String validPassword = "ValidPass123"; 
        Visiteur visiteurValid = visiteurService.getVisiteurByMdp(validPassword);
        assertNotNull(visiteurValid);

        // Test un mot de passe trop court
        String shortPassword = "short";
        Visiteur visiteurShort = visiteurService.getVisiteurByMdp(shortPassword);
        assertNull(visiteurShort);

        // Test un mot de passe trop long
        String longPassword = "ThisIsAReallyLongPassword123";
        Visiteur visiteurLong = visiteurService.getVisiteurByMdp(longPassword);
        assertNotNull(visiteurLong);
    }
}