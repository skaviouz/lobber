/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis;

import java.net.URLEncoder;

/**
 * Any random test I wanted to try when I'm bored...
 *
 * @author skaviouz
 */
public class randomtest {

    public static void main(String[] args) {
        System.out.println("\"\u003d\"");
        new randomtest() {
            {
                nonstatic();
            }
        };
    }

    public void nonstatic() {
        System.out.println(getClass().getResource(URLEncoder.encode("./resources/images/icon32_L.png")));
    }
}
