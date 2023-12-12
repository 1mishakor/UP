package com.example.matematico.Prov;

import java.util.*;

public class Prov {
    public static void main(String[] args) {
        int b = 0;
        Integer[] vv = {2, 12, 8, 3, 13};
        boolean diagonal = false;
        int a = diagonal ? 10 : 0;
        List<Integer> numbers = Arrays.asList(vv);
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
                boolean bool2 = false;
                /*for (int i = 0; i < 5; i++) {
                    //numbers2.get(i)
                    switch (i) {
                        case 0 -> {
                            bool2 = numbers2.get(i) == 1;
                        }
                        case 1 -> {
                            bool2 = numbers2.get(i) == 10;
                        }
                        case 2 -> {
                            bool2 = numbers2.get(i) == 11;
                        }
                        case 3 -> {
                            bool2 = numbers2.get(i) == 12;
                        }
                        case 4 -> {
                            if (numbers2.get(i) == 13){
                                bool2 = true;
                            }else {
                                bool2 = false;
                            }
                        }
                    }
                }*/
                if (numbers2.get(0) == 1&&
                numbers2.get(1) == 10&&
                numbers2.get(2) == 11&&
                numbers2.get(3) == 12&&
                numbers2.get(4) == 13){
                    bool2 = true;
                }
                if (bool2) b += 150 + a;
            }
        }

        System.out.println(b);
    }
}
