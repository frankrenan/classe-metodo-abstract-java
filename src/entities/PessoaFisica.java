package entities;

public class PessoaFisica extends Pessoa {

	private Double gastos;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastos) {
		super(nome, rendaAnual);
		this.gastos = gastos;
	}

	public Double getGastos() {
		return gastos;
	}

	public void setGastos(Double gastos) {
		this.gastos = gastos;
	}

	@Override
	public double imposto() {
		if (getRendaAnual() < 20000.0) {
			return (getRendaAnual() * 0.15) - (getGastos()*0.5);
		}else {
			return (getRendaAnual() * 0.25) - (getGastos()*0.5);
		}
	}

}
