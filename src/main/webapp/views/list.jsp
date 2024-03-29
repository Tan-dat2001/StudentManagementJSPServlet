<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/23/2023
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        label {
            font-weight: bold;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        table th, table td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .add-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            float: right;
        }

        .edit-button, .delete-button {
            background-color: #008CBA;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <label for="select-khoa">Chọn khoa:</label>
    <select name="select-khoa" id="select-khoa">
        <option value="khoaHoa">Khoa Toán</option>
        <option value="khoaLy">Khoa Lý</option>
        <option value="khoaFast">Khoa Fast</option>
        <option value="khoaCNTT">Khoa Công Nghệ Thông Tin</option>
        <option value="khoaHoa">Khoa Hóa</option>

    </select>
    <button class="view-button"><a href="/StudentController?action=showStudentByKhoa&khoa">Xem</a></button>
    <button class="add-button"><a href="/StudentController?action=create">Thêm mới</a></button>

    <table>
        <thead>
        <tr>
            <th>MSSV</th>
            <th>Họ tên</th>
            <th>Giới tính</th>
            <th>Khoa</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td><c:out value="${student.mssv}"/></td>
                <td><c:out value="${student.hoTen}"/></td>
                <td><c:out value="${student.gioiTinh}"/></td>
                <td><c:out value="${student.khoa}"/></td>
<%--                <td>Ten</td>--%>
<%--                <td>MSSV</td>--%>
<%--                <td>Nam</td>--%>
<%--                <td>Hoa</td>--%>
                <td><button class="edit-button"><a href="/StudentController?action=edit&id=${student.id}">Sửa</a></button></td>
                <td><button class="delete-button"><a href="/StudentController?action=delete&id=${student.id}">Xóa</a></button></td>
            </tr>
        </c:forEach>
        <!-- Thêm các dòng sinh viên khác tương tự -->
        </tbody>
    </table>
</body>
</html>
