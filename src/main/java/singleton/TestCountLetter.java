package singleton;

import java.util.*;

/**
 * @author ：Rock-Cao
 * @date ：Created at 2019/12/17 22:42
 * @modified By：
 * @version: 1.0$
 */
public class TestCountLetter {
    private String outPut(String input) {
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(52);
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            }else {
                map.put(aChar, map.get(aChar) + 1);
            }
        }
        return sortOutPut(map);
    }

    private String sortOutPut(HashMap<Character,Integer> map) {
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue().equals( o2.getValue())) {
                return o1.getKey() - o2.getKey();
            } else {
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TestCountLetter testCountLetter = new TestCountLetter();
        System.out.println(testCountLetter.outPut("aabccAAB"));
    }

    public String getNewString(String a) {
        char[] chars = a.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        ArrayList<Character> list = new ArrayList<>(set);
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });
        return list.toString();
    }

    public String calute(String input) {
        try {
            String[] split = input.split(",");
            double a = Double.parseDouble(split[0]);
            double b = Double.parseDouble(split[2]);
            switch (split[1]) {
                case "+":
                    return String.format("%.2f", Math.abs(a + b));
                case "-":
                    return String.format("%.2f", Math.abs(a - b));
                case "*":
                    return String.format("%.2f", Math.abs(a * b));
                case "/":
                    return String.format("%.2f", Math.abs(a / b));
                default:
                    return "非法运算";

            }
        } catch (NumberFormatException e) {
            return "非法运算";
        }
    }


}
