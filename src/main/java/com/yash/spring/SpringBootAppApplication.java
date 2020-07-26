package com.yash.spring;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

//@SpringBootApplication
public class SpringBootAppApplication {


    public static void main(String[] args) {
        String[] banned = {"Bob", "hit"};
        String paragraph = "Bob. hIt, baLl";
        List<String> bans = Stream.of(banned).map(String::toLowerCase).collect(Collectors.toList());
        String[] words = paragraph.replaceAll(Pattern.compile("[^A-Za-z0-9]").pattern(), " ").toLowerCase().split(" ");
        System.out.println(Arrays.asList(words));
        Map<String, Integer> map = new HashMap<>();
        for (int i =0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        List<Map.Entry> wordFreq = map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).filter(e -> null != e.getKey() && !e.getKey().equals("")).collect(Collectors.toList());
        System.out.println(wordFreq);
        for (Map.Entry e : wordFreq) {
            if (!bans.contains(e.getKey())) {
                System.out.println(e.getKey());
                break;
            }
        }
    }
}
