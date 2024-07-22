package com.sq022groupA.escalayt.entity.model;



import com.sq022groupA.escalayt.entity.enums.Category;
import com.sq022groupA.escalayt.entity.enums.Priority;
import com.sq022groupA.escalayt.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseClass{


    private String title;

    private String location;

//    @Enumerated(EnumType.STRING)
//    private Category category;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String description;

    private Long createdUnder;


    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(optional = true)
    @JoinColumn(name = "created_by_user_id", foreignKey = @ForeignKey(name = "FK_ticket_created_by_user"))
    private User createdByUser;

    @ManyToOne(optional = true)
    @JoinColumn(name = "resolved_by_user_id", foreignKey = @ForeignKey(name = "FK_ticket_resolved_by_user"))
    private User resolvedByUser;

    @ManyToOne(optional = true)
    @JoinColumn(name = "created_by_admin_id", foreignKey = @ForeignKey(name = "FK_ticket_created_by_admin"))
    private Admin createdByAdmin;

    @ManyToOne(optional = true)
    @JoinColumn(name = "resolved_by_admin_id", foreignKey = @ForeignKey(name = "FK_ticket_resolved_by_admin"))
    private Admin resolvedByAdmin;




    // map category
    @ManyToOne
    @JoinColumn(name = "ticket_category_id")
    private TicketCategory ticketCategory;

    // mapped ticket comment here
    @OneToMany(mappedBy = "ticket")
    private List<TicketComment> ticketComments;


}
