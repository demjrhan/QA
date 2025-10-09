DHCP **(Dynamic Host Configuration Protocol )** is a **network service** and protocol used to **automatically assign IP addresses and network configuration** (like default gateway, DNS servers) to client devices.

## QA

§ **What if my DHCP Server deals IP range .64-.127 subnet but lives in .2?**
Basically it will not be reachable from the client side. DHCP Server must be in that range in order to be reachable. When client sends a broadcast message, the DHCP Server must be in same subnet unless the Layer Agent or Router is configured properly. If the superscope is configured DHCP server can still give address but renewable can not be possible since its not reacable.


§ **What is DHCP Relay Agent**
When we are having multiple subnets, it might be hard to run and maintain couple DHCP servers in each subnet. Due to this we might create DHCP servers in one subnet and want to distribute the addresses from there to other subnets. We know that even though its broadcast, if the DHCP server is not in same subnet, the Discover package will never reach to DHCP Server through rooter. To fix this issue we have DHCP Relay Agent. Its main purpose is to maintain the communication between client and the server. When client sends the broadcast message it goes to the Relay Agent to maintain communication between configured server(s). Good to mention that broadcast request now turns into unicast calls between servers and agents. And the rest is like a regular DORA process but with help of Relay Agent. Relay agent gets package, forward to right place.

 - But what if multiple DHCP Servers are living in the network we forwarded?
	 - Then it will be still same like normal DORA process, multiple server responds. Client selects the first one usually.
- How Relay Agent remembers which client to send?
	- It stores its XID (randomly created 32-bit number) and MAC address.

§ **What if there was more than one DHCP server on network?**
After client sends a broadcast request to get an IP address, all DHCP servers will be responding with the **DHCP Offer** package. First **DHCP Offer** package wins, so we can say that it becomes a race between the DHCP Servers.


§ **What if even though there is multiple DHCP server on network I want specific DHCP to assign IP addresses?**
Then introduce some delay to the other DHCP servers, like couple milliseconds. This will cause the others to lose race. 

Other way to achieve the same result is creating some reservations for the devices you are going to be adding. This will also does the trick, if you know the device going to be added though.

And one other way to have same result, if you are using ad dc, only give authorization to the DHCP servers which you want to give IP addresses.

§ **Why DORA is 4 step process?**

- Maybe the offer package reserves the offered IP address, if no request comes back it will keep it reserved?
	- Not fully, even though after **OFFER** package the offered IP address is reserved for short period if no answer came, it will make it available again.

One of the reason is the making communication between all servers proper. In **DORA** process **DISCOVER** package is not the only broadcast request. **REQUEST** is also broadcast and that is the reason we are having. Since all the DHCP Servers can OFFER IP addresses, in return they will need to know that Client Computer selected the other DHCP Server.


- **Cant we make it simple DISCOVER, OFFER, REQUEST?**
	- Not really. The final **ACK** step is essential because it confirms that the selected server has successfully assigned the IP and updated its lease database. Without the **ACK** or **NACK**, the client wouldn't know for sure that it can safely use or not use the IP, and the server wouldn't finalize the lease.
