
package assign.pkg6.program;


public class Assign6Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] The  = new int[]{5, 13, 0, 0, 56, 0, 13, 0, 0, 0};
        int[] sorted = new int[The.length];
        
        sorted = randomSelect(The, 0, The.length, 0);
    }
    
    public static int[] randomSelect(int[] unsorted, int leftBound, int rightBound){
        int pivot = (int)(unsorted.length*Math.random());
        int holder = unsorted[pivot];
        unsorted[pivot]=unsorted[0];
        unsorted[0]=unsorted[pivot];
    }
}
