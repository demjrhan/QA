

https://www.youtube.com/watch?v=cwT82ibOM2Q



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