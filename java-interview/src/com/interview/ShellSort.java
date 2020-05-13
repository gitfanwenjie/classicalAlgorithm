package com.interview;

public class ShellSort {
	/**
     * 4.希尔排序666666666666666
     * 不稳定、占用常数内存，不占用额外内存
     * 说明：
     * 	  希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。
     * 	  希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，
     * 	  也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。
     * 	  它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     * 算法描述:
     *   我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，
     *   缩小增量继续以gap = gap/2的方式，
     *   这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列。
     *   希尔排序的增量序列的选择与证明是个数学难题，
     *   我们选择的这个增量序列是比较常用的，
     *   也是希尔建议的增量，称为希尔增量，
     *   但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。
     *   先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     *     1)选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     *     2)按增量序列个数k，对序列进行k 趟排序；
     *     3)每趟排序，根据对应的增量ti，
     *     将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *     仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param array
     * @return
     */
    static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] array = {12,14,2,5,3,6,99,0};
		System.out.println("希尔排序前：");
		for(int index:array) {
			System.out.print(index+",");
		}
		System.out.println("\n希尔排序后：");
		shellSort(array);
		for(int indexed:array) {
			System.out.print(indexed+",");
		}
		System.out.println("");
		long end = System.currentTimeMillis();
		System.out.println("消耗时间："+(end-start)+"毫秒");
	}
}
