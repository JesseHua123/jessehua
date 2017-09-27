package com.etc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import org.springframework.stereotype.Component;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 鏁版嵁搴撹闂殑閫氱敤绫�
 * 
 * @author Administrator
 * 
 */
@Component
public class DBUtil {

	// 鍥涗釜甯搁噺Driver銆乽rl銆乽sername銆乸assword
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test2";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * 杩斿洖涓�涓繛鎺�(Connection)瀵硅薄
	 */
	private Connection getConnection() {
		Connection con = null;

		try {

			Class.forName(DRIVER);

			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * 閲婃斁璧勬簮
	 */
	private void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {

		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 鍙湁鏌ヨ鎵嶄細杩斿洖缁撴灉闆嗭紝鑻ヤ笉鍒ゆ柇绌猴紝灏变細鍑虹幇绌烘寚閽堝紓甯�
	}

	/**
	 * 涓�涓柟娉曟潵鍋氭洿鏂帮細澧炲姞 鍒犻櫎 淇敼
	 * 
	 * @param sql     瑕佹墽琛岀殑sql璇彞
	 * @param param   鍙彉鍙傛暟    鎵ц鐨剆ql璇彞鍖呭惈鐨勫弬鏁颁釜鏁颁笉鍚�  浼犲叆0-N涓弬鏁�
	 * 
	 */
	public int execUpdate(String sql, Object... param) {

		Connection con = getConnection();
		PreparedStatement ps = null;
		int result = 0; //鍙楀奖鍝嶇殑琛屾暟

		try {

			ps = con.prepareStatement(sql);

			for (int i = 0; i < param.length; i++) {
				// 琛ュ叏sql鐨勫弬鏁�
				ps.setObject(i + 1, param[i]);
			}

			// 鎵ц鏇存柊
			result = ps.executeUpdate(); //杩斿洖鐨勬槸鍙楀奖鍝嶇殑琛屾暟

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 閲婃斁璧勬簮
			closeAll(null, ps, con);
		}

		return result;
	}
	/**
	 * 鏌ヨ
	 * @param sql   瑕佹墽琛屾煡璇㈢殑sql璇彞
	 * @param param 瑕佹墽琛宻ql璇彞瀵瑰簲鐨勫弬鏁�
	 * @return  CachedRowSet 缂撳瓨缁撴灉闆�  JDK鐢ㄨ嚜宸卞畨瑁呰繃閰嶇疆杩囩殑锛屽鏋滅敤myecplise鑷甫鐨刯dk瀹规槗鍑洪棶棰�
	 */
	public CachedRowSet execQuery(String sql, Object... param) {
		
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs =null;
		//澹版槑涓�涓紦瀛樼殑缁撴灉闆� jdk闇�瑕佽揪鍒颁竴瀹氱殑瑕佹眰
		CachedRowSetImpl crs = null;
		try {
		
			ps = con.prepareStatement(sql);
			
			//琛ュ叏sql鐨勫弬鏁板��
			for (int i = 0; i < param.length; i++) {
				
				ps.setObject(i+1, param[i]);
			}
			
			//鎵ц鏌ヨ
			rs = ps.executeQuery();
			
			//鍒涘缓缂撳瓨缁撴灉闆嗗璞�
			crs = new CachedRowSetImpl();
			
			//寤虹珛rs鍜宑rs鐨勫叧绯� 鍙互灏唕s鐨勬暟鎹缂撳瓨鍒癱rs涓�
			crs.populate(rs);
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			// 鍏抽棴璧勬簮
			closeAll(rs, ps, con);
		}
		
		return crs;
		
	}
	
}
