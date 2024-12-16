package com.company.heapDSA;
import java.util.PriorityQueue;
//CHAPTER-2 HEAP DATA STRUCTURE AND ALGORITHMS

//THEORY
//A. HEAP- INTRODUCTION- RN
//B. PROPERTIES OF HEAP- RN
//C. HOW IS BINARY HEAP REPRESENTED- RN

import java.util.ArrayList;

public class Main<T extends Comparable<T>> {
    public ArrayList<T> list;

    public Main(){
        list = new ArrayList<>();
    }

//D. IMPLEMENTATION OF HEAP

    // I. INSERTION TC-O(log n)
    public int parent(int index){
        return (index - 1) / 2;
    }

    public int left(int index){
        return 2 * index + 1;
    }

    public int right(int index){
        return 2 * index + 2;
    }

    public void swap(int firstIndex, int secondIndex){
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    public void insertion(T value){
        list.add(value);
        upHeap(list.size() - 1);
    }

    public void upHeap(int index){
         if(index == 0){
             return;
         }
         int p = parent(index);
         if(list.get(index).compareTo(list.get(p)) < 0){
             swap(index, p);
             upHeap(p);
         }
    }


    //II. DELETION TC-O(log n)
    public T deletion() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty Heap DS!");
        }

        T temp = list.get(0);
        T last = list.get(list.size()-1);

        list.set(0, last);
        downHeap(0);
        return temp;
    }

    public void downHeap(int index){
        int min = index;
        int l = left(index);
        int r = right(index);

        if(l < list.size() && list.get(min).compareTo(list.get(l)) > 0){
            min = l;
        }

        if(r < list.size() && list.get(min).compareTo(list.get(r)) > 0){
            min = r;
        }

        if(index != min){
            swap(min, index);
            downHeap(min);
        }

    }


    //III. HEAPIFY-MAXHEAP TC-O(n)
    public void heapify(int[] arr, int n, int i){

        int largest = i;
        int left = left(i);
        int right= right(i);

        if(left < n && arr[largest] < arr[left]){
            largest = left;
        }

        if(right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        if(largest != i){
            swap(arr[i], arr[largest]);
            heapify(arr, n, largest);
        }
    }

    public int[] buildHeap(int[] arr){
        int n = arr.length;
        for(int i = n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
        return arr;
    }



//EXERCISES

    //EXERCISE-1

    //QUESTION-1 Heap Sort
    //Source-https://leetcode.com/problems/sort-an-array/description/

        public int[] heapSort(int[] arr){
            int n = arr.length;

            while(n >= 0){
                swap(arr[0], arr[n-1]);
                n--;

                heapify(arr, n, 0);
            }
            return arr;
        }




    //QUESTION-2 Kth Smallest Number
    //Source-https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

        public static int kthSmallest(int[] arr, int N, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            for(int i=0; i<K; i++){
                pq.offer(arr[i]);
            }

            for(int i = K; i<N; i++){
                if(arr[i] < pq.peek()){
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }

            return pq.peek();
        }
        /* T1: IMAGINARY PODIUM- Insert K numbers in the max-heap from the array. Now compare other numbers to the
           Kth Largest Number of the Max-Heap(Podium), if any of the position can be overtaken by new number give
           it. Poll and Offer. */




    //QUESTION-3 Merge Two Binary Max Heaps
    //Source-https://www.geeksforgeeks.org/problems/merge-two-binary-max-heap

        public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((c, d) -> d - c);

            for(int i = 0; i<n; i++){
                pq.offer(a[i]);
            }

            for(int i = 0; i<m; i++){
                pq.offer(b[i]);
            }

            int[] ans = new int[n+m];

            int i =0;
            while(!pq.isEmpty()){
                ans[i] = pq.poll();
                i++;
            }

            return ans;
        }




    //QUESTION-4 Minimum Cost of Ropes
    //Source-https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes

        public int minCost(int[] arr) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(int i = 0; i<arr.length; i++){
                pq.offer(arr[i]);
            }

            int finalSum = 0;

            while(pq.size() > 1){
                int x = pq.poll();
                int y = pq.poll();

                int sum = x + y;
                finalSum += sum;

                pq.offer(sum);
            }

            return finalSum;
        }




    //QUESTION-5 Is Binary Tree Heap
    //Source-https://www.geeksforgeeks.org/problems/is-binary-tree-heap/
/*
        boolean isHeap(TreeNode tree) {
            return helper(tree, true);
        }

        boolean helper(Node tree, boolean flag){
            if(tree.left == null && tree.right == null){
                return flag;
            }

            if(tree.left == null || tree.right == null){
                return false;
            }

            if(tree.left.data <= tree.data && tree.right.data <= tree.data){
                flag = true;
            }
            else{
                flag = false;
            }

            boolean l = helper(tree.left, flag);
            boolean r = helper(tree.right, flag);

            return flag;
        }

*/

    //QUESTION-6 Merge K Sorted Arrays
    //Source-https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/0


    //QUESTION-7 Mere K Sorted List
    //Source-https://leetcode.com/problems/merge-k-sorted-lists/description/


    //QUESTION-8 Find Median from Data Stream
    //Source-https://leetcode.com/problems/find-median-from-data-stream/description/


    //QUESTION-9 The Smallest Range Covering Elements from K Lists
    //Source-https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/


    //QUESTION-10 Reorganize String
    //Source-https://leetcode.com/problems/reorganize-string/description/


    //QUESTION-11 K-th Largest Sum Contiguous Subarray
    //Source-https://www.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1



























    public static void main(String[] args) {


        System.out.println("Hello World");

    }
}
