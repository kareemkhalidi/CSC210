import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PA5Main {


    public static void main(String args[]) throws FileNotFoundException {

        Scanner f = new Scanner(new File(args[0]));
        f.next();
        int rows = f.nextInt();
        f.next();
        int columns = f.nextInt();
        if (columns <= 16) {

            Plot p = new Plot(rows, columns);
            f.nextLine();
            f.nextLine();
            while (f.hasNextLine()) {

                String[] s = f.nextLine().split(" ");
                if (!s[0].equalsIgnoreCase("PLANT")) {

                    System.out.print("> " + s[0].toUpperCase());
                    if (s.length == 2) {

                        System.out.print(" " + s[1]);

                    } else if (s.length == 3) {

                        System.out.print(" " + s[1] + " " + s[2]);

                    }

                    System.out.println();

                }

                if (s[0].equalsIgnoreCase("PLANT")) {

                    if (s[2].equalsIgnoreCase("iris")
                            || s[2].equalsIgnoreCase("lily")
                            || s[2].equalsIgnoreCase("rose")
                            || s[2].equalsIgnoreCase("daisy")
                            || s[2].equalsIgnoreCase("tulip")
                            || s[2].equalsIgnoreCase("sunflower")) {

                        p.plant(new Flower(s[2]),
                                Integer.parseInt(
                                        s[1].substring(1, s[1].indexOf(','))),
                                Integer.parseInt(
                                        s[1].substring(s[1].indexOf(',') + 1,
                                                s[1].indexOf(')'))));

                    } else if (s[2].equalsIgnoreCase("oak")
                            || s[2].equalsIgnoreCase("willow")
                            || s[2].equalsIgnoreCase("banana")
                            || s[2].equalsIgnoreCase("coconut")
                            || s[2].equalsIgnoreCase("pine")) {

                        p.plant(new Tree(s[2]),
                                Integer.parseInt(
                                        s[1].substring(1, s[1].indexOf(','))),
                                Integer.parseInt(
                                        s[1].substring(s[1].indexOf(',') + 1,
                                                s[1].indexOf(')'))));

                    } else if (s[2].equalsIgnoreCase("garlic")
                            || s[2].equalsIgnoreCase("zucchini")
                            || s[2].equalsIgnoreCase("tomato")
                            || s[2].equalsIgnoreCase("yam")
                            || s[2].equalsIgnoreCase("lettuce")) {

                        p.plant(new Vegetable(s[2]),
                                Integer.parseInt(
                                        s[1].substring(1, s[1].indexOf(','))),
                                Integer.parseInt(
                                        s[1].substring(s[1].indexOf(',') + 1,
                                                s[1].indexOf(')'))));

                    }

                }
                else if (s[0].equalsIgnoreCase("PRINT")) {

                    p.print();

                } else if (s[0].equalsIgnoreCase("GROW")) {

                    if (s.length == 2) {

                        p.grow(Integer.parseInt(s[1]));

                    } else if (s[2].charAt(0) == '(') {

                        p.grow(Integer.parseInt(s[1]),
                                Integer.parseInt(
                                        s[2].substring(1, s[2].indexOf(','))),
                                Integer.parseInt(
                                        s[2].substring(s[2].indexOf(',') + 1,
                                                s[2].indexOf(')'))));

                    } else {

                        p.grow(Integer.parseInt(s[1]), s[2]);

                    }

                }
                else if (s[0].equalsIgnoreCase("HARVEST")) {

                    if (s.length == 1) {

                        p.harvest();

                    } else if (s[1].charAt(0) == '(') {

                        p.harvest(
                                Integer.parseInt(
                                        s[1].substring(1, s[1].indexOf(','))),
                                Integer.parseInt(
                                        s[1].substring(s[1].indexOf(',') + 1,
                                                s[1].indexOf(')'))));

                    } else {

                        p.harvest(s[1]);

                    }

                }

                else if (s[0].equalsIgnoreCase("PICK")) {

                    if (s.length == 1) {

                        p.pick();

                    } else if (s[1].charAt(0) == '(') {

                        p.pick(Integer
                                .parseInt(s[1].substring(1, s[1].indexOf(','))),
                                Integer.parseInt(
                                        s[1].substring(s[1].indexOf(',') + 1,
                                                s[1].indexOf(')'))));

                    } else {

                        p.pick(s[1]);

                    }

                }

                else if (s[0].equalsIgnoreCase("CUT")) {

                    if (s.length == 1) {

                        p.cut();

                    } else if (s[1].charAt(0) == '(') {

                        p.cut(Integer
                                .parseInt(s[1].substring(1, s[1].indexOf(','))),
                                Integer.parseInt(
                                        s[1].substring(3, s[1].indexOf(')'))));

                    } else {

                        p.cut(s[1]);

                    }

                }

                if (!s[0].equalsIgnoreCase("PLANT")) {

                    System.out.println();

                }

            }

        }
        else {

            System.out.println("Too many plot columns.");

        }

    }

}
