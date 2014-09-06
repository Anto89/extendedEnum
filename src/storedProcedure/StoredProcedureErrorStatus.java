package storedProcedure;

/**
 * Interface que doit implementer les enums d'erreurs des proc stock.
 */
public interface StoredProcedureErrorStatus {
	/**
	 * Recupere le code de message d'erreur.
	 * @return
	 */
	String getInternationalizedCode();
}
