package com.sq022groupA.escalayt.repository;

import com.sq022groupA.escalayt.entity.enums.Status;
import com.sq022groupA.escalayt.entity.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findTop3ByStatusOrderByCreatedAtDesc(Status status);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByAdmin.id = :adminId")
    Long countTicketsByAdmin(Long adminId);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByAdmin.id = :adminId AND t.status = :status")
    Long countTicketsByAdminAndStatus(Long adminId, Status status);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByUser.id = :userId")
    Long countTicketsByUser(Long userId);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByUser.id = :userId AND t.status = :status")
    Long countTicketsByUserAndStatus(Long userId, Status status);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByAdmin.id = :adminId OR t.createdByUser.createdUnder = :adminId")
    Long countAllTicketsUnderAdmin(Long adminId);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE (t.createdByAdmin.id = :adminId OR t.createdByUser.createdUnder = :adminId) AND t.status = :status")
    Long countAllTicketsUnderAdminAndStatus(Long adminId, Status status);
//
//    // Methods for counting tickets by admin
//    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByAdmin.id = :adminId")
//    Long countAllTicketsUnderAdmin(@Param("adminId") Long adminId);
//
//    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByAdmin.id = :adminId AND t.status = :status")
//    Long countAllTicketsUnderAdminAndStatus(@Param("adminId") Long adminId, @Param("status") Status status);
//
//    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByUser.admin.id = :adminId")
//    Long countAllTicketsByEmployeesUnderAdmin(@Param("adminId") Long adminId);
//
//    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByUser.admin.id = :adminId AND t.status = :status")
//    Long countAllTicketsByEmployeesUnderAdminAndStatus(@Param("adminId") Long adminId, @Param("status") Status status);
//
//    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByUser.id = :userId")
//    Long countTicketsByUser(@Param("userId") Long userId);
//
//    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.createdByUser.id = :userId AND t.status = :status")
//    Long countTicketsByUserAndStatus(@Param("userId") Long userId, @Param("status") Status status);
}
