package bg.jwd.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String sayHello() {
		return "Hello";
	}

}
