package com.redcompany.red.entity.behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Schema {


    private List<HobbyDayAndTime> listSchema;

    public Schema() {
        listSchema = new ArrayList();
    }

    public void addDayAndTimeToSchemaList(HobbyDayAndTime hobbyDayAndTime){
        listSchema.add(hobbyDayAndTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schema schema = (Schema) o;
        return Objects.equals(listSchema, schema.listSchema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listSchema);
    }

    @Override
    public String toString() {
        return "Schema{" +
                "listSchema=" + listSchema +
                '}';
    }
}
