package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Autowired vai injetar uma instancia dos beans no construtor. (Isso é uma injeção de dependecia)

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository,
                       TodoValidator validator,
                       MailSender mailSender){
        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        mailSender.enviar("Todo "  + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }
}

// camada lógica
