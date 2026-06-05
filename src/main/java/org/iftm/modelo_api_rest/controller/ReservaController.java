package org.iftm.modelo_api_rest.controllers;

import java.util.List;

import org.iftm.modelo_api_rest.entity.Reserva;
import org.iftm.modelo_api_rest.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Inserir
    @PostMapping
    public Reserva inserir(@RequestBody Reserva reserva) {
        return reservaService.inserir(reserva);
    }

    // Inserir vários
    @PostMapping("/lista")
    public List<Reserva> inserirTodos(@RequestBody List<Reserva> reservas) {
        return reservaService.inserirTodos(reservas);
    }

    // Atualizar
    @PutMapping
    public Reserva atualizar(@RequestBody Reserva reserva) {
        return reservaService.atualizar(reserva);
    }

    // Excluir por id
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        reservaService.apagar(id);
    }

    // Excluir todos
    @DeleteMapping
    public void apagarTodos() {
        reservaService.apagarTodos();
    }

    // Consulta por status
    @GetMapping("/status/{status}")
    public List<Reserva> buscarPorStatus(@PathVariable String status) {
        return reservaService.buscarPorStatus(status);
    }

    // Consulta por usuário
    @GetMapping("/usuario/{id}")
    public List<Reserva> buscarPorUsuario(@PathVariable Long id) {
        return reservaService.buscarPorUsuario(id);
    }

    // Consulta @Query
    @GetMapping("/antigas")
    public List<Reserva> buscarReservasAntigas() {
        return reservaService.buscarReservasAntigas();
    }
}