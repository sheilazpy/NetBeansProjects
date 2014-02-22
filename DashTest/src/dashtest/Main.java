/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dashtest;

import java.awt.Color;
import hsa.PaintBug;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double xPosition = Math.random () * 400;
        double yPosition = Math.random () * 300;
        double direction = Math.random () * 360;
        PaintBug bug = new PaintBug (xPosition, yPosition, direction, Color.RED);
        PaintBug.setSpeed (95);
        while (0 < 1)
        {
            if (bug.getYPos () <= 0 || bug.getYPos () >= 300)
            {
                bug.setDirection (360 - bug.getDirection ());
            } //if
            if (bug.getXPos () <= 0 || bug.getXPos () >= 400)
            {
                bug.setDirection (180 - bug.getDirection ());
            } //if
            bug.move (1);
        } //while
    }

}
