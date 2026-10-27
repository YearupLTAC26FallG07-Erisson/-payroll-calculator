package com.pluralsight;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        try {
            // 1. Open the file with FileReader and wrap it in a BufferedReader
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            System.out.println("--- Payroll Information ---");
            System.out.printf("%-10s %-20s %-10s\n", "ID", "Name", "Gross Pay");
            System.out.println("------------------------------------------");

            // 2. Read each line of text
            while ((line = bufferedReader.readLine()) != null) {

                // 3. Split it into individual fields using the | character as the delimiter
                // We use \\| because the pipe symbol is a special character in Java regex
                String[] tokens = line.split("\\|");

                // 4. Copy values from tokens array into matching variables
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Create a new Employee object using the variables
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                // 5. Display the employee using printf and calling the methods
                System.out.printf("%-10d %-20s $%-10.2f\n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay());
            }

            // Always close the reader
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + fileName + "' was not found.");
        } catch (IOException e) {
            System.out.println("Error: An error occurred while reading the file.");
        }
    }
}
