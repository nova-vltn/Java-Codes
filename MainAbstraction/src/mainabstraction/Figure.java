/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainabstraction;

public abstract class Figure {
    public abstract void  sides();
    public abstract void  shapename();
    
    public void description(){
        System.out.println("All figures have dimensions.");
    }
}
