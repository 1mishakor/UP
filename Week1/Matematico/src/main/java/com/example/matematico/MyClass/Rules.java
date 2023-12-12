package com.example.matematico.MyClass;

import java.util.*;

public class Rules {
    public int getRules(Integer[] list, boolean diagonal) {
        int b = 0;
        int a = diagonal ? 10 : 0;
        List<Integer> numbers = Arrays.asList(list);
        Set<Integer> set = new HashSet<>();
        List<Object> duplicates = new ArrayList<>();
        numbers.forEach(n -> {
            if (!set.add(n)) {
                duplicates.add(n);
            }
        });
        Set<Integer> set2 = new HashSet<>();
        List<Object> duplicates2 = new ArrayList<>();
        duplicates.forEach(n -> {
            if (!set2.add((Integer) n)) {
                duplicates2.add(n);
            }
        });

        if (duplicates2.size() != 0) {
            if (set2.size() != 1) {
                if (new ArrayList<>(set).get(0) == 1 && new ArrayList<>(set).get(1) == 13) {
                    b += 100 + a;
                } else {
                    b += 80 + a;
                }

            } else if (duplicates2.size() == 2) {
                if (Objects.equals(duplicates2.get(0), 1)) {
                    b += 200 + a;
                } else {
                    b += 160 + a;
                }

            } else {
                b += 40 + a;
            }
        } else {
            if (duplicates.size() != 0) {
                b += 10 * duplicates.size() + a;
            } else {
                List<Integer> numbers2 = new ArrayList<>(set);
                boolean bool = true;
                for (int i = 0; i < 5; i++) {
                    if (numbers2.get(i) != i + 1) {
                        bool = false;
                        break;
                    }
                }
                if (bool) b += 50 + a;
                boolean bool2 = numbers2.get(0) == 1 &&
                        numbers2.get(1) == 10 &&
                        numbers2.get(2) == 11 &&
                        numbers2.get(3) == 12 &&
                        numbers2.get(4) == 13;
                if (bool2) b += 150 + a;
            }
        }
        return b;
    }
}

