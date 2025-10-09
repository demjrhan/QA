This is a unique identifier assigned to a network interface card (NIC) by the manufacturer. It is tied to the **hardware** (e.g., your Ethernet or Wi-Fi adapter), not the computer itself.

Imagine MAC address as your name and IP address as the address of your home. IP address is changeable, even though your public address. However, MAC address is permanent. You can move out to another apartment, but your name stays put.

#### ARP 
Is a **(LAYER 2)** protocol used to translate IP addresses to MAC addresses. When client sends a package to local network, ARP asks who has that IP address, tell the client who you are and they exchange MAC addresses. Then the direct communication can happen, more efficient due to fact it does not involve rooting.


```bash
#ethernet header
 Dst MAC:  FF:FF:FF:FF:FF:FF #broadcast
 Src MAC:  <your-MAC>

#this is more or less how arp payload looks like
Sender MAC address (SHA)   = <your-MAC>
Sender IP address (SPA)    = <your-IP>
Target MAC address (THA)   = 00:00:00:00:00:00 #because it does not know the target mac.
Target IP address (TPA)    = <target-IP>

```

```bash
#creates in arp cache static mac address
arp -s <ip_address> <mac_address> 

#displays arp cache
arp -a
```
## QA

§ **But why we have it at all? Can not we just use IP address?**

No, we **can't rely on IP addresses alone**, especially for **local communication** inside a network. And MAC address using in same local network is more efficient due to fact that it does not involve rooting and enables direct communication.

- IP addresses operate at the **Network Layer (Layer 3)**.
- MAC addresses are used at the **Data Link Layer (Layer 2)** for direct device-to-device communication within the same local network (e.g., your router communicating with your laptop).

When your device sends a packet on a local network, it needs to know the **MAC address** of the destination (e.g., the router). This is where **ARP** (Address Resolution Protocol) comes in — it translates IP addresses to MAC addresses for local delivery.

In order to be able to communicate via MAC address, the station who is sending the first message sends a broadcast message asking, who has this IP address, give me MAC address.

Once the packet leaves your network (e.g., going to google.com), your **public IP address** takes over and MAC addresses are no longer relevant.


§ **Where is mac address stored in computer?**

In your network interface card, it is tied to your **hardware** (for example; wi-fi adapter.)