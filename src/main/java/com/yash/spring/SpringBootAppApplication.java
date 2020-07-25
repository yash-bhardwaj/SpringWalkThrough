package com.yash.spring;

import java.util.*;
import java.util.stream.Collectors;

//@SpringBootApplication
public class SpringBootAppApplication {
		/*static String isBalanced(String s) {

			char[] braces = s.toCharArray();
			String buffer = "";
			for (int i =0 ; i<braces.length; i++) {
				char c = s.charAt(i);
				switch (c) {
					case '(' : buffer += c; break;
					case '{' : buffer += c; break;
					case '[' : buffer += c; break;
					case ')' : buffer.deleteCharAt(buffer.length()-1); break;
					case '}' : buffer.deleteCharAt(buffer.length()-1); break;
					case ']' : buffer.deleteCharAt(buffer.length()-1); break;
				}
			}

			boolean b = buffer.toString().equals("");
			return b ? "YES" : "NO";
		}*/

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0) {
            String next = sc.nextLine();
            int n = Integer.parseInt(next.split(" ")[0]);
            int k = Integer.parseInt(next.split(" ")[1]);
            List<String> words = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                words.add(sc.nextLine().toLowerCase());
            }
            System.out.println("Case " + t + ":");
            printMostFreqWords(words, k);
            --t;
        }
    }

    private static void printMostFreqWords(List<String> words, int k) {
        List<List<String>> possibleCombs = new ArrayList<>();
        String[] kArr = new String[k];

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < k-1; j++) {
                kArr[j] = kArr[j+1];
            }
            kArr[k-1] = words.get(i);
            possibleCombs.add(new ArrayList<>(Arrays.asList(kArr)));
        }

        possibleCombs = possibleCombs.stream().map(list -> list.stream().filter(Objects::nonNull).collect(Collectors.toList())).collect(Collectors.toList());
        possibleCombs.forEach(decFrequency -> {

            if (decFrequency.size() < 2) {
                System.out.println(decFrequency.get(0) + " " + 1);
            } else {
                Map<String, Integer> map = getMostFrequentWord(decFrequency);
                List<String> alphabatical = new ArrayList<>(decFrequency);
                decFrequency.sort((a,b) -> map.get(b) - map.get(a));
                Collections.reverse(decFrequency);
                Collections.sort(alphabatical);
                String freKey = decFrequency.get(decFrequency.size()-1);
                Integer freVal = map.get(freKey);

                String alphaKey = alphabatical.get(0);
                Integer alphaVal = map.get(alphaKey);

                if (freVal > alphaVal) System.out.println(freKey + " " + freVal);
                else System.out.println(alphaKey + " " + alphaVal);
            }

        });
    }

    private static Map<String, Integer> getMostFrequentWord(List<String> limit) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < limit.size(); i++) {
            map.put(limit.get(i), map.getOrDefault(limit.get(i), 0) + 1);
        }
        return map;
    }
}
