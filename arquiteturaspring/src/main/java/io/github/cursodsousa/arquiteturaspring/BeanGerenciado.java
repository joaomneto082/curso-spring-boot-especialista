package io.github.cursodsousa.arquiteturaspring;

import io.github.cursodsousa.arquiteturaspring.todos.TodoEntity;
import io.github.cursodsousa.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


// beans são instancias de componentes
// o escopo padrão é singleton (uma instancia unica vai atender a toda a aplicação)
//@Lazy(false)   //só vai carregar quando precisar
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class BeanGerenciado {

    private String idUsuarioLogado;

    @Autowired
    private TodoValidator validator;

    @Autowired // O spring prefere que se use o construtor, mais recomendado.
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator){   //ALT + ENTER - vai indicar como preencher o campo
        this.validator = validator;
        ;
    }
}
