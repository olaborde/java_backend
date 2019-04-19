

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import com.dbutil.OracleDbConnection;
import com.to.Player;



public class PlayerDAOOriginal {
	
	public Player registerPlayer(Player player) {
		
		try {
			Connection connection = OracleDbConnection.getConnection();
			String sql = "{call REGISTERPLAYER(?,?,?,?,?,?,?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
			callableStatement.setString(2, player.getName());
			callableStatement.setDate(3, new java.sql.Date(player.getDob().getTime()));
			callableStatement.setString(4, player.getEmail());
			callableStatement.setString(5, player.getGender());
			callableStatement.setString(6,  player.getTeamname());
			callableStatement.setLong(7, player.getContact());
			
			callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
			
			callableStatement.executeQuery();
			if(callableStatement.getString(8)==null) {
				player.setId(callableStatement.getString(8));
			}
			else {
				throw new SQLException(callableStatement.getString(8));
			}
			player.setId(callableStatement.getString(1));
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error, kindly contact sysadmin "+e);
		} 
		return player;
	}
	
//	public int  getPlayerById(String id) {
//		
//		try {
//			//, name, age, dob,email, department_id
//			Connection connection = OracleDbConnection.getConnection();
//			String sql = " { ?= call getPlayerById(?) }";
//			CallableStatement callableStatement = connection.prepareCall(sql);
//			
//			callableStatement.setString(1, );
//			callableStatement.executeQuery();
//		
//			
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println("Internal error, kindly contact sysadmin"+e);
//		} 
//		
//		
//		return "";
//	}

}
