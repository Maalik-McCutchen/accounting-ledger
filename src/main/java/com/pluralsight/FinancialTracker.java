package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Capstone skeleton – personal finance tracker.
 * ------------------------------------------------
 * File format  (pipe-delimited)
 *     yyyy-MM-dd|HH:mm:ss|description|vendor|amount
 * A deposit has a positive amount; a payment is stored
 * as a negative amount.
 *
 * TODO: create the Transaction class in this package first.
 *       One object = one line of the file. Decide its fields from
 *       the file format above, add a constructor and getters.
 *       This class does not compile until Transaction exists.
 */
public class FinancialTracker {

    /* ------------------------------------------------------------------
       Shared data and formatters
       ------------------------------------------------------------------ */
    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transactions.csv";

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    /* ------------------------------------------------------------------
       Main menu
       ------------------------------------------------------------------ */
    public static void main(String[] args) {
        loadTransactions(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to TransactionApp");
            System.out.println("Choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D" -> addDeposit(scanner);
                case "P" -> addPayment(scanner);
                case "L" -> ledgerMenu(scanner);
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    /* ------------------------------------------------------------------
       File I/O
       ------------------------------------------------------------------ */

    /**
     * Load transactions from FILE_NAME.
     * • If the file doesn’t exist, create an empty one so that future writes succeed.
     * • Each line looks like: date|time|description|vendor|amount
     */
    public static void loadTransactions(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split("\\|");
                if (tokens.length != 5) {
                    continue;
                }
                LocalDate date = LocalDate.parse(tokens[0]);
                LocalTime time = LocalTime.parse(tokens[1]);
                String description = tokens[2];
                String vendor = tokens[3];
                double amount = Double.parseDouble(tokens[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);

            }
            reader.close();

        } catch (Exception e) {
            System.err.println("Something went wrong.");
        }
    }

    /* ------------------------------------------------------------------
       Add new transactions
       ------------------------------------------------------------------ */

    /**
     * Prompt for ONE date+time string in the format
     * "yyyy-MM-dd HH:mm:ss", plus description, vendor, amount.
     * Validate that the amount entered is positive.
     * Store the amount as-is (positive) and append to the file.
     */
    private static void addDeposit(Scanner scanner) {
        try {
            System.out.println("Enter date and time: " + DATE_PATTERN + " " + TIME_PATTERN);
            String userDateTime = scanner.nextLine().trim();
            LocalDateTime dateTime = LocalDateTime.parse(userDateTime, DATETIME_FMT);
            LocalDate date = dateTime.toLocalDate();
            LocalTime time = dateTime.toLocalTime();

            System.out.println("Enter a description: ");
            String description = scanner.nextLine().trim();

            System.out.println("Enter a vendor: ");
            String vendor = scanner.nextLine().trim();

            System.out.println("Enter the amount: ");
            double amount = scanner.nextDouble();

            while (amount <= 0) {
                System.out.println("Please enter a positive amount: ");
                amount = scanner.nextDouble();
            }
            scanner.nextLine();

            Transaction deposit = new Transaction(date, time, description, vendor, amount);
            transactions.add(deposit);

            FileWriter writer = new FileWriter(FILE_NAME, true);
            String userFormattedDate = deposit.getDate().format(DATE_FMT);
            String userFormattedTime = deposit.getTime().format(TIME_FMT);
            String userDescription = deposit.getDescription();
            String userVendor = deposit.getVendor();
            double userAmount = deposit.getAmount();

            writer.write(userFormattedDate + "|" + userFormattedTime + "|" + userDescription + "|" + userVendor + "|" + userAmount);
            writer.write("\n");

            writer.close();

        } catch (Exception e) {
            System.err.println("Unable to save transaction to file.");
        }


    }

    /**
     * Same prompts as addDeposit.
     * Amount must be entered as a positive number,
     * then converted to a negative amount before storing.
     */
    private static void addPayment(Scanner scanner) {
        try {
            System.out.println("Enter date and time: " + DATE_PATTERN + " " + TIME_PATTERN);
            String userDateTime = scanner.nextLine().trim();
            LocalDateTime dateTime = LocalDateTime.parse(userDateTime, DATETIME_FMT);
            LocalDate date = dateTime.toLocalDate();
            LocalTime time = dateTime.toLocalTime();

            System.out.println("Enter a description: ");
            String description = scanner.nextLine().trim();

            System.out.println("Enter a vendor: ");
            String vendor = scanner.nextLine().trim();

            System.out.println("Enter the amount: ");
            double amount = scanner.nextDouble();


            while (amount <= 0) {
                System.out.println("Please enter a positive amount: ");
                amount = scanner.nextDouble();
            }
            double userPayment = amount * -1;
            scanner.nextLine();

            Transaction payment = new Transaction(date, time, description, vendor, userPayment);
            transactions.add(payment);

            FileWriter writer = new FileWriter(FILE_NAME, true);
            String userFormattedDate = payment.getDate().format(DATE_FMT);
            String userFormattedTime = payment.getTime().format(TIME_FMT);
            String userDescription = payment.getDescription();
            String userVendor = payment.getVendor();
            double userAmount = payment.getAmount();

            writer.write(userFormattedDate + "|" + userFormattedTime + "|" + userDescription + "|" + userVendor + "|" + userAmount);
            writer.write("\n");


            writer.close();

        } catch (Exception e) {
            System.err.println("Unable to save transaction to file.");
        }
    }

    /* ------------------------------------------------------------------
       Ledger menu
       ------------------------------------------------------------------ */
    private static void ledgerMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Ledger");
            System.out.println("Choose an option:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> reportsMenu(scanner);
                case "H" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Display helpers: show data in neat columns
       ------------------------------------------------------------------ */
    private static void displayLedger() {
        ArrayList<Transaction> sortedTransactions = new ArrayList<>(transactions);
        Collections.reverse(sortedTransactions);
        for (Transaction sortedTransaction : sortedTransactions) {
            printTransaction(sortedTransaction);
        }
    }

    private static void printTransaction(Transaction transaction) {
        System.out.printf("%s | %s | %s | %s | %.2f%n",
                transaction.getDate(),
                transaction.getTime(),
                transaction.getDescription(),
                transaction.getVendor(),
                transaction.getAmount());

    }

    private static void displayDeposits() {
        ArrayList<Transaction> sortedTransactions = new ArrayList<>(transactions);
        Collections.reverse(sortedTransactions);
        for (Transaction transaction : sortedTransactions) {
            if (transaction.getAmount() > 0)
                printTransaction(transaction);

        }
    }

    private static void displayPayments() {
        ArrayList<Transaction> sortedTransactions = new ArrayList<>(transactions);
        Collections.reverse(sortedTransactions);
        for (Transaction transaction : sortedTransactions) {
            if (transaction.getAmount() < 0)
                printTransaction(transaction);

        }

    }

    /* ------------------------------------------------------------------
       Reports menu
       ------------------------------------------------------------------ */
    private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {
                    LocalDate today = LocalDate.now();
                    LocalDate start = today.withDayOfMonth(1);
                    filterTransactionsByDate(start, today);
                }
                case "2" -> {
                    LocalDate previousMonth = LocalDate.now().minusMonths(1);

                    LocalDate start = previousMonth.withDayOfMonth(1);
                    LocalDate end = previousMonth.withDayOfMonth(previousMonth.lengthOfMonth());
                    filterTransactionsByDate(start, end);
                }
                case "3" -> {
                    LocalDate today = LocalDate.now();
                    LocalDate start = today.withDayOfYear(1);
                    filterTransactionsByDate(start, today);

                }
                case "4" -> {
                    LocalDate previousYear = LocalDate.now().minusYears(1);

                    LocalDate start = previousYear.withDayOfYear(1);
                    LocalDate end = previousYear.withDayOfYear(previousYear.lengthOfYear());
                    filterTransactionsByDate(start, end);
                }
                case "5" -> {
                    System.out.println("Enter a vendor: ");
                    String vendor = scanner.nextLine().trim();

                    filterTransactionsByVendor(vendor);

                }
                case "6" -> customSearch(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Reporting helpers
       ------------------------------------------------------------------ */
    private static void filterTransactionsByDate(LocalDate start, LocalDate end) {
        ArrayList<Transaction> sortedTransactions = new ArrayList<>(transactions);
        Collections.reverse(sortedTransactions);

        int filter = 0;
        for (Transaction sortedTransaction : sortedTransactions) {

            LocalDate transactionDate = sortedTransaction.getDate();

            if (!transactionDate.isBefore(start) && !transactionDate.isAfter(end)) {
                filter++;

                printTransaction(sortedTransaction);
            }
        }

        if (filter == 0) {
            System.out.println("No transactions found for this date range.");
        }

    }

    private static void filterTransactionsByVendor(String vendor) {

        ArrayList<Transaction> sortedTransactions = new ArrayList<>(transactions);
        Collections.reverse(sortedTransactions);

        int filter = 0;

        for (Transaction sortedTransaction : sortedTransactions) {

            String transactionVendor = sortedTransaction.getVendor();

            if (transactionVendor.equals(vendor)) {
                filter++;

                printTransaction(sortedTransaction);
            }

        }

        if (filter == 0) {
            System.out.println("Vendor not found.");
        }
    }

    private static void customSearch(Scanner scanner) {

        ArrayList<Transaction> customSearchTransactions = new ArrayList<>(transactions);
        Collections.reverse(customSearchTransactions);

        int count = 0;

        System.out.println("Start Date: ");
        String startDate = scanner.nextLine().trim();

        LocalDate userStartDate = parseDate(startDate);

        System.out.println("End Date: ");
        String endDate = scanner.nextLine().trim();

        LocalDate userEndDate = parseDate(endDate);

        System.out.println("Description: ");
        String userDescription = scanner.nextLine().trim();

        System.out.println("Vendor: ");
        String userVendor = scanner.nextLine().trim();

        System.out.println("Amount: ");
        String numberAmount = scanner.nextLine().trim();

        Double userAmount = parseDouble(numberAmount);

        for (Transaction sortedTransaction : customSearchTransactions) {
            LocalDate transactionDate = sortedTransaction.getDate();


            if (userStartDate != null && transactionDate.isBefore(userStartDate)) {
                continue;
            }
            if (userEndDate != null && transactionDate.isAfter(userEndDate)) {

                continue;
            }

            String description = sortedTransaction.getDescription();

            if (!userDescription.isBlank() && !userDescription.equals(description)) {
                continue;
            }

            String vendor = sortedTransaction.getVendor();

            if (!userVendor.isBlank() && !userVendor.equals(vendor)) {
                continue;
            }

            double amount = sortedTransaction.getAmount();

            if (userAmount != null && !userAmount.equals(amount)) {
                continue;
            }

            count++;
            printTransaction(sortedTransaction);

        }

        if (count == 0) {
            System.out.println("No transactions found.");

        }

    }

    /* ------------------------------------------------------------------
       Utility parsers (you can reuse in many places)
       ------------------------------------------------------------------ */
    private static LocalDate parseDate(String s) {

        if (s.isBlank())
            return null;

        try {
            LocalDate date = LocalDate.parse(s);

                return date;

        } catch (Exception e) {

            System.out.println("Invalid date format.");
        }
        return null;
    }

    private static Double parseDouble(String s) {

        if (s.isBlank())
            return null;

        try {

            double amount = Double.parseDouble(s);
            return amount;

        } catch (Exception e) {

            System.out.println("Invalid amount format.");
        }
        return null;
    }
}
