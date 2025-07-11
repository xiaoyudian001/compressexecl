package com.xyd.util;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        // 创建一个包含大量整数的列表
        List<Integer> numbers = IntStream.range(1, 1500).boxed().collect(Collectors.toList());

        // 顺序流示例
        long startTime = System.currentTimeMillis();
        long sumSequential = numbers.stream().reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("顺序流结果: " + sumSequential);
        System.out.println("顺序流耗时: " + (endTime - startTime) + " 毫秒");

        // 并行流示例
        startTime = System.currentTimeMillis();
        long sumParallel = numbers.parallelStream().reduce(0, Integer::sum);
        endTime = System.currentTimeMillis();
        System.out.println("并行流结果: " + sumParallel);
        System.out.println("并行流耗时: " + (endTime - startTime) + " 毫秒");
    }
}

