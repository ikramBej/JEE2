package tn.esprit.jsf_app.presentation.mbeans;

import tn.esprit.jsf_app.entities.Meeting;

public class BackBean {

	public  String request(){
		String navigateTo = "null";
		navigateTo ="/template/ListRequest?faces-redirect=true";
		return navigateTo;
		
	}
	
	public  String meeting(){
		String navigateTo = "null";
		navigateTo ="/template/ListMeeting?faces-redirect=true";
		return navigateTo;
		
	}
}
