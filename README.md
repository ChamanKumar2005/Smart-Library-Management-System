# 📚 Bibliotek – Smart Library Management System (Java + Swing + MySQL)

**Bibliotek** is a desktop-based Integrated Library System (ILS) developed in Java. It streamlines library operations such as managing books, tracking issued/returned items, calculating fines for overdue returns, and maintaining user roles (Admin/Student). Built using Java Swing and JDBC, it provides a clean user interface and reliable backend integration.

---

## 🚀 Features

- 🔐 **Login System** – Separate roles for Admin and Students
- 📖 **Book Management** – Add, update, delete, and search for books (Admin only)
- 👥 **User Management** – Manage student records (Admin only)
- 📚 **Issue & Return System** – Track which books are borrowed by whom
- ⏰ **Fine Calculation** – Automatically calculates late return fines
- 📅 **Due Date Tracking** – Highlights overdue books
- 🧩 **Interactive GUI** – Built using Java Swing components
- 🛡️ **Input Validation** – Ensures secure and error-free data entry

---

## 🧑‍💻 Technologies Used

| Component   | Technology            |
|------------|------------------------|
| Language    | Java                  |
| UI Library  | Java Swing            |
| Database    | MySQL or SQLite       |
| Connectivity| JDBC                  |
| IDE         | IntelliJ / Eclipse    |

---

## 🖥️ Screenshots

- 📌 STARTING PAGE

  ![start](https://github.com/user-attachments/assets/ceae99d7-f9f4-4259-a82a-d5c3cfa26104)

- 📌 LOGIN PAGE

 ![login](https://github.com/user-attachments/assets/a470df6e-c87d-49a6-a260-2657a48cb88f)

- 📌 DASHBOARD

  ![dashboard](https://github.com/user-attachments/assets/c0df037b-2856-47d3-b06c-9960d89c4076)

- 📌 Book Issue/Return Interface

  ![issue-return](https://github.com/user-attachments/assets/3685bfbd-125b-46f7-8d79-28ff04996c9b)

---

## 🏗️ Project Structure
  ![project structure](https://github.com/user-attachments/assets/943625a6-cd6a-4fcd-9cd7-c61c10bc38de)

---

## 🛠️ How to Run the Project

1. **Clone the Repository**  
git clone https://github.com/ChamanKumar2005/Online-Library-Management-System.git

2. **Open in IDE (Eclipse/IntelliJ)**  
- Import as a Java project.
- Add JDBC library to classpath (`mysql-connector.jar` if using MySQL).

3. **Set up the Database**  
- Use the provided SQL script to create tables and initial data.
- Update DB credentials in `DatabaseUtil.java`.

4. **Run `Main.java`**  
- Launch the application and use default credentials to login.

---

## 🧭 System Flowchart

The following diagram illustrates the overall flow and main functionalities of the Bibliotek system:

![System Flowchart](https://github.com/user-attachments/assets/0b1b627f-0598-4283-9f25-b6e4946172d5)

---

## 🧪 Default Credentials

| Role   | Username | Password |
|--------|----------|----------|
| Admin  | admin    | admin123 |
| Student| student1 | pass123  |

> *(You can modify these in the database)*

---

## 👨‍💻 Contributors

Thanks to these amazing people for their contributions:

| Name                  | GitHub Profile                                                         | Role                    |
|------------------     |------------------------------------------------------------------------|-------------------------|
| Chaman Kumar          | [@ChamanKumar2005] (https://github.com/ChamanKumar2005)                | Project Lead, Developer |
| Abhay Pratap Singh    | [@abhaysingh009]   (https://github.com/abhaysingh009)                  | UI Designer             |
| Kanishka Prasad       | [@kp-1212]         (https://github.com/kp-1212)                        | Documentation           |


---

## 📃 License

This project is open-source and available under the [MIT License](LICENSE).

---

🤝 Contribution Guidelines
--
Contributions are welcome! 🚀 To contribute:

- Fork this repository.
- Create a feature branch.
- Commit your changes.
- Open a Pull Request with a brief description.<br>

You can also open issues for bugs or enhancement ideas.


