import java.sql.SQLException;

import com.ctgu.qmx.abstructFactory.AbstructFactory;
import com.ctgu.qmx.dao.AdminDao;
import com.ctgu.qmx.factoryProducer.FactoryProducer;

public class demo {
	public static void main(String[] args) throws SQLException {
		AbstructFactory abstructFactory = FactoryProducer.getIBaseDaoFactory();
		AdminDao adminDao = abstructFactory.getAdminDaoImpl();
	}
}
