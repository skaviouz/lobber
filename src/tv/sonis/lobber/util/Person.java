/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber.util;
import lombok.*;
import lombok.experimental.*;

/**
 *
 * @author Blitz
 */
    @Getter @Setter @Accessors(chain = true)
public class Person {
    
    public String Name = "";
    public String Special = "";
    public String Thanks = "";
    
    public Person(String str){
        Name = str;
    }
    
}
