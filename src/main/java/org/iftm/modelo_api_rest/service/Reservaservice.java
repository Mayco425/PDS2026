package org.iftm.modelo_api_rest.services;

import java.util.List;

import org.iftm.modelo_api_rest.entity.Reserva;
import org.iftm.modelo_api_rest.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public boolean validarStatus(Reserva reserva) {
        return reserva.getStatus() != null && !reserva.getStatus().isEmpty();
    }

    public boolean validarLivro(Reserva reserva) {
        return reserva.getLivro() != null;
    }

    public boolean validarUsuario(Reserva reserva) {
        return reserva.getUsuario() != null;
    }

    public boolean validarReserva(Reserva reserva) {
        return validarStatus(reserva) &&
               validarLivro(reserva) &&
               validarUsuario(reserva);
    }

    
    public Reserva inserir(Reserva reserva) {
        if (validarReserva(reserva)) {
            return reservaRepository.save(reserva);
        }
        throw new RuntimeException("Reserva inválida.");
    }

    public List<Reserva> inserirTodos(List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (!validarReserva(reserva)) {
                throw new RuntimeException("Reserva inválida.");
            }
        }
        return reservaRepository.saveAll(reservas);
    }

    public Reserva atualizar(Reserva reserva) {
        if (validarReserva(reserva)) {
            return reservaRepository.save(reserva);
        }
        throw new RuntimeException("Reserva inválida.");
    }

    public void apagar(Long id) {
        reservaRepository.deleteById(id);
    }

    public void apagarTodos() {
        reservaRepository.deleteAll();
    }

  

    public List<Reserva> buscarPorStatus(String status) {
        return reservaRepository.findByStatus(status);
    }

    public List<Reserva> buscarPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    public List<Reserva> buscarReservasAntigas() {
        return reservaRepository.buscarReservasAntigas();
    }
}