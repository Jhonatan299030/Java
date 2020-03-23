package br.com.lorde.supremo.listavip;

import br.com.lorde.supremo.enviaemail.EmailService;
import br.com.lorde.supremo.listavip.model.Convidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadoController {
    @Autowired
    private ConvidadoService service;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("listaconvidados")
    public String listaconvidados(Model model){
        model.addAttribute("convidados",
            service.obterTodos()
        );

        return "listaconvidados";
    }

    @RequestMapping(value= "salvar", method = RequestMethod.POST)
    public ModelAndView salvar(@RequestParam MultiValueMap convidado, ModelMap model){
        service.salvar(new Convidado(convidado));

        new EmailService().enviar((String) convidado.getFirst("nome"),
            (String) convidado.getFirst("email")
        );

        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/listaconvidados", model);
    }
}
