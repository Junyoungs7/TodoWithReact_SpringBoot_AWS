package com.jun.todo.service;

import com.jun.todo.model.TodoEntity;
import com.jun.todo.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public String testService(){
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
        todoRepository.save(entity);
        TodoEntity savedEntity = todoRepository.findById(entity.getId()).get();
        return savedEntity.getTitle();
    }

    private void validate(final TodoEntity entity) {
        if(entity == null){
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }
        if (entity.getUserId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

    public List<TodoEntity> create(final TodoEntity entity){
        todoRepository.save(entity);
        log.info("Entity Id : {} is saved.", entity.getId());
        return todoRepository.findByUserId(entity.getUserId());
    }
}
