package com.company;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int inputInt() {
        Scanner in = new Scanner(System.in);
        int vvod = in.nextInt();
        return vvod;
    }

    public static long inputLong() {
        Scanner in = new Scanner(System.in);
        long vvod = in.nextLong();
        return vvod;
    }

    public static double inputDouble() {
        Scanner in = new Scanner(System.in);
        double vvod = in.nextDouble();
        return vvod;
    }

    public static String inputStr() {
        Scanner in = new Scanner(System.in);
        String vvod = in.nextLine();
        return vvod;
    }

    public static char inputchar() throws IOException {
        Scanner in = new Scanner(System.in);
        char vvod = (char) System.in.read();
        return vvod;
    }

    public static String task1_coder( String str) {
        if (str.length()<1){
            return "Error";
        }
        int [] code = new int[str.length()];
        char [] chars = str.toCharArray();
        for (int i = 0; i<str.length();i++){
            if (i > 0){
                code[i]=(int)str.charAt(i)-(int)str.charAt(i-1);
            }
            else{
                code[0]=(int)str.charAt(i);
            }
        }
        return Arrays.toString(code);
        }

    public static String task1_decoder(int [] num) {
        if (num.length < 1) {
            return "Error";
        }
        int[] code = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            if (i > 0) {
                code[i] = num[i] + num[i - 1];
                num[i] = code[i];
            } else {
                code[0] = num[i];
            }
        }
        char[] chars = new char[code.length];
        for (int i = 0; i < code.length; i++) {
            chars[i] = (char) code[i];
        }
        return Arrays.toString(chars);
    }

    public static boolean task2(String name, String first, String last ){
        int xfirst = 0;
        int yfirst = 0;
        int xlast = 0;
        int ylast = 0;
        xfirst = 8-(72-first.charAt(0));
        yfirst = 8-(72-first.charAt(1));
        xlast = 8-(72-last.charAt(0));
        ylast = 8-(72-last.charAt(1));

        if (name =="rook"){
            if (xfirst == xlast || yfirst == ylast){
                return true;
            }
            else{
                return false;
            }
        }
        if (name =="knight"){
            if ((Math.abs(xfirst-xlast) == 3 && Math.abs(yfirst-ylast) == 2) || (Math.abs(xfirst-xlast) == 2 && Math.abs(yfirst-ylast) == 3)){
                return true;
            }
            else{
                return false;
            }
        }
        if (name =="bishop"){
            if (Math.abs(xfirst-xlast) == Math.abs(yfirst-ylast)){
                return true;
            }
            else {
                return false;
            }
        }
        if (name =="queen"){
            if (Math.abs(xfirst-xlast) == Math.abs(yfirst-ylast)){
                //return true;
            }
            else {
                if (xfirst == xlast || yfirst == ylast) {
                    //return true;
                } else {
                    return false;
                }
            }
        }
        if (name =="king"){
            if ((Math.abs(xfirst-xlast) == Math.abs(yfirst-ylast)) && (Math.abs(xfirst-xlast) == 1) && (Math.abs(yfirst-ylast) == 1)){
                return true;
            }
            else {
                if ((xfirst == xlast || yfirst == ylast) && (Math.abs(xfirst-xlast)==1 || Math.abs(yfirst-ylast)==1)){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        if (name =="panws"){
            if ((Math.abs(xfirst-xlast) == Math.abs(yfirst-ylast)) && (Math.abs(xfirst-xlast) == 1) && (Math.abs(yfirst-ylast) == 1)){
                return true;
            }
            else {
                if ((xfirst == xlast) && (Math.abs(xfirst-xlast)==0 || Math.abs(yfirst-ylast)==1)){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
    public static boolean task3(String arr, String word) {
        int index = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == arr.charAt(index)){
                index++;
            }
        }
        return index == arr.length();

    }
    public static String task4(int [] num) {
        int sum = 0;
        int mult = 1;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        String digit = "";
        digit += sum;
        do {
            for (int i = 0; i < digit.length(); i++) {
                mult = mult * (9 - (57 - (int) digit.charAt(i)));
            }
            digit = "";
            digit += mult;
            mult = 1;
        } while (digit.length() > 1);

        return digit;
    }

        public static String task5(String [] arr) {
            String word = arr[0];
            word = word.toLowerCase();
            String wordNew = "";
            for (int i = 0; i < word.length();i++){
                if (word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u'){
                    wordNew += (char)word.charAt(i);
                }
            }

            String out = "";
            for (int i=1;i<arr.length;i++){
                word = "";
                word += arr[i];
                word = word.toLowerCase();

                boolean check = false;
                for (int j = 0; j < word.length();j++){
                    if (word.charAt(j)=='a' || word.charAt(j)=='e' || word.charAt(j)=='i' || word.charAt(j)=='o' || word.charAt(j)=='u'){
                        check = false;
                        for (int k = 0; k < wordNew.length();k++){
                            if (word.charAt(j)==wordNew.charAt(k)){
                                check = true;
                            }
                        }
                        if (check != true){
                            break;
                        }
                    }

                }
                if (check==true) {
                    out += word + " ";
                }
            }
            return arr[0] + " " + out;
    }

    public static boolean task6(String n) {
        if (n.length()>=14 && n.length()<19){
        }
        else{
            System.out.println("Error");
            return false;
        }
        String num = "";
        num += n;
        int  check_digit = (9-(57-num.charAt(num.length()-1)));
        int [] array_digit = new int [num.length()-1];
        for (int i = 0; i<array_digit.length;i++){
            array_digit[i]=(9-(57-num.charAt(i)));
        }

        int [] array_digit_reverse = new int[array_digit.length];
        for (int i = 0;i<array_digit_reverse.length;i++){
            array_digit_reverse[i]=array_digit[array_digit.length-1 - i];
        }

        for (int i = 0; i < array_digit_reverse.length; i++){
            if (i % 2 == 0){
                array_digit_reverse[i] = array_digit_reverse[i] * 2;
            }
            if(array_digit_reverse[i]>9){
                array_digit_reverse[i] = 1 + array_digit_reverse[i] % 10;
            }
        }
        int sum = 0;
        for (int i = 0; i <array_digit_reverse.length; i++){
            sum = sum + array_digit_reverse[i];
        }
        int check_sum = 10 - sum % 10;
        return check_sum == check_digit;
    }

    public static String task7(int n) {
        String [] level1 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String [] level2 = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                "eighty", "ninety"};
        String num = "";
        String out = "";
        num += n;
        if (num.length()==1){
            out += level1[n];
        }
        if (num.length()==2){
            if (n<20){
                out += level1[n];
            }
            else{
                out += level2[n / 10] + " " + level1[n % 10];
            }
        }
        if (num.length()==3){
            out += level1[n / 100] + " hundred ";
            if (n % 100 < 20){
                out += level1[n];
            }
            else{
                out += level2[n % 100 / 10] + " " + level1[n % 10];
            }
        }
        return out;
    }
    public static byte[] task8_fc(String in) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(in.getBytes(StandardCharsets.UTF_8));
    }

    public static String task8_sc(byte[] a) {
        BigInteger number = new BigInteger(1, a);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    public static String task9 ( String arr)    {
        String [] arrays = arr.split(" ");
        String out = "";

        for(int  i = 0; i < arrays.length; i++){
            String word = "";
            word += arrays[i];
            word = word.toLowerCase();

            boolean check = false;

            if (word.charAt(0) == 'a' && word.charAt(1) == 'n' && word.charAt(2) == 'd' && word.length() < 5) {
                out += word + " ";
                check =true;
            }
            if (word.charAt(0) == 't' && word.charAt(1) == 'h' && word.charAt(2) == 'e' && word.length() < 5) {
                out += word + " ";
                check =true;
            }
            if (word.charAt(0) == 'o' && word.charAt(1) == 'f' && word.length() < 4) {
                out += word + " ";
                check =true;
            }
            if (word.charAt(0) == 'i' && word.charAt(1) == 'n' && word.length() < 4) {
                out += word + " ";
                check =true;
            }
            if (check == false){
                word = word.substring(0,1).toUpperCase() + word.substring(1);
                out += word + " ";
            }
        }
        return out;
    }

    public static String task10(int n){
        int sum = 1;
        int c = 1;
        while (sum < n)
        {
            sum = sum + (6 * c);
            c++;
        }
        if (sum != n){
            return "Error";
        }
        else{
            int size = c * 2 - 1;

            int str = (size - 1) / 2;

            int point = size - c + 1;

            for (int i = 0; i<size; i++){
                for (int j = 0; j<str; j++){
                    System.out.print(" ");
                }
                for (int j = 0; j<point; j++){
                    System.out.print("о ");
                }

                System.out.println("");
                if (i < (size - 1) / 2){
                    point++;
                    str--;
                }
                else{
                    point--;
                    str++;
                }
            }
            return "";
        }
    }
    public static void main(String[] args) {
        int key=0;
        int key1=0;
        do{
            System.out.println("Введите номер задания или 11 для выхода:");
            key=inputInt();
            switch (key){
                case (1):
                    do{
                        System.out.println("Введите номер подзадания или 3 для выбора основного задания:");
                        key1=inputInt();
                        switch (key1) {
                            case (1):
                                System.out.println("Введите слово: ");
                                String str = inputStr();
                                System.out.println("Закодированное слово:" + task1_coder(str));
                                break;
                            case (2):
                                System.out.println("Введите длину слова: ");
                                int [] str2= new int[inputInt()];
                                System.out.println("Введите посимвольно закодированное слово: ");
                                for (int i=0;i<str2.length;i++){
                                    str2[i]=inputInt();
                                }
                                System.out.println("Раскодированное слово: " + task1_decoder(str2));
                            case(3):
                                break;
                        }
                    }while(key1!=3);
                    break;
                case(2):
                    System.out.println("Введите название фигуры и координаты доски: ");
                    String name=inputStr(), fc=inputStr(), lc=inputStr();
                    System.out.println(task2(name,fc,lc));
                    break;
                case(3):
                    System.out.println("Введите часть слова и слово: ");
                    String arr=inputStr(), word=inputStr();
                    System.out.println("Результат: " + task3(arr,word));
                    break;
                case(4):
                    System.out.println("Введите количество чисел: ");
                    int [] num= new int[inputInt()];
                    System.out.println("Введите числа: ");
                    for (int i=0;i<num.length;i++){
                        num[i]=inputInt();
                    }
                    System.out.println("Результат: "+ task4(num));
                    break;
                case (5):
                    System.out.println("Введите количество слов: ");
                    String [] str= new String[inputInt()];
                    System.out.println("Введите слова: ");
                    for (int i=0;i<str.length;i++){
                        str[i]=inputStr();
                    }
                    System.out.println("Результат: "+ task5(str));
                    break;
                case(6):
                    System.out.println("Введите номер карты: ");
                    String numcard=inputStr();
                    System.out.println(task6(numcard));
                    break;
                case(7):
                    System.out.println("Введите число: ");
                    int n=inputInt();
                    System.out.println(task7(n));
                    break;
                case(8):
                    try {
                        System.out.println("Введите строку:");
                        String s1 = inputStr();
                        System.out.println("\n" + s1 + " : " +task8_sc(task8_fc(s1)));
                    }
                    catch (NoSuchAlgorithmException e) {
                        System.out.println("Exception thrown for an incorrect algorithm: " + e);
                    }
                    break;
                case(9):
                    System.out.println("Введите название серии: ");
                    String str1=inputStr();
                    System.out.println("Результат: "+ task9(str1));
                    break;
                case(10):
                    System.out.println("Введите число: ");
                    int a=inputInt();
                    System.out.println("Результат: "+ task10(a));
                    break;
                case(11):
                    System.out.println("До свидания!");
                    break;
            }
        } while (key!=11);
    }
}