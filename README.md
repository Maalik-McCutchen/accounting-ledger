# Financial Tracker

- A console based financial tracker that records deposits and payments in a CSV file and allows users to review their transaction history.

## Description of the Project

- This application allows users to add deposits, make payments, and view their transaction history through a console-based menu.
- All transactions are saved in a CSV file so users can keep track of their financial history.
- Users can also access the reports menu to filter transactions by date, search by vendor, or use custom search options to find specific transactions.
- The goal of this application is to help users organize and review their financial transactions in one place.

## Features

- Displays the home screen with options to add a deposit, make a payment, view the ledger, or exit the application.   
- The ledger menu allows users to view all transactions, view deposits, view payments, access reports, or return to the home screen from the ledger menu. 
- The reports menu allows users to filter transactions by month to date, previous month, year to date, previous year, search by vendor,
  or (bonus)custom search criteria through the reports menu.

## User Stories

## 1. Add Deposit

**User Story**

- As a user, I want to add a deposit with its date, description, vendor and amount,
  so that the money I received is saved in my ledger. 

**Acceptance criteria**

- I am asked for the date and time, the description, the vendor and the amount
- the amount must be positive
- after saving, the deposit is a new line at the end of transactions.csv

## 2. Make Payment

**User Story**

- As a user, I want to make a payment with its date, time, description, vendor, and amount, 
  so that I can track money going out of my account.

**Acceptance criteria**

- I am asked for the date and time, the description, the vendor and the amount
- The payment is stored as a negative amount.
- After saving, the payment is added to transactions.csv.

## 3. Ledger - All

**User Story**

- As a user, I want to view all transactions with the newest entries first, 
  so that I can review my financial history.

**Acceptance criteria**

- All transactions are displayed
- Transactions are sorted from newest to oldest.

## 4. Ledger - Deposits

**User Story**

- As a user, I want to view only deposits, 
  so that I can review money coming into my account.

**Acceptance criteria**

- Only transactions with positive amounts are displayed.
- Deposits are displayed with the newest entries first.

## 5. Ledger - Payments

**User Story**

- As a user, I want to view only payments, 
  so that I can keep track of money going out of my account.

**Acceptance criteria**

- Only transactions with negative amounts are displayed.
- Payments are displayed with the newest entries first.

## 6. Reports - Month To Date

**User Story**

- As a user, I want to view transactions from the beginning of the month through today, 
  so that I can review my monthly financial history.

**Acceptance criteria**

- Only transactions from the current month are displayed.
- Transactions are displayed with the newest entries first.

## 7. Reports - Previous Month

**User Story**

- As a user, I want to view transactions from the previous month, 
  so that I can view my financial history from last month.

**Acceptance criteria**

- Only transactions from the previous month are displayed.
- Transactions are displayed with the newest entries first.

## 8. Reports - Year To Date

**User Story**

- As a user, I want to view transactions from the beginning of the year through today,
  so that I can review my yearly financial history.

**Acceptance criteria**

- Only transactions from the current year are displayed.
- Transactions are displayed with the newest entries first.

## 9. Reports - Previous Year

**User Story**

- As a user, I want to view transactions from the previous year,
  so that I can view my financial history from last year.

**Acceptance criteria**

- Only transactions from the previous year are displayed.
- Transactions are displayed with the newest entries first.

## 10. Reports - Search by Vendor

**User Story**

- As a user, I want to search transactions by vendor name, 
  so that I can find the vendor name I'm searching for.

**Acceptance criteria**

- I am asked to enter a vendor name.
- Transactions matching the vendor name are displayed.

## 11. Reports - Custom Search

**User Story**

- As a user, I want to search transactions using multiple search values, 
  so that I can find transactions based on their details.

**Acceptance criteria**

- I am asked to enter a start date, end date, description, vendor, and amount.
- Transactions are filtered using the search values I provide.
- Values I did not provide for fields are not filtered during search.

## 12. README

- As a user, I want an Informational README, 
  so that I can understand the application's purpose, features, and how to run it.

**Acceptance criteria**

- The README describes the project and its features.
- The README explains the setup and how to run the application.
- The README information from the project and screenshots.

## Setup

### Prerequisites

