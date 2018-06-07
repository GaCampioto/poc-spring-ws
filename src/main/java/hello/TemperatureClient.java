package hello;

import hello.wsdl.CelsiusToFahrenheit;
import hello.wsdl.CelsiusToFahrenheitResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TemperatureClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TemperatureClient.class);

    public CelsiusToFahrenheitResponse celsiusToFahrenheit(String celsius) {
        CelsiusToFahrenheit request = new CelsiusToFahrenheit();
        request.setCelsius(celsius);

        CelsiusToFahrenheitResponse response = (CelsiusToFahrenheitResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.w3schools.com/xml/tempconvert.asmx",
                        request,
                        new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit"));

        return response;
    }
}
