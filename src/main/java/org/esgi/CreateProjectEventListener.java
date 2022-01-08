package org.esgi;

import org.esgi.kernel.EventListener;
import org.esgi.use_case.project.application.CreateProjectEvent;
import org.esgi.use_case.project.domain.ProjectRepository;
import org.esgi.use_case.project.domain.ProjectValidator;

public class CreateProjectEventListener implements EventListener<CreateProjectEvent> {
    private final ProjectRepository projectRepository;

    public CreateProjectEventListener(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void listenTo(CreateProjectEvent event){
        final ProjectValidator validator = new ProjectValidator();

        if(validator.isValid(event.getProject())) {
            projectRepository.setValid(event.getProject().getId());
        } else {
            projectRepository.setInvalid(event.getProject().getId());
        }

    }
}
