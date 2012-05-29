
package jp.co.cacco.tel.dao;

import jp.co.cacco.tel.dto.TelNoDto;

/**
 * �����������sDao
 * 
 */
@S2Dao(bean = TelNoDto.class)
public interface TelDao {

	//BEAN�A�m�e�[�V����
    public Class BEAN = TelNoDto.class;

    //ARGS�A�m�e�[�V����
    public static final String findTelInfo_ARGS = "telNo";
  
    @Arguments("telNo")
    //��������(DTO)
	public TelNoDto selectTelInfo(String telNo);

}