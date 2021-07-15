import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Aplication {

    public enum Seasons {
        WINTER, SUMMER, SPRING, AUTUMN
    }

    enum Months {
        JANUARY(31, Seasons.WINTER),
        FEBRUARY(29, Seasons.WINTER),
        MARCH(31, Seasons.SPRING),
        APRIL(30, Seasons.SPRING),
        MAY(31, Seasons.SPRING),
        JUNE(30, Seasons.SUMMER),
        JULY(31, Seasons.SUMMER),
        AUGUST(31, Seasons.SUMMER),
        SEPTEMBER(30, Seasons.AUTUMN),
        OCTOBER(31, Seasons.AUTUMN),
        NOVEMBER(30, Seasons.AUTUMN),
        DECEMBER(31, Seasons.WINTER);

        public Integer getDays() {
            return days;
        }

        public Seasons getSeasons() {
            return seasons;
        }

        Integer days;
        Seasons seasons;

        Months(Integer days, Seasons seasons) {
            this.days = days;
            this.seasons = seasons;
        }
    }

    static void menu() {
        System.out.println("1 щоб перевірити чи існує такий місяць");
        System.out.println("2 щоб вивести всі місяці з такою ж порою року");
        System.out.println("3 всі місяці які мають таку ж кількість днів");
        System.out.println("4 всі місяці які мають меншу кількість днів");
        System.out.println("5 наступна пора року");
        System.out.println("6 всі місяці які мають парну кількість днів");
        System.out.println("7 всі місяці які мають не парну кількість днів");
        System.out.println("8 чи місяць має парну кількість днів");
    }

    public static void main(String[] args) {



        List<Months> amountMonths = Arrays.asList(Months.values());
        List<Seasons> amountSeasons = Arrays.asList(Seasons.values());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            switch (scanner.next()) {
                case "1": {

                    System.out.println("ВВедіть місяць");
                    String months = scanner.next().toUpperCase();

                    boolean flag = false;

                    for (Months m : amountMonths) {
                        if (m.name().equals(months)) {
                            System.out.println("Такий місяць існує");
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("Такого місяця не існує");
                    }
                    break;
                }
                case "2": {
                    System.out.println("ВВедіть пору року");
                    String Season = scanner.next().toUpperCase();

                    boolean flag = false;

                    for (Months m : amountMonths) {
                        if (m.getSeasons().name().equals(Season)) {
                            System.out.println(m);
                            flag = true;
                        }
                    }

                    if (!flag) {
                        System.out.println("Season doesnt exist");
                    }
                    break;


                }
                case "3": {
                    System.out.println("Введіть кількість днів");
                    int count = scanner.nextInt();

                    boolean flag = false;

                    for (Months m : amountMonths) {
                        if (m.getDays() == count) {
                            System.out.println(m);
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("Інформація введена не коректно");
                    }
                    break;
                }
                case "4": {
                    System.out.println("ВВедіть кількість днів");
                    int count = scanner.nextInt();

                    boolean flag = false;

                    for (Months m : amountMonths) {
                        if (m.getDays() < count) {
                            System.out.println(m);
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("Інформація введена не коректно");
                    }
                    break;
                }
                case "5": {
                    System.out.println("Введіть пору року");
                    String enteredWord = scanner.next().toUpperCase();

                    boolean flag = false;

                    for (Seasons s : amountSeasons) {
                        if (s.name().equals(enteredWord)) {
                            System.out.println("Сезон існує");
                            flag = true;
                        }
                    }

                    if (flag) {
                        Seasons seasonObject = Seasons.valueOf(enteredWord);
                        int ordinal = seasonObject.ordinal();
                        Object[] asa = amountSeasons.toArray();
                        System.out.println();
                        if (ordinal == asa.length - 1) {
                            Object xn = amountSeasons.get(0);
                            System.out.println(xn);
                        } else {
                            System.out.println(asa[ordinal + 1]);
                        }
                    }
                    if (!flag) {
                        System.out.println("Такої пори року не існує");
                    }
                    break;
                }
                case "6": {
                    for (Months m : amountMonths) {
                        if (m.getDays() % 2 == 0) {
                            System.out.println(m);
                        }

                    }
                    break;
                }
                case "7": {
                    for (Months m : amountMonths) {
                        if (m.getDays() % 2 == 1) {
                            System.out.println(m);
                        }

                    }
                    break;
                }
                case "8":{
                    System.out.println("Введіть місяць");
                    String word = scanner.next().toUpperCase();

                    boolean flag = false;

                    for (Months m : amountMonths) {
                        if (m.name().equals(word)) {
                            System.out.println("Такий місяць існує");
                            flag = true;
                        }
                    }
                    if (flag) {

                        Months mo = Months.valueOf(word);

                        if (mo.getDays() % 2 == 0) {
                            System.out.println("Кількість днів парна");
                        } else {
                            System.out.println("Кількість днів не парна");
                        }
                    }
                    if (!flag) {
                        System.out.println("Місяць не знайдено");
                    }
                }
            }
        }
    }
}