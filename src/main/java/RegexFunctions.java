import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexFunctions {
    public static boolean isPhoneNumberCorrect(String str) {
        return correctionChecker(str, "^(8|(\\+7))[0-9]{10}$");
    }

    public static List<String> correctPhoneNumberList(List<String> array) {
        return getList(array, RegexFunctions::isPhoneNumberCorrect);
    }

    public static boolean isEmailCorrect(String str) {
        return correctionChecker(str, "^[a-z](\\.?[a-z]+)+@[a-z](\\.?[a-z]+)+$");
    }

    public static List correctEmailList(List<String> array) {
        return getList(array, RegexFunctions::isEmailCorrect);
    }

    public static boolean isMacCorrect(String str) {
        return correctionChecker(str, "^([a-fA-F0-9]{2}(\\.|-)){5}[a-fA-F0-9]{2}$");
    }

    public static List<String> correctMacList(List<String> array) {
        return getList(array, RegexFunctions::isMacCorrect);
    }

    public static boolean isDateCorrect(String str) {
        return correctionChecker(str, "^([1]?[0-9]{0,3}|201[0-9]|202[012]|200[0-9])\\/(1[012]|[0-9])\\/(30|[12]?[0-9])$");
    }

    public static List<String> correctDataList(List<String> array) {
        return getList(array, RegexFunctions::isDateCorrect);
    }

    public static boolean isIpCorrect(String str) {
        return correctionChecker(str, "^((1[0-9]{2}|2[0-4][0-9]|[0-9]{1,2}|25[0-6])\\.){3}(1[0-9]{2}|2[0-4][0-9]|[0-9]{1,2}|25[0-6])$");
    }

    public static List<String> correctIpList(List<String> array) {
        return getList(array, RegexFunctions::isIpCorrect);
    }

    public static boolean isLinkCorrect(String str) {
        return correctionChecker(str, "^https?:\\/\\/[a-z][a-z0-9]+\\.[a-z]+\\/?$");
    }

    public static List<String> correctLinkList(List<String> array){
        return getList(array, RegexFunctions::isLinkCorrect);
    }

    private static boolean correctionChecker(String str, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private static List<String> getList(List<String> array, Predicate<String> predicate) {
        return array.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
