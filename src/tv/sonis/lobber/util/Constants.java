/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber.util;

/**
 *
 * @author skaviouz
 */
public class Constants {

    public static String getTitle() {
        return "Lobber Tools " + Version.var;
    }
    public static final Version Version = new Version("6");
    
    public static double random(double max){
        return random(0, max);
    }
    
    public static double random(double min, double max){
        return (Math.random()*(max-min) + min);
    }
    
    public static float d2f(double d){
        return (float) d;
    }
    
    public static int d2i(double d){
        return (int) d;
    }
    
    public static int f2i(float f){
        return (int) f;
    }
    
}
