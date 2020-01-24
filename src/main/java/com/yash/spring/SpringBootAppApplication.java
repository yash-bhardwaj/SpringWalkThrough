package com.yash.spring;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootAppApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
        //final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //processStringProblem(br);
        //processSeriesProblem(br);

    private static void processStringProblem(final BufferedReader br) throws IOException {
        List<Integer> n_q = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        final int n = n_q.get(0);
        String a = br.readLine();
        String b = br.readLine();
        String i;
        int queryNum;
        while ((i = br.readLine()) != null) {
            queryNum = Integer.parseInt(i)-1;
            if (queryNum + 1 > n ) throw new RuntimeException("ArrayIndexOutOfBounds");
            if (queryNum <= b.length()){
                b = b.substring(0, queryNum) + 1 + b.substring(queryNum + 1);
            }
            if (a.equals(b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            System.out.println(b);
        }
    }

    private static void processSeriesProblem(final BufferedReader br) throws IOException {
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
