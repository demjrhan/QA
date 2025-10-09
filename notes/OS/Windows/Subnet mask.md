A **subnet mask** tells the device which part of its IP address represents the **network** and which part represents the **host**. It’s used to figure out whether another IP is on the same network or not. For example, with a subnet mask of `255.255.255.0`, all devices with the same first three numbers in their IP address are considered local.

> Subnet masks are always 1's followed by 0's. 
> ==11100000== -> is good example
> ==11010000== -> is bad example
```
255  11111111
254  11111110
252  11111100
248  11111000
240  11110000
224  11100000
192  11000000
128  10000000
  0  00000000
```
These are the only possible subnet octets can happen.

## QA

§ **How two devices understands that they can communicate or not by looking IP and Subnet addresses**

Server 1 -> 192.168.22.10 -> Subnet Mask -> 255.255.255.192
Server 2 -> 192.168.22.74 -> Subnet Mask -> 255.255.255.192

They do bitwise operation to understand if the requested address is in same subnet or not.


- **IP**: 
	- `192.168.22.10` -> `11000000.10101000.00010110.00001010`
- **Subnet Mask**: 
	- `255.255.255.192` -> `11111111.11111111.11111111.11000000`
- **Network Address**: 
	- `192.168.22.0` -> `11000000.10101000.00010110.00000000`


- **IP**: 
	- `192.168.22.74` -> `11000000.10101000.00010110.01001010`
- **Subnet Mask**: 
	- `255.255.255.192` -> `11111111.11111111.11111111.11000000`
- **Network Address**: 
	- `192.168.22.64` -> `11000000.10101000.00010110.01000000`


**Server 1 Network Address** -> 192.168.22.0 
**Server 2 Network Address** -> 192.168.22.64 

They are different, router is needed.


§ **What is broadcast address and subnet address that uses 2 IP addresses on my subnet mask?**

The network address is the first address of your subnet/network that identifies network itself.

However the last address of your subnet/network identifies that in case of any broadcast request this will be the address where your query will go.

§ **What is the maximum IP addresses I can use in the subnet mask 255.255.255.0** 
The answer is 254 with subtraction of broadcast address 255.255.255.255 and the network address 255.255.255.0.

§ **Network bits and Host bits**

Network bits is the part of the subnet mask detonated with ==1== and host bits are ==0==.

So in a subnet mask 255.255.255.192 /26
==11111111 11111111 11111111 11000000== 
last six 0's are indicating host bits.

In case of asking more total IP addresses on the network more host bits can be taken.

§ **255.255.255.252 (/30) What is this /30 /29**

The part /0-32 is an identifier how much IP addresses are available in this subnet, the number /30 is identifying 2^32-30 IP addresses. The maximum IP addresses in one subnet is 0.0.0.0 /0 which **a-lot**.

§ **Why subnet is existing?**

- Local traffic optimization  
    When two hosts share the same subnet, they can exchange packets directly, without routing through a gateway. This reduces latency and conserves router CPU and bandwidth for inter-subnet or Internet traffic.
    
- Improved security and policy enforcement  
    By grouping hosts into subnets, you can apply firewall rules, access controls or VLANs at the subnet boundary. For example, you might isolate your guest Wi-Fi users from your corporate servers simply by putting them on different subnets.
    
- Easier network management  
    Smaller subnets limit broadcast domains. Fewer broadcast storms occur, and IP address assignment (static or via DHCP) becomes clearer. Maintenance tasks such as firmware upgrades, monitoring or troubleshooting can be scoped to a particular subnet rather than the entire organization.

§ **Why when one company can have multiple subnet masks when another company does the job with only one?**

- Company size and number of hosts  
    A small office with 20 devices may fit comfortably within a /24 (up to 254 usable addresses). A campus network with thousands of devices needs to be split into multiple /24s or smaller to avoid excessively large broadcast domains.
    
- Functional or departmental separation  
    You may choose separate subnets for finance, engineering, wireless, servers, etc., so that policies can be tailored per group.
    
- Geographic distribution  
    Branch offices or data centers at different sites usually get distinct subnets, both for address planning and to map routing domains or VPN tunnels.
    
- Growth planning and address conservation  
    Even if you start with one subnet, anticipating growth often leads administrators to carve out additional subnets in advance. Conversely, some very small networks never exceed a single subnet.

§ **Why do I make subnet work, purpose.**
- Defining which bits of the IP address identify the network and which identify the host.
    
- Configuring each host (and the network’s routers) with the same subnet mask, so they agree on who is local and who must be reached via a gateway.
    
- Ensuring that IP address allocation (static or dynamic) matches the subnet boundaries, so no overlaps or gaps occur.  
    In effect, you are teaching every device “these addresses are on my local link; any others must go through the router.” That knowledge lets each machine build its ARP or MAC-address table only for truly local peers.

§ **What are the ways of writing subnet mask?**
- Prefix length (CIDR notation)  
    Writing 192.168.1.0/24 means the first 24 bits are the network portion (equivalent to 255.255.255.0).
    
- Binary string  
    11111111.11111111.11111111.00000000 is the same as /24.  
    If you wanted a /26 mask, you’d write 11111111.11111111.11111111.11000000 (or 255.255.255.192).
- Dotted-decimal notation
	- 255.255.255.0
	- 255.255.0.0 ~ etc.

§ **How we understand count of the subnets available by looking IP address and subnet mask?**

Look at the subnet mask
==11111111.11111111.11111111.00000000==
this is 255.255.255.0 subnet mask with CIDR denotation /24

Imagine the scenario you want 32 available host addresses on each subnet and get as much as subnets possible. In this case we know that 32 available hosts means /27.

You can verify it by 2 ^ 32 **(max)** - 27 **(current)** : 2 ^ 5 -> 32 total host addresses.

And to calculate how many subnets this makes write it in subnet mask form again
==11111111.11111111.11111111.11100000== -> /27 -> target
==11111111.11111111.11111111.00000000== -> /24 -> started
**target - start** : 3

And know we need to calculate 2 to the power of result of this action. **2^3 -> 8 subnets in total.**