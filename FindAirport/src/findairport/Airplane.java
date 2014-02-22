/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package findairport;

/**
 *
 * @author 1003125
 */
public class Airplane {
    
    double x, y, distance;

    public Airplane(double xPos, double yPos)
    {
        x=xPos;
        y=yPos;
    }//Airplane constructor

    public Airplane()
    {
        x=Math.random()*1000-500;
        y=Math.random()*1000-500;
    }//Airplane constructor

    void fly(double angle, double distance)
    {
        angle = 360-angle-270;
        x+=Math.cos(Math.toRadians(angle))*distance;
        y+=Math.sin(Math.toRadians(angle))*distance;
    }//fly method

    double distanceAway(Airplane plane)
    {
        distance=Math.sqrt(Math.pow(x-plane.x, 2)+Math.pow(y-plane.y, 2));
        return distance;
    }//distanceAway method

}//Airplane class
