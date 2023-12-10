package edu.lab.tag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TableRow {

    private List<String> items;
}
