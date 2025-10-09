Domain Name System is a **network service** and protocol used to **resolve domain names to IP addresses**, enabling human-friendly navigation of network resources. Good to mention that port ==53== serves for DNS.

==Questions and Answers can be found in very bottom of the documentation==

```bash
ipconfig /displaydns -> will show you the dns cache in current workstation.

ipconfig /flushdns -> will clear the cache.

C:\Windows\System32\drivers\etc\hosts -> for hosts file
```

### Resolving Domain Name

1. **Check DNS Cache**  
    The system first checks its local DNS cache for a previously resolved result.
    `ipconfig /displaydns`
2. **Check the HOSTS File**  
    If not in the cache, it checks the local `HOSTS` file located at:
    `C:\Windows\System32\drivers\etc\hosts`
3. **Send Recursive Request to DNS Server**  
    If no local match is found, the client sends a **recursive DNS request** to the configured DNS server (e.g., `192.168.22.10`).
    - If the DNS server has the record in its own zones or cache, it returns the result.
4. **DNS Server Tries Forwarders (if configured)**
    - If forwarders are set (e.g., `8.8.8.8`), the DNS server sends the query there. (In order to be able to do this operation if the forwarder set outside of local network a default gateway is necessary to have.)
    - If the forwarder responds, the answer is returned to the client.
    - If no forwarder is configured or the forwarder fails, then the DNS server continues with root hints.
5. **DNS Server Performs Iterative Lookup (if needed)**  
    If the DNS server doesn't have the answer:
    - It sends an **iterative query** to a **Root DNS server**.
    - The **Root server** doesn’t know the exact IP, but it points to the appropriate **TLD (Top-Level Domain) server**, such as for `.com`, `.net`, etc.
    - The **TLD server** then points to the **authoritative name server** for the requested domain (e.g., `example.com`).
    - The **authoritative server** provides the actual IP address (A record ) for the hostname (e.g., `www.example.com`).


### Forwarder
A DNS server to which queries are forwarded when the local DNS server cannot resolve them. Commonly used to forward external queries (e.g., to 8.8.8.8) to reduce load and centralize internet name resolution.

### Conditional Forwarder
A specific type of forwarder that handles queries for particular domain names (e.g., forward all branch.local queries to a specific internal DNS server). Useful for resolving names between different internal domains or forests.


### Zones

**Forward Lookup Zone**
Purpose of having forward lookup zone is to resolve domain names to ip addresses.

**Reverse Lookup Zone** 
Purpose of having reverse lookup zone is to resolve ip addresses to domain names.


### Types of zones

**Primary zone**
Holds all the records about the IP addresses; can manage records (add, edit, update). This is the authoritative source for the zone data.

**Secondary zone**
A read-only copy of the primary zone. It receives zone data through zone transfers and cannot be directly modified.

**Stub Zone**
In a stub zone, only the Name Server (NS), Start of Authority (SOA), and A records of the authoritative DNS servers are stored. This allows the stub zone to stay updated with any changes made on the main DNS server, eliminating the need for manual updates.

It is generally used for small branches connected to a larger network, such as a headquarters and a branch in another district or city. It is not recommended for large branches, as it would result in a high volume of query forwarding.

**Active Directory Integrated Zone**
Stores zone data in Active Directory, allowing multi-master replication and secure dynamic updates. Changes made on one Domain Controller replicate automatically to others.


### Zone Transfers
A mechanism by which a DNS server transfers a copy of zone data to another server. Used between Primary and Secondary zones or stub zones. Not used in AD-Integrated zones (they replicate via Active Directory instead).


**Can not be done:**
- AD-Integrated to Primary
- Primary to Primary
- Secondary to Stub
**Can be done:**
- Ad-Integrated to Secondary
- Ad-Integrated to Stub
- Primary to Secondary
- Primary to Stub
- Secondary to Secondary


### Record Types

