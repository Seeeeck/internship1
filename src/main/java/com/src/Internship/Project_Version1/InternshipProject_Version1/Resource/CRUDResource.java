package com.src.Internship.Project_Version1.InternshipProject_Version1.Resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

import com.src.Internship.Project.Internship_Project.Entity.RequestBody;
import com.src.Internship.Project_Version1.Internship_Project_Version1.Logic.UserQuestionnaireLogic;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("")
public class CRUDResource {
	
	@Inject
	UserQuestionnaireLogic Questionnaire;
	
	@POST
    @Path("/UserQuestionnaire")
    public Response UserQuestionnaire(RequestBody requestBody) {
		System.out.println(requestBody);
    	return Questionnaire.CRUDService(requestBody);
    }


}
