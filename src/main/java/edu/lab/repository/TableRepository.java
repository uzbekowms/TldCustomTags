package edu.lab.repository;

import edu.lab.tag.entity.Table;
import edu.lab.tag.entity.TableRow;
import lombok.Data;

import java.util.List;

@Data
public class TableRepository {

    private static TableRepository repository;
    private Table table = Table.builder()
            .titles(List.of("First", "Second", "Third"))
            .rows(
                    List.of(
                            new TableRow(List.of("11", "12", "13")),
                            new TableRow(List.of("21", "22", "23")),
                            new TableRow(List.of("31", "32", "33"))
                    )
            )
            .build();

    private TableRepository() {
    }

    public static TableRepository getInternal() {
        if (repository == null) {
            repository = new TableRepository();
        }
        return repository;
    }
}
