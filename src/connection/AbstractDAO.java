package connection;

import java.sql.*;

public class AbstractDAO {

	protected Connection connection=SingleConnection.getConnection();
	

}
