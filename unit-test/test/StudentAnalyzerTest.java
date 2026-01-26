import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import java.util.List;

class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // ========================================================
    // TEST GROUP 1: countExcellentStudents
    // Logic: Điểm giỏi >= 8.0 và phải hợp lệ (0 <= điểm <= 10)
    // ========================================================

    @Test
    void testCount_NullInput_ReturnsZero() {
        assertEquals(0, analyzer.countExcellentStudents(null), "Should return 0 for null input");
    }

    @Test
    void testCount_EmptyList_ReturnsZero() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()), "Should return 0 for empty list");
    }

    @Test
    void testCount_StandardCase_ReturnsCorrectCount() {
        // Case: Mixed valid scores
        // 9.0 (Giỏi), 7.5 (Khá), 10.0 (Giỏi), 5.0 (TB)
        List<Double> scores = Arrays.asList(9.0, 7.5, 10.0, 5.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    void testCount_BoundaryValues_CheckThreshold8() {
        // Boundary at 8.0
        // 7.9 (No), 8.0 (Yes), 8.1 (Yes)
        List<Double> scores = Arrays.asList(7.9, 8.0, 8.1);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    void testCount_InvalidScores_AreIgnored() {
        // Invalid scores (< 0 or > 10) should be ignored even if >= 8
        // 11.0 (Invalid), -5.0 (Invalid), 20.0 (Invalid)
        List<Double> scores = Arrays.asList(11.0, -5.0, 20.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    void testCount_MixedValidAndInvalid_ReturnsCorrectCount() {
        // 9.0 (Yes), 11.0 (Ignored), -1.0 (Ignored), 8.5 (Yes)
        List<Double> scores = Arrays.asList(9.0, 11.0, -1.0, 8.5);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    // ========================================================
    // TEST GROUP 2: calculateValidAverage
    // Logic: Trung bình cộng các điểm hợp lệ (0 <= điểm <= 10).
    // Bỏ qua điểm không hợp lệ. Trả về 0 nếu không có điểm hợp lệ.
    // ========================================================

    @Test
    void testAverage_NullInput_ReturnsZero() {
        assertEquals(0, analyzer.calculateValidAverage(null), 0.001, "Should return 0 for null input");
    }

    @Test
    void testAverage_EmptyList_ReturnsZero() {
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001,
                "Should return 0 for empty list");
    }

    @Test
    void testAverage_StandardCase_CalculatesCorrectly() {
        // (8.0 + 9.0 + 7.0) / 3 = 24 / 3 = 8.0
        List<Double> scores = Arrays.asList(8.0, 9.0, 7.0);
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void testAverage_WithInvalidScores_IgnoresInvalid() {
        // Valid: 10.0, 5.0 -> Sum=15, Count=2 -> Avg=7.5
        // Invalid: -1.0, 11.0
        List<Double> scores = Arrays.asList(10.0, -1.0, 5.0, 11.0);
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void testAverage_AllInvalidScores_ReturnsZero() {
        // No valid scores -> logic returns 0 (handling division by zero case
        // internally)
        List<Double> scores = Arrays.asList(-1.0, 11.0, 100.0);
        assertEquals(0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void testAverage_SingleValidScore_ReturnsThatScore() {
        List<Double> scores = Arrays.asList(7.5);
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001);
    }
}
