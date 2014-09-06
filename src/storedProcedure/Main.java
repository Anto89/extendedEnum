package storedProcedure;

import storedProcedure.StoredProcedureResponse.STORED_PROCEDURE_NAME;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String eanResponseOk = "ean OK";
		final String eanResponseKo = "ERR1";
		final String nuartResponseOk = "nuart OK";
		final String nuartResponseKo = "ERR2";
		
		StoredProcedureResponse eanOk = new StoredProcedureResponse(STORED_PROCEDURE_NAME.EAN, eanResponseOk);
		System.out.println(eanOk.getValidResult() + " - " + eanOk.getErrorStatus());
		
		StoredProcedureResponse eanKo = new StoredProcedureResponse(STORED_PROCEDURE_NAME.EAN, eanResponseKo);
		System.out.println(eanKo.getValidResult() + " - " + eanKo.getErrorStatus().getInternationalizedCode());
		
		StoredProcedureResponse nuartOk = new StoredProcedureResponse(STORED_PROCEDURE_NAME.NUART, nuartResponseOk);
		System.out.println(nuartOk.getValidResult() + " - " + nuartOk.getErrorStatus());
		
		StoredProcedureResponse nuartKo = new StoredProcedureResponse(STORED_PROCEDURE_NAME.NUART, nuartResponseKo);
		System.out.println(nuartKo.getValidResult() + " - " + nuartKo.getErrorStatus().getInternationalizedCode());
	}

}
