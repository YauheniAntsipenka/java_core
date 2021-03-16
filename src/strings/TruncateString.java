package strings;

public class TruncateString {
    public static void start(){
        System.out.println(truncateString("123 56"));
        System.out.println(truncateString("q wert"));

        System.out.println(truncateValue("123 56", 5));
        System.out.println(truncateValue("q wert", 6));
    }

    private static String truncateString(String incomingString){
        if (incomingString.length() > 5){
            if (incomingString.charAt(5) == ' '){
                return incomingString;
            } else {
                for (int i = incomingString.length() - 1; i > 0; i--){
                    if (incomingString.charAt(i) == ' '){
                        return incomingString.substring(0, i);
                    }
                }
            }
        }
        return incomingString;
    }

    private static String truncateValue(String incomingValue, int maxValueLength){
        if (incomingValue.length() > maxValueLength){
            if (String.valueOf(incomingValue.charAt(maxValueLength)).equals(" ")){
                return incomingValue;
            } else {
                int indexOfLastSpace = incomingValue.lastIndexOf(" ");
                return incomingValue.substring(0, indexOfLastSpace);
            }
        }
        return incomingValue;
    }
}
