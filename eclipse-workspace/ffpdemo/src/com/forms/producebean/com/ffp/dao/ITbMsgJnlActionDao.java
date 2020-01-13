package com.forms.producebean.com.ffp.dao;

/**
 * Copy Right Information : Forms Syntron <br> 
 * Project : zhangying <br> 
 * Description : tb_msg_jnl_action  <br> 
 * Author : zhangying <br> 
 * Version : 1.0.0 <br> 
 * Since : 1.0.0 <br> 
 * Date : 2018-2-7 <br> 
 */
public interface ITbMsgJnlActionDao {
    int dDelete(int msgJnl);

    int dInsert(TbMsgJnlAction record);

    TbMsgJnlAction dList(int msgJnl);

    int dUpdate(TbMsgJnlAction record);
}