package edu.lab.repository;

import edu.lab.tag.entity.MenuItem;
import lombok.Getter;

import java.util.List;

@Getter
public class MenuRepository {

    private static MenuRepository repository;

    private List<MenuItem> items = List.of(
            new MenuItem("Main", "/menu"),
            new MenuItem("Store", "/store"),
            new MenuItem("Profile", "/profile"));

    private MenuRepository(){}

    public static MenuRepository getInternal(){
        if (repository == null){
            repository = new MenuRepository();
        }
        return repository;
    }

}
