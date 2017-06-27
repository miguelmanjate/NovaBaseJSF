package mz.com.nova.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory fabricaDesessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDesessoes() {
		return fabricaDesessoes;
	}
	
	private static SessionFactory criarFabricaDeSessoes(){
		
		try {
			
			Configuration configuracao = new Configuration().configure();
			
			ServiceRegistry servicos = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			SessionFactory fabrica = configuracao.buildSessionFactory(servicos);
			return fabrica;
		} catch (Throwable e) {
		    System.err.println("Erro na criacao da fabrica de sessoes");
		    throw new ExceptionInInitializerError(e);
		}
		
		
	}

}
