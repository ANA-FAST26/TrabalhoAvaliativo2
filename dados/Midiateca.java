package dados;

import java.util.Collection;
import java.util.ArrayList;

public class Midiateca implements Iterador {

	private int contador;

	private ArrayList<Midia> midias;


	public Midiateca() {
		midias = new ArrayList<>();
	}

	//Verifica se ha alguma midia cadastrada por codigo e se não tem nenhuma midia cadastrada, ele add no ArrayList.
	public boolean cadastraMidia(Midia midia) {
		int codigo = midia.getCodigo();
		if (consultaPorCodigo(codigo) == null) {
			return midias.add(midia);
		}
		return false;
	}

	public Midia consultaPorCodigo(int codigo) {
		for (Midia midiaAux : midias) {
			if (midiaAux.getCodigo() == codigo) {
				return midiaAux;
			}
		}
		return null;
	}

	public ArrayList<Midia> consultaPorCategoria(Categoria categoria) {
		ArrayList<Midia> midiasAux = new ArrayList<>();
		if(!midias.isEmpty()) { //!midias.isEmpty() retorna se o tamanho é diferente de zero
			for (Midia midiaAux : midias){
				if(midiaAux instanceof Video){
					Video video = (Video) midiaAux;
					if(video.getCategoria() == categoria){
						midiasAux.add(video);
					}
				}else {
					Musica musica = (Musica)midiaAux;
					if (musica.getCategoria() == categoria){
						midiasAux.add(musica);
					}
				}
			}
			return midiasAux;
		}
		return null;
	}

	public boolean removeMidia(int codigo) {
		for (Midia midia : midias){
			if(consultaPorCodigo(codigo) != null){
				return midias.remove(midia);
			}
		}
		return false;
	}


	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {

	}


	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		return false;
	}


	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {
		return null;
	}

}

