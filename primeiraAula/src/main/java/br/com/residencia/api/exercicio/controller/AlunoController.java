package br.com.residencia.api.exercicio.controller;

import br.com.residencia.api.exercicio.model.Aluno;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private static List<Aluno> alunos = new ArrayList<>();
    
    static {
        alunos.add(new Aluno("111", "Gabriel", "gabriel@gmail.com"));
        alunos.add(new Aluno("321", "Ana", "a@gmail.com"));
        alunos.add(new Aluno("124", "Jose", "j@gmail.com"));
        alunos.add(new Aluno("126", "Carlos", "c@gmail.com"));
    }

    @GetMapping
    public List<Aluno> lista() {
        return alunos;
    }


    @GetMapping("{matricula}")
    public Aluno buscar(@PathVariable String matricula) {
        for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				return alunos.get(i);
			}
		}
		return null;
    }
}
