# BÁO CÁO MÔN HỌC KIỂM THỬ PHẦN MỀM 
## Họ và Tên: Lê Đình Anh Đức

## Chương 1: Kiểm thử giao diện (Can't Unsee)
Chương này tập trung vào việc rèn luyện và kiểm tra mắt thẩm mỹ cũng như khả năng phát hiện lỗi trong thiết kế giao diện người dùng (UI).
- **Hoạt động**: Thực hiện bài test trên trang Can't Unsee.
- **Kết quả**: Số điểm em đạt được là **7180 điểm**.
- **Minh chứng**: Xem hình ảnh `Screenshot 2026-01-05 142553.png`.

## Chương 2: Kiểm thử đơn vị (Unit Testing)
Chương này mô tả quá trình xây dựng và kiểm thử lớp xử lý dữ liệu sinh viên `StudentAnalyzer` bằng Java và JUnit 5.

### Cấu trúc dự án
- **Source code**: `unit-test/src/StudentAnalyzer.java`
- **Test code**: `unit-test/test/StudentAnalyzerTest.java`

### Chức năng đã thực hiện
1. **`countExcellentStudents(List<Double> scores)`**:
   - Đếm số lượng sinh viên có điểm giỏi (điểm >= 8.0).
   - Bỏ qua các điểm không hợp lệ (ngoài khoảng 0-10).
   - Xử lý trường hợp danh sách rỗng hoặc null.

2. **`calculateValidAverage(List<Double> scores)`**:
   - Tính điểm trung bình cộng của các điểm hợp lệ.
   - Bỏ qua các điểm không hợp lệ.
   - Trả về 0 nếu không có điểm hợp lệ nào.

### Kết quả kiểm thử
Các test case trong `StudentAnalyzerTest.java` đã bao phủ:
- Trường hợp danh sách điểm bình thường.
- Trường hợp danh sách rỗng (`Collections.emptyList()`).
- Trường hợp có điểm không hợp lệ (âm hoặc > 10).
- Kiểm tra độ chính xác của số thực (delta).
