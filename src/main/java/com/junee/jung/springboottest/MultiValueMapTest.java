package com.junee.jung.springboottest;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

public class MultiValueMapTest {
    public static void main(String[] args) {
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("key","value1");
        map.add("key","value2");
        map.add("key","value3");
        List<String> list = map.get("key");
        System.out.println(list.toString());
    }
}
