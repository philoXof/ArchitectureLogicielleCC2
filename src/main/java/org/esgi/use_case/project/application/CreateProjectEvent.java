package org.esgi.use_case.project.application;

import org.esgi.kernel.ApplicationEvent;
import org.esgi.use_case.project.domain.Project;

import java.util.Objects;

public final class CreateProjectEvent implements ApplicationEvent {
    private final Project project;

    public CreateProjectEvent(Project project){
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProjectEvent that = (CreateProjectEvent) o;
        return Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project);
    }
}
