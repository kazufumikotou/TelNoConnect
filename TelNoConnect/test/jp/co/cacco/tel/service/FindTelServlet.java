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
	 * �d�b�ԍ�����Servlet
	 * 
	 */
	public class FindBookServlet extends HttpServlet {

	    private static final long serialVersionUID = 1L;
		private TelDao telDao;

		/**
		 * ����������
		 * 
		 */		
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	        //�R���e�i���擾����
	        //�R���|�[�l���g���Ăяo��	
	        telDao = (TelDao) SingletonS2ContainerFactory.getContainer()
	                .getComponent(TelDao.class);
	    }

		/**
		 * ���N�G�X�g�p�����[�^�̎擾
		 * 
		 */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	TelNoDto dto = new TelNoDto();
	    	PrintWriter out = null;
	    	
	        // ���N�G�X�g�p�����[�^�̒l���擾���A�ϐ��ɐݒ�
	        String telNo = request.getParameter("paramTel");
	        if (telNo != null) {
	        	//�n�C�t�������݂����ꍇ�A""�ɒu������
	        	telNo= telNo.replaceAll("-", "");
	        }
	        
	        //Dao�̎��s���ʂ�DTO�ɐݒ�
	        dto = telDao.selectTelInfo(telNo);
	        
	        //�ǐ��̍���JSON�ɕϊ�
	        String json = JSON.encode(dto,true);
	        
	        try {
		        //�����R�[�h(UTF-8)��ݒ�
		        response.setContentType("text/html;charset=UTF-8");
		        //JSON�𑗐M����
		        out = response.getWriter();
		        out.println("json");
	        } finally {
                if (out != null) {
                	//�X�g���[�������
                    out.close();
                }
	        }
	    }
	}
}