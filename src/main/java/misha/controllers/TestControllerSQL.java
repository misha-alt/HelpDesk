package misha.controllers;


import misha.domain.User;
import misha.service.CreateComment;
import misha.service.ManagerService;
import misha.service.TickedService;
import misha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.security.Principal;

@Controller
@Transactional
public class TestControllerSQL {

    private ManagerService managerService;
    private UserService userService;
    private TickedService tickedService;
    private CreateComment createComment;

    @Autowired
    public TestControllerSQL(CreateComment createComment, ManagerService managerService, UserService userService, TickedService tickedService) {
        this.managerService = managerService;
        this.userService = userService;
        this.tickedService = tickedService;
        this.createComment = createComment;

    }

    @RequestMapping("/testCont")
    public ModelAndView create (Principal principal, Model model,@RequestParam(value = "ob", defaultValue = "NEW") Object ob){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testFilter");

        model.addAttribute("ob", tickedService.filteredListByCriteria(ob));


        return modelAndView;
    }

}
