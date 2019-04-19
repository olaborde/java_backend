

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.dbutil.OracleDbConnection;
import com.exception.BusinessException;
import com.to.Player;

public class PlayerDAOImpl implements PlayerDAO {

	@Override
	public Player addPlayer(Player player) throws BusinessException {
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

	@Override
	public Player viewPlayers(Player player) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player deletePlayer(Player player) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
