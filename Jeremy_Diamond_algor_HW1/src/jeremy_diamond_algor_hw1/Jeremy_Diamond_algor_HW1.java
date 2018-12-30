

package jeremy_diamond_algor_hw1;

/**
 *
 * @author Jeremy G Diamond
 */

import java.io.*;
public class Jeremy_Diamond_algor_HW1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int numOfComps = 0;
        String file = "shuffled.txt";
        
        meargeHead(file);
        countSort(file);
        bubble(file);
    }
    
    public static void bubble(String fileName) {
        int[] toBeSorted;
        String currentLine = null;
        int convert = 0;
        int counter = 0;
        int size = 0;
        int compCounter = 0;
   
       try{ 
        
        FileReader reader = new FileReader(fileName);// reads text file
         
         BufferedReader bufferedReader = 
                new BufferedReader(reader);
         
         currentLine = bufferedReader.readLine(); //skips first line 
         
         currentLine = bufferedReader.readLine();// reads in size as a string
         convert = Integer.parseInt(currentLine);// converts string to int
         toBeSorted = new int[convert];// allowcates array
         size = convert; // sets the size of the array
         
         
         while((currentLine = bufferedReader.readLine()) != null) {
                convert = Integer.parseInt(currentLine);
                toBeSorted[counter] = convert;
                
                counter++;
                //System.out.println(currentLine);
            }
         
           for (int i = 0; i < size-1; i++)// bubble sort algor
            for (int j = 0; j < size-i-1; j++){
                compCounter++;
                if (toBeSorted[j] > toBeSorted[j+1])
                {
                    // swap temp and arr[i]
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j+1];
                    toBeSorted[j+1] = temp;
                }
            }
          //for (int i = 0; i < size; i++) //print results used for testing
            //  System.out.println(toBeSorted[i]);
          System.out.println("num of comps for bubble is");
          System.out.println(compCounter);
          
       } 
         catch(FileNotFoundException ex) { // default catch for FileNotFoundException
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");
         }  
       
        catch(IOException ex) { // default catch for IOException
             System.out.println(
                 "Error reading file '" 
                 + fileName + "'");                  
             // Or we could just do this: 
             // ex.printStackTrace();
         }
       
       
     
         
    }
    
    public static void meargeHead(String fileName) {
     
        int[] toBeSorted;
        String currentLine = null;
        int convert = 0;
        int counter = 0;
        int size = 0;
        int[] compCounter = new int[1]; //this is hacked up way to pass a pointer to an int
        compCounter[0] = 0;
   
       try{ 
        
        FileReader reader = new FileReader(fileName);// reads text file
         
         BufferedReader bufferedReader = 
                new BufferedReader(reader);
         
         currentLine = bufferedReader.readLine(); //skips first line 
         
         currentLine = bufferedReader.readLine();// reads in size as a string
         convert = Integer.parseInt(currentLine);// converts string to int
         toBeSorted = new int[convert];// allowcates array
         size = convert; // sets the size of the array
         
         
         while((currentLine = bufferedReader.readLine()) != null) {
                convert = Integer.parseInt(currentLine);
                toBeSorted[counter] = convert;
                
                counter++;
                //System.out.println(currentLine);
            }
         
           mergeSort (toBeSorted, 0, size-1, compCounter); 
         
          //for (int i = 0; i < size; i++) //print results used for testing
            // System.out.println(toBeSorted[i]);
          System.out.println("num of comps for merge is");
          System.out.println(compCounter[0]);
          
       } 
         catch(FileNotFoundException ex) { // default catch for FileNotFoundException
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");
         }  
       
        catch(IOException ex) { // default catch for IOException
             System.out.println(
                 "Error reading file '" 
                 + fileName + "'");                  
             // Or we could just do this: 
             // ex.printStackTrace();
         }
       
       
     
        
        
        return;
    }
    
    public static void countSort(String fileName) {
        
        int[] toBeSorted;
        String currentLine = null;
        int convert = 0;
        int counter = 0;
        int size = 0;
        int compCounter = 0; 
   
       try{ 
        
        FileReader reader = new FileReader(fileName);// reads text file
         
         BufferedReader bufferedReader = 
                new BufferedReader(reader);
         
         currentLine = bufferedReader.readLine(); //skips first line 
         
         currentLine = bufferedReader.readLine();// reads in size as a string
         convert = Integer.parseInt(currentLine);// converts string to int
         toBeSorted = new int[convert];// allowcates array
         size = convert; // sets the size of the array
         
         
         while((currentLine = bufferedReader.readLine()) != null) {
                convert = Integer.parseInt(currentLine);
                toBeSorted[counter] = convert;
                
                counter++;
                //System.out.println(currentLine);
            }
         
         
         
          //for (int i = 0; i < size; i++) //print results used for testing
            // System.out.println(toBeSorted[i]);
          System.out.println("num of comps for count is");
          System.out.println(compCounter);
          
       } 
         catch(FileNotFoundException ex) { // default catch for FileNotFoundException
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");
         }  
       
        catch(IOException ex) { // default catch for IOException
             System.out.println(
                 "Error reading file '" 
                 + fileName + "'");                  
             // Or we could just do this: 
             // ex.printStackTrace();
         }
       
     
        
    }
    
     public static void mergeSort(int arrToSort[], int x, int y, int daCount[]){
        daCount[0]++; 
         if (x < y) {
             
             int m = (x + y) / 2;// Find the mid

             mergeSort(arrToSort, x, m, daCount);// Sort both halves
             mergeSort(arrToSort, m + 1, y, daCount);

             merge(arrToSort, x, m, y, daCount); // Merge the sorted halves
         }
         
     }
     
     public static void merge(int arrToSort[], int x, int m, int y, int daCount[]){
          
        int s1 = m - x + 1; // set sizes of two subarrays
        int s2 = y - m;
 
        int left[] = new int [s1]; // temp arrays
        int right[] = new int [s2];
 
        
        for (int i=0; i<s1; ++i) //Copy data to temp arrays
            left[i] = arrToSort[ x + i];
        for (int j=0; j<s2; ++j)
            right[j] = arrToSort[m + 1+ j];
 
 
        int i = 0, j = 0; //indexes of first and second subarrays
 
        int k = x ;// index of merged array
        
        while (i < s1 && j < s2) //merge the 2 arrays
        {
            daCount[0]++;
            if (left[i] <= right[j])
            {
                arrToSort[k] = left[i];
                i++;
            }
            else
            {
                arrToSort[k] = right[j];
                j++;
            }
            k++;
        }
 
        while (i < s1) 
        {
            daCount[0]++;
            arrToSort[k] = left[i];
            i++;
            k++;
        }

        while (j < s2)//copy extra elements
        {
            daCount[0]++;
            arrToSort[k] = right[j];
            j++;
            k++;
        }
    }
     
}
    

