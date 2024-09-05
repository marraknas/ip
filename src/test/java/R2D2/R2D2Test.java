package R2D2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class R2D2Test {
    @Test
    public void mark_task_success() {
        Task task = new Todo("test task");
        task.setDone(true);
        assertEquals("X", task.getStatusIcon());
    }

    @Test
    public void deadline_dateTime_exceptionThrown() {
        try {
            Task task = new Deadline("do homework", "2 12 2004");
        } catch (BuzzException e) {
            assertEquals("WRONG!!! The date and time format should be d/M/yyyy HHmm (e.g., 5/10/2024 0500).", e.getMessage());
        }
    }
}
