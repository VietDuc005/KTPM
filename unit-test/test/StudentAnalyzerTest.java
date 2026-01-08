import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    // ===== TEST cho countExcellentStudents =====

    // Trường hợp bình thường: có điểm hợp lệ và không hợp lệ
    @Test
    public void testCountExcellentStudents_mixedScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    // Trường hợp danh sách toàn bộ hợp lệ
    @Test
    public void testCountExcellentStudents_allValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.0, 9.0, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    // Trường hợp biên: danh sách trống
    @Test
    public void testCountExcellentStudents_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    // Trường hợp biên: chỉ chứa 0 và 10
    @Test
    public void testCountExcellentStudents_boundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    // ===== TEST cho calculateValidAverage =====

    // Trường hợp bình thường: có điểm hợp lệ và không hợp lệ
    @Test
    public void testCalculateValidAverage_mixedScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }

    // Trường hợp danh sách toàn bộ hợp lệ
    @Test
    public void testCalculateValidAverage_allValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.0, 9.0, 10.0);
        assertEquals(9.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    // Trường hợp biên: danh sách trống
    @Test
    public void testCalculateValidAverage_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    // Trường hợp ngoại lệ: toàn bộ điểm không hợp lệ
    @Test
    public void testCalculateValidAverage_allInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-2.0, 15.0);
        assertEquals(0, analyzer.calculateValidAverage(scores), 0.01);
    }
}
