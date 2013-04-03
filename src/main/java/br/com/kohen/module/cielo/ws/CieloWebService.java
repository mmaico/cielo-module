package br.com.kohen.module.cielo.ws;

import br.com.kohen.module.cielo.entity.CieloResponse;
import br.com.kohen.module.cielo.entity.CieloTransaction;


public interface CieloWebService {

	CieloResponse newTransaction(CieloTransaction transaction);
}
