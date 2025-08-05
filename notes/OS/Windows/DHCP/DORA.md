![[Pasted image 20250612160407.png]]
The image above represents the four-step process of communication between DHCP client and DHCP server.

1. The DHCP client **broadcasts** a **DHCPDISCOVER** packet. The only computers that respond are computers that have the DHCP Server role, or computers or routers that are running a **DHCP relay agent**. 
2.  A DHCP Server responds with a **DHCPOFFER** packet, which contains a potential address for the client. If multiple DHCP servers receive the DHCPDISCOVER packet, then multiple DHCP servers can respond.
3. The client receives the **DHCPOFFER** packet. If the client receives multiple DHCPOFFER packets, it selects the first response. The client then sends a **DHCPREQUEST** packet that contains a server identifier. This informs the DHCP servers that receive the broadcast which server’s **DHCPOFFER** the client has chosen to accept.
4. The DHCP servers receive the **DHCPREQUEST**. Servers that the client hasn't accepted use this message as the notification that the client has declined that server’s offer. The chosen server stores the IP address-client information in the DHCP database and responds with a **DHCPACK** message. If the DHCP server can't provide the address that was offered in the initial DHCPOFFER, the DHCP server sends a **DHCPNAK** message.


