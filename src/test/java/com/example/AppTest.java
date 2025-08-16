cat > src/test/java/com/example/AppTest.java << 'EOF'
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    void testAdd() {
        assertEquals(5, App.add(2, 3), "2 + 3 should equal 5");
    }
}
EOF

