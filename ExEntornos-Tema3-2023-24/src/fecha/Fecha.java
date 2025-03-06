package fecha;

public class Fecha {
	public static final int DIEZ = 10;
	private int dia; //d�a
	private int mes; //mes
	private int año; //a�o

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
		this.dia = dia;
		this.mes = mes;
		this.año = anio;
	}

	
	/**
	 * Comprueba si la fecha invocante es correcta
	 * @return Devuelve 3 booleanos que indican si el dia, el mes y el año son correctos
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto; 
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = año > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Comprueba si el año invocante es bisiesto
	 * @return Devuelve un booleano, True si es bisiesto y false en caso contrario
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean esBisiesto = año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
		return esBisiesto;
	}

	/**
	 * Suma un dia a la fecha invocante, actualizando también meses y años
	 */
	// M�todo diaSiguiente
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				año++;
			}
		}
	}

	/**
	 * Metodo toString que sobre escribe a la clase Object, 
	 * devuelve la fecha en un formato especifico
	 */
	// M�todo toString
	public String toString() {
		String res = "";
		if (dia < DIEZ && mes < 10) {
			res = "0" + dia + "-0" + mes + "-" + año;
		} else if (dia < 10 && mes >= 10) {
			res = "0" + dia + "-" + mes + "-" + año;
		} else if (dia >= 10 && mes < 10) {
			res = dia + "-0" + mes + "-" + año;
		} else {
			res = dia + "-" + mes + "-" + año;
		}
		return res;
	}

}
