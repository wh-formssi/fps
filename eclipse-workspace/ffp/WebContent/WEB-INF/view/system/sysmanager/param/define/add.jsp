<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<form id="addForm" method="post" style="width: 97%; text-align: center;">
	<div class="bf4j-group">
		<div class="bf4j-group-content">
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.paramCode" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input">
					 <input type="text"
						name="paramCode" class="easyui-validatebox" style="width: 90%"
						data-options="required:true,missingMessage:'<spring:message code="system.sysmanager.param.define.paramCodeMiss" />',invalidMessage:'输入格式不正确,参数代码长度在4-32个字符之间.', validType:'length[4,32]'" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.paramName" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					<input type="text"
						name="paramName" class="easyui-validatebox" style="width: 90%"
						data-options="required:true,missingMessage:'<spring:message code="system.sysmanager.param.define.paramNameMiss" />'" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.storeType" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					 <input class="bf4j-combo"
						combo-options="extra:'select',dataKey:'STORE_TYPE'"
						data-options="required:true" name="storeType" style="width: 195%;" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.paramGroup" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					 <input class="bf4j-combo"
						combo-options="extra:'select',dataKey:'PARAM_GROUP'"
						data-options="required:true,missingMessage:'<spring:message code="system.sysmanager.param.define.paramCode" />'"
						name="paramGroup" style="width: 195%;" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.dataType" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					 <input class="bf4j-combo"
						combo-options="extra:'select',dataKey:'DATA_TYPE'"
						data-options="required:true" name="dataType" style="width: 195%;" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.editable" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input">
					 <input class="bf4j-combo"
						combo-options="extra:'select',dataKey:'BOOLEAN'"
						data-options="required:true" style="width: 195%;" name="editable" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.defaultValue" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					 <input type="text"
						name="defaultValue" class="easyui-validatebox" style="width: 90%" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.valueRule" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					 <input type="text"
						name="valueRule" class="easyui-validatebox" style="width: 90%" />
					</span>
				</div>
			</div>
			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label style="width: 90%"><spring:message code="system.sysmanager.param.define.valueRuleParam" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					 <input type="text"
						name="valueRuleParam" class="easyui-validatebox"
						style="width: 90%" />
					</span>
				</div>
			</div>

			<div class="bf4j-line">
				<div class="bf4j-cell bf4j-c4">
					<label><spring:message code="system.sysmanager.param.define.des" /></label>
				</div>
				<div class="bf4j-cell bf4j-c7">
					<span class="bf4j-input"> 
					 <textarea name="des"
							class="easyui-validatebox"
							style="width: 89%; height: 60px; font-family: Arial;"></textarea>
					</span>
				</div>
			</div>
		</div>
	</div>
</form>
