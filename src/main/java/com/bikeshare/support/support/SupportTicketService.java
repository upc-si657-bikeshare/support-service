package com.bikeshare.support.support;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportTicketService {
    private final SupportTicketRepository ticketRepository;

    public List<SupportTicket> findTicketsByUserId(Long userId) {
        return ticketRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    @Transactional
    public SupportTicket createTicket(SupportTicketDTOs.CreateTicketRequest dto) {

        SupportTicket ticket = SupportTicket.builder()
                .userId(dto.userId())
                .subject(dto.subject())
                .category(dto.category())
                .message(dto.message())
                .status(SupportStatus.OPEN)
                .build();
        return ticketRepository.save(ticket);
    }
}