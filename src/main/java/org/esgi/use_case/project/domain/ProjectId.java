package org.esgi.use_case.project.domain;

import java.util.Objects;

public final class ProjectId {
    private final int id;

    private ProjectId(int id){
        this.id = id;
    }

    public static ProjectId of(int id) {
        return new ProjectId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectId projectId = (ProjectId) o;
        return id == projectId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getValue(){
        return String.valueOf(id);
    }
}
