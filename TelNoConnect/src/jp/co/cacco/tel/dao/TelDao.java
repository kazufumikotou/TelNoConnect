
package jp.co.cacco.tel.dao;

import jp.co.cacco.tel.dto.ncot;

/**
 * 検索処理実行Dao
 * 
 */
@S2Dao(bean = ncot.class)
public interface TelDao {

	//BEANアノテーション
    public Class BEAN = ncot.class;
    
    //ARGSアノテーション
    public static final String selectTelInfo_ARGS = "telno";
    
    //QUERYアノテーション
    public static final String selectTelInfo_QUERY = "ncot.telno = ?";
  
    @Arguments("telno")
    //検索処理(DTO)
	public ncot selectTelInfo(String telno);

}