package com.example.demo;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.model.Todos;
import com.example.model.TodosPropertiesEditor;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	CustomClassListInValue customClassListInValue;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CustomEditorConfigurer customEditorConfigurer() {

	    Map<Class<?>, Class<? extends PropertyEditor>> customEditors = 
	            new HashMap<Class<?>, Class<? extends PropertyEditor>>(1);
	    customEditors.put(Todos.class, TodosPropertiesEditor.class);

	    CustomEditorConfigurer configurer = new CustomEditorConfigurer();
	    configurer.setCustomEditors(customEditors);

	    return configurer;
	}

}
