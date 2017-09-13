package com.example;

import com.example.model.Info;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by libin on 5/16/16.
 */
public interface InfoRepository extends CrudRepository<Info, Long> {
    List<Info> findByName(String name);
}
