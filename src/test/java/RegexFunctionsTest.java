import com.sun.jdi.connect.ListeningConnector;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegexFunctionsTest {

    @Test
    void isPhoneNumberCorrect() {
        assertTrue(RegexFunctions.isPhoneNumberCorrect("+79319921293"));
        assertTrue(RegexFunctions.isPhoneNumberCorrect("89319921293"));
        assertFalse(RegexFunctions.isPhoneNumberCorrect("+7931972129"));
        assertFalse(RegexFunctions.isPhoneNumberCorrect("8931972129"));
        assertFalse(RegexFunctions.isPhoneNumberCorrect("+793197212921"));
        assertFalse(RegexFunctions.isPhoneNumberCorrect("+99319721292"));
    }

    @Test
    void correctPhoneNumberList() {
        List<String> list = Arrays.asList("+79319921293",
                "89319921293",
                "+7931972129",
                "8931972129",
                "+793197212921",
                "+99319721292");
        assertEquals(RegexFunctions.correctPhoneNumberList(list), Arrays.asList("+79319921293",
                "89319921293"));

    }

    @Test
    void isEmailCorrect() {
        assertTrue(RegexFunctions.isEmailCorrect("aa@daf.cae"));
        assertTrue(RegexFunctions.isEmailCorrect("a.s@d.af.fs"));
        assertTrue(RegexFunctions.isEmailCorrect("asdaddas@yandex.com"));
        assertTrue(RegexFunctions.isEmailCorrect("asda.ddas@yandex.com"));
        assertFalse(RegexFunctions.isEmailCorrect("dafs.daf.@afaaf.dad.fa.ad"));
        assertFalse(RegexFunctions.isEmailCorrect(".dafsaf@dasf.com"));
        assertFalse(RegexFunctions.isEmailCorrect("a@daf.cae"));
    }

    @Test
    void correctEmailList() {
        List<String> list = Arrays.asList("aa@daf.cae",
                "a.s@d.af.fs",
                "asdaddas@yandex.com",
                "asda.ddas@yandex.com",
                "dafs.daf.@afaaf.dad.fa.ad",
                ".dafsaf@dasf.com",
                "a@daf.cae");
        assertEquals(RegexFunctions.correctEmailList(list),Arrays.asList("aa@daf.cae",
                "a.s@d.af.fs",
                "asdaddas@yandex.com",
                "asda.ddas@yandex.com"));
    }
}