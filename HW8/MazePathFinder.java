/*
This program finds the shortest path on weighted paths through a maze with walls
and then prints the weighted value of the best paths and the path itself
*/
package mazepathfinder;



import java.util.HashMap;
//import java.util.Map;

public class mazePathFinder2 {

    
    public static void main(String[] args) {
       
        int mazeSize =5;
        String[] maze = new String[mazeSize*mazeSize]; 
        /*[X][1] represents the name of the node while[X][2] represents the best
        previous node to go to for an efficient path to that node*/
        
        int[] bestPrevious=new int[mazeSize*mazeSize];
        int[] lowestVal = new int[mazeSize*mazeSize];

        HashMap<Integer,Integer> next=new HashMap<>();
        
        int[] horizontalMove= new int[]{0,2,1,4,  2,0,3,0,   3,3,3,3,  1,2,0,6, 
            1,2,1,3};
        int[] verticalMove= new int[]{0,2,1,0,1,  1,1,3,0,2,  1,2,3,2,1,  
            2,1,1,3,2};

        
        for(int point=0; point<(mazeSize*mazeSize);point++){
            String value=(char)(point+65)+" ";
            maze[point]=value;
            bestPrevious[point]=999;
            lowestVal[point]= Integer.MAX_VALUE;
        }
        bestPrevious[0]=0;
        lowestVal[0]=0;
         
        int location =0;
        //we start in upper left square and end in (mazeSize*mazeSize -1)
        
        
        for(int pathNum=0;pathNum<=mazeSize*mazeSize&&location<25;pathNum++){
            if(location/mazeSize>=1){
                //check point above, it is not on first row
                if(lowestVal[location-mazeSize]>lowestVal[location]+verticalMove[(location-mazeSize)%(mazeSize)+(location-mazeSize)/(mazeSize)*(mazeSize)]){
                    
                    lowestVal[location-mazeSize]=lowestVal[location]+verticalMove[(location-mazeSize)%(mazeSize)+(location-mazeSize)/(mazeSize)*(mazeSize)];
                    bestPrevious[location-mazeSize] = location;
                    next.put(location-mazeSize, lowestVal[location-mazeSize]);
                }
            }
            if(location<mazeSize*(mazeSize-1)){
                //check point below, it is not on last row
                
                if(lowestVal[location+mazeSize]>lowestVal[location]+verticalMove[location%(mazeSize)+location/(mazeSize)*(mazeSize)]){
                    
                    lowestVal[location+mazeSize]=lowestVal[location]+verticalMove[location%(mazeSize)+location/(mazeSize)*(mazeSize)];
                    bestPrevious[location+mazeSize] =location;
                    next.put(location+mazeSize, lowestVal[location+mazeSize]);
                            
                }
            }
            if(location%mazeSize!=0){
                //check point to the left, it is not on first Column
                if(lowestVal[location-1]>lowestVal[location]+horizontalMove[((location-1)%(mazeSize)+(location-1)/(mazeSize)*(mazeSize-1))]){
                    
                    lowestVal[location-1]=lowestVal[location]+horizontalMove[((location-1)%(mazeSize)+(location-1)/(mazeSize)*(mazeSize-1))];
                    bestPrevious[location-1] = location;
                    next.put(location-1, lowestVal[location-1]);
                            
                }
            }
            if(location%mazeSize!=(mazeSize-1)){
                //check point to the right, it is not on last Column
                if(lowestVal[location+1]>lowestVal[location]+horizontalMove[(location%(mazeSize)+location/(mazeSize)*(mazeSize-1))]){
                    
                    lowestVal[location+1]=lowestVal[location]+horizontalMove[(location%(mazeSize)+location/(mazeSize)*(mazeSize-1))];
                    bestPrevious[location+1] = location;
                    next.put(location+1, lowestVal[location+1]);
                            
                }
            }
            
            location=getMinKey(next);
            next.remove(location);

        }
        
        System.out.println("The best path has a total of : "+lowestVal[lowestVal.length-1]);
        location = maze.length-1;
        
        String[] endList = new String[maze.length];
        int a=maze.length-1;
        while(location!=0){
            endList[a]=maze[location];
            a--;
            location = bestPrevious[location];
        }

        System.out.print("["+maze[0]);
       while(a<endList.length-1){
            System.out.print(", "+endList[a+1]);
            a++;
        }
        System.out.println("]");
        System.out.println();
        

        //printArrays(mazeSize, maze, horizontalMove, verticalMove, bestPrevious,lowestVal);
    }
    
    public static Integer getMinKey(HashMap<Integer,Integer> map){
        int minKey = 1000;
        int minValue = Integer.MAX_VALUE;
        for(int key : map.keySet()) {
            int value = map.get(key);
            if(value < minValue) {
                minValue = value;
                minKey = key;
            }
        }
        return minKey;
    }
    
    public static void printArrays(int mazeSize,String[] maze,
            int[] horizontalMove,int[] verticalMove,int[] bestPrevious,int[] lowestVal){
        
        
        System.out.println("Bug tester and visualization code only, coment out the method call  to printArrays when printing actual output\n");
        for(int x=0; x<mazeSize;x++){
            for(int y=0; y<mazeSize;y++){
                System.out.print(maze[(x*mazeSize)+y]+" ");
                if (x!=mazeSize&&y!=mazeSize-1){
                    System.out.print(horizontalMove[(x*mazeSize)+y-x]+"  ");
                }
            
            }
            System.out.println();   
            
            for(int z=0; z<mazeSize;z++){
                if (x!=mazeSize-1&&z!=mazeSize){
                        System.out.print(verticalMove[(x*(mazeSize))+z]+"     ");
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
