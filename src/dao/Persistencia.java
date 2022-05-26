package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Veiculo;

public class Persistencia {
	
	private Connection con;
	private PreparedStatement stmt;
	
	private final String USER = "root";
	private final String PASS = "";
	private final String URL = "jdbc:mysql://localhost:3306/veiculos";
	
	
	public void conectar(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PASS);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void inserir(Veiculo veiculo){
		String sql = "INSERT INTO veiculo(modelo,"
				+ "marca,"
				+ "ano,"
				+ "placa,"
				+ "imagem,"
				+ "cor,"
				+ "preco,"
				+ "combustivel,"
				+ "cambio, "
				+ "portas, "
				+ "km, "
				+ "versao) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getModelo());
			stmt.setString(2, veiculo.getMarca());
			stmt.setInt(3, veiculo.getAno());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setBytes(5, veiculo.getImagem());
			stmt.setString(6, veiculo.getCor());
			stmt.setDouble(7, veiculo.getPreco());
			stmt.setString(8, veiculo.getCombustivel());
			stmt.setString(9, veiculo.getCambio());
			stmt.setInt(10, veiculo.getPortas());
			stmt.setInt(11, veiculo.getKm());
			stmt.setString(12, veiculo.getVersao());
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Veiculo veiculo){
		String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, veiculo.getIdveiculo());
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void alterar(Veiculo veiculo){
		String sql = "UPDATE veiculo SET "
				+ "modelo = ?, "
				+ "marca = ?, "
				+ "ano = ?, "
				+ "placa = ?, "
				+ "imagem = ?, "
				+ "cor = ?, "
				+ "preco = ?, "
				+ "combustivel = ?, "
				+ "cambio = ?, "
				+ "portas = ?, "
				+ "km = ?, "
				+ "versao = ?  "
				+ "WHERE idveiculo = ?";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getModelo());
			stmt.setString(2, veiculo.getMarca());
			stmt.setInt(3, veiculo.getAno());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setBytes(5, veiculo.getImagem());
			stmt.setString(6, veiculo.getCor());
			stmt.setDouble(7, veiculo.getPreco());
			stmt.setString(8, veiculo.getCombustivel());
			stmt.setString(9, veiculo.getCambio());
			stmt.setInt(10, veiculo.getPortas());
			stmt.setInt(11, veiculo.getKm());
			stmt.setString(12, veiculo.getVersao());
			stmt.setLong(13, veiculo.getIdveiculo());
			
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> listar(){
		String sql = "SELECT * FROM veiculo";
		List<Veiculo> lista = new ArrayList<Veiculo>();
		
		try {
			
			stmt = con.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				Veiculo veiculo = new Veiculo();
				veiculo.setIdveiculo(res.getLong("idveiculo"));
				veiculo.setModelo(res.getString("modelo"));
				veiculo.setMarca(res.getString("marca"));
				veiculo.setAno(res.getInt("ano"));
				veiculo.setPlaca(res.getString("placa"));
				veiculo.setImagem(res.getBytes("imagem"));
				veiculo.setCor(res.getString("cor"));
				veiculo.setPreco(res.getDouble("preco"));
				veiculo.setCombustivel(res.getString("combustivel"));
				veiculo.setCambio(res.getString("cambio"));
				veiculo.setPortas(res.getInt("portas"));
				veiculo.setKm(res.getInt("km"));
				veiculo.setVersao(res.getString("versao"));
				
				lista.add(veiculo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	public void fecharCon(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
