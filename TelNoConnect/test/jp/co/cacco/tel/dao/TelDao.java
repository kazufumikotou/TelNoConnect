
package jp.co.cacco.tel.dao;

import jp.co.cacco.tel.dto.TelNoDto;

/**
 * 検索処理実行Dao
 * 
 */
@S2Dao(bean = TelNoDto.class)
public interface TelDao {

	//BEANアノテーション
    public Class BEAN = TelNoDto.class;

    //ARGSアノテーション
    public static final String findTelInfo_ARGS = "telNo";
  
    @Arguments("telNo")
    //検索処理(DTO)
	public TelNoDto selectTelInfo(String telNo);

}