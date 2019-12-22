package Tests;

import io.restassured.response.*;
import static io.restassured.RestAssured.given;

public class Utils {

    private static String baseURL = "http://fish-text.ru/get";
    private static String type = "type";
    private static String number = "number";
    private static String format = "format";

    public static String def = null;
    public static String formatJSON = "json";
    public static String formarHTML = "html";
    public static String typeTitle = "title";
    public static String typeParagraph = "paragraph";
    public static String typeSentence = "sentence";
    public static String errorText1 = "You requested too much content. Be more moderate.";
    public static String errorText0 = "Unknown error. Contact the administration.";
    public static String status = "status";
    public static String statusSuccess = "success";
    public static String statusError = "error";
    public static String errorCode = "errorCode";
    public static String text = "text";


    public static Response request(String type, int num, String format) {
        return given()
                .queryParam(type, type)
                .queryParam(number, num)
                .queryParam(format, format)
                .get(baseURL);
    }


    public static String getInvalidAmountMessage(String type) {
        return "Invalid amount of '" + type + "':";
    }


    public static String countItemsNumber(String responseTest, String type, String format) {
        String[] tokens = responseTest.split(getDelimiter(type, format));
        if (type.equals(typeSentence) && format.equals(formarHTML)) {
            return tokens.length - 1;
        } else {
            return tokens.length;
        }
    }

    private static String getDelimiter(String type, String format) {
        if (type.equals(typeSentence)) {
            return "[.?!]";
        } else {
            if (format.equals(formatJSON)) {
                return "\\\\n\\\\n";
            } else {
                if (type.equals(typeParagraph)) {
                    return "</p>";
                } else { // TYPE_TITLE
                    return "</h1>";
                }
            }
        }
    }
}
