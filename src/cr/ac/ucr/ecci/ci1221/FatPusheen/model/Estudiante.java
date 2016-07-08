package cr.ac.ucr.ecci.ci1221.FatPusheen.model;

public class Estudiante implements EstudianteI {

	/**
	 * Atributos: 
	 * index: sera la posicion en la lista de clase 
	 * Nombre: el nombre del estudiante
	 */
	int index;
	String Nombre;

	/**
	 * Constructor de Estudiante
	 * 
	 * @param Nombre
	 *            el nombre del estudiante
	 * @param index
	 *            la posicion en la lista del clase del estudiante
	 */
	public Estudiante(String Nombre, int index) {
		this.Nombre = Nombre;
		this.index = index;
	}

	/**
	 * Get de index
	 */
	@Override
	public int getIndex() {
		return this.index;
	}

	/**
	 * Set de index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Hash code de estudiante, denotado por su index
	 */
	@Override
	public int hashCode() {
		return index;
	}

	/**
	 * CompareTo de Estudiante, retorna -1 si this es mayor a comparacion 0 si
	 * son iguales y 1 si comparacion es mayor a this
	 */
	@Override
	public int compareTo(Object comparacion) {
		int primero = this.index;
		int segundo = ((Estudiante) comparacion).index;
		int res = 0;
		if (primero < segundo) {
			res = -1;
		} else if (primero == segundo) {
			res = 0;
		} else if (primero > segundo) {
			res = 1;
		}
		return res;
	}

	/**
	 * Get de nombre
	 */
	@Override
	public String getNombre() {
		return this.Nombre;
	}

	/**
	 * Set de nombre
	 */
	@Override
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

}
