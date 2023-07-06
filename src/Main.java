import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("Mean With Unknown Variables");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Asking for the number of variables until the user enters a valid number and if the user click on cancel then exit
            int n = 0;
            while (n <= 0) {
                String nString = JOptionPane.showInputDialog("How many variables (marks) you know?");
                if (nString == null) {
                    System.exit(0);
                }
                n = Integer.parseInt(nString);
            }

            // Asking to fill the variables and coefficients (ECTS) in a table until the user enters a valid double number and if the user click on cancel then exit
            String[][] numbers = new String[n][2];
            for (int i = 0; i < n; i++) {
                numbers[i][0] = JOptionPane.showInputDialog("What is the variable (mark) number " + (i + 1) + "?");
                if (numbers[i][0] == null) {
                    System.exit(0);
                }
                numbers[i][1] = JOptionPane.showInputDialog("What is the coefficient (ECTS) of the variable (mark) number " + (i + 1) + "?");
                if (numbers[i][1] == null) {
                    System.exit(0);
                }
            }

            // Asking for the mean until the user enters a valid double number and if the user click on cancel then exit
            double mean = 0;
            while (mean <= 0) {
                String meanString = JOptionPane.showInputDialog("What is the mean?");
                if (meanString == null) {
                    System.exit(0);
                }
                mean = Double.parseDouble(meanString);
            }
            // Asking for the sum of the coefficients of the unknown variables until the user enters a valid double number and if the user click on cancel then exit
            double missingCoeffSum = 0;
            while (missingCoeffSum <= 0) {
                String missingCoefSumString = JOptionPane.showInputDialog("What is the sum of the coefficients of the unknown variables (marks)?");
                if (missingCoefSumString == null) {
                    System.exit(0);
                }
                missingCoeffSum = Double.parseDouble(missingCoefSumString);
            }

            // Calculating the unknown variables mean
            double actuelCoeffSum = 0;
            for (int i = 0; i < n; i++) {
                actuelCoeffSum += Double.parseDouble(numbers[i][1]);
            }

            double sumProdOfNumbers = 0;
            for (int i = 0; i < n; i++) {
                sumProdOfNumbers += Double.parseDouble(numbers[i][0]) * Double.parseDouble(numbers[i][1]);
            }

            double unknownMean = (mean * (actuelCoeffSum + missingCoeffSum) - sumProdOfNumbers) / missingCoeffSum;

            // Rounding the unknown variables mean
            unknownMean = Math.round(unknownMean * 100.0) / 100.0;

            // Showing the unknown variables mean
            JOptionPane.showMessageDialog(null, "The unknown variables (marks) mean is " + unknownMean);

            // Asking if the user wants to calculate another unknown variables mean
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to calculate another unknown variables (marks) mean?", "Yes or No", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                frame.setVisible(false);
                main(args);
            } else {
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            System.exit(0);
        }
    }
}