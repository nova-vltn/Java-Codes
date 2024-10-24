
package mainconstructors;


public class Area {
    
    public String strshape;
    public int intRadius, intLength, intWidth;
    public double dblRadius, dblLength, dblWidth;
    
    //Circle1
    public Area (String strshape,int intRadius){
        this.strshape = strshape;
        this.intRadius = intRadius;           
    }
    public double computeArea(int intRadius) {
        return Math.PI * intRadius * intRadius;
    }
    
    //Circle2
    public Area (String strshape,double intRadius){
        this.strshape = strshape;
        this.dblRadius = intRadius;           
    }
    public double computeArea(double intRadius) {
        return Math.PI * intRadius * intRadius;
    }
    
    //Rectangle1
    public Area (String strshape,int intLength,int intWidth){
        this.strshape = strshape;
        this.dblRadius = intRadius;           
    }
      public double computeArea(int length, int width) {
        return length * width;
    }
               
    //Rectangle2
    public Area (String strshape, int intLength, double intWidth){
        this.strshape = strshape;
        this.dblRadius = intRadius;           
    }
     public double computeArea(int length, double width) {
        return length * width;
    }
    
    //Rectangle3
    public Area (String strshape, double intLength, int intWidth){
        this.strshape = strshape;
        this.dblRadius = intRadius;         
    }
     public double computeArea(double length, int width) {
        return length * width;
    }
    
    //Rectangle4
    public Area (String strshape, double length, double width){
        this.strshape = strshape;
        this.dblRadius = intRadius;           
    }
     public double computeArea(double length, double width) {
        return length * width;
    }
    
    
    
}
