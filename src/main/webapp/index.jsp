<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/22/2023
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <style>
      * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
      }

      .wrapper {
        margin-top: 200px;
      }

      .button {
        /* float: left; */
        display: inline-block;
      }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
  </head>
  <body>
  <div class="container wrapper">
    <h1>Đăng nhập hệ thống</h1>
    <form class="row" role="form" method="post" action="LoginController">
      <div class="form-group">
        <label for="firstname" class="col-md-2 col-form-label">Tên đăng nhập</label>
        <div class="col-md-10">
          <input type="text" name="txtUsername" class="form-control" id="firstname" placeholder="">
        </div>
      </div>
      <div class="form-group">
        <label for="lastname" class="col-md-2 col-form-label">Mật khẩu</label>
        <div class="col-md-10">
          <input type="password" name="txtPassword" class="form-control" id="lastname" placeholder="">
        </div>
      </div>
      <div class="form-group button">
        <div class=" col-md-10">
          <button type="submit" value="login" name="btnAction" class="btn btn-secondary">Đăng nhập</button>
          <button type="submit" class="btn btn-secondary">Hủy</button>
        </div>
      </div>
    </form>
  </div>
  </body>
</html>
