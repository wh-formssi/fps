<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<style type="text/css">
	/**悬浮菜单图标合集**/
	#PointIcon .icon-node{
		margin:5px 0px 5px 10px;
		padding:5px 0px;
		border:1px solid #F2E2D7;
		height:55px;
		width:100px;
		float:left;
		text-align:center;
		border-radius:5px;
		cursor:pointer;
	}
	#PointIcon .icon-node:hover{
		border:1px solid #C01A3F;
	}
	#PointIcon .icon-node i{
		margin:0px;
		padding:0px;
		height:32px;
		width:32px;
		display:inline-block;
	}
	#PointIcon .icon-node input{
		font-size:10px;
		border:0px solid red;
		cursor:pointer;
	}
	/**悬浮菜单图标合集**/
	#PointIconPreview .icon-node{
		margin:5px 0px 5px 10px;
		padding:5px 0px;
		border:1px solid #F2E2D7;
		height:55px;
		width:100px;
		float:left;
		text-align:center;
		border-radius:5px;
		cursor:pointer;
	}
	#PointIconPreview .icon-node:hover{
		border:1px solid #C01A3F;
	}
	#PointIconPreview .icon-node i{
		margin:0px;
		padding:0px;
		height:32px;
		width:32px;
		display:inline-block;
	}
	#PointIconPreview .icon-node input{
		font-size:10px;
		border:0px solid red;
		cursor:pointer;
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/view/common/includer/page-includer.jsp"></jsp:include>
<title>快捷菜单设置</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true" style="padding-top:10px;">
		<div data-options="region:'center',border:false">
			<div class="bf4j-warp" >
				<!-- 导航页面 -->
				<jsp:include page="/WEB-INF/view/common/leader/leaderView.jsp"></jsp:include>
				<div class="easyui-layout" data-options="fit:true" style="padding-top:10px;height: 600px; ">
					<div data-options="region:'west',title:'菜单树'"  style="width:270px;padding-top:10px;">
						<div class="bf4j-warp" >
							<input id="searchArea"></input> 
							<div id="displayType" style="width:120px"> 
								<div data-options="name:'0'"><font style="color: black">全部　</font></div> 
								<div data-options="name:'1'"><font style="color: black">已收藏</font></div>
								<div data-options="name:'2'"><font style="color: black">未收藏</font></div> 
							</div>
							<ul id="tree"></ul>
						</div>
					</div>
					<div data-options="region:'center',title:'快捷菜单预览'" style="padding-left:30px;border-left:0px;" id="favPreviewDiv">
						<div class="bf4j-warp">
							<div class="bf4j-group" id="PointIconPreview"></div>
							<div class="bf4j-group" id="iconSort" style="display: none;">
								<div class="bf4j-line">
									<div class="bf4j-cell bf4j-sc23 bf4j-right">
										<a class="bf4j-btn-2 saveSort" title="保存修改"> <i
											class="bf4j-icon-btn-save" style="height: 17px;"></i>保存修改</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="popupMenuAdd" class="easyui-menu" style="width: 120px; display: none;">
					<div class="gotoAdd" data-options="iconCls:'bf4j-icon-right-add'">添加快捷菜单</div>
				</div>
				<div id="popupMenuEdit" class="easyui-menu" style="width: 120px; display: none;">
					<div class="gotoUpdate" data-options="iconCls:'bf4j-icon-right-edit'">修改快捷菜单</div>
					<div class="doDelete" data-options="iconCls:'bf4j-icon-right-delete'">删除快捷菜单</div>
				</div>
				<div id="dialog" class="bf4j-esc"> </div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src='<b:path url="favorites{min}.js"/>'></script>
</body>
</html>