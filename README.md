# Comparison-of-sorting-algorithms-java
The first project of my algorithms class, comparing 3 sort methods. You can read read the full problem statement in “CSCI-3412-Program-1.pdf”, my report of the results in “Jeremy_Diamond_HW1-1.pdf”, and the collected data in “output.xlsx”. The following is adapted from “Jeremy_Diamond_HW1-1.pdf”.

## Select Sorting Algorithms 
For my naive sort O(𝑛^2 ) I selected bubble sort for familiarity. For my O(n ln(n)) sort I chose Merge sort for ease of implementation and consistent behavior. For my O(n) sort I chose counting sort for simplicity

## Write Pseudo-Code for Each Of the Algorithms
### Bubble Sort 
Taken from page 40 of the textbook (CLRS). This algorithm swaps elements one at a time to cause the smallest values to ”bubble” up to the top. 
### Merge Sort
Taken from pages 30-34 of the textbook (CLRS). This algorithm is made up of 2 distinct methods. MergeSort and Merge. MergeSort receives an array and two integers to serve a top and bottom indexes for a subarray. If that sub array has 2 or more elements in it the sub array is divided in half and both halves reclusively call the method. This recursive call is the main loop. Merge is a subloop of the MergeSort method. It takes two sorted subarrays and combines them into a signal array. It does this by looking at the first element of each moving the smaller one into the new array and looping this behavior until both are empty. This Pseudo-code contains a feature I never implanted where you make the last element of each subarray an arbitrarily large number to speed up merging. For more complete explications see pages 30-34 of the text.
### Counting Sort
There was no available version of this to be referenced so I wrote it myself. I likely didn’t look hard enough. 
CountingSort(A)
1. B = array with indexes 1 to x where x is the max value of an element in A 
2. for i = 1 to A.length 
3. n = A[i] 
4. B[n-1]++ 

This algorithm simply increments the value of an index n-1 in B for every n that is an element of A. It only works if the elements are integers, with both an upper, and lower bounds.
## Static Analysis
### Bubble Sort
* The loop invariant for the main loop (lines 1-4) of Bubble sort is:
The smallest value form index i to index A.length-1 in not yet known to be in index i.
* Initialization: Initially no values have been evaluated so the lowest value can’t be know
to be in index 1.
* Maintenance: Assume that i != A.length. Between these two indexes there must be a
lowest value to be moves to the lowest position. After that is done i is incremented and
the loop restarts.
* Termination: The loop terminates when i = A.lenght. At this point all of the previous sub
arrays of i to A.lenght have had their smallest value moved to the first index to the array
must be sorted.
### Merge Sort
* The loop invariant for the main loop (lines 1-5) of Merge sort is:
The sub array A[p] to A[r] contains more than 1 element.
* Initialization: Initially no sub arrays have been split. Thus any unsorted set A must have
more than 1 element.
* Maintenance: Assume that the subarray used to call MergeSort has more than 1
element in it. The function then calls itself recursively with 2 new smaller sub arrays
* Termination: The loop terminates when the recursive tree hits the level of sub arrays
with 1 or 0 elements at which point all the respective Merge methods are called.
### Counting Sort
* The loop invariant for the main loop (lines 2-4) of Counting sort is:
There is another value in set A to be sorted.
* Initialization: Initially no values have been sorted so if set A exists there must be a next
value.
* Maintenance: Assume that set i <= A.length. The value is sorted and the loop restarts.
* Termination: The loop terminates when i = A.length. At this point all of the previous
elements of A must have been sorted, thus the array is sorted.
## Implementation
All three algorithms were coded in Java in 3 separate files. One for running bubble sort on the million value file. Another for running all files on the three sorts. The third for running various sizes on all three sorts. This was my first java project ever and as a result there are a few oddities with this code.
* The sorts are implemented inside of try blocks because I didn’t yet know the proper way to get around the required try catch in Java file io.
* In order to count the operations and swaps I needed to pass an int by reference to MergeSort and Merge. To do this I used 1 element arrays.
* Merge doesn’t have the lower bound optimization of the above Pseudo-Code
