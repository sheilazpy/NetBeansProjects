/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clockserendipity;

/**
 *
 * @author 1003125
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int hours, minutes, seconds;
        double hAngle, mAngle;
        String minStr, secStr;
        for (hours = 1; hours <= 12; hours++) {
            for (minutes = 0; minutes < 60; minutes++) {
                for (seconds = 0; seconds < 60; seconds++) {
                    hAngle = hours * 30 + minutes / 2.0 + seconds / 120.0;
                    hAngle = Math.round(hAngle * 10) / 10.0;
                    if (hAngle >= 360) {
                        hAngle -= 360;
                    }//if
                    mAngle = minutes * 6 + seconds / 10.0;
                    if (hAngle == mAngle) {
                        minStr = "" + minutes;
                        secStr = "" + seconds;
                        if (minutes < 10) {
                            minStr = "0" + minutes;
                        }//if
                        if (seconds < 10) {
                            secStr = "0" + seconds;
                        }//if
                        System.out.println(hours + ":" + minStr + ":" + secStr);
                        break;
                    }//if
                }//for
            }//for
        }//for
    }//main method
}//Main class

