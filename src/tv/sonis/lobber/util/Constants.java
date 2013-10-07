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
        return "Lobber Tools " + Version.var + " - \"Graph like a pro!\" (C) 2012";
//        return "Lobber Tools " + Version.var + " - Graph like a pro";
    }
    public static final Version Version = new Version("6.0");
    public static final Person[] Honors = new Person[]{
        new Person("Eric M. Horvitz II").setSpecial("Programmer").setThanks("For all the time and effort"), 
        new Person("Tom Waller").setSpecial("From the insirpration of").setThanks("Asking for the program to be made"), 
        new Person("James Bennet").setSpecial("Honorably Mentioned").setThanks("Thanks for testing and looking for bugs"), 
        new Person("Stephen Gilmore").setSpecial("Honorably Mentioned").setThanks("Thanks for testing and looking for bugs")
    };

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