- Java 17 (Amazon Corretto), the version used in class.
- IntelliJ IDEA Community Edition: <https://www.jetbrains.com/idea/download/>

### Running the application

1. Clone this repository, or download it as a zip and unzip it.
2. In IntelliJ: File > Open, pick the project folder (the one that holds `pom.xml`), press Open.
3. Wait for IntelliJ to finish indexing (progress bar at the bottom).
4. Open `src/main/java/com/pluralsight/YourMainClassName.java`. <!-- replace YourMainClassName with the class that has main -->
5. Right-click inside the file and choose Run 'YourMainClassName.main()'.

### Data and configuration

- `transactions.csv` is stored in the project root directory and contains the application's transaction history.
- If `transactions.csv` does not exist, the application creates it automatically when it runs.

## Technologies Used

- Java 17
- IntelliJ IDEA

## Demo

**Home Screen**
![Main menu](![financial-tracker-back-to-home-screen-demo.gif](financial-tracker-back-to-home-screen-demo.gif))

**Deposit**
![Add Deposit](![financial-tracker-deposit-demo.gif](images/financial-tracker-deposit-demo.gif))

**Payments**
![Add Payment](![financial-tracker-payment-demo.gif](images/financial-tracker-payment-demo.gif))

**Ledger**
![View All Transactions](![financial-tracker-ledger-all-demo.gif](images/financial-tracker-ledger-all-demo.gif))
![View Deposits](![financial-tracker-ledger-deposit-demo.gif](images/financial-tracker-ledger-deposit-demo.gif))
![View Payments](![financial-tracker-ledger-payments-demo.gif](images/financial-tracker-ledger-payments-demo.gif))

**Reports**
![Month To Date](![financial-tracker-reports-month-demo.gif](images/financial-tracker-reports-month-demo.gif))
![Previous Month](![financial-tracker-reports-previous-month-demo.gif](images/financial-tracker-reports-previous-month-demo.gif))
![Year To Date](![financial-tracker-reports-year-demo.gif](images/financial-tracker-reports-year-demo.gif))
![Previous Year](![financial-tracker-reports-previous-year-demo.gif](images/financial-tracker-reports-previous-year-demo.gif))
![Search By Vendor](![financial-tracker-reports-vendor-demo.gif](images/financial-tracker-reports-vendor-demo.gif))

**Bonus**
![Custom Search](![financial-tracker-reports-custom-search-demo.gif](images/financial-tracker-reports-custom-search-demo.gif))

## A piece of code I am proud of

- This code reads the CSV file line by line and splits each line using the pipe delimiter. 
  It uses the array indexes to extract the transaction details, converts the values into the appropriate data types, and creates a Transaction object. 
  Finally, it adds each transaction to the transaction list.

- I chose this piece of code because it was one of the most challenging parts of the project for me. 
  I struggled with understanding how to, separate the data, and convert it into Java objects. 
  After practicing, I became comfortable enough with the code, and now I can write it from memory. 

```  
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
```

## Future Work

- I would improve application by adding more loops to handle invalid user input. 
  For example, if a user enters "abc" instead of a valid date or time, the application would ask them to try again instead of crashing.

## Resources

- Java YearUp Fall 2026 hub: <https://raymaroun.github.io/yearup-java-fall2026/>
- https://www.geeksforgeeks.org/java/file-exists-method-in-java-with-examples/
- https://www.tutorialspoint.com/javatime/javatime_monthday_withdayofmonth.htm
- https://raymaroun.github.io/yearup-java-fall2026/week-04/index.html#07-commit-message
- https://howtodoinjava.com/java/date-time/java8-next-previous-date/
- https://www.geeksforgeeks.org/java/localdate-lengthofmonth-method-in-java-with-examples/

## Author

- **Maalik** - [GitHub]https://github.com/Maalik-McCutchen

## Thanks

- Thank you to Raymond for being patient with us as we learned Java over the past four weeks 
  and for providing us with more than enough resources for our exercises, workshops, capstones, and study time. 

- Thank you to Adrian for asking so many questions about your code. 
  It has helped me test my own logic and think about situations I might not have thought about.

- Thank you to Zion for asking for help when you're stuck. It helps me test my logic and work through problems together.