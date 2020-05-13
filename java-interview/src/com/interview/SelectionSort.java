package com.interview;

public class SelectionSort {
	/**
     * 2.选择排序
     * 不稳定、占用常数内存，不占用额外内存
     * 说明:
     *   表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，
     *   所以用到它的时候，数据规模越小越好。
     *   唯一的好处可能就是不占用额外的内存空间了吧。
     *  算法描述:
     *    n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     *      1)初始状态：无序区为R[1..n]，有序区为空；
     *      2)第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     *        该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     *        使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     *      3)n-1趟结束，数组有序化了
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] array = {12,14,2,5,3,6,99};
		System.out.println("选择排序前：");
		for(int index:array) {
			System.out.print(index+",");
		}
		System.out.println("\n选择排序后：");
		selectionSort(array);
		for(int indexed:array) {
			System.out.print(indexed+",");
		}
		System.out.println("");
		long end = System.currentTimeMillis();
		System.out.println("消耗时间："+(end-start)+"毫秒");
	}
}