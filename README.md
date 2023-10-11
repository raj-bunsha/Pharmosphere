## Getting Started

Welcome to Pharmosphere. An application for managing a pharmacy. This application is built using Java and mysql.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- 'sql': the folder to maintain sql files

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

### Running the project:

1. Run sql/create.sql to initialize the database
2. Navigate to src/backend/Database.java, edit static variables USER and PASS to match the sql username and password.
3. Run src/App.java to execute the main function
4. Register or login to Pharmosphere

### Given below are a list of functions:

1. Add Customer - Add a new customer to the database
2. Add Medicine - Add a new medicine to the database
3. Make Order - Add medicines to the inventory
4. Inventory Manager - Show or remove items from the inventory
5. Sell Medicine - Sell items from the inventory to a customer
6. Show Sales - Get the revenue generated by a particular pharmacy
7. Customer Report - Get the purchase history of a customer
8. Add Substitute - Add a substitute for a medicine
9. Show Substitute - Get all the substitutes for a medicine

## Documentation

Made as a part of the course database management system in IIITB.

To run the application, run the App in the src folder.

##Contributors
Raj Bunsha
Adithya Sunil
Tanmay Jain
