package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;

import negocio.Extrato;
import to.ExtratoTO;

public class ExtratoDAO {
	
	public Object[][] dados;
	
	public void incluir(ExtratoTO to) {
		String sqlInsert = "INSERT INTO acao(dataMov, operacao, valorMov, conta) VALUES (curdate(), ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			//stm.setString(1, to.getConta().getCliente().getNome());
			stm.setString(1, to.getOperacao());
			stm.setDouble(2, to.getValor());
			stm.setInt(3, to.getNumConta());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ExtratoTO carregar(ExtratoTO to){
		 ArrayList<Extrato> list = new ArrayList<Extrato>();
		 String sqlSelect =  "SELECT * FROM acao WHERE conta = ? and dataMov BETWEEN CURRENT_DATE()-? AND CURRENT_DATE() ;";
		 try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			 stm.setInt(1, to.getNumConta());
			 stm.setInt(2,to.getPrazo());
			 try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
	            	Extrato a = new Extrato(rs.getString(2), rs.getString(3), rs.getDouble(4));
	            	list.add(a);   
				}
			 }
			 catch (SQLException e) {
			     e.printStackTrace();
			 }
	         
	         dados = new Object[list.size()][3];
	         int linha = 0;
	            for (Extrato c : list) {
	                dados[linha][0] = c.getData(); 
	                dados[linha][1] = c.getOperacao();
	                dados[linha][2] = c.getValor();
	                linha++;
	            }

	      }
		  catch (SQLException e1) {
		      System.out.print(e1.getStackTrace());
	      }

		to.setMatriz(dados);
		return to;
	}
	
	public void excluir(ExtratoTO to) {
		String sqlDelete = "DELETE FROM acao WHERE conta = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getNumConta());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(ExtratoTO to) {
		String sqlUpdate = "UPDATE acao SET dataMov = ?, operacao = ? WHERE conta=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getData());
			stm.setString(2, to.getOperacao());
			stm.setInt(3, to.getNumConta());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
