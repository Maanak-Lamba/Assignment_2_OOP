/*
 * Name: [Your Name]
 * Date: June 3, 2026
 * Description: This program asks the user for a pizza diameter and tells them
 * how many slices it will be cut into and the area of each slice.
 * Only diameters between 6 and 24 inches are accepted.
 */

import java.util.Scanner;

public class PizzaSlicer {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double diameter;
        int numSlices;
        double pizzaArea;
        double sliceArea;

        System.out.print("Please enter the diameter of your pizza (between 6\" and 24\"): ");

        // make sure they typed a number first
        if (keyboard.hasNextDouble() == false) {
            System.out.println("Error: Please enter a numeric value for the diameter.");
            keyboard.close();
            return;
        }

        diameter = keyboard.nextDouble();

        // check if the diameter is within the valid range
        if (diameter < 6 || diameter > 24) {
            System.out.println("Error: Pizza must have a diameter in the range of 6\" to 24\" inclusive! Please try again.");
            keyboard.close();
            return;
        }

        // figure out how many slices based on the diameter
        if (diameter < 8) {
            numSlices = 4;
        } else if (diameter < 12) {
            numSlices = 6;
        } else if (diameter < 14) {
            numSlices = 8;
        } else if (diameter < 16) {
            numSlices = 10;
        } else if (diameter < 20) {
            numSlices = 12;
        } else {
            numSlices = 16;
        }

        // calculate the total area of the pizza then divide by slices
        // area of a circle = pi * radius^2, radius is half the diameter
        pizzaArea = Math.PI * Math.pow(diameter / 2, 2);
        sliceArea = pizzaArea / numSlices;

        // round both values to 2 decimal places for display
        double roundedDiameter = Math.round(diameter * 100.0) / 100.0;
        double roundedSliceArea = Math.round(sliceArea * 100.0) / 100.0;

        System.out.println("\nA " + roundedDiameter + "\" pizza will yield " + numSlices + " slices.");
        System.out.printf("Each slice will have an area of %.2f square inches.\n", sliceArea);

        keyboard.close();

    }

}