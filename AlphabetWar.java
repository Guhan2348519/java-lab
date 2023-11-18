// step 1. Start
//step 2. Initialize Constants and Variables: Initialize the left-side letters string (`left_side_letters`) containing 'w', 'p', 'b', 's'.
// Initialize the right-side letters string (`right_side_letters`) containing 'm', 'q', 'd', 'z'.
// Initialize strength values for each left-side letter (`strength_W`, `strength_P`, `strength_B`, `strength_S`).
// Initialize strength values for each right-side letter (`strength_M`, `strength_Q`, `strength_D`, `strength_Z`).
// step 3. Main Method 
//  Open a `Scanner` to read input.
//  Read the user's input as a string (`userInput`).
// step 4. Evaluate Word Method (`evaluateWord`)
//  Initialize `leftStrength` and `rightStrength` to 0.
//  For each letter in the input word:
//  If the letter is in `left_side_letters`, add its corresponding strength to `leftStrength`.
//  If the letter is in `right_side_letters`, add its corresponding strength to `rightStrength`.
//  if the letter is not in either set, return an error message using `handleInvalid`.
// step 5. Compare Strengths
// Compare `leftStrength` and `rightStrength`.
//  If `leftStrength` is greater, return "Left side wins!".
//  If `rightStrength` is greater, return "Right side wins!".
// If they are equal, return "Let's fight again!".
// step 6. Get Left Side Strength (`LeftSideStrength`)
//  Switch on the input letter:
//  Case 'w': Return `strength_W`.
// Case 'p': Return `strength_P`.
// Case 'b': Return `strength_B`.
// Case 's': Return `strength_S`.
//  Default: Return 0 (invalid letter).
// step 7. Get Right Side Strength (`RightSideStrength`)
//Switch on the input letter:
// Case 'm': Return `strength_M`.
// Case 'q': Return `strength_Q`.
// Case 'd': Return `strength_D`.
// Case 'z': Return `strength_Z`.
//  Default: Return 0 (invalid letter).
// step 8. Handle Invalid (`handleInvalid`)
// Return an error message indicating that the letter is invalid.
//step 9. End

import java.util.*;
import java.io.*;
import java.util.*;

public class AlphabetWar {
    private static String left_side_letters = "wpbs";
    private static String right_side_letters = "mqdz";
    private static int strength_W = 4;
    private static int strength_P = 3;
    private static int strength_B = 2;
    private static int strength_S = 1;
    private static int strength_M = 4;
    private static int strength_Q = 3;
    private static int strength_D = 2;
    private static int strength_Z = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String userInput = scanner.nextLine();
        System.out.println(AlphabetWar(userInput));
        scanner.close();
    }

    public static String AlphabetWar(String word) {
        int leftStrength = 0;
        int rightStrength = 0;
        for (char letter : word.toCharArray()) {
            if (left_side_letters.contains(String.valueOf(letter))) {
                leftStrength += LeftSideStrength(letter);
            } else if (right_side_letters.contains(String.valueOf(letter))) {
                rightStrength += RightSideStrength(letter);
            } else {
                return handleInvalid(letter);
            }
        }
        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    private static int LeftSideStrength(char letter) {
        switch(letter) {
            case 'w': return strength_W;
            case 'p': return strength_P;
            case 'b': return strength_B;
            case 's': return strength_S;
            default: return 0; // Invalid letter
        }
    }

    private static int RightSideStrength(char letter) {
        switch (letter) {
            case 'm': return strength_M;
            case 'q': return strength_Q;
            case 'd': return strength_D;
            case 'z': return strength_Z;
            default: return 0; // Invalid letter
        }
    }

    private static String handleInvalid(char letter) {
        return "Invalid letter: " + letter;
    }
}
