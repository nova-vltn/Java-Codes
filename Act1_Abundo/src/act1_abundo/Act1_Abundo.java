package act1_abundo;
/**
 *
 * @author Jonalene Ryza & Carla Mabutas (BSCS 2-1)
 */
public class Act1_Abundo {

    public static void main(String[] args) {
        
        Functions clFunctions = new Functions();
        System.out.println("The area of the circle is " + clFunctions.area(5));
        System.out.println("The sum of the series is " + clFunctions.series(10));
        System.out.println("The number has a total of " + clFunctions.digits(123) + "  digits ");
        System.out.println("The reversed digits of the number is " + clFunctions.reverse(123));
        
        /*char[] charArray = {'h', 'e', 'l', 'l', 'o'};
        char charKey = 'e';
        if (clFunction.search(charArray,charKey,0))
            System.out.println("Yes!  "+ charKey + " is found in the array.");
        else
            System.out.println("Sorry  " + charKey + " is not found in the array.");
        */
        }
    
}
