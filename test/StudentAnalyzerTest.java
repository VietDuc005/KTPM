import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import java.util.Collections;

import java.util.List;



public class StudentAnalyzerTest {



    // ==========================

    // Helper

    // ==========================

    private StudentAnalyzer analyzer() {

        return new StudentAnalyzer();

    }



    // =========================================================

    // 1) TEST cho countExcellentStudents - EP + BVA (sâu nhất)

    // =========================================================



    // ---- Partition: list == null

    @Test

    public void testCountExcellentStudents_nullList_returns0() {

        assertEquals(0, analyzer().countExcellentStudents(null));

    }



    // ---- Partition: list empty

    @Test

    public void testCountExcellentStudents_emptyList_returns0() {

        assertEquals(0, analyzer().countExcellentStudents(Collections.emptyList()));

    }



    // ---- Partition: mixed valid/invalid (invalid low + invalid high)

    @Test

    public void testCountExcellentStudents_mixedValidAndInvalid_scores() {

        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 10.01, -0.01);

        assertEquals(2, analyzer().countExcellentStudents(scores));

    }



    // ---- BVA: validity boundaries (0, 10) + invalid just outside (-0.0001, 10.0001)

    @Test

    public void testCountExcellentStudents_validityBoundaries_andJustOutside() {

        List<Double> scores = Arrays.asList(

                0.0, 10.0,   // valid

                -0.0001,     // invalid low

                10.0001      // invalid high

        );

        // Excellent likely counts 10.0 but not 0.0; invalid ignored

        assertEquals(1, analyzer().countExcellentStudents(scores));

    }



    // ---- BVA: Excellent threshold boundary (giả định threshold là 8.0 theo test bạn đã sửa)

    // Kiểm tra 7.99 không excellent, 8.0 excellent, 8.01 excellent

    @Test

    public void testCountExcellentStudents_excellentThresholdBoundary_around8() {

        List<Double> scores = Arrays.asList(7.99, 8.0, 8.01);

        assertEquals(2, analyzer().countExcellentStudents(scores));

    }



    // ---- Partition: all valid & all excellent

    @Test

    public void testCountExcellentStudents_allValidAllExcellent() {

        List<Double> scores = Arrays.asList(8.0, 9.0, 9.99, 10.0);

        assertEquals(4, analyzer().countExcellentStudents(scores));

    }



    // ---- Partition: all valid but none excellent (để chắc chắn không đếm nhầm)

    @Test

    public void testCountExcellentStudents_allValidNoneExcellent() {

        List<Double> scores = Arrays.asList(0.0, 3.5, 7.99);

        assertEquals(0, analyzer().countExcellentStudents(scores));

    }



    // ---- Robustness: list contains null item (kỳ vọng bỏ qua null)

    @Test

    public void testCountExcellentStudents_containsNullItem_ignoreNull() {

        List<Double> scores = Arrays.asList(9.0, null, 8.0);

        assertEquals(2, analyzer().countExcellentStudents(scores));

    }



    // ---- Robustness: special floating values NaN/Infinity (kỳ vọng bỏ qua)

    @Test

    public void testCountExcellentStudents_containsNaNAndInfinity_ignoreThem() {

        List<Double> scores = Arrays.asList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 9.0);

        assertEquals(1, analyzer().countExcellentStudents(scores));

    }



    // =========================================================

    // 2) TEST cho calculateValidAverage - EP + BVA (sâu nhất)

    // =========================================================



    // ---- Partition: list == null

    @Test

    public void testCalculateValidAverage_nullList_returns0() {

        assertEquals(0, analyzer().calculateValidAverage(null), 0.0001);

    }



    // ---- Partition: list empty

    @Test

    public void testCalculateValidAverage_emptyList_returns0() {

        assertEquals(0, analyzer().calculateValidAverage(Collections.emptyList()), 0.0001);

    }



    // ---- Partition: all invalid (low + high) => 0

    @Test

    public void testCalculateValidAverage_allInvalid_returns0() {

        List<Double> scores = Arrays.asList(-0.01, 15.0, 10.0001);

        assertEquals(0, analyzer().calculateValidAverage(scores), 0.0001);

    }



    // ---- Partition: mixed valid/invalid => average only valid

    @Test

    public void testCalculateValidAverage_mixedValidInvalid_onlyValidAveraged() {

        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 10.01, -0.01);

        // valid = 9.0 + 8.5 + 7.0 = 24.5 / 3 = 8.166666...

        assertEquals(8.1667, analyzer().calculateValidAverage(scores), 0.01);

    }



    // ---- BVA: include 0 and 10 in average

    @Test

    public void testCalculateValidAverage_includesBoundaryValid0and10() {

        List<Double> scores = Arrays.asList(0.0, 10.0);

        assertEquals(5.0, analyzer().calculateValidAverage(scores), 0.0001);

    }



    // ---- Important EP: only 1 valid score => average equals that score

    @Test

    public void testCalculateValidAverage_onlyOneValidScore() {

        List<Double> scores = Arrays.asList(-1.0, 9.5, 11.0);

        assertEquals(9.5, analyzer().calculateValidAverage(scores), 0.0001);

    }



    // ---- BVA: just inside/outside validity boundaries

    @Test

    public void testCalculateValidAverage_justInsideOutsideValidityBoundaries() {

        List<Double> scores = Arrays.asList(-0.0001, 0.0, 10.0, 10.0001);

        // valid = 0.0 + 10.0 => avg = 5.0

        assertEquals(5.0, analyzer().calculateValidAverage(scores), 0.0001);

    }



    // ---- Robustness: contains null item (ignore)

    @Test

    public void testCalculateValidAverage_containsNullItem_ignoreNull() {

        List<Double> scores = Arrays.asList(8.0, null, 10.0);

        assertEquals(9.0, analyzer().calculateValidAverage(scores), 0.0001);

    }



    // ---- Robustness: contains NaN/Infinity (ignore)

    @Test

    public void testCalculateValidAverage_containsNaNAndInfinity_ignoreThem() {

        List<Double> scores = Arrays.asList(Double.NaN, Double.POSITIVE_INFINITY, 8.0, 10.0);

        assertEquals(9.0, analyzer().calculateValidAverage(scores), 0.0001);

    }



    // ---- Precision case: many decimals to check rounding / floating error

    @Test

    public void testCalculateValidAverage_precisionManyDecimals() {

        List<Double> scores = Arrays.asList(8.33, 8.33, 8.34);

        // sum = 25.00 / 3 = 8.333333...

        assertEquals(8.3333, analyzer().calculateValidAverage(scores), 0.001);

    }

}