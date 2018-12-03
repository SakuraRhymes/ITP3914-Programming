package Lab4;

import javax.swing.*;

public class CylinderGUI {
    public static void main(String[] args) {
        double r, l, v;
        String input;

        input = JOptionPane.showInputDialog(null, "Enter the radius:");
        r = Integer.parseInt(input);

        input = JOptionPane.showInputDialog(null, "Enter the length:");
        l = Integer.parseInt(input);

        v = r * r * (Math.PI) * l;

        JOptionPane.showMessageDialog(null, "The volume of the cylinder with radius = " + r + " and length = " + l + " is " + v + ".");
    }
}