# GitHub Actions Zero to Hero 🚀

This project is a **beginner-friendly Java + Maven + GitHub Actions pipeline**.  
It shows how to create a simple Java application, build it with Maven, and run it automatically using **GitHub Actions CI/CD**.

---

## 📌 Project Overview
- Language: **Java**
- Build Tool: **Maven**
- CI/CD: **GitHub Actions**
- Example program: Adds two numbers and prints the result.

This project is useful if you are new to:
- GitHub Actions
- Java + Maven projects
- CI/CD pipelines

---

## 📂 Project Structure
```
├── pom.xml # Maven build configuration
└── src
└── main
└── java
└── com
└── example
└── App.java # Main Java application
```

---

## 📜 Code Explanation

**App.java**
```java
package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, GitHub Actions with Maven!");
        int sum = add(2, 3);
        System.out.println("2 + 3 = " + sum);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
```

When you run this app, the output will be:


Hello, GitHub Actions with Maven!


2 + 3 = 5

---

## 🤖 GitHub Actions Workflow

- This project includes a GitHub Actions workflow that:

- Runs automatically on every push/pull request to main.

- Sets up Java and Maven.

- Builds the project with mvn clean package.

- Runs the compiled .jar file.

## Workflow file:
```
.github/workflows/maven.yml
```

Example snippet:
```
name: Java CI with Maven

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build with Maven
        run: mvn -B package --file pom.xml
      - name: Run App
        run: java -jar target/github-actions-zero-to-hero1-1.0.0.jar
```
---

## ✅ Learning Outcomes

- How to structure a Java + Maven project.

- How to set up a CI/CD pipeline using GitHub Actions.

- How to automatically build and run code in the cloud.
---

## 🔮 Future Projects

These projects will be added step by step in this repository:

✅ Deploy Java App with Maven + SonarQube → For static code analysis & quality gates.

✅ Deploy Java App to Kubernetes → Using manifests, ConfigMaps, and services.

✅ Deploy Java App with Docker Swarm → For container orchestration and scaling.

Each project will have its own folder and detailed README.md with step-by-step instructions.

---

🙌 Contributing

- If you are a beginner and want to practice GitHub Actions or Java, feel free to fork this repo and try making changes!
---

## 📄 License

- This project is licensed under the MIT License - feel free to use it for learning and sharing!
---
