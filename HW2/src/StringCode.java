import java.util.HashSet;

public class StringCode {
    public String blowup(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) != '\0' ){
                    int a = Character.getNumericValue(str.charAt(i));
                    for (int j = 0; j < a; j++) {
                        sb.append(str.charAt(i+1));
                    }
                }
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public int maxRun(String str) {
        int max = 0;
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 1;
            }
        }
        return max;
    }

    public boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null) {
            return false;
        }
        if (len <= 0) {
            return false;
        }
        if (len > a.length() || len > b.length()) {
            return false;
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }
        for (int i = 0; i <= b.length() - len; i++) {
            String sub = b.substring(i, i + len);
            if (set.contains(sub)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new StringCode().blowup("12x"));
        System.out.println(new StringCode().maxRun("xxxxggggggiii"));
        System.out.println(new StringCode().stringIntersect("asdfdssff", "dsidsdass" , 2));
    }
}

