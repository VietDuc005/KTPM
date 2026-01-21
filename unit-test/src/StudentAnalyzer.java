import java.util.List;

public class StudentAnalyzer {

    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * 
     * @param scores danh sách điểm số
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     */
    public int countExcellentStudents(List<Double> scores) {
        // Nếu danh sách rỗng hoặc null thì trả về 0
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;

        // Duyệt qua danh sách điểm
        for (Double score : scores) {
            // FIX: Kiểm tra null trước khi so sánh để tránh NullPointerException
            if (score == null) {
                continue;
            }

            // Chỉ xét điểm hợp lệ từ 0 đến 10
            if (score >= 0 && score <= 10) {
                // Học sinh giỏi nếu điểm >= 8.0
                if (score >= 8.0) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Tính điểm trung bình các điểm hợp lệ (0–10)
     * 
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        // Nếu danh sách rỗng hoặc null thì trả về 0
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int validCount = 0;

        // Duyệt qua danh sách điểm
        for (Double score : scores) {
            // FIX: Kiểm tra null trước khi tính toán
            if (score == null) {
                continue;
            }

            // Chỉ tính các điểm hợp lệ
            if (score >= 0 && score <= 10) {
                sum += score;
                validCount++;
            }
        }

        // Nếu không có điểm hợp lệ thì trả về 0
        if (validCount == 0) {
            return 0;
        }

        return sum / validCount;
    }
}