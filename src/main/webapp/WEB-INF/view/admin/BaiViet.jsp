<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bai Viet</title>
</head>
<body ng-app="myApp">
	<div ng-controller="BaiVietController as ctrl">
		<div>
			<h2>Form of BaiViet</h2>
			<div>
				<form ng-submit="ctrl.submit()" name="myForm">
					<input type="hidden" ng-model="ctrl.baiviet.maBV" />
					
					<div>
						<label>Tieu De</label>
						<div>
							<input type="text" ng-model="ctrl.baiviet.tieuDe" name="btieude" required ng-minlength="5" />
							<div ng-show="myForm.$dirty">
								<span ng-show="myForm.btieude.$error.required">La truong bat buoc</span>
								<span ng-show="myForm.btieude.$error.minlength">Bat buoc tren 4 ky tu</span>
								<span ng-show="myForm.btieude.$error.invalid">Khong hop le</span>
							</div>
						</div>
					</div>
					
					<div>
						<label>Danh Muc</label>
						<div>
							<input type="text" ng-model="ctrl.baiviet.danhMuc" name="bdanhmuc" required ng-minlength="5" />
							<div ng-show="myForm.$dirty">
								<span ng-show="myForm.bdanhmuc.$error.required">La truong bat buoc</span>
								<span ng-show="myForm.bdanhmuc.$error.minlength">Bat buoc tren 4 ky tu</span>
								<span ng-show="myForm.bdanhmuc.$error.invalid">Khong hop le</span>
							</div>
						</div>
					</div>
					
					<div>
						<label>Chi Tiet</label>
						<div>
							<input type="text" ng-model="ctrl.baiviet.chiTiet" name="bchitiet" required ng-minlength="5" />
							<div ng-show="myForm.$dirty">
								<span ng-show="myForm.bchitiet.$error.required">La truong bat buoc</span>
								<span ng-show="myForm.bchitiet.$error.minlength">Bat buoc tren 4 ky tu</span>
								<span ng-show="myForm.bchitiet.$error.invalid">Khong hop le</span>
							</div>
						</div>
					</div>
					
					<div>
						<label>Lich Dang</label>
						<div>
							<input type="text" ng-model="ctrl.baiviet.lichDang" name="blichdang" required ng-minlength="5" />
							<div ng-show="myForm.$dirty">
								<span ng-show="myForm.blichdang.$error.required">La truong bat buoc</span>
								<span ng-show="myForm.blichdang.$error.minlength">Bat buoc tren 4 ky tu</span>
								<span ng-show="myForm.blichdang.$error.invalid">Khong hop le</span>
							</div>
						</div>
					</div>
					
					<div>
						<label>Trang Thai</label>
						<div>
							<input type="text" ng-model="ctrl.baiviet.trangThai" name="btrangthai" required ng-minlength="5" />
							<div ng-show="myForm.$dirty">
								<span ng-show="myForm.btrangthai.$error.required">La truong bat buoc</span>
								<span ng-show="myForm.btrangthai.$error.minlength">Bat buoc tren 4 ky tu</span>
								<span ng-show="myForm.btrangthai.$error.invalid">Khong hop le</span>
							</div>
						</div>
					</div>
					
					<div>
						<label>Nhan</label>
						<div>
							<input type="text" ng-model="ctrl.baiviet.nhan" name="bnhan" required ng-minlength="5" />
							<div ng-show="myForm.$dirty">
								<span ng-show="myForm.bnhan.$error.required">La truong bat buoc</span>
								<span ng-show="myForm.bnhan.$error.minlength">Bat buoc tren 4 ky tu</span>
								<span ng-show="myForm.bnhan.$error.invalid">Khong hop le</span>
							</div>
						</div>	
					</div>
					
					<div>
						<input type="submit"  value="{{!ctrl.baiviet.maBV ? 'Add' : 'Update'}}" ng-disabled="myForm.$invalid">
	                    <button type="button" ng-click="ctrl.reset()" ng-disabled="myForm.$pristine">Reset Form</button>
					</div>
					
				</form>
			</div>
		</div>
		<div>
			<h2>List of BaiViets</h2>
			<div>
				<table border="1">
				    <thead>
				        <tr>
				            <th>MaBV</th>
							<th>Tieu De</th>
							<th>Danh Muc</th>
							<th>Chi Tiet</th>
							<th>Lich Dang</th>
							<th>Trang Thai</th>
							<th>Nhan</th>
				            <th></th>
				        </tr>
				    </thead>
				    <tbody>
				        <tr ng-repeat="b in ctrl.baiviets">
				            <td><span ng-bind="b.maBV"></span></td>
				            <td><span ng-bind="b.tieuDe"></span></td>
				            <td><span ng-bind="b.danhMuc"></span></td>
				            <td><span ng-bind="b.chiTiet"></span></td>
				            <td><span ng-bind="b.lichDang"></span></td>
				            <td><span ng-bind="b.trangThai"></span></td>
				            <td><span ng-bind="b.nhan"></span></td>
				            <td>
					            <button type="button" ng-click="ctrl.update(b.maBV)">Edit</button>
					            <button type="button" ng-click="ctrl.remove(b.maBV)">Remove</button>
				            </td>
				        </tr>
				    </tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="<c:url value='/static/js/angular.min.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/baiviet_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/baiviet_controller.js' />"></script>
</body>
</html>