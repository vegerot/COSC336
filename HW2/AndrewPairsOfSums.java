import java.util.*;
public class Assignment3 {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.println("n = number of integers to be entered.");
    System.out.println("t = target that a pair of integers will be aiming to sum into.");
    System.out.print("Please enter a number for desired number of integers and the target (seperated by a space): ");
    int n = getInt(input);
    int t = getInt(input);
    //System.out.println("n = " + n);
    //System.out.println("t (sum) = " + t);
     int [] array1 = new int [n + 1];
    System.out.print("Please enter " + n + " integers to be summed into " + t + " :");
    int num = getInt(input);
    //while loop allows user to enter elements seperated by a space, 999 will signal to stop loop
    while (num != 999) {
      for (int i = 1; i <= n; i++){
        array1[i] = num;
        num = getInt(input);
      }
    }
    
    for (int i = 0; i < array1.length; i++)
      System.out.print(array1[i] +" ");   
    System.out.println();
    findThePairs(array1, t);
  

  }

//Methods
  //getInt method validates that user is only entering integers
  public static int getInt(Scanner scan) {
    int number = 0;
    boolean done = false;
    while (!done) {
      try {
        number = scan.nextInt();
        if (number < 0 ) {
          System.out.println("Number has to be 0 or greater. Try again: ");
        }
        else {
          done = true;
        }
      }
      catch (InputMismatchException e) {
        System.out.println("Not an integer. Try again.");
        scan.nextLine();
      }
    }
    return number;
  }

static void findThePairs(int inputArray[], int inputNumber){
        //Sorting the given array
        Arrays.sort(inputArray);
        System.out.println("Pairs of elements whose sum is "+inputNumber+" are : ");
        //Initializing i to first index
        int i = 0;
        //Initializing j to last index
        int j = inputArray.length-1;
        //Till i crosses j, perform the following task
        while (i < j){
            //If inputArray[i]+inputArray[j] is equal to inputNumber
            if(inputArray[i]+inputArray[j] == inputNumber){
                //then Print inputArray[i] and inputArray[j]
                System.out.println(inputArray[i]+" + "+inputArray[j]+" = "+inputNumber);
                //Increment i
                i++;
                //Decrement j
                j--;
            }
            //If inputArray[i]+inputArray[j] is smaller than inputNumber
            else if (inputArray[i]+inputArray[j] < inputNumber){
                //then increment i
                i++;
            }
            //If inputArray[i]+inputArray[j] is greater than inputNumber
            else if (inputArray[i]+inputArray[j] > inputNumber){
                //then decrement j
                j--;
            }
        }
    }

}