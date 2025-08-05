

![[Pasted image 20250616223423.png]]
##### **Hot Standby**

In this protocol, the DHCP server configured as hot standby will be analyzing the active DHCP server silently to take over if the active DHCP server goes down. The server configured as hot standby already has all the active leases, and if a client tries to renew the existing lease or request a new lease, it will be able to make these changes or provide a new lease. In general, it is expected to have the same range of IP addresses in the hot standby DHCP server as the active DHCP server.

In case the active DHCP server goes down and the hot standby DHCP server makes any changes, they will be automatically updated when the original server comes back online.
##### **Load Balancing**

In this protocol, the DHCP servers are both running at the same time and checking each other’s behavior; they are synchronized. Most of the time, 50% of the pool of IP addresses is assigned to one server, and the other 50% is assigned to the other server, so they divide the work to make the system more efficient. In some scenarios, both servers can have access to the full pool of IP addresses. Even in that case, both servers will know which IP addresses are available or not to avoid duplication. They will not assign the same IP address to two different stations.