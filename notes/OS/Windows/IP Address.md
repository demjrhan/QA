A **private IP** is used inside a local network and isn’t accessible from the internet. Devices like my PC or phone use private IPs assigned by the router. A **public IP** is assigned by the ISP and is used to identify your network on the internet. If a server or website needs to be reachable globally, it must have a public IP.

It is good to mention that your address is changeable, even your public IP address.


## QA

§ **What the hell is classless and classful addressing?**

**(1981)**
Classful addressing is the start point of IP addresses. When the IP addresses are available to deliver people, companies, schools they started as classful. But wait, what does that mean. It means they used this chart to give IP addresses.

| Class | Address Range               | Default Mask      | Usable Hosts per Net |
| :---: | :-------------------------- | :---------------- | :------------------- |
|   A   | 1.0.0.0 – 126.255.255.255   | 255.0.0.0<br>     | ~16 M                |
|   B   | 128.0.0.0 – 191.255.255.255 | 255.255.0.0<br>   | ~65 K                |
|   C   | 192.0.0.0 – 223.255.255.255 | 255.255.255.0<br> | ~254                 |
|   D   | 224.0.0.0 – 239.255.255.255 | n/a               | Multicast            |
|   E   | 240.0.0.0 – 255.255.255.255 | n/a               | Experimental         |

What this chart means that companies were getting the ranges like 16 million, 65 thousand, 254.

And its also good to mention that actually class A starts from range 0.0.0.0 but the this 0.0.0.0 range is reserved for actual default network.

And its actually finishing on 127.255.255.255 but this 127.0.0.0 - 127.255.255.255 is reserved for loopback.

**~ What if I need just 500?**
Oh boy, that was the problem, if you need more than 254 but not so much like ~65.000 still you were getting class B IP addressing. Around 64000 was going to be unallocated and idle staying.

But when the IP address is found, the engineers was not able to think that internet is going to be this big, they started giving some companies 16 million IP addresses, some 60 thousands...

**(1993)**
And it made them realize that **IP address are running out!** In order to fix this issue classless addressing was found. And that is what you see these days **/23**, **/28** and in this idea it was really straight, you need 500 -> take 512 addresses here you go **/23**.

It was relief to see that now people are getting enough addresses, no more. But dream did not last long because it was also not enough.

**(1994)**
The idea of having private and public addresses "saved" Ipv4, in this idea your local network is having private addresses which is not able to get queries from outside of internet directly, but can communicate inside of the network. And having couple (usually 1, depending on size of company) public addresses was communicating with outside of the world. So it was using portion of IP addresses efficiently.  


§ **Why we have private and public IP addresses?**

The concept of private and public IP addresses was introduced in the early 1990s to address the limited number of available IP addresses in the IPv4 system. Without this system, every internet-connected device—such as your phone, computer, tablet, or smart TV—would need a unique public IP address. Given the vast number of devices worldwide, this would quickly finish the pool of available addresses.

To solve this, **private IP addresses** started to be used within local networks (e.g., your home or office). These addresses are **not routable on the public internet**. Instead, your **router** is assigned a single **public IP address**, which it uses to communicate with external networks.

When a device in your local network (with a private IP) sends a request to the internet, the **router translates the private IP to its public IP** using a process called **Network Address Translation (NAT)**. The response from the internet is then forwarded by the router to the correct device inside your network.

§ **How my router knows that which package goes where? There might be 10 machines sending package outside.**


When multiple devices in your home connect to the internet, they all use **private IP addresses**. However, these addresses are **not valid on the internet**, so your **router acts as a middleman** using something called **Network Address Translation (NAT)**.

When a device (like your laptop) sends a request to a website, the router:

1. **Changes** the **source IP** from the private one (e.g., `192.168.0.2`) to its **own public IP** (e.g., `93.184.216.34`).
2. Assigns a **unique port number** for that request (e.g., `60001`).
3. **Stores** this mapping (private IP + port ↔ public IP + port) in a **NAT table**.
4. Sends the modified packet to the internet.

When the website replies:

1. The response comes back to the router's **public IP and port** (e.g., `93.184.216.34:60001`).
2. The router **checks its NAT table** to see which internal device it belongs to.
3. It **forwards** the response to the correct private IP and port (e.g., `192.168.0.2:54321`)

*Package before going to rooter*
```
Source IP:     192.168.0.2
Source Port:   54321
Destination IP: 142.250.74.78 (Google)
Destination Port: 80 (HTTP)
```

*Package after going to rooter*
```
Source IP:     93.184.216.34  (Router's Public IP)
Source Port:   60001          (Assigned by router)
Destination IP:142.250.74.78
Destination Port: 80
```
*NAT Table*

| Public IP & Port    | Private IP & Port |
| ------------------- | ----------------- |
| 93.184.216.34:60001 | 192.168.0.2:54321 |
| 93.184.216.34:60002 | 192.168.0.3:54444 |
| 93.184.216.34:60003 | 192.168.0.4:50000 |

*Response comes back to rooter*
```
Destination IP: 93.184.216.34
Destination Port: 60001
Source IP:       142.250.74.78
Source Port:     80
```

*Rooter transforms it and sends it back to the device*
```
Destination IP: 192.168.0.2
Destination Port: 54321
```

§ **Why we have whole 127.0.0.0 IP address range for our machine?**

This range 127.0.0.0/8 is completely reserved for the loopback purposes.

- **Flexibility**: Developers and services can bind to different loopback IPs (e.g., `127.0.0.2`, `127.0.1.1`) to **run multiple local services independently**.

- **Testing and Isolation**: It allows testing **multi-host setups**, **DNS configurations**, or **network software** without affecting external traffic.

- **Legacy and Compatibility**: Assigned early in networking history, this large block ensures **broad compatibility** across systems and use cases.
