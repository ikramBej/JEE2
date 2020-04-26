package tn.esprit.jsf_app.presentation.mbeans;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.jsf_app.entities.Request.Category;
import tn.esprit.jsf_app.entities.Request.Kind;
import tn.esprit.jsf_app.entities.Request.Priority;
import tn.esprit.jsf_app.entities.Request.Status;


@ManagedBean
@ApplicationScoped
public class Data {
	
	public Category[] getCategory(){
		return Category.values();
		
	}
	
	public Priority[] getPriority(){
		return Priority.values();
		
	}
	
	public Kind[] getKind(){
		return Kind.values();
		
	}
	
	public Status[] getStatus(){
		return Status.values();
		
	}


}
