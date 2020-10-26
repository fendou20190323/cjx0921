package com.fendou.mq;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: cjx
 * @Date: 2020-10-20 15:56
 * @Description;
 */
public class Sort {

    @Test
    public void test1() {
        int[] arr = {3, 8, 7, 0, 6, 5, 9, 1, 4, 2};
        System.err.println("前：" + Arrays.toString(arr));
        System.err.println("后：" + Arrays.toString(insertSort(arr)));
    }

    private int[] insertSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return arr;

        for (int i = 1; i < len; i++) {
            int current = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;

        }
        return arr;
    }
}
