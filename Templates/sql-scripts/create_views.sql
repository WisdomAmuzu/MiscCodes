CREATE VIEW payment_report AS
SELECT
    p.id,
    p.referenceno,
    b.id AS branch_id,
    b.name AS branch_name,
    p.amount,
    p.passportno,
    p.surname,
    p.othernames,
    p.status,
    r.status AS reversal_status,
    u.id AS teller_id,
    u.fullname AS teller_name,
    p.created_at AS payment_date,
    r.created_at AS reversals_date,
    r.referenceno AS reversal_referenceno
FROM
    payments p
LEFT JOIN branches b ON p.branch = b.id
LEFT JOIN users u ON p.teller = u.id
LEFT JOIN reversals r ON p.referenceno = r.payment
ORDER BY payment_date DESC;