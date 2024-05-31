package dados;

public class Video extends Midia {

	private int qualidade;
	private Categoria categoria;

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
		super(codigo, titulo, ano);
		this.categoria = categoria;
		this.qualidade = qualidade;
	}
	public int getQualidade(){
		return qualidade;
	}
	public Categoria getCategoria(){
		return categoria;
	}

    @Override
	public double calculaLocacao() {
		int ano = super.getAno();
		double valorLocacao = 0;
		if(ano==2024){
			valorLocacao = 20.00;
		}else if(ano>=2000 && ano<=2023){
			valorLocacao = 15.00;
		}else{
			valorLocacao = 10.00;
		}
		return valorLocacao;
	}

	@Override
	public String getData() {
		return getCodigo() + "," + getTitulo() + "," + getAno() + "," + getCategoria() + "," + getQualidade();
	}
}
