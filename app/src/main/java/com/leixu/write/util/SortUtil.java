package com.leixu.write.util;

/**
 * Created by Lei on 2017/10/26.
 *  各种排序算法
 */

public class SortUtil {


    public static void main(String[] args){
//        directInsert();

//        dichotomyInsert();

        hillSort();
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
     */
    public static void hillSort(){
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
                for(int i=x+d;i<a.length;i=i+d){
                    int temp = a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d){
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



}
