# KTPM
T2 - 5/1/2026: up ảnh số điểm đạt được

T5 - 8/1/2026:
# Bài tập thực hành kiểm thử với JUnit
## Mục tiêu
- Viết kiểm thử đơn vị bằng JUnit 5
- Kiểm thử chương trình phân tích điểm số học sinh
## Mô tả bài toán
Chương trình gồm lớp `StudentAnalyzer` với hai chức năng:
- Đếm số học sinh đạt loại Giỏi (điểm >= 8.0)
- Tính điểm trung bình các điểm hợp lệ (0–10)
Các điểm < 0 hoặc > 10 được coi là dữ liệu không hợp lệ và bị bỏ qua.
## Cấu trúc thư mục
unit-test/
│── src/
│ └── StudentAnalyzer.java
│── test/
│ └── StudentAnalyzerTest.java
│── README.md
## Công nghệ sử dụng
- Java
- JUnit 5
- IntelliJ IDEA
## Cách chạy kiểm thử
1. Mở project bằng IntelliJ IDEA
2. Chuột phải vào lớp `StudentAnalyzerTest`
3. Chọn **Run 'StudentAnalyzerTest'**
4. Kiểm tra kết quả tất cả test đều PASSED
