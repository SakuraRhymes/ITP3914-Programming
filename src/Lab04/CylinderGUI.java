package Lab04;

import javax.swing.*;

public class CylinderGUI {
    public static void main(String[] args) {
        double r, l, v;
        String input;

        input = JOptionPane.showInputDialog(null, "Enter the radius:");
        r = Double.parseDouble(input);

        input = JOptionPane.showInputDialog(null, "Enter the length:");
        l = Double.parseDouble(input);

        v = r * r * (Math.PI) * l;

        JOptionPane.showMessageDialog(null, "The volume of the cylinder with radius = " + r + " and length = " + l + " is " + v + ".");
    }
}