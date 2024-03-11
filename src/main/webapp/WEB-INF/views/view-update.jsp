<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/thuc-vat/update/${tv.id}" method="post">
    Id: <input type="text" name="id" value="${tv.id}" />
    <br/>
    Loai Cây: <input type="text" name="loaiCay" value="${tv.loaiCay}" />
    <br/>
    Tên: <input type="text" name="ten" value="${tv.ten}"/>
    <br/>
    Tuổi: <input type="text" name="tuoi" value="${tv.tuoi}" />
    <br/>
    giới tính: <input type="radio" name="gioiTinh" value="${tv.gioiTinh}"/>1
               <input type="radio" name="gioiTinh" value="${tv.gioiTinh}"/>2
    <br/>
    Khu Vực: <input type="text" name="khuVuc" value="${tv.khuVuc}"/>
    <br/>
    <button type="submit">Update </button>
</form>

</body>
</html>
