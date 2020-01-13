/**
 * Copy Right Information : Forms Syntron <br>
 * Project : 四方精創 Java EE 開發平臺 <br>
 * Description : 使用require定義國際化資源模組<br>
 * Author : LinJisong <br>
 * Version : 1.0.0 <br>
 * Since : 1.0.0 <br>
 * Date : 2016-4-5<br>
 */
define({
	form	:	{
		login	:	{
			username	:	'用戶名',
			password	:	'密　碼'
		}
	},
	title	:	{
		add	:	'添加',
		edit:	'編輯',
		remove:	'刪除',
		detail: '明細',
		home  : '首頁',
		lang  : '語言切換',
		search  : '搜索條件',
		naddress  : '當前位置',
		systemTip :'系統提示',
		systemError :'系統錯誤',
		systemWarning:'操作提醒',
		systemConfirm:'系統確認',
		pleaseWait:   '請稍後',
		tipDetail :   '提示詳情'
	},
	label   :   {
		all :   '全部',
		pub :   '公共',
		pleaseSelect : ' 請選擇   '
	},
	button	:	{// 按鈕
		find:	'查  找',
		add:	'新  增',
		insert:	'添  加',
		reset:	'重  置',
		submit:	'提  交',
		cancel:	'取  消',
		save:	'保  存',
		edit:	'修  改',
		remove:	'刪  除',
		login:	'登  錄',
		close:	'關  閉',
		look:	'查  看',
		submitSearch:'提交查詢'
	},
	check	:	{// 表單檢驗
		pleaseInput	:	'請輸入“{1}”！',
		pleaseSelect:	'請選擇“{1}”！'
	},
	operate		:	{// 操作提示
		edit			:	'請選擇1條記錄進行修改！',
		selectToRemove	:	'請選擇要刪除的記錄！',
		remove			:	'您確定要刪除所選的{1}條記錄嗎?',
		removeOk   	    :	'操作成功，成功刪除{1}條記錄！',
		nothingRole		:	'操作許可權尚未開通！',
		openTabMax		:	'您打開的頁面數量已經達到最大限制，請關閉一些頁面後再試。',
		exitSytem       :   '確認退出系統？',
		closeHome       :   '您確定要關閉首頁嗎？',
		notClose        :   '{1}不可以被關閉！',
		doOk            :   '操作成功！',
		doFail          :   '操作失敗！',
		load			:	'加載中...',
		systemDo		:	'系統正在處理中...',
		selectToRecord	:   '請選擇需要操作的記錄',
		selectRecordToMore : '選擇的記錄條數過多，每次只能選擇一條記錄操作',
		uploadsuccess   :    "上傳成功",
		msginfo   :    "資訊提示：{1}。"
	},
	error	:	{// 異常提示
		loadtype		:	'不支持的資源類型，無法加載！',
		loadjs			:	'加載JS腳本失敗：{1}',
		loadcss			:	'加載CSS樣式表失敗：{1}',
		loadData		:	'加載數據異常！',
		loadnoregister	:	'要加載的模組 {1} 尚未註冊！',
		requestError	:	'請求數據格式非法！',
		pageNotFound	:	'頁面未找到!',
		serverError		:	'伺服器異常！',
		loadError		:	'加載出現錯誤，請聯繫管理員',
		requestTimeout  :   '請求超時，請重新操作。',
		ajaxSubtmitError:   'Ajax提交出現錯誤，URL：{1}',
		ajaxDebugError  :   'Ajax調試出現錯誤，URL：{1}，{2}',
		ajaxSubmitError :   'Ajax提交表單出現錯誤，URL：{1}',
		inputContentError:  '輸入內容不正確。',
		hasObject		:   '已經存在對象 {1}，請檢查...',
		notFindKey      :   '未找到鍵值為{1}的參數。',
		notFindNode     :   '未找到節點{1}。',
		uploadfail      :   "上傳失敗",
		uploadunsuport  :   "上傳插件環境檢測不通過"
		
	},
	validate :	{
		select			:	'請選擇',
		file			:	'至少選擇一個上傳檔',
		engNum			:	'請輸入英文字母或數字',
		chsEngNum		: 	'只允許漢字、英文字母或數字',
		name			:	'用戶名不合法(字母開頭，允許4-16位元組，允許字母數字下劃線)',
		code			:	'只允許漢字、英文字母、數字及下劃線',
		minLength		:	'最少輸入 {0}個字元.',
		maxLength		:	'最多輸入 {0}個字元.',
		tel				:	'輸入的內容必須是電話號碼(中國)格式.',
		mobile			:	'輸入的內容必須是移動電話號碼(中國)格式.',
		telOrMobile		:	'輸入的內容必須是電話號碼(中國)或移動電話號碼(中國)格式.',
		fax				:	'輸入的內容必須是傳真號碼(中國)格式.',
		zipCode			:	'輸入的內容必須是郵遞區號(中國)格式.',
		incorrect		:	'輸入內容不正確...',
		same			:	'兩次輸入不一致！',
		contains		:	'輸入的內容必須包含 {0}.',
		startsWith		:	'輸入的內容必須以 {0} 作為起始字元.',
		endsWith		:	'輸入的內容必須以 {0} 作為起始字元.',
		longDate		:	'輸入的內容必須是長日期時間(yyyy-MM-dd hh:mm:ss)格式.',
		shortDate		:	'輸入的內容必須是短日期(yyyy-MM-dd)格式.',
		existChinese	:	'輸入的內容必須是包含中文漢字.',
		chinese			:	'輸入的內容必須是純中文漢字.',
		english			:	'輸入的內容必須是純英文字母.',
		fileName		:	'輸入的內容必須是合法的檔案名(不能包含字元 \\/:*?\'<>|).',
		ip				:	'輸入的內容必須是正確的 IP地址v4 格式.',
		url				:	'輸入的內容必須是正確的 url 格式.',
		qq				:	'輸入的內容必須是正確 QQ 號碼格式.',
		carNo			:	'輸入的內容必須是合法的汽車車牌號碼格式.',
		carEngineNo		:	'輸入的內容必須是合法的汽車發動機序列號格式.',
		idCard			:	'輸入的內容必須是合法的身份證號碼(中國)格式.',
		integer			:	'輸入的內容必須是合法的整數格式.',
		integerRange	:	'輸入的內容必須是合法的整數格式且值介於 {0} 與 {1} 之間.',
		numeric			:	'輸入的內容必須是指定類型的數字格式.',
		numericRange	:	'輸入的內容必須是指定類型的數字格式且介於 {0} 與 {1} 之間.',
		onefile			:	'選擇檔過多，只支持上傳一個檔'
	},
	demo    :  { //DEMO
		title  :{
			add:'新增產品',
			update:'修改產品',
			remove:'刪除產品',
			detail:'產品資訊'
		},
		product:{//DEMO 產品資訊
			name:'產品名稱',
			type:'產品類型',
			count:'產品數量',
			oldprice:'原價（元）',
			newprice:'現價（元）',
			address:'產品地址',
			description:'產品描述',
			remark:'備註'
		}
	},

	
	//平臺系統參數，防止與
	system  :  {
		main :{
			noteice 	: '公告',
			memo		: '備忘錄'
		},
		news  :{
			title  :{
				msgTitle:'消息標題',
				msgTypeName:'消息類型',
				msgLevelName:'消息級別',
				msgContent:'消息內容',
				sendOper:'發佈人',
				sendDate:'發佈日期',
				sendTime:'發佈時間'
			},
			content  :{
				addTitle:'新增消息',
				editTitle:'修改消息',
				detailTitle:'消息詳細'
			}
		},
		document:{
			title:{
				docName:'文檔名稱',
				suffix:'檔尾碼',
				checkSumType: '檔校驗類型',
				checkSum: '檔校驗值',
				docSize:'文檔大小',
				docType:'文檔類型',
				docState:'文檔狀態',
				instOper:'上傳用戶',
				instDate:'上傳日期'
			},
			content:{
				addTitle:'新增文檔',
				editTitle:'修改文檔',
				detailTitle:'文檔詳細',
				notNeedUnLock:"當前狀態已啟用，無需解鎖",
				notNeedLock:"當前狀態已鎖定，無需再次鎖定",
				dbtile:"雙擊刪除",
				process:"已上傳",
				param:"傳遞的參數當中，文檔編號為空，刪除失敗",
				undownload:"當前狀態已鎖定，暫不支持下載"
			}
		},
		menu :{
			favorites:{
				success		: '收藏成功',
				failure		: '收藏失敗',
				notSupport	: '該菜單不支持收藏',
				isExist	: '該菜單已經收藏'
			}
		},
		taskrule :{
			title:{
				limitusers	: '限定用戶',
				limitorgs	: '限定機構',
				limitroles	: '限定角色',
				linkdetail	: '進入明細',
                detailmenuname: '明細菜單',
				islinkdetail: '是否進入明細頁面',
				modify		: '修改任務節點',
				insert		: '新增任務節點',
				gotoadduser	: '新增用戶',
				userId		: '用戶ID：',
				userName	: '  用戶姓名：'
			},
			content:{
				userexists	: '以下用戶已添加或已存在\r\n{1}',	
				yes			: '是',
				no			: '否',
				deleteAllUser: '您確定要刪除選擇的所有已選擇的用戶點嗎？',
				doadd		: '您確定要添加該規則嗎？',
				doupdate	: '您確定要更新該規則嗎？',
				notseletuser: '當前未選擇用戶，請選擇',
				doOk		: '操作成功，可繼續添加;\r\n無需添加請點擊關閉'
			},
			validate:{
				tasknodenotnull : '任務節點不能為空' 
			}
		},
		multiuploader : {
			success    : " 上傳成功,檔ID：{1}",
			dbclickdel : "雙擊刪除",
			del        : "檔{1}從佇列移除",
			uploading  : " 正在上傳 : {1}%",
			checkerror : "上傳插件環境檢測不通過",
			
		},
		/*gcl*/

		sysmanager : {
			user : {
				username : '用戶名稱',
				nickName : '用戶昵稱',
				status : '狀態',
				agencyNumber : '機構號',
				IDType : '證件類型',
				IDNumber : '證件號碼',
				mobileTelephone : '移動電話',
				phoneNumber : '電話號碼',
				emailAddress : '電子郵箱',
				limitationIP : '受限IP',
				MaximumSessionNumber : '最大會話數',
				theLockSymbol : '鎖定標誌',
				LockTheDate : '鎖定日期',
				lockingTime : '鎖定時間',
				TryLoginFrequency : '已嘗試登錄次數',
				FinallyLoginIP : '最後登錄IP',
				lastvisitDate : '最後登錄日期',
				LastLoginTime : '最後登錄時間',
				LastChangePassword : '最後修改密碼日期',
				changeThePasswordTime : '最後修改密碼時間',
				adduser : '新增用戶',
				usermod : '修改用戶',
				roleName : '角色名稱',
				remove1 : '您確定要刪除選擇的',
				remove2 : '個用戶嗎?',
				removeS : '操作成功，成功刪除',
				removeS2 : '個用戶'
			},
			onlineuser : {
				SessionID : '會話ID',
				username : '用戶名稱',
				agencyNumber : '機構號',
				serverIP : '服務端IP',
				clientIP : '客戶端IP',
				browser : '流覽器',
				operatingSystem : '操作系統',
				entryDate : '登錄日期',
				LogonTime : '登錄時間',
			},
			role : {
				RoleCode : '角色代碼',
				roleName : '角色名稱',
				describe : '描述',
				AddRoles : '新增角色',
				modifyRole : '修改角色',
				authorizationID : '許可權ID',
				menu : '菜單',
				menuID : '菜單ID',
				remove1 : '您確定要刪除選擇的',
				remove2 : '個角色嗎?',
				removeS : '操作成功，成功刪除',
				removeS2 : '個角色',
				RoleAssignment : '角色(分配)名稱',
				menutype : '菜單顯示屬性',
				operability : '顯示可操作',
				uoperability : '顯示不可操作',
				choose : '請選擇',
			},
			roleallot : {
				describe : '描述',
				RoleAssignment : '角色(分配)代碼',
				assignmentName : '角色(分配)名稱',
				rolesAssignments : '新增角色(分配)',
				ModifyRoles : '修改角色(分配)',
				remove1 : '您確定要刪除選擇的',
				remove2 : '個角色(分配)嗎？',
				removeS : '操作成功，成功刪除 ',
				removeS2 : '個角色(分配)',
				authorizationID : '許可權ID',
				menu : '菜單',
				menuID : '菜單ID',
			},
			rolelimit : {
				describe : '描述',
				role : '角色',
				tot1 : '(共',
				tot2 : '個角色)',
				NewRole : '新增角色約束',
				RoleConstraints : '角色約束',
				CharacterName : '角色名稱',
				RoleDescription : '角色描述',
				ModifyRoleConstraint : '修改角色約束',
				check1 : '請勾選組成約束的角色，至少勾選',
				check2 : '個角色',
				remove1 : '您確定要刪除選擇的',
				remove2 : '組角色約束嗎？',
				removeS : '操作成功，成功刪除 ',
				removeS2 : '組角色約束',
			},
			param:{
				enum:{
					ParametersCode:'參數代碼',
					parameterName:'參數名稱',
					section:'所屬組別',
					parameterCharacteristics:'參數特性',
					Canedit:'可否編輯',
					yes:'是',
					no:'否',
					definition:'新增參數定義',
					compile:'編輯參數定義',
					detail:'編輯列表型參數明細',
					dataCode:'數據代碼',
					TextData:'數據文本',
					DataParameter:'數據參數',
					orderNumber:'序號',
					describe:'描述',
					treeParameter:'編輯樹型參數明細',
					saveSuccessfully:'保存成功！',
					 noContent:'沒有要保存的內容！',
					 remove1:'您確定要刪除選擇的',
					 remove2:'個參數項嗎？',
					 removeS:'操作成功，成功刪除 ',
					 removeS2:'個參數項',
					 succeed1:'已經添加成功',
					 succeed2:'修改成功!',
					 node :'節點',
					 DragTheSuccess :'拖動成功',
					 sureToDelete:'您確定要刪除所選的',
					 sureToDelete2:'及其所有子節點',
					 succeedRemove:'成功刪除',
					
				},
				difine:{
					yes:'是',
					no:'否',
					describe:'描述',
					ParametersCode:'參數代碼',
					parameterName:'參數名稱',
					ParametersGroup:'參數組別',
					ParameterStorageType:'參數存儲類型',
					Canedit:'可否編輯',
					AddParameterDefinitions:'添加參數定義',
					ModifyParameterDefinition:'修改參數定義',
					unmodified:'您未做任何修改',
					remove1:'您確定要刪除選擇的',
					remove2:'個參數項嗎？',
					removeS:'操作成功，成功刪除 ',
					removeS2:'個參數',
					
				}
			},
			holiday:{
				PleaseSelectDate:'請選擇日期'
			},
			org:{
				remove1:'您確定要刪除所選的',
				remove2:'及其所有子機構',
				succeedRemove:'成功刪除',
				orgQ1:'您確定要將',
				orgQ2:'拖至',
				orgQ3:'下嗎？',
			},
			syslog:{
				login:{
					 logout:'用戶登出',
					 TimeoutLogout:'超時登出',
					 SessionID:'會話ID',
					 userId:'用戶ID',
					 username:'用戶名稱',
					 agencyNumber:'機構號',
					 OrganizationNames:'機構名稱',
					 serverIP:'服務端IP',
					 clientIP:'客戶端IP',
					 browser:'流覽器',
					 operatingSystem:'操作系統',
					 entryDate:'登錄日期',
					 LogonTime:'登錄時間',
					 LogOutDate:'登出日期',
					 LogOutTime:'登出時間',
					 AppropriateType:'登出類型',
				},
				visit:{
					through:'通過',
					Refused:'拒絕',
					SessionID:'會話ID',
					 userId:'用戶ID',
					 username:'用戶名稱',
					 agencyNumber:'機構號',
					 OrganizationNames:'機構名稱',
					 AuthorizationID:'許可權ID',
					 serverIP:'服務端IP',
					 clientIP:'客戶端IP',
					 browser:'流覽器',
					 operatingSystem:'操作系統',
					 authorizationResult:'授權結果',
					 menuPath:'菜單路徑',
					 accessURL:'訪問URL',
					 operationDate:'操作日期',
					 operatingTime:'操作時間',
					 operatingTime2:'操作耗時',
					
				}
			},
			cache:{
				cacheName:'緩存名稱',
				cacheType:'緩存類型',
				isKinematic:'是否動態',
				Kb:'緩存容量',
				cached:'已緩存數',
				visits:'訪問次數',
				hitCounts:'命中次數',
				attributes:'特徵屬性',
				describe : '描述',
				wipeCache:'清空緩存',
				remove1:'您確定要移除所選的',
				remove2:'條緩存條目嗎？',
				checkRe:'請勾選需要移除的緩存條目！',
				sureReAll:'您確定要清除所有緩存嗎？',
				sureRe:'您確定要清除緩存',
				checkAll:'全選',
				removeChecked:'移除所選條目',	
			},
			taskrule:{
				user:{
					username:'用戶名稱',
					nickName : '用戶昵稱',
					status : '狀態',
					startUsing:'啟用',
					stop:'停用',
					agencyNumber:'機構號',
				},
				taskrule:{
					nodeCode:'任務節點代碼',
					nodeName:'任務節點名稱',
					LimitedRole:'限定角色',
					QualifiedInstitutions:'限定機構',
					QualifiedPerson:'限定人',
					EnterTheDetails:'進入明細',
					username:'用戶名稱',
					roleName:'角色名稱',
					organizationID:'機構ID',
					organization:'機構',
				}
				
			},
			menulocale:{
				guide:{
					menuName:'菜單名稱:',
					alertmm:'請先修改輸入框中的該數據再執行保存操作。',
				},
				locale:{
					menu:'菜單',
					alertOut:'數據已經更改，是否提交已修改數據？',
					alertOk:'請先修改表格中的數據再進行保存操作。',
					alertIng:'請先選中一行進行編輯。',
					notBeingEdited:'沒有正在編輯的行！',
				}
			},
			maintenance:{
				roleID:'角色ID',
				roleName:'角色名稱',
				roleName2:'角色(分配)名稱',
				addRole:'新增角色和角色(分配)的關係',
				checkRole:'請勾選至少一個角色(分配)!',
				modificationRole:'修改角色和角色(分配)的關係', 
				removeRole:'您將刪除此關係!請勾選至少一個角色(分配)!',
				notMake:'您未做任何修改!',
				remove1:'您確定要刪除選擇的所有與',
				remove2:'關聯的角色(分配)關係嗎？',
				removeS:'操作成功，已刪除 ',
				removeS2:'組角色與角色(分配)關係',
				roleID2:'角色(分配)ID',
				roleName2:'角色(分配)名稱',
				
			}

		}
	
	},
	logout : {
		beforeunloadtitle : "確定退出嗎？"
	},
	ffp : {
		common : {
			constant : {
				CREAT:'創建',
				APPST:'等待',
				TMOUT:'超時',
				COMPL:'完成',
				RJCT:'拒絕',
				PROCE:'處理中',
				ERROR:'錯誤',
			}
		},
		cashmanagement : {
			return_refund:{
				jnlNo:"流水號",
				refund:'退款',
				Arefund :'確定退款? ',
				debtorName:'付款方名稱',
				debtorAcctno:'付款方賬號',
				creditorName:'收款方名稱',
				creditorAcctno:'收款方賬號',
				settlementAmt:'付款金額',
				settlementDate:'付款日期'
			},
			otherbankmode : {
				clearingCode:'清算行代碼',
				receiptMode:'接收模式',
				lastUpdateTs:'最後更新時間',
			},
			transactionstatus : {
				jnlNo:'交易流水號號',
				txStat:'交易狀態',
				transactionId:'交易唯一編碼',
				clrSysRef:'清算參考編碼',
				dbtrAgtMmbId:'扣款方清算編號',
				cdtrAgtMmbId:'收款方清算編號',
				createTs:'創建日期'

			},
			fpspaymentnotification :{
				msgId:'報文編號', 
				ntfctnId: '通知編號',
				ntfctnCreateTs: '通知建立時間',
				ntfctnAcctId: 'FPS帳號',
				ntfctnAcctType: '帳號類型',
				ntfctnAmt: '金額',
				paymentCag: '類別',
				paymentEndToEndId: 'END TO END ID',
				paymentTxId: '交易編號',
				paymentClrSysRef: 'FPS結算號',
				paymentDbtr: '扣賬方',
				paymentCdtr: '入賬方',
				settlementTs: '結算日期',
			},
		},
		systemmaintenance : {
			cutoff : {
				title  :{
					amendtitle:'維護時間修改',
					cutofftype:'類別名稱',
					workdayStart:'工作日開始時間',
					workdayEnd:'工作日結束時間',
					satStart:'週六開始時間',
					satEnd:'週六結束時間',
					holidayStart:'假期開始時間',
					holidayEnd:'假期結束時間'
				}
			},
			systemstat : {
				switchmode : {
					BTCH : '切換為即時模式',
					RLTM : '切換為批處理模式',
					RLTMP: '處理中...',
					BTCHP: '處理中...',
				},
				switchListener:{
					R : '停止監聽',
					C : '啟動監聽',
					RP : '監聽啟動中...',
					CP : '監聽停止中...',
				},
				switchController:{
					R : '停止控制器',
					C : '啟動控制器',
				},
				confirm1: '您確定要',
				confirm2: '嗎？',
				alertMsg1 : '請先啟動即時監聽程式!',
				alertMsg2 : '請先更新接收模式為批處理!',
				processing : '處理中,請稍後...',
			},
		},
		transaction  :{
			jnlNo:"流水號",
			remarks:"評論",
			txStat:"交易狀態",
			txSrc:"起始地",
			transactionId:"交易Id",
			endToEndId:"端對端",
			msgId:"報文id",
			msgFromType:"msgFromType",
			msgFrom:"msgFrom",
			msgToType:"msgToType",
			msgTo:"msgTo",
			msgType:"msgType",
			msgStatus:"msgStatus",
			debtorName:"debtorName",
			debtorAcctno:"debtorAcctno",
			debtorAcctnoType:"debtorAcctnoType",
			debtorAgtId:"debtorAgtId",
			debtorAgtBic:"debtorAgtBic",
			creditorName:"creditorName",
			creditorAcctno:"creditorAcctno",
			creditorAcctnoType:"creditorAcctnoType",
			creditorAgtId:"creditorAgtId",
			creditorAgtBic:"creditorAgtBic"
		},
		title:{
			detail:"詳情",
			Del:"刪除",
			count:"product count",
			oldprice:"old price",
			newprice:"now price",
			address:"product address",
			description:"product description",
			remark:"remark"
		}
	},

	
});