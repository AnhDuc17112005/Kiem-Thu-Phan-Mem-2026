# BÁO CÁO MÔN HỌC KIỂM THỬ PHẦN MỀM 
## Họ và Tên: Lê Đình Anh Đức

## Chương 1: Kiểm thử giao diện (Can't Unsee)
Chương này tập trung vào việc rèn luyện và kiểm tra mắt thẩm mỹ cũng như khả năng phát hiện lỗi trong thiết kế giao diện người dùng (UI).
- **Hoạt động**: Thực hiện bài test trên trang Can't Unsee.
- **Kết quả**: Số điểm em đạt được là **7180 điểm**.
- **Minh chứng**: Xem hình ảnh <img width="1895" height="969" alt="Screenshot 2026-01-05 142553" src="https://github.com/user-attachments/assets/ff4c9063-4723-4e60-b579-cbc409402ea4" />
42553.png`.

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

## Chương 3: Kiểm thử tự động End-to-End với Cypress
Chương này thực hành kiểm thử tự động giao diện web (End-to-End Testing) trên trang [Swag Labs](https://www.saucedemo.com/) sử dụng framework Cypress.

### Cấu trúc dự án
Thư mục: `cypress-exercise/`
- **Test Specs** (`cypress/e2e/`):
    - `login_spec.cy.js`: Kịch bản đăng nhập (thành công/thất bại).
    - `cart_spec.cy.js`: Kịch bản thêm/xóa sản phẩm và sắp xếp.
    - `checkout_spec.cy.js`: Kịch bản thanh toán.

### Các kịch bản kiểm thử (Test Scenarios)
1. **Đăng nhập (Login)**:
   - Đăng nhập thành công với `standard_user`.
   - Kiểm báo lỗi khi nhập sai thông tin.

2. **Giỏ hàng (Cart)**:
   - Thêm sản phẩm vào giỏ hàng.
   - Sắp xếp sản phẩm (Giá thấp -> cao).
   - **(Bài tập thêm)** Xóa sản phẩm khỏi giỏ hàng.

3. **Thanh toán (Checkout)**:
   - **(Bài tập thêm)** Quy trình thanh toán đầy đủ: Giỏ hàng -> Checkout -> Điền thông tin -> Xác nhận.

### Hướng dẫn chạy
Mở terminal tại thư mục `cypress-exercise` và chạy lệnh:
```bash
npx cypress open
```
Hoặc chạy ngầm (headless):
```bash
npx cypress run

```
