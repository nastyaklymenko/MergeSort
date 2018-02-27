/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author klyme
 */
public class MergeSort {

    private static void merge(int arr[], int left, int middle, int right)
    {
        
        int size1 = middle - left + 1;
        int size2 = right - middle;
 
   
        int leftArray[] = new int [size1];
        int rightArray[] = new int [size2];
 
       
        for (int i=0; i<size1; ++i)
            leftArray[i] = arr[left + i];
        for (int j=0; j<size2; ++j)
            rightArray[j] = arr[middle + 1+ j];

        int i = 0; 
        int j = 0;

        int left1 = left;
        while (i < size1 && j < size2)
        {
            if (leftArray[i] <= rightArray[j])
            {
                arr[left1] = leftArray[i];
                i++;
            }
            else
            {
                arr[left1] = rightArray[j];
                j++;
            }
            left1++;
        }

        while (i < size1)
        {
            arr[left1] = leftArray[i];
            i++;
            left1++;
        }

        while (j < size2)
        {
            arr[left1] = rightArray[j];
            j++;
            left1++;
        }
    }

    public static void sort(int arr[], int left, int right)
    {
        if (left < right)
        {

            int middle = (left+right)/2;

            sort(arr, left, middle);
            sort(arr , middle+1, right);

            merge(arr, left, middle, right);
        }
    }


    public static void main(String args[])
    {
        int arr[] = {122, 18,16,55,43,217,89,354,1 };
        sort(arr, 0, arr.length-1);
 
        System.out.println("Sorted array: ");
        int size = arr.length;
        for (int i=0; i<size; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
