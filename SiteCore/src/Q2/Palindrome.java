package Q2;

/**
 *
 * @author fahmihafiz
 */

public class Palindrome {
    public static void main(String[] args) {
        String inputString1 = "a@b!!b$a";
        String trashSymbols1 = "!@$";
        System.out.println("Example 1 Result: " + check(inputString1, trashSymbols1));

        String inputString2 = "?Aa#c";
        String trashSymbols2 = "#?";
        System.out.println("Example 2 Result: " + check(inputString2, trashSymbols2));
    }
    
    public static boolean check(String inputString, String trashSymbols) {
        int left = 0;
        int right = inputString.length() - 1;
        
        while(left < right){
            char leftChar = inputString.charAt(left);
            char rightChar = inputString.charAt(right);
            
            boolean flag = true;
            
            
            // First inner loop for left side (to skip the trashSymbols)
            while(flag){
                // Check if leftChar is in trashSymbols or not
                if(trashSymbols.indexOf(Character.toLowerCase(leftChar)) != -1){
                    left++;
                    leftChar = inputString.charAt(left);              
                }

                else{
                    flag = false;
                }
            }
            
            flag = true;
            
            // Second inner loop for right side
            while(flag){
                // Check if leftChar is in trashSymbols or not (to skip the trashSymbols)
                if(trashSymbols.indexOf(Character.toLowerCase(rightChar)) != -1){
                    right--;
                    rightChar = inputString.charAt(right);              
                }

                else{
                    flag = false;
                }
            }
            
            // Check if both characters are similar
            if(leftChar != rightChar){
                return false;
            }
            left++;
            right--;
            
        }
        return true;
  
    }
}
