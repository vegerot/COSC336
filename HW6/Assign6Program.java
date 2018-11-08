package assign6program;
/*
This program does a partial quicksort, stopping whenever it would be sorting a 
group that is smaller than or equal to one third of the of the max list size
(converted to a double for comparing small groups or groups which are very close)

because any group one third or less of the origional data set is ignored
this program can maintain an expected runtime of O(n). This can be estimated as 
follows. 

1.Assuming an average distribution with no groups of duplicates of 
signifant size the random selection will most likely land in the 24th to 76th 
percentile for numbers possible, this will repeat and the expected result is 
that on average 24% of the group will be ignored for the next pass. so if this 
is done 5 times you get .76*.76*.76*.76*.76 remaining or .25355254 which 
itself can be ignored as it is less than 33.33333%, assuming worst case it would 
be quicksortand not remove anything but the probabilities are so low of the 
random number always beign the largest or smallest number or close theretoo. 
This case gives a worst case of around 10 run with a large group when the
random selecter gets a bad pick a few times. With a small group the odds of it 
becoming not O(n) increasese due to ease of variability, but it also is less 
costly to run a small group as O(n^2) - the worst runtime of quicksort which is
the basis of the program. - expected run on average-ish case 10 runs*constant*n

2.Assuming at least 1 group of size between 1/3 and 1/2 but not over 1/2 of the 
list total we can say the program is expected to run around 3 times before finding
the group, then remove that group of 1/3rd+ with the Clear left method.
then with 2/3 to 1/2 of the points left evenly distributed it should take 
approximately 2-3 runs to remove the remaining options

3.Assuming one group of 1/2+ list size it will take aproximately 2 operations 
before it finds the 1/2 group and quits the program

4.Assuming a 1/2+ group and a 1/3+ to 1/2- group the odds are in 2 passes it will
find the 1/2 group but if it lands on the 1/3+ to 1/2- first it will remove them
with the Clearleft and then almost guaranteed find the 1/2 group in the next pass

*/
import java.util.*;


public class Assign6Program {
    public static boolean OneThird;
    public static boolean OneHalf;
    
    public static String getInput(){
            //=================================

            // Gets filename from user

            //=================================


            System.out.print("Input file here: ");
            Scanner cin=new Scanner(System.in);
            String file=cin.next();
            cin.close();
            return file;

    }
    
    public static void main(String[] args) {
        String basename;
        if (args.length!=0)
                basename=args[0];
        else
                basename=getInput();
        int[] list=new fileParser(basename).getData();
        
        //initializing to the answer "no"
        OneHalf=false;
        OneThird=false;
        
       randomSelect(list);
       
       if(OneThird){
           if(OneHalf){
               System.out.println("Yes");
           }else{
               System.out.println("No");
           }
           System.out.println("Yes");
       }else{
           System.out.println("No \nNo");
       }
    }
    
    
    
    
    public static void randomSelect(int[] list){
        randomSelect(list, 0,list.length-1);
    }
        
    
    
    
    public static void randomSelect(int[] fullList, int leftBound, int rightBound){
        int pivot = (int)((rightBound-leftBound)*Math.random())+leftBound; 
        //index of pivot at this point not actual pivot
        
        boolean thisPivotIsOneThird=false;
        
        int holder =fullList[leftBound];
        fullList[leftBound]=fullList[pivot];
        fullList[pivot]=holder;
        //swaps the pivot with the first element of the group in question
        
        pivot=fullList[leftBound]; 
        //set pivot to actual pivot value not index of origional position(space efficiency)
        
        double count=1;
        int l=leftBound+1;
        int r=rightBound;
        
        
        while(l<r){

            while(l<fullList.length&&fullList[l]<=pivot){
                if(fullList[l]==pivot){
                    count++;
                }
                l++;
            }
            
            while(r>0&&fullList[r]>pivot && r>leftBound){
                r--;
            }
            
            if(l<r){
                holder =fullList[r];
                fullList[r]=fullList[l];
                fullList[l]=holder;
                //swaps the two items on the wrong side
            }

        }
             
        holder =fullList[r];
        fullList[r]=fullList[leftBound];
        fullList[leftBound]=holder;
        
        if (count>fullList.length/3.0){
            OneThird=true;
            thisPivotIsOneThird=true;
            if(count>fullList.length/2.0){
                OneHalf=true;
                return;
            }
        }
        
        if((r-leftBound)>(fullList.length/3.0)&&!OneHalf){
            if(thisPivotIsOneThird){
                ClearLeft(fullList, leftBound,r, pivot);   
            }
            /*remove value of pointer from list when one third but not 
            one half has occured. Should only fire when we need to make sure the
            current pointer is not reused repeatedly and 
            */       
            else{
                randomSelect(fullList, leftBound,r-1);
            }
        }
        if(rightBound-r>fullList.length/3.0&&!OneHalf){
            randomSelect(fullList, r+1,rightBound);
        }
        
    }
    public static void ClearLeft(int[] fullList, int leftBound, int rightBound, int value){
        int l=leftBound;
        int r=rightBound;
        int holder;

        while(l<r){
            
            while(l<fullList.length&&fullList[l]<value){
                l++;
            }//finds first point equal to value
            
            while(r>0 && fullList[r]==value && r>leftBound){
                r--;
            }//finds first point not equal to value
            
            if(l<r){
                holder =fullList[r];
                fullList[r]=fullList[l];
                fullList[l]=holder;
            }
        }
        if(r-leftBound>fullList.length/3.0){
                randomSelect(fullList, leftBound,r);
        }
    }
}
