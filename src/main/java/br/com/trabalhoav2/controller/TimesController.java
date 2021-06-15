package br.com.trabalhoav2.controller;

import br.com.trabalhoav2.model.Times;
import br.com.trabalhoav2.repository.TimesRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TimesController {
    @Autowired
    private TimesRepository timesRepository;

    @GetMapping("/gerenciarTimes")
    public String listarTimes(Model model) {
        model.addAttribute("listaTimes", timesRepository.findAll());
        return "gerenciar_Times";
    }

    @GetMapping("/novoTime")
    public String novoTime(Model model) {
        model.addAttribute("times", new Times());
        return "editar_time";
    }

    @GetMapping("/editarTimes/{id}")
    public String editarTimes(@PathVariable("id") long idTimes, Model model) {
        Optional<Times> times = timesRepository.findById(idTimes);
        model.addAttribute("times", times.get());
        return "editar_times";
    }

    @PostMapping("/salvarTimes")
    public String salvarTimes(Times times, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_times";
        }
        timesRepository.save(times);
        return "redirect:/gerenciarTimes";
    }

    @GetMapping("/excluirTimes/{id}")
    public String excluirTimes(@PathVariable("id") long idTimes) {
        timesRepository.deleteById(idTimes);
        return "redirect:/gerenciarTimes";
    }
    
}
