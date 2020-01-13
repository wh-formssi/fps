/**
 * Copy Right Information : Forms Syntron <br>
 * Project : 四方精创 Java EE 开发平台 <br>
 * Description : 使用require定义国际化资源模块<br>
 * Author : LinJisong <br>
 * Version : 1.0.0 <br>
 * Since : 1.0.0 <br>
 * Date : 2016-4-5<br>
 */
define({
	form	:	{
		login	:	{
			username	:	'用户名',
			password	:	'密　码'
		}
	},
	title	:	{
		add	:	'添加',
		edit:	'编辑',
		remove:	'删除',
		detail: '明细',
		home  : '首页',
		lang  : '语言切换',
		search  : '搜索条件',
		naddress  : '当前位置',
		systemTip :'系统提示',
		systemError :'系统错误',
		systemWarning:'操作提醒',
		systemConfirm:'系统确认',
		pleaseWait:   '请稍后',
		tipDetail :   '提示详情'
	},
	label   :   {
		all :   '全部',
		pub :   '公共',
		pleaseSelect : ' 请选择   '
	},
	button	:	{// 按钮
		find:	'查  找',
		add:	'新  增',
		insert:	'添  加',
		reset:	'重  置',
		submit:	'提  交',
		cancel:	'取  消',
		save:	'保  存',
		edit:	'修  改',
		remove:	'删  除',
		login:	'登  录',
		close:	'关  闭',
		look:	'查  看',
		submitSearch:'提交查询'
	},
	check	:	{// 表单检验
		pleaseInput	:	'请输入“{1}”！',
		pleaseSelect:	'请选择“{1}”！'
	},
	operate		:	{// 操作提示
		edit			:	'请选择1条记录进行修改！',
		selectToRemove	:	'请选择要删除的记录！',
		remove			:	'您确定要删除所选的{1}条记录吗?',
		removeOk   	    :	'操作成功，成功删除{1}条记录！',
		nothingRole		:	'操作权限尚未开通！',
		openTabMax		:	'您打开的页面数量已经达到最大限制，请关闭一些页面后再试。',
		exitSytem       :   '确认退出系统？',
		closeHome       :   '您确定要关闭首页吗？',
		notClose        :   '{1}不可以被关闭！',
		doOk            :   '操作成功！',
		doFail          :   '操作失败！',
		load			:	'加载中...',
		systemDo		:	'系统正在处理中...',
		selectToRecord	:   '请选择需要操作的记录',
		selectRecordToMore : '选择的记录条数过多，每次只能选择一条记录操作',
		uploadsuccess   :    "上传成功",
		msginfo   :    "信息提示：{1}。"
	},
	error	:	{// 异常提示
		loadtype		:	'不支持的资源类型，无法加载！',
		loadjs			:	'加载JS脚本失败：{1}',
		loadcss			:	'加载CSS样式表失败：{1}',
		loadData		:	'加载数据异常！',
		loadnoregister	:	'要加载的模块 {1} 尚未注册！',
		requestError	:	'请求数据格式非法！',
		pageNotFound	:	'页面未找到!',
		serverError		:	'服务器异常！',
		loadError		:	'加载出现错误，请联系管理员',
		requestTimeout  :   '请求超时，请重新操作。',
		ajaxSubtmitError:   'Ajax提交出现错误，URL：{1}',
		ajaxDebugError  :   'Ajax调试出现错误，URL：{1}，{2}',
		ajaxSubmitError :   'Ajax提交表单出现错误，URL：{1}',
		inputContentError:  '输入内容不正确。',
		hasObject		:   '已经存在对象 {1}，请检查...',
		notFindKey      :   '未找到键值为{1}的参数。',
		notFindNode     :   '未找到节点{1}。',
		uploadfail      :   "上传失败",
		uploadunsuport  :   "上传插件环境检测不通过"
		
	},
	validate :	{
		select			:	'请选择',
		file			:	'至少选择一个上传文件',
		engNum			:	'请输入英文字母或数字',
		chsEngNum		: 	'只允许汉字、英文字母或数字',
		name			:	'用户名不合法(字母开头，允许4-16字节，允许字母数字下划线)',
		code			:	'只允许汉字、英文字母、数字及下划线',
		minLength		:	'最少输入 {0}个字符.',
		maxLength		:	'最多输入 {0}个字符.',
		tel				:	'输入的内容必须是电话号码(中国)格式.',
		mobile			:	'输入的内容必须是移动电话号码(中国)格式.',
		telOrMobile		:	'输入的内容必须是电话号码(中国)或移动电话号码(中国)格式.',
		fax				:	'输入的内容必须是传真号码(中国)格式.',
		zipCode			:	'输入的内容必须是邮政编码(中国)格式.',
		incorrect		:	'输入内容不正确...',
		same			:	'两次输入不一致！',
		contains		:	'输入的内容必须包含 {0}.',
		startsWith		:	'输入的内容必须以 {0} 作为起始字符.',
		endsWith		:	'输入的内容必须以 {0} 作为起始字符.',
		longDate		:	'输入的内容必须是长日期时间(yyyy-MM-dd hh:mm:ss)格式.',
		shortDate		:	'输入的内容必须是短日期(yyyy-MM-dd)格式.',
		existChinese	:	'输入的内容必须是包含中文汉字.',
		chinese			:	'输入的内容必须是纯中文汉字.',
		english			:	'输入的内容必须是纯英文字母.',
		fileName		:	'输入的内容必须是合法的文件名(不能包含字符 \\/:*?\'<>|).',
		ip				:	'输入的内容必须是正确的 IP地址v4 格式.',
		url				:	'输入的内容必须是正确的 url 格式.',
		qq				:	'输入的内容必须是正确 QQ 号码格式.',
		carNo			:	'输入的内容必须是合法的汽车车牌号码格式.',
		carEngineNo		:	'输入的内容必须是合法的汽车发动机序列号格式.',
		idCard			:	'输入的内容必须是合法的身份证号码(中国)格式.',
		integer			:	'输入的内容必须是合法的整数格式.',
		integerRange	:	'输入的内容必须是合法的整数格式且值介于 {0} 与 {1} 之间.',
		numeric			:	'输入的内容必须是指定类型的数字格式.',
		numericRange	:	'输入的内容必须是指定类型的数字格式且介于 {0} 与 {1} 之间.',
		onefile			:	'选择文件过多，只支持上传一个文件'
	},
	demo    :  { //DEMO
		title  :{
			add:'新增产品',
			update:'修改产品',
			remove:'删除产品',
			detail:'产品信息'
		},
		product:{//DEMO 产品信息
			name:'产品名称',
			type:'产品类型',
			count:'产品数量',
			oldprice:'原价（元）',
			newprice:'现价（元）',
			address:'产品地址',
			description:'产品描述',
			remark:'备注'
		}
	},

	
	//平台系统参数，防止与
	system  :  {
		main :{
			noteice 	: '公告',
			memo		: '备忘录'
		},
		news  :{
			title  :{
				msgTitle:'消息标题',
				msgTypeName:'消息类型',
				msgLevelName:'消息级别',
				msgContent:'消息内容',
				sendOper:'发布人',
				sendDate:'发布日期',
				sendTime:'发布时间'
			},
			content  :{
				addTitle:'新增消息',
				editTitle:'修改消息',
				detailTitle:'消息详细'
			}
		},
		document:{
			title:{
				docName:'文档名称',
				suffix:'文件后缀',
				checkSumType: '文件校验类型',
				checkSum: '文件校验值',
				docSize:'文档大小',
				docType:'文档类型',
				docState:'文档状态',
				instOper:'上传用户',
				instDate:'上传日期'
			},
			content:{
				addTitle:'新增文档',
				editTitle:'修改文档',
				detailTitle:'文档详细',
				notNeedUnLock:"当前状态已启用，无需解锁",
				notNeedLock:"当前状态已锁定，无需再次锁定",
				dbtile:"双击删除",
				process:"已上传",
				param:"传递的参数当中，文档编号为空，删除失败",
				undownload:"当前状态已锁定，暂不支持下载"
			}
		},
		menu :{
			favorites:{
				success		: '收藏成功',
				failure		: '收藏失败',
				notSupport	: '该菜单不支持收藏',
				isExist	: '该菜单已经收藏'
			}
		},
		taskrule :{
			title:{
				limitusers	: '限定用户',
				limitorgs	: '限定机构',
				limitroles	: '限定角色',
				linkdetail	: '进入明细',
                detailmenuname: '明细菜单',
				islinkdetail: '是否进入明细页面',
				modify		: '修改任务节点',
				insert		: '新增任务节点',
				gotoadduser	: '新增用户',
				userId		: '用户ID：',
				userName	: '  用户姓名：'
			},
			content:{
				userexists	: '以下用户已添加或已存在\r\n{1}',	
				yes			: '是',
				no			: '否',
				deleteAllUser: '您确定要删除选择的所有已选择的用户点吗？',
				doadd		: '您确定要添加该规则吗？',
				doupdate	: '您确定要更新该规则吗？',
				notseletuser: '当前未选择用户，请选择',
				doOk		: '操作成功，可继续添加;\r\n无需添加请点击关闭'
			},
			validate:{
				tasknodenotnull : '任务节点不能为空' 
			}
		},
		multiuploader : {
			success    : " 上传成功,文件ID：{1}",
			dbclickdel : "双击删除",
			del        : "文件{1}从队列移除",
			uploading  : " 正在上传 : {1}%",
			checkerror : "上传插件环境检测不通过",
			
		},
		/*gcl*/

		sysmanager : {
			user : {
				username : '用户名称',
				nickName : '用户昵称',
				status : '状态',
				agencyNumber : '机构号',
				IDType : '证件类型',
				IDNumber : '证件号码',
				mobileTelephone : '移动电话',
				phoneNumber : '电话号码',
				emailAddress : '电子邮箱',
				limitationIP : '受限IP',
				MaximumSessionNumber : '最大会话数',
				theLockSymbol : '锁定标志',
				LockTheDate : '锁定日期',
				lockingTime : '锁定时间',
				TryLoginFrequency : '已尝试登录次数',
				FinallyLoginIP : '最后登录IP',
				lastvisitDate : '最后登录日期',
				LastLoginTime : '最后登录时间',
				LastChangePassword : '最后修改密码日期',
				changeThePasswordTime : '最后修改密码时间',
				adduser : '新增用户',
				usermod : '修改用户',
				roleName : '角色名称',
				remove1 : '您确定要删除选择的',
				remove2 : '个用户吗?',
				removeS : '操作成功，成功删除',
				removeS2 : '个用户'
			},
			onlineuser : {
				SessionID : '会话ID',
				username : '用户名称',
				agencyNumber : '机构号',
				serverIP : '服务端IP',
				clientIP : '客户端IP',
				browser : '浏览器',
				operatingSystem : '操作系统',
				entryDate : '登录日期',
				LogonTime : '登录时间',
			},
			role : {
				RoleCode : '角色代码',
				roleName : '角色名称',
				describe : '描述',
				AddRoles : '新增角色',
				modifyRole : '修改角色',
				authorizationID : '权限ID',
				menu : '菜单',
				menuID : '菜单ID',
				remove1 : '您确定要删除选择的',
				remove2 : '个角色吗?',
				removeS : '操作成功，成功删除',
				removeS2 : '个角色',
				RoleAssignment : '角色(分配)名称',
				menutype : '菜单显示属性',
				operability : '显示可操作',
				uoperability : '显示不可操作',
				choose : '请选择',
			},
			roleallot : {
				describe : '描述',
				RoleAssignment : '角色(分配)代码',
				assignmentName : '角色(分配)名称',
				rolesAssignments : '新增角色(分配)',
				ModifyRoles : '修改角色(分配)',
				remove1 : '您确定要删除选择的',
				remove2 : '个角色(分配)吗？',
				removeS : '操作成功，成功删除 ',
				removeS2 : '个角色(分配)',
				authorizationID : '权限ID',
				menu : '菜单',
				menuID : '菜单ID',
			},
			rolelimit : {
				describe : '描述',
				role : '角色',
				tot1 : '(共',
				tot2 : '个角色)',
				NewRole : '新增角色约束',
				RoleConstraints : '角色约束',
				CharacterName : '角色名称',
				RoleDescription : '角色描述',
				ModifyRoleConstraint : '修改角色约束',
				check1 : '请勾选组成约束的角色，至少勾选',
				check2 : '个角色',
				remove1 : '您确定要删除选择的',
				remove2 : '组角色约束吗？',
				removeS : '操作成功，成功删除 ',
				removeS2 : '组角色约束',
			},
			param:{
				enum:{
					ParametersCode:'参数代码',
					parameterName:'参数名称',
					section:'所属组别',
					parameterCharacteristics:'参数特性',
					Canedit:'可否编辑',
					yes:'是',
					no:'否',
					definition:'新增参数定义',
					compile:'编辑参数定义',
					detail:'编辑列表型参数明细',
					dataCode:'数据代码',
					TextData:'数据文本',
					DataParameter:'数据参数',
					orderNumber:'序号',
					describe:'描述',
					treeParameter:'编辑树型参数明细',
					saveSuccessfully:'保存成功！',
					 noContent:'没有要保存的内容！',
					 remove1:'您确定要删除选择的',
					 remove2:'个参数项吗？',
					 removeS:'操作成功，成功删除 ',
					 removeS2:'个参数项',
					 succeed1:'已经添加成功',
					 succeed2:'修改成功!',
					 node :'节点',
					 DragTheSuccess :'拖动成功',
					 sureToDelete:'您确定要删除所选的',
					 sureToDelete2:'及其所有子节点',
					 succeedRemove:'成功删除',
					
				},
				difine:{
					yes:'是',
					no:'否',
					describe:'描述',
					ParametersCode:'参数代码',
					parameterName:'参数名称',
					ParametersGroup:'参数组别',
					ParameterStorageType:'参数存储类型',
					Canedit:'可否编辑',
					AddParameterDefinitions:'添加参数定义',
					ModifyParameterDefinition:'修改参数定义',
					unmodified:'您未做任何修改',
					remove1:'您确定要删除选择的',
					remove2:'个参数项吗？',
					removeS:'操作成功，成功删除 ',
					removeS2:'个参数',
					
				}
			},
			holiday:{
				PleaseSelectDate:'请选择日期'
			},
			org:{
				remove1:'您确定要删除所选的',
				remove2:'及其所有子机构',
				succeedRemove:'成功删除',
				orgQ1:'您确定要将',
				orgQ2:'拖至',
				orgQ3:'下吗？',
			},
			syslog:{
				login:{
					 logout:'用户登出',
					 TimeoutLogout:'超时登出',
					 SessionID:'会话ID',
					 userId:'用户ID',
					 username:'用户名称',
					 agencyNumber:'机构号',
					 OrganizationNames:'机构名称',
					 serverIP:'服务端IP',
					 clientIP:'客户端IP',
					 browser:'浏览器',
					 operatingSystem:'操作系统',
					 entryDate:'登录日期',
					 LogonTime:'登录时间',
					 LogOutDate:'登出日期',
					 LogOutTime:'登出时间',
					 AppropriateType:'登出类型',
				},
				visit:{
					through:'通过',
					Refused:'拒绝',
					SessionID:'会话ID',
					 userId:'用户ID',
					 username:'用户名称',
					 agencyNumber:'机构号',
					 OrganizationNames:'机构名称',
					 AuthorizationID:'权限ID',
					 serverIP:'服务端IP',
					 clientIP:'客户端IP',
					 browser:'浏览器',
					 operatingSystem:'操作系统',
					 authorizationResult:'授权结果',
					 menuPath:'菜单路径',
					 accessURL:'访问URL',
					 operationDate:'操作日期',
					 operatingTime:'操作时间',
					 operatingTime2:'操作耗时',
					
				}
			},
			cache:{
				cacheName:'缓存名称',
				cacheType:'缓存类型',
				isKinematic:'是否动态',
				Kb:'缓存容量',
				cached:'已缓存数',
				visits:'访问次数',
				hitCounts:'命中次数',
				attributes:'特征属性',
				describe : '描述',
				wipeCache:'清空缓存',
				remove1:'您确定要移除所选的',
				remove2:'条缓存条目吗？',
				checkRe:'请勾选需要移除的缓存条目！',
				sureReAll:'您确定要清除所有缓存吗？',
				sureRe:'您确定要清除缓存',
				checkAll:'全选',
				removeChecked:'移除所选条目',	
			},
			taskrule:{
				user:{
					username:'用户名称',
					nickName : '用户昵称',
					status : '状态',
					startUsing:'启用',
					stop:'停用',
					agencyNumber:'机构号',
				},
				taskrule:{
					nodeCode:'任务节点代码',
					nodeName:'任务节点名称',
					LimitedRole:'限定角色',
					QualifiedInstitutions:'限定机构',
					QualifiedPerson:'限定人',
					EnterTheDetails:'进入明细',
					username:'用户名称',
					roleName:'角色名称',
					organizationID:'机构ID',
					organization:'机构',
				}
				
			},
			menulocale:{
				guide:{
					menuName:'菜单名称:',
					alertmm:'请先修改输入框中的该数据再执行保存操作。',
				},
				locale:{
					menu:'菜单',
					alertOut:'数据已经更改，是否提交已修改数据？',
					alertOk:'请先修改表格中的数据再进行保存操作。',
					alertIng:'请先选中一行进行编辑。',
					notBeingEdited:'没有正在编辑的行！',
				}
			},
			maintenance:{
				roleID:'角色ID',
				roleName:'角色名称',
				roleName2:'角色(分配)名称',
				addRole:'新增角色和角色(分配)的关系',
				checkRole:'请勾选至少一个角色(分配)!',
				modificationRole:'修改角色和角色(分配)的关系', 
				removeRole:'您将删除此关系!请勾选至少一个角色(分配)!',
				notMake:'您未做任何修改!',
				remove1:'您确定要删除选择的所有与',
				remove2:'关联的角色(分配)关系吗？',
				removeS:'操作成功，已删除 ',
				removeS2:'组角色与角色(分配)关系',
				roleID2:'角色(分配)ID',
				roleName2:'角色(分配)名称',
				
			}

		}
	
	},
	logout : {
		beforeunloadtitle : "确定退出吗？"
	},
	ffp : {
		common : {
			constant : {
				CREAT:'创建',
				APPST:'等待',
				TMOUT:'超时',
				COMPL:'完成',
				RJCT:'拒绝',
				PROCE:'处理中',
				ERROR:'错误',
			}
		},
		cashmanagement : {
			return_refund:{
				jnlNo:"流水号",
				refund:'退款',
				Arefund :'确定退款? ',
				debtorName:'付款方名称',
				debtorAcctno:'付款方账号',
				creditorName:'收款方名称',
				creditorAcctno:'收款方账号',
				settlementAmt:'付款金额',
				settlementDate:'付款日期'
			},
			otherbankmode : {
				clearingCode:'清算行代码',
				receiptMode:'接收模式',
				lastUpdateTs:'最后更新时间',
			},
			transactionstatus : {
				jnlNo:'交易流水号',
				txStat:'交易状态',
				transactionId:'交易唯一编码',
				clrSysRef:'清算参考编码',
				dbtrAgtMmbId:'扣款方清算编号',
				cdtrAgtMmbId:'收款方清算编号',
				createTs:'创建日期'

			},
			fpspaymentnotification :{
				msgId:'报文编号', 
				ntfctnId: '通知编号',
				ntfctnCreateTs: '通知建立时间',
				ntfctnAcctId: 'FPS账号',
				ntfctnAcctType: '账号类型',
				ntfctnAmt: '金额',
				paymentCag: '类别',
				paymentEndToEndId: 'END TO END ID',
				paymentTxId: '交易编号',
				paymentClrSysRef: 'FPS结算号',
				paymentDbtr: '扣账方',
				paymentCdtr: '入账方',
				settlementTs: '结算日期',
			},
		},
		systemmaintenance : {
			cutoff : {
				title  :{
					amendtitle:'维护时间修改',
					cutofftype:'类别名称',
					workdayStart:'工作日开始时间',
					workdayEnd:'工作日结束时间',
					satStart:'周六开始时间',
					satEnd:'周六结束时间',
					holidayStart:'假期开始时间',
					holidayEnd:'假期结束时间'
				}
			},
			systemstat : {
				switchmode : {
					BTCH : '切换为实时模式',
					RLTM : '切换为批处理模式',
					RLTMP: '处理中...',
					BTCHP: '处理中...',
				},
				switchListener:{
					R : '停止监听',
					C : '启动监听',
					RP : '监听启动中...',
					CP : '监听停止中...',
				},
				switchController:{
					R : '停止控制器',
					C : '启动控制器',
				},
				confirm1: '您确定要',
				confirm2: '吗？',
				alertMsg1 : '请先启动实时监听程序!',
				alertMsg2 : '请先更新接收模式为批处理!',
				processing : '处理中,请稍后...',
			},
		},
		transaction  :{
			jnlNo:"流水号",
			remarks:"评论",
			txStat:"交易状态",
			txSrc:"起始地",
			transactionId:"交易Id",
			endToEndId:"端对端",
			msgId:"报文id",
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
			detail:"详情",
			Del:"删除",
			count:"product count",
			oldprice:"old price",
			newprice:"now price",
			address:"product address",
			description:"product description",
			remark:"remark"
		},
	},

	
});