import java.util.*;

public class MergeSort {

//NOT DONE

    public static int[] mergeSortList(int[] list, int left, int right){
        if(right-left<=1){
            
                return merge(new int[]{list[left]},new int[]{list[right]});

        }else{
            int middle = left+ (right-left)/2; 
            int[] sortedLeft = mergeSortList(list, left, middle);
            int[] sortedRight = mergeSortList(list, middle, right);
            
            return merge(sortedLeft,sortedRight);
        }
    }
    
    public static int[] merge(int[] Left,int[] Right){
        int[] merged = new int[Left.length+Right.length];
        int l=0; 
        int r=0;
        while(l<Left.length&&r<Right.length){
            System.out.println();
                System.out.print(merged[0]);
                for(int i=1;i<merged.length;i++){
                    System.out.print(", "+merged[i]);
            }
                System.out.println();
            System.out.println(merged[l]+", "+merged[r]+ " "+l +" vs "+ r);
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
    
    public static void main(String[] args) {
        int[] fromGetFunc = new int[] {1,2,3,4,5,6};
        
        int[] sorted = mergeSortList(fromGetFunc, 0, fromGetFunc.length-1);
        
        System.out.println();
        System.out.print(sorted[0]);
        for(int i=1;i<sorted.length;i++){
            System.out.print(", "+sorted[i]);
        }
        System.out.println();
    }
    
    
    
}
