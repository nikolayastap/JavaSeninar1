//Задание №1
//Написать программу, которая запросит пользователя ввести
//<Имя> в консоли. Получит введенную строку и выведет в консоль сообщение
//“Привет, <Имя>!”

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // .in-входящий паток
        String s = scanner.next();
        String out = new String("Привет, %s!");
        System.out.printf(out, s);
    }
}

//Задание №2
//В консоли запросить имя пользователя. В зависимости от текущего времени, вывести
//приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

//        1 вариант
        LocalDateTime dateTime = LocalDateTime.now();
        int i = dateTime.getHour();

        String temp = "";
        if(i >= 5 && i < 12){
            temp = "Доброе утро";
        }
        if(i >= 12 && i < 18){
            temp = "Добрый день";
        }
        if(i >= 18 && i < 23){
            temp = "Добрый вечер";
        }
        if(i <= 5 || i == 23){
            temp = "Доброй ночи";
        }

        System.out.println(temp + "," + s);
//

//        2 Вариант
        LocalDateTime now = LocalDateTime.now();
        if(now.isAfter(ChronoLocalDateTime.from(LocalTime.of(5,0))) &&
                now.isBefore(ChronoLocalDateTime.from(LocalTime.of(11, 59)))) {
            System.out.println("Доброе утро" + s + "!");
        } else if (now.isAfter(ChronoLocalDateTime.from(LocalTime.of(11,0))) &&
                now.isBefore(ChronoLocalDateTime.from(LocalTime.of(17, 59)))) {
            System.out.println("Добрый день" + s + "!");
        } else if (now.isAfter(ChronoLocalDateTime.from(LocalTime.of(18,0))) &&
                now.isBefore(ChronoLocalDateTime.from(LocalTime.of(22, 59)))) {
            System.out.println("Добрый вечер" + s + "!");

        } else {
            System.out.println("Доброй ночи" + s + "!");
//
    }
}


//Задание №3
//Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное кол-во
// подряд идущих 1.
public class Main {
    public static void main(String[] args) {
        int[] array = {1,1,0,1,1,1}; //Задаем массив

        int counter = 0; // Счетчик для подсчета подряд идущих единиц
        int max = 0; // Макс последовательность единиц
        for (int i: array) {
            if(i == 1) {
                counter ++;
            }
            if(i == 0){
                if(counter != 0){
                    if(max < counter){
                        max = counter;
                    }
                    counter = 0;
                }
            }
        }
        if(counter != 0){ // Делаем повторную проверку т.к. пр 0,1,1,1 показывает не верное значение
            if(max < counter){
                max = counter;
            }
        }
        System.out.println(max);
    }
}

//Задание №4
//Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке
public class Main {
    public static void main(String[] args) {
        String s = "Добро пожаловать на курс по Java";
        String[] array = s.split(" "); // Разбиваем на массив слов разбитых символом пробела
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}



//Задание №5
//Реализовать функцию возведения числа а в степень b. a, b из Z.
//Пример 1: а = 3, b = 2, ответ: 9
//Пример 2: а = 2, b = -2, ответ: 0.25
//Пример 3: а = 3, b = 0, ответ: 1
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Считываем числа A и B из консоли
        int a = scanner.nextInt();
        int b = scanner.nextInt();

//        1 вариант решения (через вызов в циклах)
        int result = 1;
        for (int i = 1; i <= b; i++){ // При b<0 дает не верный результат!!!
            result = result * a;
        }
        System.out.print(result);

//        2 вариант решения (через рекурсию (множественный цикл одной и той-же функции которая останавливается при выполнении некоторых условий))
        int c = pow(a, b); // Вызов метода
        System.out.print(c);
    }
        public static int pow(int a, int b){
            if (b == 1){ // Точка выхода из рекурсии
                return a;
            } else {
                return a * pow(a,b - 1);
            }
        }

//        3 вариант решения (с помощью системных java утилит)
    double c = Math.pow(a, b);
    System.out.print(c);
    }
}