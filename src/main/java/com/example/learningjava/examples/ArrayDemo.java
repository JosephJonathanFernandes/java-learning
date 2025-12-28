package com.example.learningjava.examples;

class ArrayDemo {
    public static void main(String[] args) {
        int[] marks = {90, 85, 88, 92, 95};

        System.out.println("Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }

        // Calculate average
        int sum = 0;
        for (int mark : marks) sum += mark;

        double avg = sum / (double) marks.length;
        System.out.println("Average: " + avg);
    }
}
