
package mazepathfinder;

import static mazepathfinder.HeapSort.printArray;

public class MazePathFinder {

    
    public static void main(String[] args) {
       
        int mazeSize =5;
        String[] maze = new String[mazeSize*mazeSize]; 
        /*[X][1] represents the name of the node while[X][2] represents the best
        previous node to go to for an efficient path to that node*/
        String[] bestPrevious=new String[mazeSize*mazeSize];
        int[] lowestVal = new int[mazeSize*mazeSize];
        
        int[] vertMove= new int[]{0,2,1,4,  2,0,3,0,   3,3,3,3,  1,2,0,6, 
            1,2,1,3};
        int[] horizMove= new int[]{0,2,1,0,1,  1,1,3,0,2,  1,2,3,2,1,  
            2,1,1,3,2};
        
        HeapSort ob = new HeapSort(); 
        ob.sort(arr);
        printArray(arr);
        for(int point=65; point<(mazeSize*mazeSize)+65;point++){
            String value=(char)point+" ";
            maze[point-65]=value;
            bestPrevious[point-65]="null";
            lowestVal[point-65]= 2147483647;
        }
        
        
        
        
        
        

        printArrays(mazeSize, maze, vertMove, horizMove, bestPrevious,lowestVal);
    }
    
    
    
    public static void printArrays(int mazeSize,String[] maze,
            int[] vertMove,int[] horizMove,String[] bestPrevious,int[] lowestVal){
        for(int x=0; x<mazeSize;x++){
            for(int y=0; y<mazeSize;y++){
                System.out.print(maze[(x*mazeSize)+y]+" ");
                if (x!=5&&y!=4){
                    System.out.print(vertMove[(x*mazeSize)+y-x]+"  ");
                }
            
            }
            System.out.println();   
            
            for(int y=0; y<mazeSize;y++){
                if (x!=4&&y!=5){
                        System.out.print(horizMove[(x*mazeSize)+y-x]+"     ");
                }
            }
            
            System.out.println();     
            
        }
        System.out.println("\nThe above list is the maze with the number cost "
                + "of moving between spots in between");
        System.out.println("The list below is the best previous node to have "
                + "gone to and best total path (null should not show up when "
                + "code is done)\n\n");
        for(int x=0; x<mazeSize;x++){
            for(int y=0; y<mazeSize;y++){
                System.out.print("("+bestPrevious[(x*mazeSize)+y]+","
                        +lowestVal[(x*mazeSize)+y]+")  ");
            
            }
            
            System.out.println();     
            
        }
    }
    
}
