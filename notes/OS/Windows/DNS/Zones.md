#### Forward Lookup Zone
Purpose of having forward lookup zone is to resolve domain names to ip addresses.
##### Host (A) Record
Maps a **domain name to an IPv4 address** (e.g., veeam.local → 192.168.1.10).

##### Host (AAAA) Record
Maps a **domain name to an IPv6 address** (e.g., veeam.local → fe80::1).

##### Alias (CNAME) Record
Creates an **alias** from one domain name to another (e.g., veeam.local → qa.veeam.com). 

##### Service (SRV) Record
Used to resolve service to ip address. Defines **services** available in the domain (e.g., used by Active Directory for domain controller location).

#### Reverse Lookup Zone 
Purpose of having reverse lookup zone is to resolve ip addresses to domain names.

##### Pointer (PTR) Record
Maps an **IP address to a domain name** (e.g., 192.168.1.10 → server.demo.lab).

## Types of zones

##### Primary zone
Holds all the records about the IP addresses; can manage records (add, edit, update). This is the authoritative source for the zone data.

##### Secondary zone
A read-only copy of the primary zone. It receives zone data through zone transfers and cannot be directly modified.
##### Stub Zone

In a stub zone, only the Name Server (NS), Start of Authority (SOA), and A records of the authoritative DNS servers are stored. This allows the stub zone to stay updated with any changes made on the main DNS server, eliminating the need for manual updates.

It is generally used for small branches connected to a larger network, such as a headquarters and a branch in another district or city. It is not recommended for large branches, as it would result in a high volume of query forwarding.

##### Active Directory Integrated zone
Stores zone data in Active Directory, allowing multi-master replication and secure dynamic updates. Changes made on one Domain Controller replicate automatically to others.
