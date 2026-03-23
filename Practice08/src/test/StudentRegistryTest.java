import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

    class StudentRegistryTest {

        @Test
        void testRemoveByIdCleansEverything() {
            StudentRegistry registry = new StudentRegistry();
            Student s1 = new Student("1", "Veronika", "ver@test.com");
            registry.addStudent(s1);

            registry.removeById("1");

            assertNull(registry.findById("1"), "Студент має зникнути з Map");
            assertFalse(registry.containsEmail("ver@test.com"), "Email має зникнути з Set");
        }

        @Test
        void testCanReuseEmailAfterDeletion() {
            StudentRegistry registry = new StudentRegistry();
            String sameEmail = "test@mail.com";

            registry.addStudent(new Student("1", "User1", sameEmail));
            registry.removeById("1");

            boolean added = registry.addStudent(new Student("2", "User2", sameEmail));
            assertTrue(added, "Після видалення email має стати доступним знову");
        }
    }

