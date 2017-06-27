package mz.com.nova.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
		 sessao.close();
		 HibernateUtil.getFabricaDesessoes().close();
	}

}
