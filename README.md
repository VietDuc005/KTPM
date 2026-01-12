# Kiểm thử phần mềm

## T2 – 05/01/2026
### Kết quả đạt được
- Ảnh số điểm đạt được: **7930 điểm**

## T5 – 08/01/2026
### Bài tập thực hành kiểm thử với JUnit

#### Mục tiêu
- Viết kiểm thử đơn vị bằng **JUnit 5**.
- Kiểm thử chương trình phân tích điểm số học sinh.

#### Mô tả bài toán
Chương trình gồm lớp `StudentAnalyzer` với hai chức năng:
- Đếm số học sinh đạt loại Giỏi (điểm >= 8.0).
- Tính điểm trung bình các điểm hợp lệ trong khoảng **0 đến 10**.
- Các điểm **nhỏ hơn 0** hoặc **lớn hơn 10** được coi là dữ liệu không hợp lệ và bị bỏ qua.

#### Cấu trúc thư mục
Thư mục `unit-test`
 - Thư mục `src`
    - Tệp `StudentAnalyzer.java`
  - Thư mục `test`
    - Tệp `StudentAnalyzerTest.java`
  - Tệp `README.md`

#### Công nghệ sử dụng
- Java
- JUnit 5
- IntelliJ IDEA

#### Cách chạy kiểm thử
1. Mở project bằng **IntelliJ IDEA**.
2. Chuột phải vào lớp `StudentAnalyzerTest`.
3. Chọn **Run `StudentAnalyzerTest`**.
4. Kiểm tra kết quả tất cả test đều **PASSED**.
