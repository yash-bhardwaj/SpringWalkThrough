package com.yash.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(final String[] args) throws IOException {
        //		SpringApplication.run(SpringBootAppApplication.class, args);
        //	}
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        final List<Integer> series = getSeries(Math.pow(10, T));
        while (T >= 0) {
            final int N = Integer.parseInt(br.readLine());
            final Integer finalNum = series.get(N - 1);
            System.out.println(getDigits(finalNum));
            --T;
        }
    }

    private static List<Integer> getSeries(final double limit) {
        final List<Integer> series = new ArrayList<>();
        if (limit>3) series.addAll(Arrays.asList(1,2,3));
        for (int j = 0; j < limit; j++) {
            if (!hasDigit(j)) {
                series.add((j * 10 + 1));
                series.add((j * 10 + 2));
                series.add((j * 10 + 3));
            }
        }
        System.out.println(series);
        return series;
    }

    public static boolean hasDigit(final long number) {
        boolean status;
        for (final char ch: "0456789".toCharArray()) {
            status =  String.valueOf(number).contains(ch+"");
            if (status) return true;
        }
        return false;
    }

    private static int getDigits(Integer n) {
        int count = 0;
        while (n >= 1) {
            count++;
            n /= 10;
        }
        return count;
    }
}
