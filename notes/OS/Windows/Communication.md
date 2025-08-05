§ **How is the full communication looking like?**

*This part is explained in detail on notes DNS->Resolving Domain Name ;)*

- **Step 1: Resolving the Domain Name (DNS Resolution)**
	- Before your device can talk to Google, it must translate `google.com` into an IP address. This process is called **Domain Name Resolution**, and it follows a step-by-step lookup:
	1. **Local DNS Cache**
	2. **Hosts File**
	3. **Local DNS Server**
	4. **DNS Server's Cache**
	5. **DNS Server's Hosts File**
	6. **Forwarders**
	7. **Root Servers** → **TLD Servers (.com)** → **Authoritative DNS**  
    
   
```
google.com → 142.250.74.78
```

-  **Step 2: Is Google’s IP Local or External?**
	- Now your device must send a request to that IP address. First, it checks whether the IP is **within your local network**:
	- It uses your **Subnet Mask** to determine this.
	- If the IP is local:  
		- → It sends an **ARP (Address Resolution Protocol)** broadcast to get the destination MAC address and communicates directly. 
	- If the IP is **external (as in this case)**:  
		- → It sends the request to your **Default Gateway** (your router).



- **Step 3: Packet Leaves Your Device**
	- Your device creates a packet like this:
```
Source IP:     192.168.0.2 (Your private IP) 
Source Port:   54321 (Chosen by your OS) 
Dest IP:     142.250.74.78  (Google) 
Dest Port:     443  (HTTPS)
```

This is sent to the router because Google is not in your local subnet.

- **Step 4: Network Address Translation (NAT ~ LAYER 3 PROTOCOL) at the Router**
	- Your router receives the packet and:
		1. **Replaces** the private IP with its **public IP** (e.g., `93.184.216.34`).
		2. Assigns a **new port number** (e.g., `60001`) for tracking.
		3. **Stores a NAT entry**:
		4. **Sends the translated packet to Google**.

```
NAT Table: Public IP & Port      →      Private IP & Port 93.184.216.34:60001   →      192.168.0.2:54321
```

-  **Step 5: Response from Google**
	- Google replies to the public IP and port:

```
Dest IP:     93.184.216.34 Dest Port:   60001 Source IP:   142.250.74.78 Source Port: 443
```

- **Step 6: Router Translates Back and Forwards**
	- The router looks up `60001` in its NAT table:
	- It finds the match to `192.168.0.2:54321`.
	- It rewrites the packet back to private IP and port.
	- Sends the response to your device.