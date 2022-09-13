import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        String lowText = text.toLowerCase();
        Map<Character, Integer> Symbols = new HashMap<>();

        for (int i = 0; i < lowText.length(); i++) {
            char nextCh = lowText.charAt(i);
            if (Character.isLetter(nextCh) && !Symbols.containsKey(nextCh)) {
                Symbols.put(nextCh, 1);
            } else if (Character.isLetter(nextCh) && Symbols.containsKey(nextCh)) {
                Symbols.put(nextCh, Symbols.get(nextCh) + 1);
            }

        }


        System.out.println(Symbols.entrySet());
        int max = -1;
        char digitMax = 0;
        int min = Integer.MAX_VALUE;
        char digitMin = 0;
        for (Map.Entry<Character,Integer> entry : Symbols.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(value > max){max = value; digitMax = key; }
            else if (value < min){ min = value; digitMin = key;}
        }
        System.out.println("Встречается чаще всего буква " + digitMax +  " " + max + " раз");
        System.out.println("Встречается реже всего буква " + digitMin + " " + min + " раз");

        WordsChecker text1 = new WordsChecker(text);
        System.out.println(text1.hasWord("lalala"));
        System.out.println(text1.hasWord("amet"));

    }
}

