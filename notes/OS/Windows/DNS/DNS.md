Domain Name System is a **network service** and protocol used to **resolve domain names to IP addresses**, enabling human-friendly navigation of network resources. 

==Port 53 is for DNS==

```bash
ipconfig /displaydns -> will show you the dns cache in current workstation.

ipconfig /flushdns -> will clear the cache.
```


> **When setting up DNS on a Windows Server that acts as a Domain Controller, you should set the server's DNS to its own IP address (e.g., `192.168.86.10` or `127.0.0.1`)**.
> 
> This allows the server to resolve and manage internal resources such as Active Directory domains, services, and SRV records.
> 
> If you instead use an external DNS (like VMware's NAT DNS at `192.168.86.2`), it will not recognize or resolve internal domain names (e.g., `demo.lab`) or required AD-related records, because it has no knowledge of your local DNS zones.


## QA


§ **What are the tools to interact with DNS?**
`nslookup`
`dig`


**nslookup** -> can provide you different settings for the request. For example
```bash
set type=(type name) e.g MX for mail exchange will return you the records about mail exchange.

server (server name) e.g google.com will change the server that you are doing dns query from.
```

§ **Why we have cache?**
>Imagine you go google.com and there is no cache of IP address so your DNS server resolves to 8.8.8.8.
  And you go for instance google.com/1, this action would repeat the process of resolving and would create redundancy.
  ***Cache holds the resolved IP address for limited time frame to clear redundancy.***


§ **Why we have both cache and hosts file?**
Cache file is providing you temporary address for you to not go DNS server again and again to query same thing, however hosts file is temporary till you delete and used to test some websites, or you can use it to block ads.

§ **If I know all IP addresses already, do I need DNS?**
    Technically, no—if every user or application always types or scripts the numeric IP, name resolution isn’t required. 

However ==it is important== to mention that DNS makes things so much easier.
- **Human usability**  
    Hostnames (like “fileserver1.corp.local”) are far easier to remember and less prone to typing errors than IPs.
- **Flexibility**  
    DNS lets you change a service’s underlying IP address without forcing every user or config file to be updated. You simply update the DNS “A record.”


§ **Which root hint is getting selected?**

Root server selection depending on some questions like the how fast it responded last time, was it available last time.

In case of first query, it is usually selecting the first root server in our case its **A** unless you specify in your query like c.root-servers.net.