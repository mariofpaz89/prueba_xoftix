package Panel.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Panel.objects.GAME_USERS;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbAccess {

	private String connectionString = "jdbc:postgresql://localhost:5432/db_prueba_mario";
	private String user = "postgres";
	private String password = "*****";
	
	private Connection connection;
	
	private static final String PS_SELECT_USERS = "SELECT user_id, username, password, user_status, created_on FROM GAME_USERS";
	
	public DbAccess()
	{
	}
	
	public List<GAME_USERS> GetUsers() throws SQLException
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GAME_USERS> result = new ArrayList<GAME_USERS>();
		
		try
		{
			// Create a new connection
			this.CreateConnection();
			
			// Get connection object
			connection = this.getConnection();
			
			// Set prepared statement
			pstmt = connection.prepareStatement(PS_SELECT_USERS);
			
			// Get reader
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GAME_USERS usr = new GAME_USERS();
				
				usr.setUser_id(rs.getLong(0));
				usr.setUsername(rs.getString(1));
				usr.setPassword(rs.getString(2));
				usr.setUser_status(rs.getString(3));
				
				result.add(usr);
			}
			
			return result;
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			
			if (pstmt != null)
			{
				pstmt.close();
			}
			
			if (connection != null && !connection.isClosed())
			{
				connection.close();
				this.setConnection(null);
			}
		}
	}
	
	private void CreateConnection() throws SQLException
	{
		Connection connection = DriverManager.getConnection(this.connectionString, this.user, this.password);
		
        this.setConnection(connection); 
	}
	
	private Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}
}
