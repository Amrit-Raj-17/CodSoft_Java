import java.util.*;
class GuessGame {
    public static final Scanner sc = new Scanner(System.in);
    static void description() {
        System.out.println("Description");
        System.out.println("Guess the number from 1 to 100 to win");
        System.out.println("Each round consists of 5 chances");
        System.out.println("As early you guess, more points you get");
        System.out.println("100 points for Guess 1");
        System.out.println(" 80 points for Guess 2");
        System.out.println(" 60 points for Guess 3");
        System.out.println(" 40 points for Guess 4");
        System.out.println(" 20 points for Guess 5");
        System.out.println("_______ All the best!!! _______");
    }
    static int guessingGame(int round) {
        System.out.println("\nROUND NUMBER " + round);
        int score = 0;
        int guess;
        int target = (int)(Math.random() * 100 + 1);
        // System.out.println(target);
        int chances = 5;
        while(chances > 0) {
            System.out.print("Enter your guess : ");
            guess = sc.nextInt();
            if(guess == target) {
                System.out.println("Congratulations!! You guessed it correctly!!");
                score += chances * 20;
                break;
            }
            else if(guess > target) {
                System.out.print("Your guess is larger than target ");
                if(guess - target <= 5)
                    System.out.print("but you are close...");
                System.out.println("\nPlease try again...");
                System.out.println("Chances left : " + (chances - 1));
            }
            else {
                System.out.print("Your guess is smaller than target ");
                if(target - guess <= 5)
                    System.out.print("but you are close...");
                System.out.println("\nPlease try again...");
                System.out.println("Chances left : " + (chances - 1));
            }
            chances--;
        }
        if(chances == 0) {
            System.out.println("Guess Number : " + target);
            System.out.println("You didn't guessed it!!");
            System.out.println("Try next time...");
        }
        System.out.println("Score of this round : " + score);
        System.out.print("Would you like to play more? ( Y / N ) ");
        char ques = sc.next().charAt(0);
        if(ques == 'Y' || ques == 'y')
            score += guessingGame(++round);
        return score;
    }
    public static void main(String args[]) {
        description();
        int round = 1;
        int score = 0;
        score += guessingGame(round);
        System.out.println("Final Score : " + score + " after " + round + " round(s).");
        System.out.println("_____ Thank You for playing _____");
    }
}