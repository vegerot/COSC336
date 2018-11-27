
package mazepathfinder;

import static mazepathfinder.HeapSort.printArray;
import java.util.HashMap;
import java.util.Map;

public class MazePathFinder {

    
    public static void main(String[] args) {
       
        int mazeSize =5;
        String[] maze = new String[mazeSize*mazeSize]; 
        /*[X][1] represents the name of the node while[X][2] represents the best
        previous node to go to for an efficient path to that node*/
        
        String[] bestPrevious=new String[mazeSize*mazeSize];
        int[] lowestVal = new int[mazeSize*mazeSize];

        HashMap<Integer,Integer> next=new HashMap<>();
        
        int[] horizontalMove= new int[]{0,2,1,4,  2,0,3,0,   3,3,3,3,  1,2,0,6, 
            1,2,1,3};
        int[] verticalMove= new int[]{0,2,1,0,1,  1,1,3,0,2,  1,2,3,2,1,  
            2,1,1,3,2};

        
        for(int point=0; point<(mazeSize*mazeSize);point++){
            String value=(char)(point+65)+" ";
            maze[point]=value;
            bestPrevious[point]="null";
            lowestVal[point]= 2147483647;
        }
        bestPrevious[0]="Start here";
        lowestVal[0]=0;
         
        int location =0;
        //we start in upper left square and end in (mazeSize*mazeSize -1)
        
        for(int pathNum=0;pathNum<=mazeSize*mazeSize;pathNum++){
            if(location>mazeSize){
                //check point above, it is not on first row
                if(lowestVal[location-mazeSize]>lowestVal[location]+verticalMove[location-mazeSize]){
                    
                    lowestVal[location-mazeSize]=lowestVal[location]+verticalMove[location-mazeSize];
                    bestPrevious[location-mazeSize] = maze[location];
                    next.put(location-mazeSize, lowestVal[location-mazeSize]);
                }
            }
            if(location<mazeSize*(mazeSize-1)){
                //check point below, it is not on last row
                if(lowestVal[location+mazeSize]>lowestVal[location]+verticalMove[location+mazeSize]){
                    
                    lowestVal[location+mazeSize]=lowestVal[location]+verticalMove[location+mazeSize];
                    bestPrevious[location+mazeSize] = maze[location];
                    next.put(location+mazeSize, lowestVal[location+mazeSize]);
                            
                }
            }
            if(location%mazeSize!=0){
                //check point to the left, it is not on first Column
                if(lowestVal[location-1]>lowestVal[location]+horizontalMove[location-1]){
                    
                    lowestVal[location-1]=lowestVal[location]+horizontalMove[location-1];
                    bestPrevious[location-1] = maze[location];
                    next.put(location-1, lowestVal[location-1]);
                            
                }
            }
            if(location%mazeSize!=mazeSize-1){
                //check point to the right, it is not on last Column
                if(lowestVal[location+1]>lowestVal[location]+horizontalMove[location+1]){
                    
                    lowestVal[location+1]=lowestVal[location]+horizontalMove[location+1];
                    bestPrevious[location+1] = maze[location];
                    next.put(location+1, lowestVal[location+1]);
                            
                }
            }
        }
        
        
        

        printArrays(mazeSize, maze, horizontalMove, verticalMove, bestPrevious,lowestVal);
    }
    

    public static void printArrays(int mazeSize,String[] maze,
            int[] horizontalMove,int[] verticalMove,String[] bestPrevious,int[] lowestVal){
        
        
        System.out.println("Bug tester and visualization code only, coment out the method call  to printArrays when printing actual output\n");
        for(int x=0; x<mazeSize;x++){
            for(int y=0; y<mazeSize;y++){
                System.out.print(maze[(x*mazeSize)+y]+" ");
                if (x!=5&&y!=4){
                    System.out.print(horizontalMove[(x*mazeSize)+y-x]+"  ");
                }
            
            }
            System.out.println();   
            
            for(int y=0; y<mazeSize;y++){
                if (x!=4&&y!=5){
                        System.out.print(verticalMove[(x*mazeSize)+y-x]+"     ");
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
