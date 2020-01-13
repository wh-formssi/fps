<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<!-- 增加角色与角色(分配)关系页面 -->
<div class="easyui-layout" data-options="fit:true" style="width:600px;height:300px;">
  	<div data-options="region:'west',title:'<spring:message code="system.sysmanager.maintenance.roleInf" />'" style="width:350px;">
  	<!-- 角色新增表单 -->
  		<form id="addForm" class="easyui-form" method="post" style="width: 97%; text-align: center;">
			<div class="bf4j-group">
				<div class="bf4j-group-content">
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label><spring:message code="system.sysmanager.maintenance.roleName" /></label>
						</div>
						<div class="bf4j-cell bf4j-c7">
							<span class="bf4j-input"> 
								<input class="bf4j-combo" id="roleSelect" combo-options="extra:'select'" data-options="required:true" name="roleName" placeholder="<spring:message code="system.sysmanager.maintenance.roleChoose" />" style="width: 100%">
								<!--另一种填充下拉框方法 --> 
								<!--<input id="cc" class="easyui-combobox" name="dept"    -->
								<!--data-options="textField:'text',url:'get_data.php'" /> -->
							</span>
						</div>
					</div>
				</div>
			</div>
		</form>
  	</div>
  	<!-- 角色(分配)列表 -->
  	<div data-options="region:'center',title:'<spring:message code="system.sysmanager.maintenance.roleallotList" />'" style="width:800px;">
  		<table id="roleAllotList" class="bf4j-grid-auto"></table>
  	</div>
</div>  
