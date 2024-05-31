package dados;

public class Musica extends Midia {

	private double duracao;
	private Categoria categoria;
	/**
	 *  
	 */
	public Musica(int codigo, String titulo, int ano, Categoria categoria, double duracao) {
        super(codigo, titulo, ano);

		this.categoria = categoria;
		this.duracao = duracao;
    }
	public Categoria getCategoria(){
		return categoria;
	}
	public double getDuracao(){
		return duracao;
	}

	@Override
	public double calculaLocacao() {
		if(categoria == Categoria.ACA){
			return duracao * 0.9;
		}else if(categoria == Categoria.DRA){
			return duracao * 0.7;
		}else if(categoria == Categoria.FIC){
			return duracao * 0.5;
		}else{
			return duracao * 0.3;
		}
	}

	@Override
	public String getData() {
		return getCodigo() + "," + getTitulo() + "," + getAno() + "," + getCategoria() + "," + getDuracao();
	}
}
