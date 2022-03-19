package homework_5;

import java.util.*;

public class Main {
    private final HashMap<String, String> hm = new HashMap<>();
    private final RandomThings[] randomThings = new RandomThings[RandomThings.values().length];
    private int max = 0;

    public static void main(String[] args) {
//        1. Написать программу по возведению числа в степень с помощью рекурсии.
//        2. Написать программу «Задача о рюкзаке» с помощью рекурсии.

        double n = 2;
        int s = -4;
        System.out.println(exponentiation(n, s));

        new Main().findAll();
    }

    private void findAll() {
        fillArray();

        find(randomThings.length);

        print();
    }

    private void fillArray() {
        int i = 0;
        for(RandomThings randomThings2 : RandomThings.values()) {
            randomThings[i] = randomThings2;
            i++;
        }
    }

    private void find(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < randomThings.length; i++) {
            find(length - 1);

            RandomThings[] rt = new RandomThings[randomThings.length];

            rotate(rt, length);

            StringBuilder s = new StringBuilder();
            int pr = 0;
            int w = 0;
            int k = 0;
            for (RandomThings things : rt) {
                if (things != null) {
                    pr += things.getPrice();
                    w += things.getWeight();
                    k++;
                    s.append(things);
                }
            }
            if (max < pr) {
                hm.clear();
                hm.put(s.toString(), "Кол-во предметов - " + k + ", общий вес - " + w + ", общая стоимость - " + pr);
                max = pr;
            }
        }
    }

    private void rotate(RandomThings[] rt, int length) {
        int first = randomThings.length - length;
        RandomThings temp = randomThings[first];
        for (int i = first + 1; i < randomThings.length; i++) {
            randomThings[first] = randomThings[i];
        }
        randomThings[randomThings.length - 1] = temp;
        int w = 0;
        for (int i = 0; i < rt.length; i++) {
            if ((w + randomThings[i].getWeight()) <= 5) {
                rt[i] = randomThings[i];
                w += rt[i].getWeight();
            }
        }
    }

    private void print() {
        for (Map.Entry<String, String> o : hm.entrySet()) {
            System.out.println("[" + o.getKey() + "\b\b] --> { " + o.getValue() + " }");
        }
    }

    private static double exponentiation(double n, int s) {
        int m = Math.abs(s);
        m--;
        if (m < 1) {
            return n;
        }
        if (s < - 1) {
            n = 1/ (n * exponentiation(n, m));
        } else {
            n = n * exponentiation(n, m);
        }
        return n;
    }
}
