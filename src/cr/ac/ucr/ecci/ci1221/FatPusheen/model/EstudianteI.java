package cr.ac.ucr.ecci.ci1221.FatPusheen.model;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.Enumerable;

public interface EstudianteI extends Comparable, Enumerable {

	/**
	 * Get de index
	 */
	@Override
	public int getIndex();

	/**
	 * Set de index
	 */
	public void setIndex(int index);

	/**
	 * Get de nombre
	 */
	public String getNombre();

	/**
	 * Set de nombre
	 */
	public void setNombre(String Nombre);

	/**
	 * Hash code de estudiante, denotado por su index
	 */
	@Override
	public int hashCode();

	/**
	 * CompareTo de Estudiante, retorna -1 si this es mayor a comparacion 0 si
	 * son iguales y 1 si comparacion es mayor a this
	 */
	@Override
	public int compareTo(Object comparacion);
}
