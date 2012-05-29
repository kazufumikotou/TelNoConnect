package jp.co.cacco.tel.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.cacco.tel.dao.TelDao;
import jp.co.cacco.tel.dto.ConvNcot;
import jp.co.cacco.tel.dto.ncot;
import net.arnx.jsonic.JSON;

import org.seasar.extension.jdbc.SqlLog;
import org.seasar.extension.jdbc.SqlLogRegistry;
import org.seasar.extension.jdbc.SqlLogRegistryLocator;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

/**
 * 電話番号検索Servlet
 * 
 */
public class FindTelServlet extends HttpServlet {

	protected static final Logger logger = Logger.getLogger(FindTelServlet.class.getName());
    private static final long serialVersionUID = 1L;
	private TelDao telDao;
	private static final String PATH = "caccoDao.dicon";

	/**
	 * 初期化処理
	 * 
	 */		
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //コンテナを取得する
        //コンポーネントを呼び出す	
		S2Container container = S2ContainerFactory.create(PATH);
		container.init();

        telDao = (TelDao)container.getComponent(TelDao.class);
    }

	/**
	 * リクエストパラメータの取得
	 * 
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	ncot dto = new ncot();
    	ConvNcot resDto = new ConvNcot();
    	PrintWriter out = null;
    	int i = 0;
        String json = "";
    	
        // リクエストパラメータの値を取得し、変数に設定
        String telno = request.getParameter("paramTel");
        if (telno != "") {
        	//ハイフンが存在した場合、""に置き換え
        	telno= telno.replaceAll("-", "");
        }else{
        	//引数が取得できない場合
            //ログ出力
            logger.fine("paramTel=" + telno);  
        }
        
        //Daoの実行結果をDTOに設定
        dto = telDao.selectTelInfo(telno);
        
        //データ取得に失敗した場合
        if(dto == null){
        	//ログ出力
        	logger.fine("sqlResult=" + dto);  
        }
        
        //実行SQLをログ出力
        SqlLogRegistry sqlLogRegistry = SqlLogRegistryLocator.getInstance();
        SqlLog sqlLog = sqlLogRegistry.getLast();
        System.out.println(sqlLog);
    	//ログ出力
    	logger.fine("sql=" + sqlLog);
        
        //検索結果保持DTOから電話番号を取得、編集用クラスに設定
        resDto.setTelNo(dto.getTelNo());


	    String[] labels = {"Flag", "Hiduke", "Itentelno"};
	    for (String label : labels) {
	    	for(i = 0; i < 13; i++) {
		        //日付形式変換処理を呼び出す。
		        dateEdit(dto, resDto, label + i);
		        	
		       }
	    }
       
        
        try {
            //可読性の高いJSONに変換
            json = JSON.encode(resDto, true);
	        //文字コード(UTF-8)を設定
	        response.setContentType("text/html;charset=UTF-8");
	        //JSONを送信する
	        out = response.getWriter();
	        out.println("JSON = " + json);
        } catch(Exception e) {
        	//ログ出力
        	logger.fine("JSON = " + json); 
        } finally {
            if (out != null) {
            	//ストリームを閉じる
                out.close();
            }
        }
    }
    
    /**
     * 日付から文字列に変換
     * @param value 日付
     * @return 文字列
     */
    private String parseString(Object value) {
    	String rtnValue = null;
    	if (value != null) {
        	// 変換
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    		rtnValue = sdf.format((Date) value);
    	}
    	return rtnValue;
    }
    
	/**
	 * 日付形式変換処理
	 * @param object1 変換元オブジェクト
	 * @param object2 変換後オブジェクト
	 * @param label メソッド名
	 */
    public void dateEdit(ncot object1, ConvNcot object2, String label) {
    									
    	String getMethodName = "get";		// getメソッドの接頭辞
    	String setMethodName = "set";		// setメソッドの接頭辞
	    Method method1;						//メソッド名
	    Method method2;						//メソッド名
	    Object obj;							//メソッド実行結果

		try {
			// ncotクラスのgetHiduke{0}メソッドを取得
			method1 = object1.getClass().getMethod(getMethodName + label, null);
			// getHiduke{0}メソッドを引数なしで実行
			obj = method1.invoke(object1, null);

			// ConvNcotクラスのsetHiduke{0}メソッドを取得
			method2 = object2.getClass().getMethod(setMethodName + label, String.class);

			// setHiduke{0}メソッドを引数ありで実行
			// ncotクラスのgetHiduke{0}メソッドで取得した値を引数にセットする
			// 取得した値がDate型なら変換して実行
			if (obj instanceof Date) {
				//Date型の場合
				method2.invoke(object2, parseString(obj));
			} else {
				method2.invoke(object2, obj);
			}

		} catch (SecurityException e) {
        	//ログ出力
        	logger.fine("err = " + e);
//			throw new RuntimeException(e);
			
		} catch (NoSuchMethodException e) {
			logger.fine("err = " + e);
//			throw new RuntimeException(e);
			
		} catch (IllegalArgumentException e) {
			logger.fine("err = " + e);
//			throw new RuntimeException(e);
			
		} catch (IllegalAccessException e) {
			logger.fine("err = " + e);
//			throw new RuntimeException(e);
			
		} catch (InvocationTargetException e) {
			logger.fine("err = " + e);
//			throw new RuntimeException(e);
		}
		return;
    }
}