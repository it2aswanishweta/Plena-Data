package PlenaData;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	static int[] counts;
    static char[] chars;
    public static int findFirstOccurance(String s) {
        counts = new int[128];
        chars = s.toCharArray();
        
        for (char ch: chars) {
            if (Character.isUpperCase(ch)) {
                counts[Character.toLowerCase(ch)]++;
            } else {
                counts[ch]++;
            }
        }

        for (int i = 0; i < chars.length; i++) {
        	char ch = chars[i];
        	if (Character.isUpperCase(chars[i])) {
        		 ch = Character.toLowerCase(ch);
        	}
            if (counts[ch] == 1) return i;
        }

        return -1;
    }

    private static String inOrderPrint(String s) {
        StringBuilder str = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
            	
                char ch = s.charAt(a), ch2 = s.charAt(b);
                
                if (Character.isUpperCase(ch)) ch = Character.toLowerCase(ch);
                if (Character.isUpperCase(ch2)) ch2 = Character.toLowerCase(ch2);

                if (counts[ch] < counts[ch2]) return -1;
                if (counts[ch] > counts[ch2]) return 1;

                return a - b;
            }
        });
        for (int i = 0; i < s.length(); i++) pq.add(i);

        while (!pq.isEmpty()) {
            str.append(s.charAt(pq.poll()));
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "";
        	System.out.println("Enter a String");
            s = in.nextLine();

            // Problem Driver code
            int idx = findFirstOccurance(s);
            if (idx == -1) System.out.println("No unique character");
            else System.out.println(s.charAt(idx));
            System.out.println(inOrderPrint(s));
        

        in.close();
    } 

	
}
