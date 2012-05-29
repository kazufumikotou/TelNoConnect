
package jp.co.cacco.tel.dao;

import jp.co.cacco.tel.dto.ncot;

/**
 * �����������sDao
 * 
 */
@S2Dao(bean = ncot.class)
public interface TelDao {

	//BEAN�A�m�e�[�V����
    public Class BEAN = ncot.class;
    
    //ARGS�A�m�e�[�V����
    public static final String selectTelInfo_ARGS = "telno";
    
    //QUERY�A�m�e�[�V����
    public static final String selectTelInfo_QUERY = "ncot.telno = ?";
  
    @Arguments("telno")
    //��������(DTO)
	public ncot selectTelInfo(String telno);

}