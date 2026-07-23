package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] scores = {78, 96, 88, 82, 91};
        QualityScan scan = new QualityScan(scores);

        System.out.println("Average score: " + scan.average());
        System.out.println("Scores above 85: " + scan.countAbove(85));
    }

    static final class QualityScan {
        private final int[] scores;

        QualityScan(int[] scores) {
            this.scores = Arrays.copyOf(scores, scores.length);
        }

        double average() {
            int total = 0;
            for (int score : scores) {
                total += score;
            }
            return (double) total / scores.length;
        }

        int countAbove(int threshold) {
            int result = 0;
            for (int score : scores) {
                if (score > threshold) {
                    result++;
                }
            }
            return result;
        }
    }
}
