package postoffice.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectUrl {

    private  static  String[] urls = {
      "/postoffice/newspaper/getAll",
            "/postoffice/order/getAll"
    };
    public static boolean isDirect(String url){
        System.out.println("DirectUrl:" + url);
        for (String x :
                urls ) {
            Pattern pattern = Pattern.compile(x);
            Matcher m = pattern.matcher(url);
            if(m.matches()){
                return true;
            }
        }
        return false;
    }
}
