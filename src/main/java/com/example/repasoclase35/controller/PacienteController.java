package com.example.repasoclase35.controller;

import com.example.repasoclase35.domain.Paciente;
import com.example.repasoclase35.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class PacienteController {

    private PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }
    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> buscarPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodosPaciente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacienteXId(@PathVariable Long id){
        Optional<Paciente> pacienteBuscado =pacienteService.buscarPaciente(id);
        if (pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}