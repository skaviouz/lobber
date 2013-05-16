/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber.model;

import java.awt.Color;
import java.util.regex.Pattern;

/**
 *
 * @author skaviouz
 */
public class AzimuthData {

    public AzimuthData() {
    }

    public AzimuthData(int i) {
        setID(i);
    }

    public AzimuthData setID(int id) {
        this.ID = id;
        return this;
    }

    public AzimuthData setValue(Double val) {
        Value = val;
        return this;
    }

    public AzimuthData setName(String nam) {
        Name = nam;
        return this;
    }

    public AzimuthData setNameColor(Color col) {
        NameColor = col;
        return this;
    }

    public AzimuthData setNameOffset(Double[] namoff) {
        NameOffset = namoff;
        return this;
    }

    public AzimuthData setThickness(double thick) {
        Thickness = thick;
        return this;
    }

    public static Color addAlpha(Color col, int alph) {
        return new Color(col.getRed(), col.getGreen(), col.getBlue(), alph);
    }
    public int ID = 0;
    public Double Value = 0.000;
    public Color LineColor = new Color(0, 0, 0, 25);
    public Double Thickness = 0.00;
    public String Name = "";
    public Color NameColor = new Color(0, 0, 0, 25);
    public Double[] NameOffset = {0.0, 0.0};
    public Color defaultColor = new Color(0, 0, 0, 75);

    public AzimuthData decipher(String str) {
        int limit = 6;//values, linecolor, name, namecolor, nameoffset, thickness
        String[] tempstr = str.split("//", limit);
        for (int i = 0; i < tempstr.length; i++) {
            if (tempstr[i].length() == 0) {
//                System.out.println("break at " + i);
                break;
            }
            switch (i + 1) {
                case 1://point
//                    System.out.println("point");
                    tempstr[i] = strip(tempstr[i], "/");
                    Value = Double.parseDouble(tempstr[i]);
//                    System.out.println(Value);
                    break;
                case 2://point color
//                    System.out.println("color");
                    tempstr[i] = strip(tempstr[i], "/");
                    LineColor = ColorParse(tempstr[i]);
//                    System.out.println(LineColor);
                    break;
                case 3://thickness
//                    System.out.println("thick");
                    tempstr[i] = strip(tempstr[i], "/");
                    Thickness = Double.parseDouble(tempstr[i]);
//                    System.out.println(Thickness);
                    break;
                case 4://name
//                    System.out.println("name");
                    Name = tempstr[i];
//                    System.out.println(Name);
                    break;
                case 5://name color
//                    System.out.println("ncolor");
                    tempstr[i] = strip(tempstr[i], "/");
                    NameColor = ColorParse(tempstr[i]);
//                    System.out.println(NameColor);
                    break;
                case 6://name offset from point
                    tempstr[i] = strip(tempstr[i], "/");
//                    System.out.println("n-offset:" + tempstr[i]);
                    String[] tempstrb = tempstr[i].split(",");
//                    System.out.println(tempstrb[0]);
//                    System.out.println(tempstrb[1]);
                    double what1 = Double.parseDouble(tempstrb[0]);
                    double what2 = Double.parseDouble(tempstrb[1]);
//                    System.out.println("The doubles?");
//                    System.out.println(what1);
//                    System.out.println(what2);
                    NameOffset = new Double[]{
                        Double.parseDouble(tempstrb[0]),
                        Double.parseDouble(tempstrb[1])};
//                    System.out.println(NameOffset);
                    return this;
            }
        }
        return this;
    }

    public Color ColorParse(String stra) {
        if (stra.contains(",")) {
            String[] tempstra = stra.split(",");
//            System.out.println("color length " + tempstra.length);
            String tempstrb[] = {tempstra[0], (tempstra.length > 1) ? tempstra[1] : "0", (tempstra.length > 2) ? tempstra[2] : "0", (tempstra.length > 3) ? tempstra[3] : "25"};
            int[] tempinta = {0, 0, 0, 0};
            tempinta[0] = Integer.parseInt(tempstrb[0]);
            tempinta[1] = Integer.parseInt(tempstrb[1]);
            tempinta[2] = Integer.parseInt(tempstrb[2]);
            tempinta[3] = Integer.parseInt(tempstrb[3]);
            Color c = new Color(tempinta[0], tempinta[1], tempinta[2], tempinta[3]);
            return c;
        } else if (Pattern.matches("[a-zA-Z'%]", stra) && !Pattern.matches("[0-9]", stra)) {
            //TODO: Name Support Later
        }
        return defaultColor;
    }

    //TODO: Add Collection to trash
    public String strip(String source, String trash) {
        while (contains(source, trash)) {
            int i = source.indexOf(trash);
            source = source.substring(0, i);
        }
        return source;
    }

    public boolean contains(String source, String... check) {
        for (int i = 0; i < check.length; i++) {
            if (source.contains(check[i])) {
                return true;
            }
        }
        return false;
    }
}
