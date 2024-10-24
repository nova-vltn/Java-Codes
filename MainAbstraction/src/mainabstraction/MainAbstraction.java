
package mainabstraction;

public class MainAbstraction {

    public static void main(String[] args) {
        Figure clTriangle= new Triangle();
        clTriangle.sides();
        clTriangle.shapename();
        clTriangle.description();
        
        Figure clPentagon= new Pentagon();
        clPentagon.sides();
        clPentagon.shapename();
        clPentagon.description();
        
        Figure clHexagon= new Hexagon();
        clHexagon.sides();
        clHexagon.shapename();
        clHexagon.description();
        
        Figure clTriangleInterface = new Triangle();
        clTriangleInterface.sides();
        clTriangleInterface.shapename();
        clTriangleInterface.description();
        
        Figure clPentagonInterface = new Pentagon();
        clPentagonInterface.sides();
        clPentagonInterface.shapename();
        clPentagonInterface.description();
        
        Figure clHexagonInterface = new Hexagon();
        clHexagonInterface.sides();
        clHexagonInterface.shapename();
        clHexagonInterface.description();
    }
    
}
