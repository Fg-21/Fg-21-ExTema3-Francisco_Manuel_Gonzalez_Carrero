package fecha;

public class Fecha {
	private int d; //d�a
	private int m; //mes
	private int a; //a�o

	/**
	 * Constructor de la fecha vacío
	 */
	public Fecha() {

	}

	
	/**
	 * Constructor de la fecha con el dia, mes y año
	 * @param dia Dia de la fecha
	 * @param mes Mes de la fecha
	 * @param anio Año de la fecha
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Comprueba si la fecha invocante es correcta
	 * @return Devuelve 3 booleanos que indican si el dia, el mes y el año son correctos
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Comprueba si el año invocante es bisiesto
	 * @return Devuelve un booleano, True si es bisiesto y false en caso contrario
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Suma un dia a la fecha invocante, actualizando también meses y años
	 */
	// M�todo diaSiguiente
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Metodo toString que sobre escribe a la clase Object, 
	 * devuelve la fecha en un formato especifico
	 */
	// M�todo toString
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
