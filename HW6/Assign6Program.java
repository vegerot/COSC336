
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
        int pivot = (int)((rightBound-leftBound)*Math.random())+leftBound; 
        //index of pivot at this point not actual pivot
        
        fullList[pivot]+=fullList[leftBound]; 
        fullList[leftBound]=fullList[pivot]-fullList[leftBound];
        fullList[pivot]-=fullList[leftBound];
        //swaps the pivot with the first element of the group in question
        
        pivot=fullList[leftBound]; 
        //set pivot to actual pivot value not index of origional position(space efficiency)
        
        int count=0;
        int l=leftBound+1;
        int r=rightBound;
        while(l<r){
            
            while(fullList[l]<=pivot && l<rightBound){
                if(fullList[l]==pivot){
                    count++;
                }
                l++;
            }
            
            while(fullList[r]>pivot && r>leftBound){
                r--;
            }
            
            if(fullList[r]==pivot){
                    count++;
            }
            
            if(r>leftBound+1&&l>rightBound){
                fullList[l]+=fullList[r]; 
                fullList[r]=fullList[l]-fullList[r];
                fullList[l]-=fullList[r];
            }
                        
        
            
        }
        if(r>=leftBound){
            fullList[leftBound]+=fullList[r]; 
            fullList[r]=fullList[leftBound]-fullList[r];
            fullList[leftBound]-=fullList[r];
        }
//if it did not find anything that should be on the right, only the pointer belongs on the left

        if(r-leftBound>fullList.length/3){
            randomSelect(fullList, leftBound,r-1);
        }
        if(rightBound-r>fullList.length/3){
            randomSelect(fullList, r+1,rightBound);
        }
        
    }
}
