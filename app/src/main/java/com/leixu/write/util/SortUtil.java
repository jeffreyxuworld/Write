package com.leixu.write.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lei on 2017/10/26.
 *  各种排序算法
 *  Gmail: jeffreyxu.world@gmail.com
 */

public class SortUtil {


    public static void main(String[] args){
//        directInsert();

//        dichotomyInsert();

//        shellSort();

//        chooseSort();

//        heapSort();

//        bubbleSort();

//        mergeSort();

        baseNumberSort();

    }


    /**
     * 直接插入法
     * 文件初态不同时，直接插入排序所耗费的时间有很大差异。若文件初态为正序，则每个待插入的记录只需要比较一次就能够找到合适的位置插入，故算法的时间复杂度为O(n)，这时最好的情况。
     * 若初态为反序，则第i个待插入记录需要比较i+1次才能找到合适位置插入，故时间复杂度为O(n2)，这时最坏的情况。
     　　直接插入排序的平均时间复杂度为O(n2)。
     */
    private static void directInsertSort(){
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
            System.out.println("排序之前：");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]+" ");
            }
            //直接插入排序
            for (int i = 1; i < a.length; i++) {
                //待插入元素
                int temp = a[i];
                int j;
            /*for (j = i-1; j>=0 && a[j]>temp; j--) {
                 //将大于temp的往后移动一位
                 a[j+1] = a[j];
             }*/
                for (j = i-1; j>=0; j--) {
                    //将大于temp的往后移动一位
                     if(a[j]>temp){
                        a[j+1] = a[j];
                     }else{
                        break;
                     }
                }
                a[j+1] = temp;
            }
            System.out.println();
            System.out.println("排序之后：");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]+" ");
            }

    }

    /**
     * 二分法插入排序
     * 二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数
     * 二分插入排序的比较次数与待排序记录的初始状态无关，仅依赖于记录的个数。当n较大时，比直接插入排序的最大比较次数少得多。但大于直接插入排序的最小比较次数。
     * 算法的移动次数与直接插入排序算法的相同，最坏的情况为n2/2，最好的情况为n，平均移动次数为O(n2)。
     */
    private static void dichotomyInsertSort(){
        int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<a[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                a[j+1] = a[j];
            }
            if(left != i){
                a[left] = temp;
            }

        }


        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }


    }

    /**
     * 希尔排序 （不稳定）
     * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
     * 然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法。
     *
     *
     * 我们知道一次插入排序是稳定的，但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，所以希尔排序是不稳定的。
     　　希尔排序的时间性能优于直接插入排序，原因如下：
     　　（1）当文件初态基本有序时直接插入排序所需的比较和移动次数均较少。
     　　（2）当n值较小时，n和n2的差别也较小，即直接插入排序的最好时间复杂度O(n)和最坏时间复杂度0(n2)差别不大。
     　　（3）在希尔排序开始时增量较大，分组较多，每组的记录数目少，故各组内直接插入较快，后来增量di逐渐缩小，分组数逐渐减少，而各组的记录数目逐渐增多，但由于已经按di-1作为距离排过序，使文件较接近于有序状态，所以新的一趟排序过程也较快。
     　　因此，希尔排序在效率上较直接插人排序有较大的改进。
     　　希尔排序的平均时间复杂度为O(nlogn)。
     */
    public static void shellSort(){
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //希尔排序
        int d = a.length;
        while(true){
            d = d / 2;
            for(int x=0;x<d;x++){
                for(int i=x+d; i<a.length; i=i+d){
                    int temp = a[i];
                    int j;
                    for(j=i-d; j>=0 && a[j]>temp; j=j-d){
                        a[j+d] = a[j];
                    }
                    a[j+d] = temp;

                }
            }

            if(d == 1){
                break;
            }

        }

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }

    /**
     * 简单选择排序(不稳定排序)
     * 每趟从待排序的记录序列中选择关键字最小的记录放置到已排序表的最前位置，直到全部排完。
     * 时间复杂度：T(n)=O(n2)。
     */
    private static void chooseSort(){
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //简单的选择排序
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int n=i; //最小数的索引
            for(int j=i+1;j<a.length;j++){
                if(a[j]<min) {  //找出最小的数
                    min = a[j];
                    n = j;
                }
            }

            a[n] = a[i];
            a[i] = min;


        }

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }

    /**
     * 堆排序（不稳定） 堆排序优于简单选择排序
     * 1.建堆  2.交换，从堆中提出最大数 3.剩余节点再建堆，再交换踢出最大数
     * 依次此类推：最后堆中剩余的最后两个节点交换，踢出一个，排序完成。
     *
     * 直接选择排序中，为了从R[1..n]中选出关键字最小的记录，必须进行n-1次比较，然后在R[2..n]中选出关键字最小的记录，又需要做n-2次比较。
     * 事实上，后面的n-2次比较中，有许多比较可能在前面的n-1次比较中已经做过，但由于前一趟排序时未保留这些比较结果，所以后一趟排序时又重复执行了这些比较操作。
     　　堆排序可通过树形结构保存部分比较结果，可减少比较次数。
     　　堆排序的最坏时间复杂度为O(nlogn)。堆序的平均性能较接近于最坏性能。由于建初始堆所需的比较次数较多，所以堆排序不适宜于记录数较少的文件。
     *
     */
    private static void heapSort(){
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64};
        int arrayLength = a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            buildMaxHeap(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,arrayLength-1-i);
            System.out.println(Arrays.toString(a));

        }



    }




    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex){
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //如果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }

                //如果k节点的值小于其较大的子节点的值
                if(data[k] < data[biggerIndex]){
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                }else{
                    break;
                }


            }

        }


    }

    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    /**
     * 冒泡排序
     * 若文件初状为正序，则一趟起泡就可完成排序，排序码的比较次数为n-1，且没有记录移动，时间复杂度是O(n)
     * 若文件初态为逆序，则需要n-1趟起泡，每趟进行n-i次排序码的比较，且每次比较都移动三次，比较和移动次数均达到最大值∶O(n2)
     * 起泡排序平均时间复杂度为O(n2)
     *
     * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
     * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     *
     */
