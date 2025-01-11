
# FairShare

WeShare is a simple, intuitive web application for tracking and managing shared expenses. Built with Java and the Javalin framework, this app uses server-side rendering with Thymeleaf templates to dynamically display expense data. The app is styled with HTML and CSS, providing a clean and user-friendly interface.

---

## Features

### User Management
- Login functionality using email.
- Logout support for secure session management.

### Expense Tracking
- Add new expenses with details such as date, description, and amount.
- View a list of all recorded expenses in a table format.

### Payment Management
- Request payments from other users for shared expenses.
- View the status of payments (requested and received) in an organized table.

### Dashboard
- Track total expenses and individual transactions.
- Simple navigation to key features such as adding expenses and managing payments.

---

## Technology Stack

### Server-Side
- **Java**: Backend logic and functionality.
- **Javalin**: Lightweight web framework for serving HTTP requests.
- **Thymeleaf**: Templating engine for dynamic HTML generation.
- **In-Memory Datastore**: Temporary persistence for application data.

### Client-Side
- **HTML**: Structuring web pages.
- **CSS**: Styling the user interface.
- **Normalize.css**: Resetting browser styles for consistent appearance.

### Testing
- **Selenium**: Automated browser testing for user interaction.

---

## Installation and Setup

1. **Clone the Repository**  
   ```
   git clone git@github.com:PhilaniMhlongo/FairShare.git
   cd FairShare
   ```

2. **Build the Project**  
   Ensure you have Maven installed. Run:
   ```
   mvn validate
   mvn test
   ```

3. **Run the Application**  
   Start the server:
   ```
   mvn exec:java -Dexec.mainClass="fairshare.server.FairShareServer"
   ```
   Open the app in your browser at [http://localhost:5050](http://localhost:5050).

---


## Usage Instructions

1. **Login Page**  
   Enter a valid email to log in.

2. **Dashboard**  
   - View all your expenses in a table format.
   - Check the total amount spent.

3. **Add Expenses**  
   - Navigate to "Add a New Expense" to create a new expense.
   - Fill in the details and save.

4. **Request Payments**  
   - Select an expense and request payments from others.
   - Monitor the status of payment requests.

---

## Design Principles

- **Simplicity**: Easy-to-use interface with intuitive navigation.
- **Consistency**: Single CSS stylesheet for uniform appearance.
- **Dynamic Rendering**: Thymeleaf templates ensure server-side updates.

---

## Testing the Application

Selenium tests are included but disabled by default. As you implement the application, progressively enable the tests to validate the functionality. Other tests provided in the codebase validate the domain and core logic.

---


