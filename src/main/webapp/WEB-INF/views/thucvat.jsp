<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <form action="/thuc-vat/tim-kiem" method="get">
        <div >
            Tên: <input type="text" name="ten">
            <br/>
            Tuổi:
            <br/>
            Số tuổi Min: <input type="number" name="tuoiMin">
            <br/>
            Số tuổi Max: <input type="number" name="tuoiMax">
            <br/>
            <button type="submit">Search</button>
        </div>
    </form>
</head>

<body>

<form action="/thuc-vat/add" method="post">
    Id: <input type="text" name="id" value="${tv.id}"/>
    <br/>
    Loại Cây: <input type="text" name="loaiCay" value="${tv.loaiCay}"/>
    <br/>
    Tên: <input type="text" name="ten" value="${tv.ten}"/>
    <br/>
    Tuổi: <input type="number" name="tuoi" value="${tv.tuoi}"/>
    <br/>
    Giới tính: <input type="radio" name="gioiTinh" checked value="${tv.gioiTinh ? '1' : '2'}"/>
               <input type="radio" name="gioiTinh" value="${tv.gioiTinh ? '2' : '1'}"/>
    <br/>
    khu Vực: <input type="text" name="khuVuc" value="${tv.khuVuc}"/>
    <br/>
<%--    ${message}--%>
    <button type="submit">Add</button>
</form>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Ten</th>
        <th>Loại Cây</th>
        <th>Tuoi</th>
        <th>Giới Tính</th>
        <th>Khu Vực</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${list}" var="tv" varStatus="t">
        <tr>
            <td>${t.index+1}</td>
            <td>${tv.ten}</td>
            <td>${tv.loaiCay}</td>
            <td>${tv.tuoi}</td>
            <td>${tv.khuVuc}</td>
            <td>${tv.gioiTinh ? '1' : '2'}</td>
            <td><a href="/thuc-vat/detail/${tv.id}">Detail</a>
                <a href="/thuc-vat/view-update/${tv.id}">Edit</a>
                <a href="/thuc-vat/remove/${tv.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>