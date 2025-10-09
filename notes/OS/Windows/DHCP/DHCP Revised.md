DHCP **(Dynamic Host Configuration Protocol )** is a **network service** and protocol used to **automatically assign IP addresses and network configuration** (like default gateway, DNS servers) to client devices.

==Questions and Answers can be found in very bottom of the documentation==


### DORA 
Is a process to assign IP address and other important details to client via communicating between DHCP Server(s).

First step is **Discover**, this packet is a broadcast and sent by client machine to all devices living in same network/subnet **(255.255.255.255)**. The goal of this message is to find every DHCP Servers available on the network and getting information we mentioned above.

The phrase **in same network/subnet** means any device in different network for instance if client is in **VLan1**, any machine in **VLan2** will not be able to hear client. Another example could be if there is 4 subnets created from 256 total addresses and client is currently in the **64-127** range, it will not be able to communicate with the DHCP Server in range **0-63** unless there is router or DHCP **Relay Agent** is configured, they can make communication. 

Second step is **Offer** packet provided from DHCP Server to respond to client who requested **Discover**, this message is this time unicast. This means going to the client directly. The question might appear that **if client does not have any IP address, how DHCP Server is able to send this message as unicast, how knows which device to send?**

The answer is really simple **MAC Address**. DHCP Server knows clients MAC Address from the **Discover** packet. If the client **Discover** message came to server through **Layer Agent** then Server will be sending **Offer** to that address and agent will make communication between. This **Offer** package contains the **IP Address**, **Subnet Mask**, **Lease** obligatory, they can not be empty. And other optional settings like **DNS Server, Suffix** or **Default Gateway** so on so forth.

Third step is **Request**, done by the client. This message same as the **Discover** is also done broadcast even though client is getting the addresses from one Server only. But why?

The reasoning behind broadcast is letting know the other servers that **I selected this DHCP Server**. When a server sends a **Offer** packet to client, server reserves the IP address sent to the client for some time in order to not cause conflicts. With this message the DHCP Server can unlock the lock of IP address and give this address to someone else. 

**But in case of multiple offers, which one will be selected?**
The answer is the usually first **Offer** came to the client side. Including the responses from the **relay agent.**

The last step is **Acknowledgement**. In this step DHCP Server is confirming the reserved IP address status and other information that everything is in order and this IP address is usable. However, if something goes wrong in the Server side this **Acknowledgement** turns into **Not Acknowledged** so client is going back to **Discover** process again.


### Relay Agent
When we are having multiple subnets, it might be hard to run and maintain couple DHCP servers in each subnet. Due to this we might create DHCP servers in one subnet and want to distribute the addresses from there to other subnets. We know that even though its broadcast, if the DHCP server is not in same subnet, the Discover package will never reach to DHCP Server through rooter. To fix this issue we have DHCP Relay Agent. Its main purpose is to maintain the communication between client and the server. When client sends the broadcast message it goes to the Relay Agent to maintain communication between configured server(s). Good to mention that broadcast request now turns into unicast calls between servers and agents. And the rest is like a regular DORA process but with help of Relay Agent. Relay agent gets package, forward to right place.

 - But what if multiple DHCP Servers are living in the network we forwarded?
	 - Then it will be still same like normal DORA process, multiple server responds. Client selects the first one usually.
- How Relay Agent remembers which client to send?
	- It stores its XID (randomly created 32-bit number) and MAC address.

### Lease
When we were talking about **DORA**, I mentioned that **Offer** package contains **Lease**. Since we have the IP address we can perform some actions, **for a specified time frame.** Lease is a agreement between Server and Client saying **you are welcome to use this address for some days, hours.** This time is by default is ==8 days==. The reasoning behind the lease agreement is while the client using this IP address, DHCP Server will never give this IP address to someone else and accept that a client is operating in this address. But imagine the scenario that there was no lease, you get IP from Server and you just needed it for 30 minutes. Forever, unless a administrator deletes record you will stay there and make the IP address busy. To fix this problem lease is existing. With this saying, now you know the problem that long lease agreement can cause. But when to use long, when to use short lease time?

**Short lease time examples:** Airport, cafes.
**Long lease time examples:** Printers, office desktops.

By **short** we think of **1-2 hours** maybe some exceptions to airport **30 minutes**. And for **long** maybe **7 days**.

#### Lease Renewal
**My lease is ending, what is going to happen?** Then the lease 
renewal process will start **(T1, T2)**. 

I will accept the fact that your lease agreement was 8 days, default. When client reaches the **50% (4. day)** of the lease time, it will automatically try to renew process by sending **Request** to the DHCP server. If DHCP Server is up and running it will respond with **ACK** and renewal process will complete and you will still have same address and subnet mask. But if something changed on the options like new DNS Server, new Suffix etc. In this renewal process you will have most up to date information too.

**DHCP Server was down in 50% of the lease time. What is going to happen now?** Then the next threshold is the **87.5%**. In other words **7.** day your computer will try to renew your lease again but this time it will be **broadcast** message to every device hoping that one DHCP Server is going to respond. If there is server connected to last DHCP Server via failover protocol then that server can still renew your lease and provide the info back when your actual DHCP Server goes online. But if there is only other Servers out there, your IP address is most likely to change to another DHCP Servers scope.

**If lease ends, client leaves the IP address and goes back to INITIAL mode and look for other DHCP Servers again with DORA Process.**


