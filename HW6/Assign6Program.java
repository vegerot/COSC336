package assign6program;
/*
This program does a partial 
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
        
        /*Testing code bellow*/
        for(int a=0;a<fullList.length;a++){
        System.out.println(fullList[a]);
        }
        /*Testing code above*/
        
        double count=1;
        int l=leftBound+1;
        int r=rightBound;
        
        /*Testing code bellow*/
        System.out.println (pivot+"=pivot");
        System.out.println(leftBound+"=leftBound");
        System.out.println(rightBound+"=rightBound\nStart\n");
        /*Testing code above*/
        
        while(l<r){

            while(l<fullList.length&&fullList[l]<=pivot){
                if(fullList[l]==pivot){
                    count++;
                    /*Testing code bellow*/
                    System.out.println("end of list "+count);
                    /*Testing code above*/
                }
                l++;
                System.out.println(l+"=L");
            }
            
            while(r>0&&fullList[r]>pivot && r>leftBound){
                r--;
                System.out.println(r+"=R");
            }
            
            
            System.out.println(l+"=L and "+r+"=R\n");
            
            if(l<r){
                holder =fullList[r];
                fullList[r]=fullList[l];
                fullList[l]=holder;
                //swaps the two items on the wrong side
            }
            
            //test code below
            for(int a=0;a<fullList.length;a++){
                        System.out.println(fullList[a]);
            }
            
            System.out.println("end of list V "+count);
        }
             
        holder =fullList[r];
        fullList[r]=fullList[leftBound];
        fullList[leftBound]=holder;
        for(int a=0;a<fullList.length;a++){
                        System.out.println(fullList[a]);
            }
            
            System.out.println("end of list game\n\n");
        
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
        while(l<r){
            
            while(fullList[l]<value && l<rightBound){
                l++;
            }//finds first point equal to value
            
            while(fullList[r]==value && r>=leftBound){
                r--;
            }//finds first point not equal to value
            
            if(r>leftBound+1&&l>rightBound&&r>l){
                fullList[l]+=fullList[r]; 
                fullList[r]=fullList[l]-fullList[r];
                fullList[l]-=fullList[r];
            }
        }
        if(r-leftBound>fullList.length/3){
                randomSelect(fullList, leftBound,r);
        }
    }
}
