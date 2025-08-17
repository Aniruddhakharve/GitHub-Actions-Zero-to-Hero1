# GitHub Actions Zero to Hero 🚀

This project is a **beginner-friendly Java + Maven + GitHub Actions pipeline**.  
It shows how to create a simple Java application, build it with Maven, and run it automatically using **GitHub Actions CI/CD**.

---

## 📌 Project Overview
- Language: **Java**
- Build Tool: **Maven**
- CI/CD: **GitHub Actions**
- Example program: Adds two numbers and prints the result.
- Runs on: **GitHub-hosted runners** 🖥️ and **Self-hosted runners** (e.g., EC2 instance) ☁️

This project is useful if you are new to:
- GitHub Actions
- Java + Maven projects
- CI/CD pipelines
- Self-hosted GitHub runners

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

Example (GitHub-hosted runner):
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
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build with Maven
        run: mvn -B package --file pom.xml
      - name: Run App
        run: java -jar target/github-actions-zero-to-hero1-1.0.0.jar

```
Example (Self-hosted runner, e.g., EC2):
```
jobs:
  build:
    runs-on: self-hosted
    steps:
      - uses: actions/checkout@v4
      - name: Install Maven (only if not pre-installed)
        run: sudo apt-get update && sudo apt-get install -y maven
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build with Maven
        run: mvn -B package --file pom.xml
      - name: Run App
        run: java -jar target/github-actions-zero-to-hero1-1.0.0.jar
```

---
## 🛠️ Setting up a Self-Hosted Runner on EC2

### 1️⃣ Launch an EC2 Instance
- OS: Ubuntu (latest LTS recommended)
- Instance type: t2.micro (enough for testing)
- Security Group rules:
    - ✅ Inbound: allow SSH (port 22) from your IP
    - ✅ Outbound: allow all traffic (0.0.0.0/0) (needed for GitHub runner to reach GitHub servers)

### 2️⃣ Install Required Packages
- SSH into your EC2 instance:
```
SSH into your EC2 instance:
```
- Update packages:
```
sudo apt-get update && sudo apt-get upgrade -y
```
- Install basic dependencies:
```
sudo apt-get install -y curl wget tar git
```

### 3️⃣ Configure Self-Hosted Runner
- 1.Go to your GitHub repo → Settings → Actions → Runners → New self-hosted runner.
- 2.Select Linux and copy the commands GitHub provides. Example:
```
# Create a folder
mkdir actions-runner && cd actions-runner

# Download the runner package (replace URL with the one from GitHub)
curl -o actions-runner-linux-x64-2.314.1.tar.gz -L https://github.com/actions/runner/releases/download/v2.314.1/actions-runner-linux-x64-2.314.1.tar.gz

# Extract
tar xzf ./actions-runner-linux-x64-2.314.1.tar.gz

# Configure (replace TOKEN and URL from GitHub setup page)
./config.sh --url https://github.com/your-username/your-repo --token YOUR_TOKEN
```
- 3.Start the runner:
```
./run.sh
```

### 4️⃣ Update Workflow to Use Self-Hosted Runner
- In your .github/workflows/maven.yml, change:
```
runs-on: ubuntu-latest
```
to:

```
runs-on: self-hosted
```

---

## ✅ Learning Outcomes

- How to structure a Java + Maven project.

- How to set up a CI/CD pipeline using GitHub Actions.

- How to automatically build and run code in the cloud.
  
- How to configure and use self-hosted runners like an EC2 instance for CI/CD.
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
