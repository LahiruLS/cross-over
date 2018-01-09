import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {
	
    /**
     * Complete the function below.
     * DONOT MODIFY anything outside this function!
     */
    static int[] rearrange(int[] elements) 
    {
        int size_elements = elements.length;
        int temp = 0;
        for (int index = 0; index < size_elements; index++){
          for(int j = 1; j < (size_elements - index); j++){ 
         if(
         (Integer.bitCount(elements[index]) >
         Integer.bitCount(elements[index+1])) || 
         ((Integer.bitCount(elements[index]) ==
         Integer.bitCount(elements[index+1])) && 
         (elements[index] > elements[index+1]))
         ){
             temp = elements[j-1];  
             elements[j-1] = elements[j];  
             elements[j] = temp; 
         }
        
        }

    }
    return elements;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int[] res;
        
        int _elements_size = 0;
        _elements_size = Integer.parseInt(in.nextLine().trim());
        int[] _elements = new int[_elements_size];
        int _elements_item;
        for(int _elements_i = 0; _elements_i < _elements_size; _elements_i++) {
            _elements_item = Integer.parseInt(in.nextLine().trim());
            _elements[_elements_i] = _elements_item;
        }
        
        res = rearrange(_elements);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }        
    }
}
