cat > src/main/java/com/example/App.java << 'EOF'
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
EOF

