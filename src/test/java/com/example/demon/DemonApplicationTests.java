package com.example.demon;

import com.example.demon.test.GitHubService;
import com.example.demon.test.GitRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.*;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemonApplicationTests {

//    @BeforeEach
//    void test(){
//        System.out.println("===== start =====");
//    }
//
//    @AfterEach
//    void test2(){
//        System.out.println("===== end =====");
//    }

    // PCCP 모의고사 1회 2번 체육대회


    int len;

    public int[] solution(String today, String[] terms, String[] privacies) {
        //파기해야 할 개인정보 번호를 오름차순 정렬해서 리턴할것.
        len = privacies.length;

        HashMap<String, Integer> terM = new HashMap<>();
        int[] expireT = new int[len];

        ArrayList<Integer> list = new ArrayList<>();
        int now = getDays(today);
        for (String x : terms) {
            terM.put(x.split(" ")[0], Integer.parseInt(x.split(" ")[1]) * 28);
        }

        for (int i = 0; i < len; i++) {
            int day = getDays(privacies[i].split(" ")[0]);
            String key = privacies[i].split(" ")[1];
            expireT[i] = day + terM.get(key);
            //System.out.println(now+","+expireT[i]);
            if (expireT[i] <= now) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public int getDays(String x) {
        int y = Integer.parseInt(x.split("\\.")[0]);
        int m = Integer.parseInt(x.split("\\.")[1]);
        int d = Integer.parseInt(x.split("\\.")[2]);

        return d + m * 28 + (y - 2000) * 12 * 28;
    }

//    @Test
//    void contextLoads() throws IOException {
//
//        GitHubService gitHubService = new GitHubService() {
//            @Override
//            public GitHub connect() throws IOException {
//                return GitHub.connect();
//            }
//        };
//
//        "xptmxm".equals("awrawr");
//        "aasd".hashCode();
//
//        try{
//            GitRepository gitRepository = new GitRepository(gitHubService);
//            int point = gitRepository.getPoint("whiteship/live-study");
//            System.out.println(point);
//            System.out.println(point);
//
//        }catch (Exception e ){
//            e.printStackTrace();
//        }
//    }

}
