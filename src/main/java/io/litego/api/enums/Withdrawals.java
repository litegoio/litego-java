package io.litego.api.enums;

public enum Withdrawals {
    REGULAR_ADDRESS_TYPE {
        @Override
        public String toString() {
            return "regular";
        }
    },

    EXTENDED_ADDRESS_TYPE {
        @Override
        public String toString() {
            return "extended";
        }
    }
}
