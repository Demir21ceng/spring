    package com.mycompany.todowithspring1.controller;

    import com.mycompany.todowithspring1.dto.*;
    import com.mycompany.todowithspring1.model.*;
    import com.mycompany.todowithspring1.services.TodoServices;
    import java.util.List;

    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.*;

    /**
     *
     * @author servan
     */
    @Controller
    @RequestMapping("/todo")
    public class TodoController {

        private final TodoServices services;

        public TodoController(@Qualifier("todoServices") TodoServices services) {
            this.services = services;
        }

        @PostMapping("/create")

        public String createTodo(
                @Valid @ModelAttribute("todo") CreateTodoRequest request,
                BindingResult bindingResult

        ) {

            if (bindingResult.hasErrors()) {
                // Hataları JSP’ye geri gönder
                return "redirect:/todo"; // formun olduğu JSP
            }

            services.createTodo(
                    request.getDuty(),
                    request.getImportance(),
                    request.getCompletionStatus()
            );

            return "redirect:/todo";
        }

        // ---------- EDİT -----------
        @GetMapping("/edit")
        public String editTodo(
                @RequestParam("duty") String duty,
                Model model
        ) {
            Todo todo = services.findTodoByDuty(duty);
            model.addAttribute("todo", todo);
            return "todo-edit";
        }


        // --------- UPDATE IMPORTANCE----------
        @PostMapping("/update/importance")
        public String updateImportance(
                @Valid @ModelAttribute("updateImportance") TodoUptadeImportanceRequest request,
                BindingResult result
        ) {
            if (result.hasErrors()) {
                return result.getAllErrors().toString();
            }

            services.updateImportance(
                    request.getDuty(),
                    request.getImportance()
            );

            return "redirect:/todo";
        }



        // --------- UPDATE COMPLLETİON STATUS----------
        @PostMapping("/update/status")
        public String updateStatus(
                @Valid @ModelAttribute("updateStatus") TodoUpdateStatusRequest request,
                BindingResult result
        ) {
            if (result.hasErrors()) {
                return result.getAllErrors().toString();
            }

            services.updateCompletionStatus(
                    request.getDuty(),
                    CompletionStatus.completed
            );

            return "redirect:/todo";
        }


        // ---- DELETE ----
        @PostMapping("/delete")
        public String deleteTodo(
                @Valid @ModelAttribute("deleteTodo") TodoDeleteRequest request,
                BindingResult result
        ) {
            if (result.hasErrors()) {
                return result.getAllErrors().toString();
            }

            services.deleteTodo(request.getDuty());
            return "redirect:/todo";
        }




        // ---- LIST ALL ----
        @GetMapping
        public String todoList(Model model) {
            List<TodoResponse> todos = services.getAllTodos();
            model.addAttribute("todos", todos);
            return "test"; // JSP adı
        }

        // ---- LIST ONLY IMPORTANT ----
        @GetMapping("/important")
        public String getImportantTodos(Model model) {
            List<TodoResponse> todos = services.getImportantTodos();
            model.addAttribute("todos", todos);
            return "test"; // JSP adı
        }

    }
