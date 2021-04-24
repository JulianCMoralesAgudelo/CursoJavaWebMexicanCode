package dominio.login;

import dominio.controlador.UsersFacade;
import dominio.modelo.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("recurso")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersEndPoint extends Application {

    @EJB
    UsersFacade usersService;

    @GET
    public List<Users> listAll() {
        return usersService.findAll();
    }

    @GET
    @Path("{id}")
    public Users findById(@PathParam("id") Integer id) {
        return usersService.find(id);
    }

    @GET
    @Path("{usr}/{password}")
    public boolean findByUsr(@PathParam("usr") String usr, @PathParam("password") String password) {
        return usersService.findUsrPassword(usr, password);
    }

    @POST
    @Path("{usr}/{password}")
    public void create(@PathParam("usr") String usr, @PathParam("password") String password) {
        Users u = new Users();
        u.setUsr(usr);
        u.setPassword(password);
        usersService.create(u);
    }

    @PUT
    @Path("{id}")    
    public void edit(@PathParam("id") Integer id,Users u) {        
        usersService.edit(u);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        usersService.remove(usersService.find(id));
    }

}
