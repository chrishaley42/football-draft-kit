package com.chaley.football.draft.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.chaley.football.draft.dao.UserDAO;
import com.chaley.football.draft.model.User;
import com.google.gson.Gson;


@Path("/user")
public class UserService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final String NO_USER = "User does not Exist.";
	private final String WRONG_PASSWORD = "Email Address and Password do not match.";
	private final String USER = "user";
	private final String UNAUTH_REQ = "Unauthorized Request";
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Context HttpServletRequest request,@FormParam("email") String email, @FormParam("password") String password) {
		List<User> users = new ArrayList<User>();
		users = getUser(email, request);
		if(users.size() > 0) {
			if(users.get(0).getPassword().equals(password)) {
				User user = users.get(0);
				HttpSession session = request.getSession();
			    session.setAttribute(USER, user);
				return Response.status(Response.Status.OK).entity(new Gson().toJson(user)).build();
			} else {
				// bad Password
				return Response.status(Response.Status.UNAUTHORIZED).entity(WRONG_PASSWORD).build();
			}
		} else { 
			// User doesn't exist
			return Response.status(Response.Status.NOT_FOUND).entity(NO_USER).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSessionUser(@Context HttpServletRequest request) {
		HttpSession session = request.getSession();
	       
	    if (session.getAttribute(USER) != null && session.getAttribute(USER) instanceof User) {
	      User user = (User) session.getAttribute(USER);
	      return Response.status(Response.Status.OK).entity(new Gson().toJson(user)).build();
	    } else {
	      return Response.status(Response.Status.UNAUTHORIZED).entity(UNAUTH_REQ).build();
	    }
	}
	
	@GET
	@Path("/logout")
	public String logOut(@Context HttpServletRequest request) {
		HttpSession session = request.getSession();
	    session.invalidate();
	    return "success";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	public boolean register(@Context HttpServletRequest request, @FormParam("firstName") String firstName,@FormParam("lastName") String lastName,
			                @FormParam("email") String email,@FormParam("password") String password){
		boolean success = false;
		EntityManagerFactory emf = (EntityManagerFactory) request.getSession().getServletContext().getAttribute(EntityManagerFactory.class.getName());
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			try {
				User user = new User(firstName,lastName,email,password);
		        em.getTransaction().begin();
		        UserDAO dao = new UserDAO(em);
		        dao.persist(user);
		        em.getTransaction().commit();
		        HttpSession session = request.getSession();
			    session.setAttribute(USER, user);
		        success = true;
		        
			} catch (Exception e) {
				log.info(e.getMessage());
		        em.getTransaction().rollback();
		    } finally {
		        em.close();
		    }
		        
		}
		return success;
	}
	
	public List<User> getUser(String email,HttpServletRequest request) {
		List<User> users = new ArrayList<User>();
		EntityManagerFactory emf = (EntityManagerFactory) request.getSession().getServletContext().getAttribute(EntityManagerFactory.class.getName());
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			try {
		        em.getTransaction().begin();
		        UserDAO dao = new UserDAO(em);
		        users = dao.getUser(email);
			} catch (Exception e) {
				log.info(e.getMessage());
		    } finally {
		        em.close();
		    }
		}
		return users;
	}
}
