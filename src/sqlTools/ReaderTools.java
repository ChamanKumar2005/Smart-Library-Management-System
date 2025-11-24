package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseTools;
import model.Reader;

public class ReaderTools {

	// -------------------- FETCH BY ID --------------------
	public List<Reader> ReaderData(String idReader) {
		String sql = "SELECT idReader, nameReader, kind, sex, password FROM reader WHERE idReader = ?";
		List<Reader> list = new ArrayList<>();

		try (Connection conn = new DatabaseTools().getConn();
			 PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, idReader);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				list.add(reader);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	// -------------------- SEARCH BY NAME --------------------
	public List<Reader> ReaderDataSearch(String nameReader) {
		String sql = "SELECT idReader, nameReader, kind, sex, password FROM reader WHERE nameReader LIKE ?";
		List<Reader> list = new ArrayList<>();

		try (Connection conn = new DatabaseTools().getConn();
			 PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, "%" + nameReader + "%");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				list.add(reader);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	// -------------------- FETCH ALL --------------------
	public List<Reader> ReaderData() {
		String sql = "SELECT idReader, nameReader, kind, sex, password FROM reader";
		List<Reader> list = new ArrayList<>();

		try (Connection conn = new DatabaseTools().getConn();
			 PreparedStatement pst = conn.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				list.add(reader);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	// -------------------- LOGIN CHECK --------------------
	public boolean ReaderLogin(String idReader, String password) {
		String sql = "SELECT idReader FROM reader WHERE idReader = ? AND password = ?";

		try (Connection conn = new DatabaseTools().getConn();
			 PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, idReader);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			return rs.next(); // true if match

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	// -------------------- ADD READER --------------------
	public int AddReader(Reader reader) {
		String sql = "INSERT INTO reader (idReader, nameReader, kind, sex, password) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = new DatabaseTools().getConn();
			 PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, reader.getIdReader());
			pst.setString(2, reader.getNameReader());
			pst.setString(3, reader.getType());
			pst.setString(4, reader.getSex());
			pst.setString(5, reader.getPassword());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	// -------------------- UPDATE READER --------------------
	public int UpdateReader(Reader reader) {
		String sql = "UPDATE reader SET nameReader = ?, kind = ?, sex = ?, password = ? WHERE idReader = ?";

		try (Connection conn = new DatabaseTools().getConn();
			 PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, reader.getNameReader());
			pst.setString(2, reader.getType());
			pst.setString(3, reader.getSex());
			pst.setString(4, reader.getPassword());
			pst.setString(5, reader.getIdReader());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	// -------------------- DELETE READER --------------------
	public int DeleteReader(String idReader) {
		String sql = "DELETE FROM reader WHERE idReader = ?";

		try (Connection conn = new DatabaseTools().getConn();
			 PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, idReader);
			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
