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
 * �d�b�ԍ�����Servlet
 * 
 */
public class FindTelServlet extends HttpServlet {

	protected static final Logger logger = Logger.getLogger(FindTelServlet.class.getName());
    private static final long serialVersionUID = 1L;
	private TelDao telDao;
	private static final String PATH = "caccoDao.dicon";

	/**
	 * ����������
	 * 
	 */		
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //�R���e�i���擾����
        //�R���|�[�l���g���Ăяo��	
		S2Container container = S2ContainerFactory.create(PATH);
		container.init();

        telDao = (TelDao)container.getComponent(TelDao.class);
    }

	/**
	 * ���N�G�X�g�p�����[�^�̎擾
	 * 
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	ncot dto = new ncot();
    	ConvNcot resDto = new ConvNcot();
    	PrintWriter out = null;
    	int i = 0;
        String json = "";
    	
        // ���N�G�X�g�p�����[�^�̒l���擾���A�ϐ��ɐݒ�
        String telno = request.getParameter("paramTel");
        if (telno != "") {
        	//�n�C�t�������݂����ꍇ�A""�ɒu������
        	telno= telno.replaceAll("-", "");
        }else{
        	//�������擾�ł��Ȃ��ꍇ
            //���O�o��
            logger.fine("paramTel=" + telno);  
        }
        
        //Dao�̎��s���ʂ�DTO�ɐݒ�
        dto = telDao.selectTelInfo(telno);
        
        //�f�[�^�擾�Ɏ��s�����ꍇ
        if(dto == null){
        	//���O�o��
        	logger.fine("sqlResult=" + dto);  
        }
        
        //���sSQL�����O�o��
        SqlLogRegistry sqlLogRegistry = SqlLogRegistryLocator.getInstance();
        SqlLog sqlLog = sqlLogRegistry.getLast();
        System.out.println(sqlLog);
    	//���O�o��
    	logger.fine("sql=" + sqlLog);
        
        //�������ʕێ�DTO����d�b�ԍ����擾�A�ҏW�p�N���X�ɐݒ�
        resDto.setTelNo(dto.getTelNo());


	    String[] labels = {"Flag", "Hiduke", "Itentelno"};
	    for (String label : labels) {
	    	for(i = 0; i < 13; i++) {
		        //���t�`���ϊ��������Ăяo���B
		        dateEdit(dto, resDto, label + i);
		        	
		       }
	    }
       
        
        try {
            //�ǐ��̍���JSON�ɕϊ�
            json = JSON.encode(resDto, true);
	        //�����R�[�h(UTF-8)��ݒ�
	        response.setContentType("text/html;charset=UTF-8");
	        //JSON�𑗐M����
	        out = response.getWriter();
	        out.println("JSON = " + json);
        } catch(Exception e) {
        	//���O�o��
        	logger.fine("JSON = " + json); 
        } finally {
            if (out != null) {
            	//�X�g���[�������
                out.close();
            }
        }
    }
    
    /**
     * ���t���當����ɕϊ�
     * @param value ���t
     * @return ������
     */
    private String parseString(Object value) {
    	String rtnValue = null;
    	if (value != null) {
        	// �ϊ�
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    		rtnValue = sdf.format((Date) value);
    	}
    	return rtnValue;
    }
    
	/**
	 * ���t�`���ϊ�����
	 * @param object1 �ϊ����I�u�W�F�N�g
	 * @param object2 �ϊ���I�u�W�F�N�g
	 * @param label ���\�b�h��
	 */
    public void dateEdit(ncot object1, ConvNcot object2, String label) {
    									
    	String getMethodName = "get";		// get���\�b�h�̐ړ���
    	String setMethodName = "set";		// set���\�b�h�̐ړ���
	    Method method1;						//���\�b�h��
	    Method method2;						//���\�b�h��
	    Object obj;							//���\�b�h���s����

		try {
			// ncot�N���X��getHiduke{0}���\�b�h���擾
			method1 = object1.getClass().getMethod(getMethodName + label, null);
			// getHiduke{0}���\�b�h�������Ȃ��Ŏ��s
			obj = method1.invoke(object1, null);

			// ConvNcot�N���X��setHiduke{0}���\�b�h���擾
			method2 = object2.getClass().getMethod(setMethodName + label, String.class);

			// setHiduke{0}���\�b�h����������Ŏ��s
			// ncot�N���X��getHiduke{0}���\�b�h�Ŏ擾�����l�������ɃZ�b�g����
			// �擾�����l��Date�^�Ȃ�ϊ����Ď��s
			if (obj instanceof Date) {
				//Date�^�̏ꍇ
				method2.invoke(object2, parseString(obj));
			} else {
				method2.invoke(object2, obj);
			}

		} catch (SecurityException e) {
        	//���O�o��
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