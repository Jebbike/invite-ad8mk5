package me.invite.lib;

import java.util.Objects;
import java.util.UUID;

public class Port {
        UUID uuid = UUID.randomUUID();

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Port{");
            sb.append("uuid=").append(uuid);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Port port = (Port) o;

            return Objects.equals(uuid, port.uuid);
        }

        @Override
        public int hashCode() {
            return uuid != null ? uuid.hashCode() : 0;
        }
    }