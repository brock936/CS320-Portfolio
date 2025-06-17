📱 CS320 Project – Contact, Task, and Appointment Services
📌 Project Mission
This project simulates the back-end services of a mobile application for managing contacts, tasks, and appointments. The goal is to design, implement, and test robust Java-based services that fulfill specific requirements provided by a client. All data is stored in-memory, and each service is tested thoroughly using JUnit to ensure correctness, reliability, and adherence to business rules.

The primary mission of this application is to:

Allow creation, updating, and deletion of Contact, Task, and Appointment objects.

Enforce strict data validation and immutability rules.

Use JUnit testing to verify all functional requirements are met with a minimum of 80% test coverage.

✅ What I Did
This project was developed over multiple phases as part of my CS320 coursework:

🔹 Contact Service
Implemented Contact.java with fields for ID, first name, last name, phone number, and address.

Enforced input validation (length restrictions, non-null fields, 10-digit phone number).

Developed ContactService.java to manage contact creation, deletion, and field-specific updates.

Wrote JUnit tests (ContactTest.java, ContactServiceTest.java) to validate functionality and data integrity.

🔹 Task Service
Created Task.java with immutable ID and editable name and description fields.

Ensured name and description follow character limits and are not null.

Built TaskService.java to support add, update, and delete operations for tasks.

Verified functionality through JUnit tests in TaskTest.java and TaskServiceTest.java.

🔹 Appointment Service
Defined Appointment.java to include an appointment ID, future date, and a description.

Applied validation to ensure the date is not in the past and all fields meet the constraints.

Constructed AppointmentService.java to handle adding and deleting appointments.

Wrote JUnit test cases in AppointmentTest.java and AppointmentServiceTest.java to confirm functionality.

🧪 Testing & Validation
All classes were verified using JUnit 5.

Coverage for each class was maintained at 80% or above.

Test cases were designed to evaluate both valid and invalid input scenarios.

💻 Technologies Used
Java (Standard Edition)

JUnit 5 (for unit testing)

IntelliJ IDEA / Eclipse (development environment)

Git & GitHub (version control)

📜 License
This project was developed for educational purposes as part of the CS320 course at Southern New Hampshire University.