- **Start of Authority (SOA):** Indicates which DNS server is the primary (master) for this zone.
- **Name Server (NS):** Shows which DNS servers are authoritative for this domain. Most DNS zones have at least two NS records in case one server fails. Secondary (slave) DNS servers can still operate.
- **Host (A):** Maps a hostname to an IPv4 address.
- **Host (AAAA):** Maps a hostname to an IPv6 address.
- **Alias (CNAME):** Points one hostname to another canonical hostname.
- **Pointer (PTR):** Maps an IP address to a hostname for reverse DNS lookups.
- **Service Locator (SRV):** Locates services (e.g. SIP, XMPP, LDAP) on specific ports. Priority determines the order in which servers are tried (lower is preferred). Weight indicates how load is distributed among servers with the same priority. If multiple SRV records share the same priority, weight-based load balancing is applied.
- **MX (Mail Exchange):** Specifies which mail servers accept email for the domain. Lower priority values are preferred; if multiple MX records share the same priority, mail is distributed among them for load balancing or redundancy.


- **SOA:** `veeam.local. IN SOA ns1.veeam.local.` `hostmaster.veeam.local`
- **NS:** `veeam.local. IN NS ns1.veeam.local.`
- **A:** `client.veeam.local. IN A 192.168.22.100`
- **AAAA:** `web.veeam.local. IN AAAA 2001:db8::1`
- **CNAME:** `www.veeam.local. IN CNAME web.veeam.local.`
- **PTR:** `100.22.168.192.in-addr.arpa. IN PTR client.veeam.local.`
- **SRV:** `_sip._tcp.veeam.local. IN SRV 10 60 5060 sip.veeam.local.`  
    `sip.veeam.local. IN A 192.168.22.150`
    - 10 is the priority, 60 is the weight, 5060 is the port.
- **MX:** `veeam.local. 3600 IN MX 10 mail-a.veeam.local.`
    - 3600 is the TTL (in seconds), 10 is the priority.


### Device Registration
In primary zone the device registration settings are only
- Nonsecure and secure
- None
In active directory zone the device registration settings are
- Only secure
- Nonsecure and secure
- None

**Only secure** ensures that devices joined to the network will not be recorded to the dns unless they join domain.
**Nonsecure and secure** ensures that devices joined to the network will be recorded to the DNS either they join domain or not.
**None** ensures that no matter what it will not be recorded.

### Different Approaches of Configuration
#### **Primary + Secondary DNS Zone Approach**
- **New York DNS Server** is configured as the **Primary Zone**.
- **Seattle DNS Server** is configured as the **Secondary Zone**.
- Do not forget that names of the both zones must be same in order to make connection.
- 
**How It Works:**
- The **Seattle server pulls all zone data from New York** via a zone transfer.
- The data on the **Secondary server is read-only**, meaning:
    - Seattle DNS cannot create, modify, or delete DNS records.
    - It only serves records that it has received from New York.
- **Workstations** and **Servers**:
    - Use **New York DNS** as the **Preferred DNS Server**.
    - Use the **Seattle DNS** as the **Alternate DNS Server**.

**Benefits:**
- Ensures **redundancy and load balancing**.
- Reduces DNS query latency for Seattle clients (they can query their local server).
- If the New York DNS goes offline, **Seattle can still serve cached DNS data**.
- **Seattle automatically refreshes its data** from New York periodically (based on SOA timers: refresh, retry, expire).

#### **AD-Integrated DNS Zone (AD Zone + AD Zone)**
In this setup, both the New York and Seattle DNS servers host the same DNS zone, integrated into Active Directory. This allows full read/write access on both ends.

**Requirements:**
- Both servers must be promoted to **Domain Controllers**.
- The DNS zone must be configured as an **Active Directory–Integrated Zone**.
- Zone data is replicated through **Active Directory replication**, not DNS zone transfers.


**Example Configuration:**
- Forest root domain: `company.com` (usually created on the New York server).
- Domain structure options:
    - Single domain: `company.com` for both locations.
    - Separate child domains: `newyork.company.com` and `seattle.company.com`.
Note: Using a single domain is more common unless you need administrative separation.


**How It Works:**
- Both servers act as **Primary** for the DNS zone.
- DNS records can be **added, modified, or deleted** on either server.
- Changes are replicated between servers using Active Directory replication.
- Replication is typically near real-time (every few seconds to minutes depending on AD site configuration).

**Advantages:**
- Full **redundancy**: both servers are authoritative and writable.
- **Dynamic updates** are supported on both ends.
- **Automatic synchronization** of DNS data across domain controllers.
- Simplifies DNS management across multiple sites.

**DNS Configuration for Clients:**
- Seattle clients: Preferred DNS = Seattle server, Alternate = New York server.
- New York clients: Preferred DNS = New York server, Alternate = Seattle server.


## QA

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