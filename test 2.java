import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) 
	{

        int size_exp = expressions.length;
        int size_maxR = maxReplacements.length;
        Stack<Integer> bal_stack = new Stack<Integer>();
	int[] results = new int[size_exp];
        
        for ( int i = 0; i < size_exp; i++ ){
            
            String exp_i = expressions[i];
            int exp_i_length = exp_i.length();
            int left = 1;
            int right = 2;
            int left_count = 0;
            int right_count = 0;
            
            for( int j = 0; j < exp_i_length; j++ ){
                if (exp_i.charAt(j) == '<'){
                    bal_stack.push(1);
                }else if (exp_i.charAt(j) == '>'){
                    if(bal_stack.peek() == 1){
                        bal_stack.pop();
                    }else if(bal_stack.peek() == 2){
                        bal_stack.push(2);
                    }
                }
                
            }
            if(!bal_stack.empty()){
		Iterator<Integer> iter = bal_stack.iterator();

		while (iter.hasNext()){
		   if(iter.next() == 1) left_count++;
		   if(iter.next() == 2) right_count++;
		}
		    
		if(left_count != 0) {
			results[i] = 0;
		}else if(left_count == 0 && right_count <= maxReplacements[i]){
			results[i] = 1;
		}
		    
	    }else{
	    	results[i] = 1;
	    }
            
        }

    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
     public static void main(String[] args) throws IOException
	 {
        Scanner in = new Scanner(System.in);
        int[] res;
        
        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for(int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }
        
        
        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for(int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }
        
        res = balancedOrNot(_expressions, _maxReplacements);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}
