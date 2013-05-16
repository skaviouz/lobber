package tv.sonis.lobber.util;

import java.awt.Point;

/**
 * File that contains all the math functions
 * @author skaviouz
 */
public class geometry {

    /**
     * returns a point for a hypothetical line starting at X,Y with Length of
     * X/Y not to exceed MaxX/MaxY the point has an azimuth from the starting
     * X,Y at DegreeAngle
     *
     * @param StartX
     * @param StartY
     * @param MaxX
     * @param MaxY
     * @param DegreeAngle
     * @return
     */
    public static int[] AzimuthLineBox(double StartX, double StartY, double MaxX, double MaxY, double DegreeAngle) {
        double CorrectDegreeAngle = (DegreeAngle + 270) % 360;
        double RadianAngle = CorrectDegreeAngle * Math.PI / 180;
        double RadiusX = Math.abs(MaxX - StartX);
        double RadiusY = Math.abs(MaxY - StartY);
        double DestX = StartX + (RadiusX * Math.cos(RadianAngle));
        double DestY = StartY + (RadiusY * Math.sin(RadianAngle));
        return new int[]{(int)DestX, (int)DestY};
    }
}
