package to;

import negocio.Conta;

public class ExtratoTO {
	private String data;
	private String operacao;
	private double valor;
	private Conta conta;
	private int prazo;
	private int numConta;
	private Object[][] matriz;

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
	
	public void setNumConta(int a){
		numConta = a;
	}
	
	public int getNumConta(){
		return numConta;
	}
	
	public void setPrazo(int prazo){
		this.prazo = prazo;
	}
	
	public int getPrazo(){
		return prazo;
	}
	
	public void setMatriz(Object[][] matriz){
		this.matriz = matriz;
	}
	
	public Object[][] getMatriz(){
		return matriz;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtratoTO other = (ExtratoTO) obj;
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
		if (matriz == null) {
			if (other.matriz != null)
				return false;
		} else if (!matriz.equals(other.matriz))
			return false;
		return true;
	}

}
