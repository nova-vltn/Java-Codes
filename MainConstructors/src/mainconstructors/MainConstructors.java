
package mainconstructors;


public class MainConstructors {


    public static void main(String[] args) {
       Area circle1 = new Area("Circle", 10);
        System.out.println("Area of Circle= " + circle1.computeArea(10));

        Area circle2 = new Area("Circle", 10.0);
        System.out.println("Area of Circle= " + circle2.computeArea(10.0));

        Area rect1 = new Area("Rectangle", 10, 10);
        System.out.println("Area of Rectangle= " + rect1.computeArea(10, 10));

        Area rect2 = new Area("Rectangle", 10, 10.0);
        System.out.println("Area of Rectangle=  " + rect2.computeArea(10, 10.0));

        Area rect3 = new Area("Rectangle", 10.0, 10);
        System.out.println("Area of Rectangle=  " + rect3.computeArea(10.0, 10));

        Area rect4 = new Area("Rectangle", 10.0, 10.0);
        System.out.println("Area of Rectangle=  " + rect4.computeArea(10.0, 10.0));
     
    
    }
}
