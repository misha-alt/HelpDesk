package misha.service;

import misha.domain.Comments;
import misha.domain.Ticked;
import misha.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class ManagerService {

    private SessionFactory sessionFactory;
    private UserService userService;
    private CreateComment createComment;

    @Autowired
    public ManagerService(SessionFactory sessionFactory, UserService
                           userService, CreateComment createComment) {
        this.sessionFactory = sessionFactory;
        this.userService =userService;
        this.createComment = createComment;
    }

    public List<User> allComments(){
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public List<User>  onleUsersWithComments(){
        List list1 = new ArrayList();
        List list = allComments();

        //Comments comment;

        for(int i = 0;i<list.size();i++){
            User user;
            user = (User)list.get(i);
            if (user.getComments().isEmpty()){
             // list1.add(user);
          }else {list1.add(user);

            }
        }
        return list1;
    }

    public List<User> allEngineers(){
        return sessionFactory.getCurrentSession()
                .createQuery("from User where authority='ROLE_ENGINEER'").list();
    }

    public List<User> allTicket(){
        return sessionFactory.
                getCurrentSession().createQuery("from Ticked").list();
    }
    public List<Ticked>  onleExistsTickets(){
        List list = new ArrayList();
        List lisrOfTicked = allTicket();

        for(int i = 0;i<lisrOfTicked.size();i++){
           Ticked ticked;
            ticked = (Ticked) lisrOfTicked.get(i);
            if (ticked.getName().isEmpty()){
                // list1.add(user);
            }else {list.add(ticked);

            }
        }
        return list;
    }

    public void seveManagerTicked (Ticked ticked, String name){
        createTickced(ticked);
        User user = userService.getByLogin(name).get(0);
        user.getTicked().add( getTickedById(ticked.getId()));
        createComment.updateUsersComment(user);
    }

    public void createTickced (Ticked ticked){
        Session session = sessionFactory.getCurrentSession();
        session.save(ticked);
    }

    public Ticked getTickedById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Ticked p where p.id = :id");
        query.setParameter("id", id);
        return (Ticked) query.list().get(0);
    }

   /* SELECT Dept, Name, Job
    FROM Staff WHERE Dept=38*/
}
