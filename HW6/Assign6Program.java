

package assign.pkg6.program;


public class Assign6Program {
    public static boolean OneThird;
    public static boolean OneHalf;
    
    
    public static void main(String[] args) {
        int[] list  = new int[]{5, 13, 0, 0, 56, 0, 13, 0, 0, 0};
        
        //initializing to the answer "no"
        OneHalf=false;
        OneThird=false;
        
       randomSelect(list);
    }
    public static void randomSelect(int[] list){
        randomSelect(list, 0,list.length);

    }
        
    public static void randomSelect(int[] fullList, int leftBound, int rightBound){
        int pivot = (int)(fullList.length*Math.random()); 
        //index of pivot at this point not actual pivot
        
        fullList[pivot]+=fullList[leftBound]; 
        fullList[leftBound]=fullList[pivot]-fullList[leftBound];
        fullList[pivot]-=fullList[leftBound];
        //swaps the pivot with the first element of the group in question
        
        pivot=fullList[leftBound]; 
        //set pivot to actual pivot value not index of pivot (space efficiency)
        
        int l=0;
        int r=0;
        while(leftBound+l<=rightBound-r){
            while(leftBound+l<=pivot){
                l++;
            }
            while(rightBound-r>pivot){
                r++;
            }
        if(leftBound+l<=rightBound-r){
            fullList[leftBound+l]+=fullList[]; 
        fullList[]=fullList[]-fullList[];
        fullList[leftBound+l]-=fullList[];
        }
        
            
        }
        
    }
}
