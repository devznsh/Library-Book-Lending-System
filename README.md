# 📚 Library Book Lending System

A desktop application built using Java and Swing that simulates a simple Library Book Lending System. It demonstrates core Java concepts such as object-oriented programming, exception handling, file I/O, and GUI development.

---

## ✅ Features

- 📘 Add and view books
- 👤 Register new members
- 🔁 Issue and return books
- 🖼️ GUI interface using Swing
- 💾 File I/O for data persistence (`books.txt`, `members.txt`)
- ⚠️ Custom exceptions to handle edge cases

---

## 🏗️ Project Structure
```
LibraryBookLendingSystem/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Book.java
│   │   ├── Member.java
│   │   ├── LibrarySystem.java
│   │   ├── BookNotAvailableException.java
│   │   └── MaxLimitReachedException.java
│   ├── storage/
│   │   └── FileHandler.java
│   └── ui/
│       └── LibraryGUI.java
├── data/
│   ├── books.txt
│   └── members.txt
├── bin/               # (Generated after compilation)
└── README.md
```

---

## 🖥️ Technologies Used

- Java (JDK 8+)
- Swing (for GUI)
- Object-Oriented Programming (OOP)
- File I/O (BufferedReader, FileWriter)
- Custom Exception Handling

---

## 🛠️ How to Run

### ▶️ Steps for Windows (Command Prompt or PowerShell)

1. Clone or download this repository.
2. Open a terminal and navigate to the project root:
   ```bash
   cd "Path\To\LibraryBookLendingSystem"
  
3. Create a bin directory if it doesn't exist:
```
 mkdir bin
```
4. Compile the Java files:
```
javac -d bin src\Main.java src\model\*.java src\storage\*.java src\ui\*.java
```
5. Run the application:
```
java -cp bin Main
```

🗃️ Sample Data
```
B1,The Alchemist,Paulo Coelho,true
B2,1984,George Orwell,true

```
👤 members.txt

```
M1,Alice
M2,Bob
```

These files are automatically loaded at startup and saved on exit.

🚫 Exception Handling
Custom exceptions are used to ensure valid operations:

BookNotAvailableException – Thrown when trying to issue a book that’s already borrowed.

MaxLimitReachedException – Thrown when a member tries to borrow more than 3 books.

Standard exception – Thrown when returning a book that wasn't borrowed.

✍️ Author
Developed by Devansh Gaur
