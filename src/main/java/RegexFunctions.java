import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexFunctions {
    public static boolean isPhoneNumberCorrect(String str){
        Pattern pattern = Pattern.compile("^(8|(\\+7))[0-9]{10}$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
    public static List<String> correctPhoneNumberList(List<String> array){
        return array.stream()
                .filter(str -> isPhoneNumberCorrect(str))
                .collect(Collectors.toList());
    }
    public static boolean isEmailCorrect(String str){
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
    public static List correctEmailList(List<String> array){
        return array.stream()
                .filter(str -> isEmailCorrect(str))
                .collect(Collectors.toList());
    }
}