### Scopes
DHCP Servers are giving IP addresses and other important settings but from where, randomly?

Of course not, just DHCP Server by itself is not enough to deal IP addresses and other settings like DNS Server address. We need to have **scopes, multicast scope, superscopes** depending on our need.

As a start lets talk about the base, **scope**. Scope is a range of IP addresses with subnet masks. It is good to mention that none of the scopes can use first and last IP addresses on the subnet. The reason behind is first address is reserved for the default network, last is reserved for the broadcast calls. Lets cover the range 0-254 -> **not 255 because 0 is inclusive not exclusive.** 

So we know that 0 is for network, 254 for broadcast. That leaves us usable 253 addresses out there. Creating a scope needs several things like, **IP Address range, Subnet Mask** and it also supports **Exclusions**. We already know IP address range, **1-253**. We also know the subnet mask **255.255.255.0** since we are dealing 255 addresses. How about this exclusions?

**Exclusions** is the range of IP addresses that DHCP Server will never assign to client in the **DORA** process. Usually this excluded IP addresses are used to assign Servers for static IP address usage.

While you are creating the scope, you can configure the settings while creating like a **default gateway, DNS suffix, DNS server** but this is like we mentioned optional and can be done later. It is good to mention that unless the created scope is active, the DHCP Server will never give address from this range.

**I want to give some addresses to clients specifically, I do not want their IPs change by time but I do not want them to be static addresses. What should I do?** Then the **reservations** are coming into the business.

**Superscope** is an administrative “container” that lets you group multiple distinct scopes (each for its own subnet) so that the DHCP service can respond to broadcast requests on a single physical network with addresses from any of those subnets. You typically use a **superscope** when you’ve carved out two or more subnets on one LAN segment—for example, when you’ve exhausted 10.0.0.0/24 and added 10.0.1.0/24—and you want the server to reply from both without adding another DHCP server or changing your physical topology. The DHCP server still matches the client’s network identifier to the correct scope, but because those scopes are in the same **superscope**, it can offer addresses across them seamlessly.

**Multicast scope** (?)


### Properties of Scope
**Name (mandatory)**
The scope must have a **name** for identification. It helps administrators quickly distinguish between multiple scopes, especially in large networks. This is set during scope creation.

**IP Address Range (mandatory)**
This defines the **range of IP addresses** the DHCP server can assign to clients (e.g., 192.168.1.100–192.168.1.200). It determines the usable address pool 
within a subnet. You configure this during scope setup.

**Subnet Mask (mandatory)**
The **subnet mask** defines the size of the subnet and helps determine which part of the IP address refers to the network and which to the host. It must match the subnet of the target network. This is required when defining the scope.

**Exclusions**
**Excluded IP addresses** are within the defined range but will **not be assigned** by DHCP. These are typically reserved for static devices like routers or printers. They are added after setting the IP range.

**Delay**
The **delay setting** can be used when multiple DHCP servers exist. It introduces a slight wait before responding to DHCPDISCOVER messages, allowing other servers to reply first if needed. This helps manage response priority.

**Lease Duration**
This sets how **long a client can use an IP address** before needing to renew it. You can configure it to suit the environment—for example, short leases in guest networks or long leases in office environments.

**Options**
**DHCP options** include extra parameters like **default gateway, DNS server, domain name**, and more. These are added to assist client configuration beyond just assigning an IP.

**Activation**
Once all properties are set, the scope must be **activated** to start leasing addresses. Until it is activated, clients won’t receive IPs from that scope.

### **Reservation**
 Reservations are the reserved IP addresses for the computers that letting same machines taking same IP address in each DORA process, or renewal process. This reservation can be done by specifying a name for reservation, a description **(which is optional)**, and most importantly **MAC address**. Reservation is done by the **MAC Address** because we know that it will always be the same so we can identify same client after time.

### High Availability
High availability is a protocols used to not leave clients without an answer even though something goes wrong or reducing the stress on one server. In this approaches you have a second DHCP Server **(buddy server)** to this operations.

##### **Hot Standby**
In this protocol, the DHCP server configured as hot standby will be analyzing the active DHCP server silently to take over if the active DHCP server goes down. The server configured as hot standby already has all the active leases, and if a client tries to renew the existing lease or request a new lease, it will be able to make these changes or provide a new lease. In general, it is expected to have the same range of IP addresses in the hot standby DHCP server as the active DHCP server.

In case the active DHCP server goes down and the hot standby DHCP server makes any changes, they will be automatically updated when the original server comes back online.
##### **Load Balancing**
In this protocol, the DHCP servers are both running at the same time and checking each other’s behavior; they are synchronized. Most of the time, 50% of the pool of IP addresses is assigned to one server, and the other 50% is assigned to the other server, so they divide the work to make the system more efficient. In some scenarios, both servers can have access to the full pool of IP addresses. Even in that case, both servers will know which IP addresses are available or not to avoid duplication. They will not assign the same IP address to two different stations.


## QA

§ **What if my DHCP Server deals IP range .64-.127 subnet but lives in .2?**
Basically it will not be reachable from the client side. DHCP Server must be in that range in order to be reachable. When client sends a broadcast message, the DHCP Server must be in same subnet unless the Layer Agent or Router is configured properly. If the superscope is configured DHCP server can still give address but renewable can not be possible since its not reachable.


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
