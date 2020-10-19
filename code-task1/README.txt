Thought process: 
First, we create a class named ‘Range’, to hold the structure of 5-digit ZIP code ranges. 
We need  2 instance variables for both lower and upper bounds.
The data type of instance variables must be String, 
Then we write a function to reformat objects of ‘Range’ class in the collection.
Finally, we implement test cases to check the logic.

Approach I took for this solution:
In order to produce the minimum ranges in one function.
First, we sort the objects based on lower bound using stream.
Second, for each ‘Range’ object, we compare with its previous reformatted ‘Range’ object:
Convert data type, String to int.
If the current object has no intersection with the previous one, add the current object to the final list.
Otherwise, if they have intersection, merge them based on their upper bounds. 
Covert data type, int to numeric String with padding, e.g. 0 -> “00000”.
Add the merged range to the final list.

Limitation of solution - Defining boundary/Scope: 
The collection can be empty.
The valid input should be in the range of [“00000”,”99999”].
Lower and upper bounds must be 5-digit String. “0” or (int) 0 are not allowed.