package to;

import negocio.Cliente;

public class ContaTO {
	private int conta;
	private int agencia;
	private double saldo;
	private Cliente cliente;

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

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaTO other = (ContaTO) obj;
		if (conta != other.conta)
			return false;
		if (saldo == 0.00) {
			if (other.saldo != 0.00)
				return false;
		} else if (!(saldo == other.saldo))
			return false;
		if (agencia == 0000) {
			if (other.agencia != 0000)
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
