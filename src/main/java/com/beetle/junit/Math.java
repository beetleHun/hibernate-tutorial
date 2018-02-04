package com.beetle.junit;

import java.util.List;

public class Math {

    int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(integer -> integer).sum();
    }

}
