package com.interview;

public class InsertionSort {
	/**
     * 3.插入排序：
     * 稳定、占用常数内存，不占用额外内存
     * 说明:
     *   插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     *   它的工作原理是通过构建有序序列，对于未排序数据，
     *   在已排序序列中从后向前扫描，找到相应位置并插入
     * 算法描述:
     *   一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     *     1)从第一个元素开始，该元素可以认为已经被排序；
     *     2)取出下一个元素，在已经排序的元素序列中从后向前扫描；
     *     3)如果该元素（已排序）大于新元素，将该元素移到下一位置；
     *     4)重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     *     5)将新元素插入到该位置后；
     *     6)重复步骤2~5。
     * @param array
     * @return
     */
    static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] array = {12,14,2,5,3,6,99};
		System.out.println("插入排序前：");
		for(int index:array) {
			System.out.print(index+",");
		}
		System.out.println("\n插入排序后：");
		insertionSort(array);
		for(int indexed:array) {
			System.out.print(indexed+",");
		}
		System.out.println("");
		long end = System.currentTimeMillis();
		System.out.println("消耗时间："+(end-start)+"毫秒");
	}
}
