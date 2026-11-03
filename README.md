# Project Title

<!-- HOW TO USE THIS TEMPLATE
     Save it as README.md at the root of your project, next to pom.xml. Replace every comment like this one
     with your own text; comments do not show on GitHub, so what you leave untouched shows as an empty heading.
     Two sections are optional and say so: Class Diagram, and Data and configuration. When your project does not
     need one, delete the whole section, heading included. Every other section stays. -->

<!-- One sentence under the title: what the app is, for whom.
     Example: A console app that keeps a store's inventory in a csv file and lets a clerk search it. -->

## Description of the Project

<!-- Three to five sentences. What the application does, who uses it, what problem it solves.
     Write it for someone who has never seen the workbook: a recruiter, a classmate, you in six months. -->

## Features

<!-- One bullet per thing the app can do, in the order of your menu. Mark bonuses.
     For an API (Capstone 3), one line per endpoint instead: method, path, what it does.
     Be honest: list what works. If something is half done, say so under Future Work instead.
     Example:
     - Shows every product in the store
     - Searches products by name (bonus) -->

-
-
-

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

<!-- OPTIONAL. Anything the program needs that is not code: data files and where they must sit, files the
     program creates, a database script to run first, a settings file to edit (connection, port).
     If there is nothing, delete this subsection, heading included.
     Example:
     - `inventory.csv` sits at the project root, next to `pom.xml`. The program reads it at start.
     - `logs.txt` is created by the program at the project root on the first run. -->

-

## Technologies Used

- Java 17
- IntelliJ IDEA
<!-- Add anything else you used: a library, Maven plugins, an external tool. For a console app this list is short. That is fine. -->

## Demo

<!-- Pictures of the app running: the console for a console app, Insomnia or Swagger for an API.
     Screenshots are enough; a GIF is a bonus.
     1. Create a folder named `images` at the project root, next to `pom.xml`.
     2. Take screenshots of the app in the IntelliJ console (the menu, one feature, one error message):
          Windows: Win + Shift + S, drag a rectangle, then paste into Paint and save as PNG, or open the
                   notification and save. Save into the `images` folder.
          Mac:     Shift + Cmd + 4, drag a rectangle. The file lands on the Desktop; move it into `images`.
     3. Name the files by what they show: `images/menu.png`, `images/search.png`.
     4. Reference each one below with a relative path. No spaces in file names.
     5. Commit the images with the rest of your work (Git > Commit shows them as unversioned files: tick them).
     Optional GIF: LICEcap (free, Windows and Mac, <https://www.cockos.com/licecap/>) records a region of the
     screen straight to a .gif. Keep it under 10 seconds and under 10 MB, save it into `images`. -->

![Main menu](images/menu.png)

![One feature in action](images/feature.png)

## A piece of code I am proud of

<!-- Paste one short block of your own code (5 to 15 lines) between the three backticks, then write two
     or three sentences: what it does and why you chose to write it that way. This is what you show on
     demo day and what you talk about in an interview. -->

```java

```

## Future Work

<!-- What you would add or fix next, one bullet each. Unfinished bonuses belong here. -->

-
-

## Resources

<!-- What helped you: the workbook, the week's hub pages, a tutorial, a documentation page. Real links. -->

- Java YearUp Fall 2026 hub: <https://raymaroun.github.io/yearup-java-fall2026/>
-

## Author

<!-- Your name and, if you like, your GitHub profile link. For a team workshop, one line per person with what each one built. -->

- **Your Name**

## Thanks

<!-- Optional. The people who helped: the instructor, a classmate who debugged with you, a mentor. -->

- Thank you to ... for ...