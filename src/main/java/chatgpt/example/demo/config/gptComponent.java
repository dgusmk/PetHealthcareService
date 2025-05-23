package chatgpt.example.demo.config;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class gptComponent {
    @Value("${spring.ai.openai.api-key}")
    private String key_value;

    @Bean
    public OpenAiApi A(){
        String asd;
        return new OpenAiApi(key_value);
    }

    @Bean
    public OpenAiChatClient B(){
        return new OpenAiChatClient(A());
    }
}
