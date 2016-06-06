package negocio;

import to.ExtratoTO;
import dao.ExtratoDAO;

public class Extrato {
	private String data;
	private String operacao;
	private double valor;
	private Conta conta;
	private static Extrato pao;
	private Object[][] dados;

	
	public Extrato(String data, String operacao, double valor) {
		this.data = data;
		this.operacao = operacao;
		this.valor = valor;
	}
	
	public Extrato(Conta conta){
		this.conta = conta;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public static Extrato getPao(Conta conta) {
		if (pao == null) {
			pao = new Extrato(conta);
		}
		return pao;
	}	
	
	public static Extrato getPao(){
		return pao;
	}
	
	public static void destroy(){
		pao = null;
	}
	
	public void consultar(int prazo){
		ExtratoDAO dao = new ExtratoDAO();
		ExtratoTO to = new ExtratoTO();
		to.setNumConta(getConta().getConta());
		to.setPrazo(prazo);
		to = dao.carregar(to);
		dados = to.getMatriz();
		//setMatriz(to.getMatriz());
	}
	
	public void incluir(){
		ExtratoDAO dao = new ExtratoDAO();
		ExtratoTO to = new ExtratoTO();
		to.setConta(conta);
		to.setNumConta(getConta().getConta());
		to.setValor(valor);
		to.setOperacao(operacao);
		dao.incluir(to);
	}
	
	public Object[][] getMatriz(){
		return dados;
	}
	
	public void setMatriz(Object[][] dados){
		this.dados = dados;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extrato other = (Extrato) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (operacao == null) {
			if (other.operacao != null)
				return false;
		} else if (!operacao.equals(other.operacao))
			return false;
		if (conta != other.conta)
			return false;
		if (valor == 0) {
			if (other.valor != 0)
				return false;
		} else if (!(valor == other.valor))
			return false;
		if (dados == null) {
			if (other.dados != null)
				return false;
		} else if (!dados.equals(other.dados))
			return false;
		return true;
	}
	

}
