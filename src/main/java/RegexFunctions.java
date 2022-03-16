import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexFunctions {
    public static boolean isPhoneNumberCorrect(String str){
        return correctionChecker(str, "^(8|(\\+7))[0-9]{10}$");
    }
    public static List<String> correctPhoneNumberList(List<String> array){
        return getList(array, str -> isPhoneNumberCorrect(str));
    }
    public static boolean isEmailCorrect(String str){
        return correctionChecker(str, "^[a-z](\\.?[a-z]+)+@[a-z](\\.?[a-z]+)+$");
    }
    public static List correctEmailList(List<String> array){
        return getList(array, str -> isEmailCorrect(str));
    }
    public static boolean isMacCorrect(String str){
        return correctionChecker(str, "^([a-fA-F0-9]{2}(\\.|-)){5}[a-fA-F0-9]{2}$");
    }
    public static List<String> correctMacList(List<String> array){
        return getList(array, str -> isMacCorrect(str));
    }
    private static boolean correctionChecker(String str, String patternString){
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
    private static List<String> getList(List<String> array, Predicate<String> predicate){
        return array.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
