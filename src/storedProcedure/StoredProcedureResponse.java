package storedProcedure;

/**
 * Classe representant la reponse a l'appel d'une procedure stockee.
 */
public class StoredProcedureResponse {
	private String response;
	private String validResult;
	private StoredProcedureErrorStatus errorStatus;

	public StoredProcedureResponse(STORED_PROCEDURE_NAME storedProcedure,
			String response) {
		this.response = response;

		if (isResponseValid()) {
			validResult = response;
		} else {
			switch (storedProcedure) {
			case EAN:
				errorStatus = EAN_ERROR_RESPONSE.valueOf(response);
				break;
			case NUART:
				errorStatus = NUART_ERROR_RESPONSE.valueOf(response);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Determine si la reponse est valide.
	 * @return
	 */
	public boolean isResponseValid() {
		if (response == null || response.isEmpty()) {
			return false;
		}

		return !response.startsWith("ERR");
	}

	/**
	 * Retourne le code erreur si la reponse n'est pas valide, null sinon.
	 * 
	 * @param errorStatus
	 */
	public StoredProcedureErrorStatus getErrorStatus() {
		return errorStatus;
	}

	/**
	 * Retourne le resultat si la reponse est valide, null sinon.
	 * 
	 * @return
	 */
	public String getValidResult() {
		return validResult;
	}

	private enum EAN_ERROR_RESPONSE implements StoredProcedureErrorStatus {
		ERR1("ERR1", "codeEanErr1"), ERR2("ERR2", "codeEanErr2");

		private String errCode;

		private EAN_ERROR_RESPONSE(String name, String errCode) {
			this.errCode = errCode;
		}

		@Override
		public String getInternationalizedCode() {
			return errCode;
		}
	}

	private enum NUART_ERROR_RESPONSE implements StoredProcedureErrorStatus {
		ERR1("ERR1", "codeNuartErr1"), ERR2("ERR2", "codeNuartErr2");

		private String errCode;

		private NUART_ERROR_RESPONSE(String name, String errCode) {
			this.errCode = errCode;
		}

		@Override
		public String getInternationalizedCode() {
			return errCode;
		}
	}

	public static enum STORED_PROCEDURE_NAME {
		EAN, NUART;
	}
}
