<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="description" content="dịch vụ chăm sóc khách hàng xịn">
<meta name="keywords" content="khách hàng, dịch vụ, chăm sóc">
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JAVA_SCRIPT -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/manage.css">
<link rel="stylesheet" type="text/css" href="/css/fontawesome.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/fontawesome.min.js"></script>
<script src="/js/manage.js"></script>

<!-- ----------------- -->

<title>Project Tong Hop</title>
</head>

<body>
	<div id="main">
		<div class="sidebar">
			<div class="sidebar-inner">
				<div class="sidebar-logo">
					<a class="sidebar-link" href="#"> <img class="icon"
						src="/img/logo.png">
						<h5 class="logo-text">Manage</h5>
					</a>
				</div>

				<nav class="navbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/manage-ticket">Quản lý
								khiếu nại</a></li>
						<li class="nav-item"><a class="nav-link" href="/manage-department">Quản lý
								phòng ban</a></li>

					</ul>

				</nav>
			</div>
		</div>
		<div class="page-container">
			<div class="header-container">
				<nav class="navbar">
					<ul class="navbar-nav">
						<li class="nav-item">
							<h4>Hệ thống tiếp nhận ý kiến chăm sóc khách hàng</h4>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"> <span class="text-icon">admin</span>
						</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/logout"><i
									class="fas fa-power-off"></i>Logout</a>
							</div></li>
					</ul>
				</nav>
			</div>

			<div class="main-content">
				<div class="row">
					<div class="col-md-12">
						<div class="form-add">
							<h6>
								Quản lý khiếu lại&ensp;<i class="fas fa-angle-right"></i>
							</h6>
							<h1 class="my-3"></h1>

							<div style="display: flex; justify-content: space-between;">
								<div class="search-by-type">
									<div class="search"
										style="margin-right: 20px; display: flex; position: relative;">
										<input class="form-control" id="inputTypeSearch" type="text"
											style="width: 300px; padding-left: 30px;"
											placeholder="Tìm theo SDT khách hàng, tên phòng ban"> <a href="javascript:void(0);"
											style="position: absolute; top: 3px; left: 5px; font-size: 20px;" onclick="searchTicket()"><i
											class="fas fa-search"></i></a>
									</div>
									<select class="form-control" onclick="searchTicketByIdDe(this.value)"
										style="margin-right: 20px;">
										<option value="">Chọn phòng ban</option>
										<c:forEach var="phongBan" items="${phongBans }">
											<option value="${phongBan.id }" >${phongBan.name }</option>
										</c:forEach>
									</select>
									<div style="display: flex; margin-right: 20px;">
										<label style="margin-top: 6px; margin-right: 10px;">From:</label>
										<input type="date" class="form-control" id="from">
									</div>
									<div style="display: flex; margin-right: 10px;">
										<label style="margin-top: 6px; margin-right: 10px;">To:
										</label> <input type="date" class="form-control" id="to">
									</div>
								</div>
								
								<a href="javascript:void(0);" onclick="addTicket()"
									class="btn btn-primary"><i class="fas fa-plus-square"></i>
									Tạo</a>
							</div>

							<h1 class="my-3"></h1>

							<table class="table">
								<thead class="thead-light">
									<tr>
										<th>Ticket ID</th>
										<th>Phòng ban tiếp nhận</th>
										<th>SĐT KH</th>
										<th>Ý kiến KH</th>
										<th>Thời gian tiếp nhận</th>
										<th>Nội dung xử lý</th>
										<th>Trạng thái xử lý</th>
										<th>Thời gian xử lý</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ticket" items="${listTicket }">
										<tr>
											<td>${ticket.id }</td>
											<td>${ticket.department.name }</td>
											<td>${ticket.mobileClient }</td>
											<td>${ticket.contentOfClient }</td>
											<td>${ticket.timeAccept }</td>
											<td>${ticket.contentReply }</td>
											<td>${ticket.status }</td>
											<td>${ticket.timeReply }</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

							<div class="container-footer">
								<h6>${sizeListTicket }&nbsp;items</h6>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>

	<!-- MODAL -->
	<div class="modal fade" tabindex="-1" role="dialog" id="modalAddTicket">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<div style="text-align: center; width: 100%">
						<h3 class="modal-title">Ghi nhận khiếu nại</h3>
					</div>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="divSuccess" class="alert alert-success"
						style="display: none;">
						<strong>Success!</strong> Gửi thành công!
					</div>
					<div id="divError" class="alert alert-danger"
						style="display: none;">
						<strong>Faile!</strong> Gửi thất bại!
					</div>
					<div class="form-group">
						<label>Tên khách hàng:</label> <input type="text"
							class="form-control" id="clientName"
							placeholder="Nhập tên khách hàng" />
					</div>

					<div class="form-group">
						<label>Số điện thoại:</label> <input type="tel"
							class="form-control" id="clientMobile" placeholder="Nhập SĐT" />
					</div>

					<div class="form-group">
						<label>Ý kiến khách hàng:</label>
						<textarea rows="3" style="width: 100%" class="form-control"
							id="clientContent"></textarea>
					</div>

					<select id="idPhongBan" class="form-control">
						<option value="0">Chọn phòng ban</option>
						<c:forEach var="phongBan" items="${phongBans }">
							<option value="${phongBan.id }">${phongBan.name }</option>
						</c:forEach>
					</select>

				</div>
				<div class="modal-footer">
					<div style="text-align: center; width: 100%">
						<button type="button" class="btn btn-primary" id="submitOk">Submit</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>