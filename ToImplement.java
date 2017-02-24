import java.util.*;
//Test Cases in the main function can be uncommented if testing from this class

public class ToImplement {

    public static HashMap < String, String > map = new HashMap < > ();
    public static String ShortUrl = "";


    public static void main(String[] args) {
            for (int i = 0; i < 5000; i++) {
            ShortUrl = set("asbc.com");
            String a = get(ShortUrl);
            System.out.println(ShortUrl);
            }
        }
        //Sets a Short URL of the form [A-Z][a-z][0-9] - This accepts the Long URL as parameter
    public static String set(String LongURI) {
        if (ShortUrl.length() == 0) {
            map.put("A", LongURI);
            return "A";
        }
        if (ShortUrl.charAt(0) == 'Z') {
            if (ShortUrl.length() == 1) {
                map.put("Aa", LongURI);
                return "Aa";
            } else if (ShortUrl.charAt(1) != 'z') {
                if (ShortUrl.length() == 3) {
                    int c = ShortUrl.charAt(1);
                    ShortUrl = ShortUrl.substring(0, 1) + String.valueOf((char)(c + 1)) + ShortUrl.substring(2);
                } else {
                    int c = ShortUrl.charAt(1);
                    ShortUrl = "A" + String.valueOf((char)(c + 1));
                }
            } else if (ShortUrl.charAt(1) == 'z') {
                if (ShortUrl.length() == 2) {
                    map.put("Aa0", LongURI);
                    return "Aa0";
                } else if (ShortUrl.charAt(2) == '9') {
                    //Exits from the program when the last regex Zz9 is added to the map.
                    System.out.println("Maximum Limit Reached.");
                    System.exit(0);
                } else {
                    int c = ShortUrl.charAt(2);
                    ShortUrl = "Aa" + String.valueOf((char)(c + 1));
                }
            }
        } else {
            if (ShortUrl.length() == 1) {
                int c = ShortUrl.charAt(0);
                ShortUrl = String.valueOf((char)(c + 1)) + ShortUrl.substring(0, ShortUrl.length() - 1);
            } else //if(ShortUrl.length() == 2)
            {
                int c = ShortUrl.charAt(0);
                ShortUrl = String.valueOf((char)(c + 1)) + ShortUrl.substring(1);
            }
        }
        map.put(ShortUrl, LongURI);
        return ShortUrl;
    }

    //Returns Long URL by mapping onto the respective hash - This accepts Short URL as parameter
    public static String get(String ShortURI) {
        //System.out.println(map.get(ShortURI));
        return map.get(ShortURI).toString();
    }
}