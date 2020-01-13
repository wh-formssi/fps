<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<div class="easyui-layout" data-options="fit:true"
	style="width: 100%; height: 400px">
	<form id="detailForm" class="easyui-form" method="post">
		<div data-options="region:'center'" style="width: 100%; height: 400px">
			<input type="hidden" name="jnlNo" value="${data.jnlNo}">
			<div class="easyui-tabs"
				data-options="plain:true,border:false,fit:true"
				style="width: 100%; border: none; height: 100%;">
				<div title="ReturnDetail">
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>debtorName:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.debtorName}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>debtorAgtBic:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.debtorAgtBic}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>debtorAcctnoType:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.debtorAcctnoType}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>debtorAcctno:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.debtorAcctno}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>creditorName:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.creditorName}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>creditorAgtBic:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.creditorAgtBic}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>creditorAcctnoType:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.creditorAcctnoType}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>creditorAcctno:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.creditorAcctno}</label>
						</div>
					</div>

					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>settlementAmt:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.settlementAmt} ${data.settlementCur}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>settlementDate:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.settlementDate}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>rejReason:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.rejReason}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>chgAgtBic:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.chgAgtBic}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>chgAmt:</label>
						</div>
						<div class="bf4j-cell bf4j-c3">
							<label>${data.chgAmt} ${data.chgCur}</label>
						</div>
					</div>
					<div class="bf4j-line">
						<div class="bf4j-cell bf4j-c4">
							<label>ReturnReason：</label>
						</div>
						<div class="bf4j-cell bf4j-c7">
							<span class="bf4j-select"> 
								<select id="cc" class="easyui-combobox" name="retCode" >
									<c:choose>
										<c:when test="${data.txStat != 'COMPL' }">
											<option value="AC01">Incorrect Account Number</option>
											<option value="AC04">Closed Account Number</option>
											<option value="AC04">Wrong Amount</option>
											<option value="BE01">Inconsistent with End Customer</option>
											<option value="CURR">Incorrect Currency</option>
											<option value="TM01">Timeout or After Processing Cut-off Time</option>
										</c:when>
										<c:otherwise>
											<option value="MD06">Refund Request by End Customer</option>
										</c:otherwise>
									</c:choose>
								</select>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

</div>
