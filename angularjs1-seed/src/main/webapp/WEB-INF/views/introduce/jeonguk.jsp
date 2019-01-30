<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
    <meta charset="utf-8">
</head>
<body ng-controller="JeonukCtrl">
<div class="row m-t-5">
    <div class="col-12 ">
        <h4>{{ $root.commonText }}</h4>
    </div>
</div>
<div class="row simple-cards users-card">
    <div class="col-md-4 col-lg-4 col-sm-12">
        <div class="card user-card">
            <div class="card-header-img">
                <img class="img-fluid img-radius" src="${pageContext.request.contextPath }/resources/files/assets/images/user-card/img-round5.gif" alt="card-img">
                <h4>임정욱</h4>
                <h5>bonazo@naver.com</h5>
                <h6>SW연구센터</h6>
            </div>
            <div class="row justify-content-center">
                <div class="col-auto">
                    <div class="label-icon">
                        <i class="icofont icofont-bell-alt"></i>
                        <label class="badge badge-primary badge-top-right">9</label>
                    </div>
                </div>
                <div class="col-auto">
                    <div class="label-icon">
                        <i class="icofont icofont-heart"></i>
                        <label class="badge badge-success badge-top-right">9</label>
                    </div>
                </div>
                <div class="col-auto">
                    <div class="label-icon">
                        <i class="icofont icofont-bag-alt"></i>
                        <label class="badge badge-danger badge-top-right">9</label>
                    </div>
                </div>
                <div class="col-auto">
                    <div class="label-icon">
                        <i class="icofont icofont-ui-message"></i>
                        <label class="badge badge-info badge-top-right">9</label>
                    </div>
                </div>
            </div>
            <p>{{ introduce.text }}</p>
            <div>
                <button type="button" class="btn btn-success waves-effect waves-light"><i class="icofont icofont-user m-r-5"></i>Profile</button>
            </div>
        </div>
    </div>
    <div class="container col-md-8 col-lg-8 col-sm-12 row-md-8">
        <table class="table table-hover bg-white">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">제목</th>
                <th scope="col">수정일</th>
                <th scope="col">작업</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="boardList in boardLists">
                <th scope="row"><input type="checkbox"></th>
                <td><a href="javascript:" >{{boardList.title}}</a></td>
                <td>{{boardList.reg_date}}</td>
                <td><button type="button" class="btn btn-success waves-effect waves-light" data-toggle="modal" data-target="#myModal{{boardList.id}}">상세보기</button>
					<button ng-show="$root.currentUser=='jeonguk-im'" ng-click="" type="button" class="btn btn-danger waves-effect waves-light" >삭제</button>
						<div class="modal fade" id="myModal{{boardList.id}}" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">{{boardList.title}}</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										
									</div>
									<div class="modal-body">
										<textarea>{{boardList.content}}</textarea>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>

							</div>
						</div>
						</td>
					</tr>
            </tbody>
        </table>
        <div>
		<button type="button" class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-target="#myModal{{boardList.id}}">글쓰기</button>
   		</div>
    </div>
    
</div>


</body>
</html>