import java.util.*;

public class MergeSort {

    public static int[] mergeSortList(int[] list)
    {
	    return mergeSortList(list, 0, list.length-1);
    }
    public static int[] mergeSortList(int[] list, int left, int right){
        if(right==left){
            return new int[]{list[left]};
        }
        else{
            int middle = left+ (right-left)/2; 
            int[] sortedLeft = mergeSortList(list, left, middle);
            int[] sortedRight = mergeSortList(list, middle+1, right);
            
            return merge(sortedLeft,sortedRight);
        }
    }
    
    public static int[] merge(int[] Left,int[] Right){
        int[] merged = new int[Left.length+Right.length];
        int l=0; 
        int r=0;
        while(l<Left.length&&r<Right.length){

            if(Left[l]<Right[r]){
                merged[l+r]=Left[l];
                l++;
            }else{
                merged[l+r]=Right[r];
                r++;
            }
        }
        while(l<Left.length){
            merged[l+r]=Left[l];
                l++;
        }
        while(r<Right.length){
            merged[l+r]=Right[r];
                r++;
        }
        return merged;
    }
    
  /* 
    public static void main(String[] args) {
        int[] fromGetFunc = new int[] {21,42,83,21,21,21};
        
        int[] sorted = mergeSortList(fromGetFunc, 0, fromGetFunc.length-1);
        
        System.out.println();
        System.out.print(sorted[0]);
        for(int i=1;i<sorted.length;i++){
            System.out.print(", "+sorted[i]);
        }
        System.out.println();
    }*/
}
