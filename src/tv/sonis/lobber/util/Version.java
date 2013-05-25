/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber.util;

/**
 * What the version number should be.
 *
 * @author skaviouz
 */
public class Version {

    public static String example = "6";
    public String var = "";
    public int major = 6;
    public int minor = 0;
    public int maintenance = 0;
    public int build = 0;

    public Version(String str) {
        var = str;
    }

    public boolean auth(String str) {
        firstcheck:
        if (!(str == null)) {
            return true;
        }
        return false;
    }
}
