package io.bhimsen.springbootconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${my.greeting : bhimsensss}")
	private String greetingMsg;

	@Value("static message")
	private String staticMessage;

	@Value("${my.list.values}")
	private List<String> listValues;

	@Value("#{${db.connection}}")
	private Map<String, String> dbValues;

	@Autowired
	private DbSetting dbSetting;

	@GetMapping("/greeting")
	public String greeting() {
		return dbSetting.getConnection() + " , " + dbSetting.getHost() + " , " + dbSetting.getPort();
	}
}
