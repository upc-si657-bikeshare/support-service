CREATE TABLE support_tickets (
                                 id             BIGSERIAL PRIMARY KEY,
                                 user_id        BIGINT NOT NULL,
                                 subject        VARCHAR(160) NOT NULL,
                                 category       VARCHAR(64),
                                 message        TEXT NOT NULL,
                                 status         VARCHAR(24) NOT NULL DEFAULT 'OPEN',
                                 created_at     TIMESTAMP NOT NULL DEFAULT NOW(),
                                 attachment_url VARCHAR(512)
);

CREATE INDEX idx_tickets_user ON support_tickets(user_id, created_at DESC);