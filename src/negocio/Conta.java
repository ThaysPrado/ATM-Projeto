package negocio;

import dao.ContaDAO;
import to.ContaTO;

public class Conta {
	private int conta;
	private int agencia;
	private double saldo;
	private Cliente cliente;
	private static Conta pao;

	public Conta(int conta, int agencia, double saldo, Cliente cliente) {
		this.conta = conta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static Conta getPao(int conta, int agencia) {
		if (pao == null) {
			pao = new Conta(conta, agencia, 0, null);
		}
		return pao;
	}
	
	public static Conta getPao(){
		return pao;
	}
	
	public static void destroy(){
		pao = null;
	}

	public void atualizar() {
		ContaDAO dao = new ContaDAO();
		ContaTO to = new ContaTO();
		to.setConta(conta);
		to.setAgencia(agencia);
		to.setSaldo(saldo);
		to.setCliente(cliente);
		dao.atualizar(to);
	}

	public void carregar() {
		ContaDAO dao = new ContaDAO();
		ContaTO to = dao.carregar(conta);
		agencia = to.getAgencia();
		saldo = to.getSaldo();
		cliente = to.getCliente();
	}

	public boolean conferirSaldo(double valor) {
		return saldo >= valor && valor > 0;
	}

	@Override
	public String toString() {
		return "Conta [conta=" + conta + ", agencia=" + agencia + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (conta != other.conta)
			return false;
		if (saldo == 0.00) {
			if (other.saldo != 0.00)
				return false;
		} else if (!(saldo == other.saldo))
			return false;
		if (agencia == 0000000) {
			if (other.agencia != 000000)
				return false;
		} else if (!(agencia == other.agencia))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
		
	}

}