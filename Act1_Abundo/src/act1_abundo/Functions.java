package act1_abundo;
public class Functions {
     
    //Area of a Given Circle
    public double area (double dblRad){
        double dblPi = 3.14;
        double dblArea= 0;
        for (int intCounter= 1; intCounter <= dblRad; ++intCounter )
            dblArea = dblPi * (dblRad * dblRad);
        return dblArea;
    }
    
    //Series Sum
    public int series (int intNum){
        int intSum=0;
        for (int intCounter=1; intCounter <= intNum; ++intCounter )
            intSum = (intNum * (intNum+2)); 
        return intSum;
    }
    
    //Digits in a Number 
    public int digits (int intNum) {
        if (intNum == 0) return 1;  // Handle the special case where the number is 0
        return (int) Math.log10(Math.abs(intNum)) + 1;

    }
    
    //Reversing the Digits in a Number
    public int reverse(int intNum) {
    int intReversed = 0;
    while (intNum != 0) {
        intReversed = intReversed * 10 + intNum % 10;
        intNum /= 10;  // Remove the last digit from intNum
    }
    return intReversed;
       }
    
    //Searching for a key
     public boolean search(char[] charArray, char charKey, int intIndex) {
        if (intIndex == charArray.length) {
            return false;  
        }
        if (charArray[intIndex] == charKey) {
            return true;  
        }
        return search(charArray, charKey, intIndex + 1);  
    }
    
     
     
     public static void main(String[] args) {
        
        Functions clFunctions = new Functions();
        System.out.println("The area of the circle is " + clFunctions.area(5));
        System.out.println("The sum of the series is " + clFunctions.series(10));
        System.out.println("The number has a total of " + clFunctions.digits(123) + "  digits ");
        System.out.println("The reversed digits of the number is " + clFunctions.reverse(123));
        
        char[] charArray = {'h', 'e', 'l', 'l', 'o'};
        char charKey = 'e';
        if (clFunctions.search(charArray,charKey,0))
            System.out.println("Yes!  "+ charKey + " is found in the array.");
        else
            System.out.println("Sorry  " + charKey + " is not found in the array.");
        
        }
}
        


