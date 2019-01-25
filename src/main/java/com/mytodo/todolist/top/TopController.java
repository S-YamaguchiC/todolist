package com.mytodo.todolist.top;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TopController {

    @RequestMapping(method = RequestMethod.GET)
    public String TopPage() {
        return "index";
    }
}
