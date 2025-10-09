The word **lease** refers to an agreement between the client and the server. This lease defines the **duration** for which an IP address is reserved for the client.

- When **50%** of the lease time has passed, the **DHCP client automatically attempts to renew** the lease. This process occurs silently in the background.
- To renew the lease, the client sends a **==unicast== DHCPREQUEST** message directly to the server that granted the lease.
- If the server is reachable, it responds with a **DHCPACK** message, which may contain updated configuration parameters.

- If the client **cannot contact the DHCP server**, it waits until **87.5%** of the lease time has passed.
- At that point, the client sends a **==broadcast== DHCPREQUEST** to any available DHCP server, still attempting to renew the **existing lease**, not to request a new one.
- If there is another **DHCP server** connected to the original one—for purposes such as **load balancing** or **fault tolerance** (e.g., **hot standby** mode)—then **this secondary server can also renew the lease**.


