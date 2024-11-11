package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String mensagem){
        System.out.println("Enviado email: " + mensagem);
    }
}


// ele é um component.

//@Component: Anotação genérica para qualquer bean gerenciado pelo Spring.
//@Service: Anotação específica para classes que implementam lógica de negócios, melhorando a clareza do código.