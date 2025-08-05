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
    - The **authoritative server** provides the actual IP address (A record) for the hostname (e.g., `www.example.com`).

#### Root Hints
A list of authoritative root DNS servers used when no forwarder is configured or the forwarder fails. The DNS server contacts a root server to begin an iterative resolution process for unknown external 
domains.

![[Pasted image 20250625184351.png]]