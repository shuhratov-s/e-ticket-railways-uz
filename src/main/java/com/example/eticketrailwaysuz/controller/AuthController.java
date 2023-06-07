package com.example.eticketrailwaysuz.controller;

import com.example.eticketrailwaysuz.domain.dto.BaseResponse;
import com.example.eticketrailwaysuz.domain.dto.request.UserPostRequest;
import com.example.eticketrailwaysuz.domain.dto.response.UserGetResponse;
import com.example.eticketrailwaysuz.service.RailwayFlightService;
import com.example.eticketrailwaysuz.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final RailwayFlightService railwayFlightService;

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("user") UserPostRequest userPostRequest){
        BaseResponse<UserGetResponse> response = userService.create(userPostRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", response.getMessage());
        if (response.getStatus()==200){
            modelAndView.setViewName("login");
        }else {
            modelAndView.setViewName("sign-up");
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              HttpSession session){
        BaseResponse<UserGetResponse> response = userService.login(email, password);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", response.getMessage());

        if (response.getStatus()!=200){
            modelAndView.setViewName("login");
        }else {
            session.setAttribute("userId", response.getData().getId());
            if (response.getData().isAdmin()) {
                modelAndView.addObject("railwayFlights", railwayFlightService.getAll());
                modelAndView.setViewName("admin-page");
            } else {
                modelAndView.setViewName("user-page");
            }
        }
        return modelAndView;
    }

    @GetMapping("/log")
    public ModelAndView jumpLogin(){
        return new ModelAndView("login");
    }
    @GetMapping("/reg")
    public ModelAndView jumpRegister(){
        return new ModelAndView("sign-up");
    }
}
