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
        RegexFunctions.setPatternAllString(false);
        assertTrue(RegexFunctions.isPhoneNumberCorrect("Nikita - +79319921293"));
        assertTrue(RegexFunctions.isPhoneNumberCorrect("Artem - 89319921293(his number)"));
        assertFalse(RegexFunctions.isPhoneNumberCorrect("Nikita - +9319921293"));
        RegexFunctions.setPatternAllString(true);
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
        RegexFunctions.setPatternAllString(false);
        assertTrue(RegexFunctions.isEmailCorrect("My email - aa@daf.cae"));
        assertFalse(RegexFunctions.isEmailCorrect("Wrong email - dafs.daf.@afaaf.dad.fa.ad"));
        RegexFunctions.setPatternAllString(true);
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
    @Test
    void isMacCorrect(){
        assertTrue(RegexFunctions.isMacCorrect("12.af.32.43.43.a3"));
        assertTrue(RegexFunctions.isMacCorrect("ad-ad-da-da-da-da"));
        assertFalse(RegexFunctions.isMacCorrect("dada.da.34.65.65.54"));
        assertFalse(RegexFunctions.isMacCorrect("fs.43.54.65.76.45"));
        RegexFunctions.setPatternAllString(false);
        assertTrue(RegexFunctions.isMacCorrect("MAC of my friend - 12.af.32.43.43.a3"));
        assertFalse(RegexFunctions.isMacCorrect("Incorrect MAC - z.da.34.65.65.54"));
        RegexFunctions.setPatternAllString(true);
    }

    @Test
    void isDateCorrect(){
        for (int i = 0; i <= 2022; i++) {
            for (int j = 0; j <= 12; j++) {
                for (int k = 0; k <= 30; k++) {
                    assertTrue(RegexFunctions.isDateCorrect(String.format("%d/%d/%d", i, j,k)));
                }
            }
            for (int j = 13; j < 100; j++) {
                for (int k = 0; k < 30; k++) {
                    assertFalse(RegexFunctions.isDateCorrect(String.format("%d/%d/%d", i, j,k)));
                }
            }
            for (int j = 0; j < 12; j++) {
                for (int k = 31; k < 100; k++) {
                    assertFalse(RegexFunctions.isDateCorrect(String.format("%d/%d/%d", i, j,k)));
                }
            }
        }
    }
    @Test
    void isIpCorrect(){
        assertTrue(RegexFunctions.isIpCorrect("230.43.132.32"));
        assertTrue(RegexFunctions.isIpCorrect("256.256.256.256"));
        assertTrue(RegexFunctions.isIpCorrect("12.23.43.124"));
        assertTrue(RegexFunctions.isIpCorrect("2.2.4.1"));
        assertFalse(RegexFunctions.isIpCorrect("2.2.4."));
        assertFalse(RegexFunctions.isIpCorrect("257.2.4.2"));
        assertFalse(RegexFunctions.isIpCorrect("2.300.4.12"));
        RegexFunctions.setPatternAllString(false);
        assertTrue(RegexFunctions.isIpCorrect("IP230.43.132.32Ip"));
        assertFalse(RegexFunctions.isIpCorrect("Error2.2.4.Error"));
        RegexFunctions.setPatternAllString(true);
    }

    @Test
    void isLinkCorrect(){
        assertTrue(RegexFunctions.isLinkCorrect("https://regex101.com/"));
        assertTrue(RegexFunctions.isLinkCorrect("https://vk.com"));
        assertTrue(RegexFunctions.isLinkCorrect("http://dgdg.c"));
        assertFalse(RegexFunctions.isLinkCorrect("hhdj://ksdd.re"));
        assertFalse(RegexFunctions.isLinkCorrect("http://dsgsvd"));
        assertFalse(RegexFunctions.isLinkCorrect("http://dsgsvd."));
        RegexFunctions.setPatternAllString(false);
        assertTrue(RegexFunctions.isLinkCorrect("I am in https://vk.com"));
        assertFalse(RegexFunctions.isLinkCorrect("Error - hhdj://ksdd.re STATUS-404"));
        RegexFunctions.setPatternAllString(true);
    }

    @Test
    void isTimeCorrect(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertTrue(RegexFunctions.isTimeCorrect(String.format("0%d:0%d", i, j)));
            }
            for (int j = 10; j < 60; j++) {
                assertTrue(RegexFunctions.isTimeCorrect(String.format("0%d:%d", i, j)));
            }

        }
        assertFalse(RegexFunctions.isTimeCorrect("23:60"));
        assertFalse(RegexFunctions.isTimeCorrect("30:30"));
        RegexFunctions.setPatternAllString(false);
        assertTrue(RegexFunctions.isTimeCorrect( "Now - 23:23 o'clock"));
        assertFalse(RegexFunctions.isTimeCorrect("Time can't be 23:60, in hour 60 minute, not 61 :)"));
        RegexFunctions.setPatternAllString(true);
    }

    @Test
    void isCarNumberCorrect(){
        assertTrue(RegexFunctions.isCarNumberCorrect("a103bv"));
        assertTrue(RegexFunctions.isCarNumberCorrect("r002re"));
        assertFalse(RegexFunctions.isCarNumberCorrect("r002r"));
        assertFalse(RegexFunctions.isCarNumberCorrect("r002ree"));
        assertFalse(RegexFunctions.isCarNumberCorrect("r02re"));
        assertFalse(RegexFunctions.isCarNumberCorrect("r0002re"));
        RegexFunctions.setPatternAllString(false);
        assertFalse(RegexFunctions.isCarNumberCorrect("You give me wrong number - r02re"));
        assertTrue(RegexFunctions.isCarNumberCorrect("The car number of intruder a103bv"));
        RegexFunctions.setPatternAllString(true);
    }

    @Test
    void getListOfUpperCaseWords(){
        List<String> list = RegexFunctions.getListOfUpperCaseWords("A world Of humAns Failed");
        assertEquals(list.get(0), "A");
        assertEquals(list.get(1), "Of");
        assertEquals(list.get(2), "Failed");
    }

    @Test
    void getListOfLowerCaseWords(){
        List<String> list = RegexFunctions.getListOfLowerCaseWords("A world Of humans Failed");
        assertEquals(list.get(0), "world");
        assertEquals(list.get(1), "humans");
    }

    @Test
    void getListOfWordsContainingSubstr(){
        List<String> list = RegexFunctions.getListOfWordsContainingSubstr(
                "Subversion of subprogram was difficult and, maybe, incorrect Resub , fsub subster ", "sub", true);
        assertEquals(list.get(0), "subversion");
        assertEquals(list.get(1), "subprogram");
        assertEquals(list.get(2), "resub");
        assertEquals(list.get(3), "fsub");
        assertEquals(list.get(4), "subster");
    }

    @Test
    void getListOfWordsStartingFrom(){
        List<String> list = RegexFunctions.getListOfWordsStartingFrom(
                "Subversion of subprogram was difficult and, maybe, incorrect Resub , fsub subster ", "sub", true);
        assertEquals(list.get(0), "subversion");
        assertEquals(list.get(1), "subprogram");
        assertEquals(list.get(2), "subster");
    }

    @Test
    void getListOfWordsEndingWith(){
        List<String> list = RegexFunctions.getListOfWordsEndingWith(
                "Subversion of subprogram was difficult and, maybe, incorrect Resub , fsub subster ", "sub", true);
        assertEquals(list.get(0), "resub");
        assertEquals(list.get(1), "fsub");
    }
}