# Báo cáo Kiểm thử Hiệu năng với JMeter

## Mục tiêu
Kiểm thử hiệu năng trang web **https://vnexpress.net** bằng công cụ JMeter để đánh giá khả năng chịu tải và độ ổn định của hệ thống.

## Công cụ
- **JMeter**: Phiên bản 5.x
- **Website mục tiêu**: [VnExpress](https://vnexpress.net)

## Kịch bản Kiểm thử (Test Scenarios)

### Thread Group 1: Kịch bản cơ bản
- **Mục tiêu**: Kiểm tra phản hồi cơ bản của trang chủ với lượng người dùng thấp.
- **Số lượng người dùng (Users)**: 10
- **Thời gian khởi động (Ramp-up)**: 1 giây
- **Số lần lặp (Loop Count)**: 5
- **Hành vi**: Gửi yêu cầu HTTP GET đến trang chủ.

### Thread Group 2: Kịch bản tải nặng
- **Mục tiêu**: Đánh giá hệ thống dưới tải cao hơn khi người dùng truy cập trang chủ và các bài viết.
- **Số lượng người dùng (Users)**: 50
- **Thời gian khởi động (Ramp-up)**: 30 giây
- **Hành vi**:
    1. Gửi request GET tới Trang chủ.
    2. Gửi request GET tới Trang Tin mới nhất/Số hóa (ví dụ: `/so-hoa`).

### Thread Group 3: Kịch bản tùy chỉnh (Stress/Duration)
- **Mục tiêu**: Kiểm tra độ ổn định của hệ thống trong 1 khoảng thời gian cố định.
- **Số lượng người dùng (Users)**: 20
- **Thời gian chạy**: 60 giây (Duration).
- **Hành vi**:
    1. Gửi request GET tới Trang Thể thao (`/the-thao`).
    2. Gửi request GET tới Trang Du lịch (`/du-lich`).

## Kết quả Kiểm thử

> *Lưu ý: Phần này sẽ được cập nhật sau khi chạy file .jmx thực tế.*

### 1. Summary Report
*(Dán ảnh chụp màn hình Summary Report tại đây)*

### 2. Biểu đồ (Response Time Graph)
*(Dán ảnh chụp màn hình biểu đồ hoặc View Results Tree tại đây)*

### 3. Phân tích số liệu
| Scenario | Samples | Average (ms) | Min (ms) | Max (ms) | Error % | Throughput/sec |
|----------|---------|--------------|----------|----------|---------|----------------|
| TG 1     | ...     | ...          | ...      | ...      | ...     | ...            |
| TG 2     | ...     | ...          | ...      | ...      | ...     | ...            |
| TG 3     | ...     | ...          | ...      | ...      | ...     | ...            |

## Nhận xét & Kết luận
- **Thời gian phản hồi**: ...
- **Tỷ lệ lỗi**: ...
- **Kết luận**: Website VnExpress hoạt động như thế nào dưới các mức tải này? (Ví dụ: Ổn định, có hiện tượng nghẽn mạng, chặn IP nếu request quá nhanh, v.v.)

---

## Hướng dẫn chạy
1. Mở JMeter.
2. File > Open > chọn `vnexpress_test_plan.jmx`.
3. Nhấn nút **Start** (mũi tên xanh lá).
4. Xem kết quả ở các Listener: **View Results Tree** và **Summary Report**.
