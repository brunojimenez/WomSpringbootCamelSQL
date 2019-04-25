package cl.wom.middleware.bean;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelProcessor implements Processor {

	private final static Logger LOGGER = Logger.getLogger(CamelProcessor.class.toString());

	@Override
	public void process(Exchange exchange) throws Exception {

		Object obj = exchange.getIn().getBody();
		if (obj instanceof List<?>) {
			List<?> list = (List<?>) obj;
			for (Object listItem : list) {
				if (listItem instanceof Map<?, ?>) {
					Map<?, ?> itemMap = (Map<?, ?>) listItem;
					LOGGER.info("CamelProcessor : " + itemMap.get("DATA"));
				}
			}
		}

	}

}
