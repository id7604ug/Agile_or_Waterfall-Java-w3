package com.anthony;

import java.util.Scanner;

public class Main {
    static Scanner numberScanner = new Scanner(System.in);
    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create variables for question answers
        int programmers; // Lots of people = Waterfall
        boolean firmDeadlineSchedule = false; // Waterfall
        boolean programmerExperience = false; // Agile
        boolean qualityControl = false; // Waterfall
        boolean earlyIntegration = false;  // Agile
        boolean customerWorkingModels = false; // Agile
        // Variable to store users answer
        String answer;

        // Ask questions
        System.out.println("How many programmers will be on the team? ");
        programmers = numberScanner.nextInt();
        System.out.println("Will there be firm deadlines and a fixed schedule? ");
        answer = stringScanner.nextLine();
        if (answer.equalsIgnoreCase("yes") | answer.equalsIgnoreCase("y")){
            firmDeadlineSchedule = true;
            answer = "";
        }
        System.out.println("Do the programmers have experience in requirements, analysis and testing as well as coding? ");
        answer = stringScanner.nextLine();
        if (answer.equalsIgnoreCase("yes") | answer.equalsIgnoreCase("y")){
            programmerExperience = true;
            answer = "";
        }
        System.out.println("Will there be stringent quality control requirements? ");
        answer = stringScanner.nextLine();
        if (answer.equalsIgnoreCase("yes") | answer.equalsIgnoreCase("y")){
            qualityControl = true;
            answer = "";
        }
        System.out.println("If early integration desirable? ");
        answer = stringScanner.nextLine();
        if (answer.equalsIgnoreCase("yes") | answer.equalsIgnoreCase("y")){
            earlyIntegration = true;
            answer = "";
        }
        System.out.println("Will the customer require working models early in the process? ");
        answer = stringScanner.nextLine();
        if (answer.equalsIgnoreCase("yes") | answer.equalsIgnoreCase("y")){
            customerWorkingModels = true;
            answer = "";
        }
        // Call method within print statement to return an opinion
        System.out.println(agileOrWaterfall(programmers, firmDeadlineSchedule, programmerExperience, qualityControl, earlyIntegration, customerWorkingModels));

        // Close Scanners
        numberScanner.close();
        stringScanner.close();
    }
    // Method to generate an opinion
    private static String agileOrWaterfall(int programmers, boolean firmDeadlineSchedule,
        boolean programmerExperience, boolean qualityControl, boolean earlyIntegration, boolean customerWorkingModels) {
        // Closer to 0 if more fit for waterfall closer to 12 more fit for agile
        int methodFit = 6;
        // Each influences the methodFit to be closer to agile (12) or waterfall (0)
        // based on the arguments sent to the method
        if (programmers > 1){
            methodFit --;
        } else { methodFit ++; }
        if (firmDeadlineSchedule){
            methodFit --;
        } else { methodFit ++; }
        if (programmerExperience){
            methodFit ++;
        } else { methodFit --; }
        if (qualityControl){
            methodFit --;
        } else { methodFit ++; }
        if (earlyIntegration){
            methodFit ++;
        } else { methodFit --; }
        if (customerWorkingModels){
            methodFit ++;
        } else { methodFit --; }
        System.out.println(methodFit); // Test for value of methodFit
        if (methodFit < 4){
            return "Your project would be best suited with the Waterfall method.";
        }
        if (methodFit >= 4 && methodFit <= 6){
            return "Your project leans toward the Waterfall method.";
        }
        if (methodFit >= 7 & methodFit <= 9){
            return "Your project leans towards the Agile method.";
        }
        if (methodFit > 9){
            return "Your project would be best suited with the Agile method.";
        }
        else {
            // Gets rid of an error
            return "Unable to calculate things";
        }
    }
}
