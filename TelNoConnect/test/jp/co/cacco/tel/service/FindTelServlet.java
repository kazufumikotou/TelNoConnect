package jp.co.cacco.tel.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.cacco.tel.dao.TelDao;
import jp.co.cacco.tel.dto.TelNoDto;
//import jp.co.cacco.tel.util.ResponseUtil;
//import net.arnx.jsonic.JSON;

import net.arnx.jsonic.JSON;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class FindTelServlet {

	/**
	 * 電話番号検索Servlet
	 * 
	 */
	public class FindBookServlet extends HttpServlet {

	    private static final long serialVersionUID = 1L;
		private TelDao telDao;

		/**
		 * 初期化処理
		 * 
		 */		
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	        //コンテナを取得する
	        //コンポーネントを呼び出す	
	        telDao = (TelDao) SingletonS2ContainerFactory.getContainer()
	                .getComponent(TelDao.class);
	    }

		/**
		 * リクエストパラメータの取得
		 * 
		 */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	TelNoDto dto = new TelNoDto();
	    	PrintWriter out = null;
	    	
	        // リクエストパラメータの値を取得し、変数に設定
	        String telNo = request.getParameter("paramTel");
	        if (telNo != null) {
	        	//ハイフンが存在した場合、""に置き換え
	        	telNo= telNo.replaceAll("-", "");
	        }
	        
	        //Daoの実行結果をDTOに設定
	        dto = telDao.selectTelInfo(telNo);
	        
	        //可読性の高いJSONに変換
	        String json = JSON.encode(dto,true);
	        
	        try {
		        //文字コード(UTF-8)を設定
		        response.setContentType("text/html;charset=UTF-8");
		        //JSONを送信する
		        out = response.getWriter();
		        out.println("json");
	        } finally {
                if (out != null) {
                	//ストリームを閉じる
                    out.close();
                }
	        }
	    }
	}
}