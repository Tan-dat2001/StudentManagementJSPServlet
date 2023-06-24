<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/23/2023
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa sinh viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-group {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: bold;
            margin-right: 10px;
        }

        .form-group input[type="text"], .form-group select {
            padding: 5px;
        }

        .form-group .gender-radio label {
            display: inline-block;
            margin-right: 10px;
        }

        .form-group .buttons {
            margin-left: auto;
        }

        .form-group .buttons button {
            margin-left: 10px;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
        }

        .form-group .buttons .back-button {
            background-color: #FF0000;
            color: white;
        }

        .form-group .buttons .add-button {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Sửa sinh viên : ${student.hoTen}</h2>
    <form method="post" action="/StudentController">
        <div>
            <div><input type="hidden"value="${student.id}" name="id"></div>
        </div>
        <div class="form-group">
            <label for="student-id">Mã sinh viên:</label>
            <input type="text" id="student-id" name="mssv" value="${student.mssv}" required>
        </div>
        <div class="form-group">
            <label for="student-name">Họ tên:</label>
            <input type="text" id="student-name" name="name" value="${student.hoTen}" required>
        </div>
        <div class="form-group">
            <label>Giới tính:</label>
            <div class="gender-radio">
                <label><input type="radio" id="gender-nam" name="gender" value="nam"> Nam</label>
                <label><input type="radio" id="gender-nu" name="gender" value="nu"> Nữ</label>
            </div>
        </div>
        <div class="form-group">
            <label for="select-khoa">Khoa:</label>
            <select id="select-khoa" name="faculty" required>
                <option value="khoaHoa">Khoa Toán</option>
                <option value="khoaLy">Khoa Lý</option>
                <option value="khoaFast">Khoa Fast</option>
                <option value="khoaCNTT">Khoa Công Nghệ Thông Tin</option>
                <option value="khoaHoa">Khoa Hóa</option>
            </select>
        </div>
        <div class="form-group buttons">
            <input type="submit" class="add-button" name="action" value="luu lai"></input>
            <input type="button" class="back-button"><a href="/StudentController?action=listAllStudent">Quay lại</a></input>
        </div>
    </form>
</div>

</body>
</html>
