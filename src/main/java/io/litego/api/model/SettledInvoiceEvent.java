package io.litego.api.model;

import java.util.Date;
import java.util.UUID;

public class SettledInvoiceEvent {
    public UUID invoice_id;
    public UUID merchant_id;
    public long amount_paid_satoshi;
    public Date settled_at;
}
