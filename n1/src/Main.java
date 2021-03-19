import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Consumer cus = (String[] strs) -> {
            int maxSym=0;
            String res = "";
            HashSet <String> listChar;
            for(int i = strs.length-1; i >= 0; i--){
                listChar = new HashSet<>(Arrays.asList(strs[i].split("")));
                if(listChar.size()>maxSym) {
                    maxSym = listChar.size();
                    res = strs[i];
                }
            }
            return res;
        };
        String[] src = {"aaaabbb", "abc", "cccccc", "addfsc"};
        System.out.println(cus.control(src));
    }
}
