package com.washiner.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.washiner.crud.model.Empregado;
import com.washiner.crud.service.EmpregadoService;

@Controller // defino que o metodo e Controlador
@RequestMapping("/empregados") //metodos encapsulados aqui
public class EmpregadoController {

    @Autowired
    public EmpregadoService EmpregadoService; // no controller vou injetar o serviço
    //automatizando servico criando um objeto pra ele injetando aqui

    //vou chamar os metodos pra conversa com model
    @GetMapping // mapeia todas as requisiçoes http do tipo GET
    //aqui nao tem argumento ou seja vai responder apenas as requisiçoes do tipo get que vai ser baseada no controlador ou seja /empregados

    public String getAllEmpregados(Model model){ //dica aqui seria o selectALL
       
        //essa lista ele vai caputar la do Service e cria ali o empregados(objeto)
        List<Empregado> empregados = EmpregadoService.getAllEmpregados();

        //model e um objeto fornecido pelo spring que vai permitir passar todos os dados do controlador para uma view , dentro dele tem o addatribute onde vai adicionar o atributo com o modelo empregados e o valor que tiver no empregados a lista que ele pega ele vai sair com aquele nome empregados
        model.addAttribute("empregados", empregados);
        return "empregado/list"; // vai retornar uma view(pagina renderizada) em formato de string por que o metodo e public string // esse arquivos naot emos vamos criar no template 

    }
    @GetMapping("/novo")
    public String showForm(Empregado empregado){//aqui seria igual o insert no banco
        return "empregado/form";
    }

    @PostMapping
    public String saveEmpregado(@ModelAttribute Empregado empregado){
        EmpregadoService.saveEmpregado(empregado);
        return "redirect:/empregados";
    }


    @GetMapping("editar/{matricula}")
    public String showUpdateForm(@PathVariable("matricula") Long matricula, Model model){
        Empregado empregado = EmpregadoService.getEmpregadoById(matricula).orElseThrow(() -> new
        IllegalArgumentException("Matricula do empregado inválido: " + matricula));
        model.addAttribute("empregado", empregado);
        return "empregado/form";
    }

    @GetMapping("/deletar/{matricula}")
    public String deleteEmpregado(@PathVariable("matricula") Long matricula){
        EmpregadoService.deleteEmpregado(matricula);
        return "redirect:/empregados";
    }


}

//Use @Controller quando você estiver desenvolvendo 
//uma aplicação web tradicional com páginas HTML.


//Use @RestController quando você estiver desenvolvendo
//uma API RESTful onde você deseja retornar dados no formato JSON ou XML.

//obs: tem que fazer isso para cada model que vc fizer exemplo departamento em fim vai ser sempre a mesma vibe
