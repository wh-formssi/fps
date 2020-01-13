package com.forms.ffp.persistents.dao.addressing;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.forms.beneform4j.core.dao.annotation.BatchParam;
import com.forms.beneform4j.core.dao.annotation.Execute;
import com.forms.beneform4j.core.dao.annotation.Executes;
import com.forms.beneform4j.core.dao.annotation.SqlRef;
import com.forms.ffp.persistents.bean.FFPJbBase;
import com.forms.ffp.persistents.bean.FFPTxJnl;
import com.forms.ffp.persistents.bean.addressing.FFPJbA110;
import com.forms.ffp.persistents.bean.addressing.FFPJbA110dtl;

@Repository("FFPIDao_A110")
public interface FFPIDao_A110
{
	@Executes({
			// 插入交易表
			@Execute(sqlRef = @SqlRef("INSERT_TB_TX_JNL") , param = @BatchParam(value = false, property = "txJnl") ),
			@Execute(sqlRef = @SqlRef("INSERT_LIST_TXJNLACTION") , param = @BatchParam(item = "jnlAction", property = "jnlActionList") ),
			@Execute(sqlRef = @SqlRef("INSERTLIST_TB_TX_A110DAT") , param = @BatchParam(false))
	})
	public int[] dInsert(FFPJbA110 form);

	
	
	@Executes({ 
			@Execute(sqlRef = @SqlRef("UPDATE_TXJNL_STAT") , param = @BatchParam(value = false, property = "txJnl") ),
			@Execute(sqlRef = @SqlRef("INSERT_UPDATE_LIST_TXJNLACTION") , param = @BatchParam(item = "jnlAction", property = "jnlActionList")) 
	})
	public int[] updateJnlStat(FFPJbBase form);
	
	
	 @Executes({
			// 插入交易表
			@Execute(sqlRef = @SqlRef("insertA110dtl") , param = @BatchParam(item = "adr", property = "adrList" ))
	}) 
	public int[] dInsertA110dtl(FFPJbA110 form);
	 
	 
	 
	List<FFPJbA110dtl> inqueryAddress_A110Dtl(@Param("jnlNo")String jnlNo);
	 
	int updateA110Status(@Param("status")String status,@Param("jnlNo")String jnlNo);
	
	
}
