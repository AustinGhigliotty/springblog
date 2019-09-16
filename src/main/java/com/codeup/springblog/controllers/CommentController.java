package com.codeup.springblog.controllers;

import com.codeup.springblog.Models.Ad;
import com.codeup.springblog.Models.Comment;
import com.codeup.springblog.Models.User;
import com.codeup.springblog.repos.AdRepository;
import com.codeup.springblog.repos.CommentRepository;
import com.codeup.springblog.repos.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    private final AdRepository adDao;
    private final UserRepository userDao;
    private final CommentRepository commentDao;

    public CommentController(AdRepository adRepo, UserRepository userRepo, CommentRepository commentRepo){
        this.userDao = userRepo;
        this.adDao = adRepo;
        this.commentDao = commentRepo;

    }

//    @GetMapping("/comments")
//    public String index(Model vModel) {
//        Iterable<Comment> comments = commentDao.findCommentsByAd();
//        vModel.addAttribute("comments", comments);
//        return "ads/";
//    }

    @GetMapping("/comments/create")
    public String addComment(Model model) {
        model.addAttribute("comment", new Comment());
        return "ads/";
    }

    @PostMapping("/comments/create")
    public String createComment(
            @ModelAttribute Comment commentText
    ) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = userDao.findOne(userSession.getId());
        commentText.setUser(userDB);
//        commentText.setAd();
        Comment savedComment = commentDao.save(commentText);
//        EmailService.prepareAndSend(
//                savedAd,
//                "Ad created",
//                String.format("Ad with the id %d has been created", savedAd.getId()));
        return "redirect:/ads/" + savedComment.getId();
    }

    @GetMapping("/comments/show")
    public String show(@RequestParam(name = "ad-id") long term, Model viewModel) {
        List<Comment> comments = commentDao.findCommentsByAd(term);
        viewModel.addAttribute("comments", comments);
        return "ads/index";
    }
}
