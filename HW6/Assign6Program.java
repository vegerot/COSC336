
package assign.pkg6.program;


public class Assign6Program {
    public static boolean OneThird;
    public static boolean OneHalf;
    
    
    public static void main(String[] args) {
        int[] list  = new int[]{5, 13, 0, 0, 56, 0, 13, 0, 0, 0};
        
        //initializing to the answer "no"
        OneHalf=false;
        OneThird=false;
        
       randomSelect(list, list.length, 0);
    }
    
    public static void randomSelect(int[] fullList, int leftBound, int rightBound){
        int pivot = (int)(fullList.length*Math.random());
        int holder = fullList[pivot];
        fullList[pivot]=fullList[0];
        fullList[0]=fullList[holder];
        
        
        
    }
}