//    private static void bubbleSort(){
//        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1,8};
//        System.out.println("排序之前：");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]+" ");
//        }
//        //快速排序
//        quick(a);
//        System.out.println();
//        System.out.println("排序之后：");
//        for(int i = 0; i < a.length; i++){
//            System.out.print(a[i]+ " ");
//        }
//
//    }
//
//
//    private static void quick(int[] a){
//        if(a.length > 0){
//            quickSort(a, 0, a.length-1);
//        }
//    }
//
//    private static void quickSort(int[] a, int low, int high){
//        if(low < high){  //如果不加这个判断递归会无法退出导致堆栈溢出异常
//            int middle = getMiddle(a, low, high);
//            quickSort(a, 0, middle-1);
//            quickSort(a, middle+1, high);
//        }
//    }
//
//
//    private static int getMiddle(int[] a, int low, int high){
//        int temp = a[low]; //基准元素
//        while (low < high){
//            //找到比基准元素小的元素位置
//            while (low < high && a[high] >= temp){
//                high--;
//            }
//            a[low] = a[high];
//            while (low < high && a[low] <= temp){
//                low++;
//            }
//            a[low] = a[high];
//            while(low < high && a[low] <= temp){
//                low++;
//            }
//            a[high] = a[low];
//
//
//        }
//        a[low] = temp;
//        return low;
//
//
//    }


    /**
     * 归并排序 (稳定)
     *
     * 归并排序是稳定的排序方法。
     *
     * 基本思想:归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     *
     * 归并排序的时间复杂度为O(nlogn)。
     * 速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
     *
     */
    private static void mergeSort(){
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //归并排序
        mergeSortMethod(a,0,a.length-1);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }


    }



    private static void mergeSortMethod(int[] a, int left, int right) {
        if(left < right){
            int middle = (left + right)/2;
            //对左边进行递归
            mergeSortMethod(a, left, middle);
            //对右边进行递归
            mergeSortMethod(a, middle+1, right);
            //合并
            merge(a, left, middle, right);

        }
    }


    private static void merge(int[] a, int left, int middle, int right){
        int[] tmpArr = new int[a.length];
        int mid = middle + 1; //右边的起始位置
        int tmp = left;
        int third = left;
        while(left <= middle && mid <= right){
            //从两个数据中选取较小的数放入中间的数组
            if(a[left] <= a[mid]){
                tmpArr[third++] = a[left++];
            }else{
                tmpArr[third++] = a[mid++];
            }

        }

        //将剩余的部分放入中间数组
        while(left <= middle){
            tmpArr[third++] = a[left++];
        }
        while (mid <= right){
            tmpArr[third++] = a[mid++];
        }

        //将中间数组复制回原数组
        while (tmp <= right){
            a[tmp] = tmpArr[tmp++];
        }



    }


    /**
     * 基数排序(稳定)
     * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     *
     * 基数排序的时间复杂度为O(d(n+r)),d为位数，r为基数。
     */
    private static void baseNumberSort(){
        int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+ " ");
        }
        //基数排序
        sort(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }


    }

    //基数排序
    private static void sort(int[] array) {
        //找到最大数，确定要排序几趟
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(max<array[i]){
                max = array[i];
            }
        }

        //判断位数
        int times = 0;
        while(max > 0){
            max = max/10;
            times++;
        }
        //建立十个队列
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList queue1 = new ArrayList();
            queue.add(queue1);

        }

        //进行times次分配和收集
        for(int i = 0; i < times; i++){
            //分配
            for(int j = 0; j < array.length; j++){
                int x = array[j]%(int)Math.pow(10,  i+1)/(int)Math.pow(10, i);
                ArrayList queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);

            }

            //收集
            int count = 0;
            for(int j = 0; j < 10; j++){
                while (queue.get(j).size() > 0){
                    ArrayList<Integer> queue3 = queue.get(j);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }



        }



    }










}
