package org.esgi.use_case.project.application;

import org.esgi.kernel.ApplicationEvent;
import org.esgi.kernel.EventBus;
import org.esgi.use_case.project.domain.ProjectId;
import org.esgi.use_case.project.domain.ProjectRepository;
import org.esgi.use_case.project.domain.Project;

public final class ProjectService {
    private final ProjectRepository projectRepository;
    private final EventBus<ApplicationEvent> eventBus;

    public ProjectService(ProjectRepository projectRepository, EventBus<ApplicationEvent> eventBus) {
        this.projectRepository = projectRepository;
        this.eventBus = eventBus;
    }

    public void create(Project project){
        this.projectRepository.add(project);
        this.eventBus.publish(new CreateProjectEvent(project));
    }

    public void setValid(ProjectId id){
        System.out.println("coucou");
        this.projectRepository.setValid(id);
    }
}
