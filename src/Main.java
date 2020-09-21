import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int chips = 100;
        int commitment;

        do {

            System.out.printf("Choose your bet: (you have %d Chips) | Quit with -1", chips);
            commitment = sc.nextInt();
            if (commitment == -1){
                break;
            }
            chips = chips - commitment;
            System.out.println("Colour, Number or Third");
            String choose = sc.next().toLowerCase();

            int randomNum = ThreadLocalRandom.current().nextInt(0, 36);

            boolean red = false, black = false, green = false;

            if (randomNum == 0) {
                green = true;
            } else if (randomNum % 2 == 0) {
                black = true;
            } else {
                red = true;
            }
            switch (choose) {
                case "colour" -> {
                    System.out.println("Black, red or green ?");
                    String chooseColour = sc.next().toLowerCase();
                    switch (chooseColour) {
                        case "black" -> {
                            if (black) {
                                System.out.println("Congrats, Chips won: " + commitment * 2);
                                chips = chips + commitment * 2;
                            } else {
                                System.out.println("LOST: " + commitment);
                            }
                        }
                        case "red" -> {
                            if (red) {
                                System.out.println("Congrats, Chips won: " + commitment * 2);
                                chips = chips + commitment * 2;
                            } else {
                                System.out.println("LOST: " + commitment);
                            }
                        }
                        case "green" -> {
                            if (green) {
                                System.out.println("Congrats, Chips won: " + commitment * 14);
                                chips = chips + commitment * 14;
                            } else {
                                System.out.println("LOST: " + commitment);
                            }
                        }
                        default -> System.out.println("ERROR");
                    }
                }
                case "number" -> {
                    System.out.println("Enter the number:");
                    int chooseNum = sc.nextInt();
                    if (chooseNum == randomNum) {
                        chips = chips + commitment * 36;
                        System.out.println("Congrats, you won " + commitment * 36);
                    } else {
                        System.out.println("LOST");
                    }
                }
                case "third" -> {
                    System.out.println("Which third ? 1,2 or 3");
                    int chooseThird = sc.nextInt();
                    if (chooseThird == 1 && randomNum >= 1 && randomNum <= 12) {
                        System.out.println("Congrats, you won: " + commitment * 3);
                        chips = chips + commitment * 3;
                    } else if (chooseThird == 2 && randomNum >= 13 && randomNum <= 24) {
                        System.out.println("Congrats, you won: " + commitment * 3);
                        chips = chips + commitment * 3;
                    } else if (chooseThird == 3 && randomNum >= 25 && randomNum <= 36) {
                        System.out.println("Congrats, you won: " + commitment * 3);
                        chips = chips + commitment * 3;
                    } else {
                        System.out.println("LOST");
                    }
                }
                default -> System.out.println("ERROR");
            }
            System.out.printf("Number was %d", randomNum);
            System.out.println();
        } while (chips > 0);

    }

}
