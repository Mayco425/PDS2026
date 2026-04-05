package org.iftm.modelo_api_rest.repositories;

import java.util.Date;
import java.util.List;

import org.iftm.modelo_api_rest.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    //  QueryMethods 

    List<Reserva> findByStatus(String status);

    List<Reserva> findByDataReserva(Date dataReserva);

    List<Reserva> findByUsuarioId(Long usuarioId);

    List<Reserva> findByLivroCodigo(Long codigoLivro);

    List<Reserva> findByStatusAndUsuarioId(String status, Long usuarioId);

    //  @Query
    @Query("SELECT r FROM Reserva r WHERE r.dataReserva < CURRENT_DATE")
    List<Reserva> buscarReservasAntigas();
}