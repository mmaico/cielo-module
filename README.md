cielo-module
============

API de integracao com o sistema de pagamento da Cielo desenvolvida em Java.

Exemplo de uso para integração buyCielo Page

```java
import br.com.kohen.module.cielo.entity.*;
import br.com.kohen.module.cielo.enums.*;
import br.com.kohen.module.cielo.ws.impl.CieloWebServiceImpl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.DatatypeConverter;
import java.text.ParseException;
import java.util.Calendar;

public static void main(String[] args) throws ParseException {
    CieloWebServiceImpl service = new CieloWebServiceImpl();
    CieloResponse cieloResponse = service.newTransaction(getTransaction());

    System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction(), ToStringStyle.MULTI_LINE_STYLE));
    System.out.println(cieloResponse.getTransaction().getUrlAuthentication());
}

private static CieloTransaction getTransaction() throws ParseException {
    Calendar calendar = DatatypeConverter.parseDateTime("2013-04-09T11:43:37");
    CieloOrder cieloOrder = CieloOrder.build().withNumber("12345")
        .withAmount(100000l)
        .withCurrency(CieloCurrency.REAL)
        .withDate(calendar.getTime())
        .withLang(CieloLanguage.EN);

    CieloPayment cieloPayment = CieloPayment.build().withCreditCardType(CieloCreditCardType.VISA)
        .withPlots(3)
        .withModality(CieloModality.INSTALLMENTS_BUSINESS_STABLISHMENT);

    CieloTransaction cieloTransaction = CieloTransaction.build().withOrder(cieloOrder)
        .withPayment(cieloPayment);

    cieloTransaction.setCapture(Boolean.TRUE);

    return cieloTransaction;
}
```

   A api irá buscar as configurações dentro do arquivo cielo-config.properties dentro do seu resources (src/java/resources)
   segue as chaves que deve estar no arquivo:

```properties
cielo.establishment.number=1001734898
cielo.establishment.key=e84827130b9837473681c2787007da5914d6359947015a5cdb2b8843db0fa832
cielo.url.to.return=http://localhost/back
cielo.url.webservice=https://qasecommerce.cielo.com.br/servicos/ecommwsec.do
```

   Para recuperar uma venda com o TID devolvido na resposta da criação use:

```java
String tid = "10017348980976562003";
//getTransaction().getbEstablishment() - Essa chamada ira recuperar os dados do estabelecimento do arquivo cielo-config.properties.

CieloResponse cieloResponse = service.findTransaction(tid, getTransaction().getbEstablishment());
```
