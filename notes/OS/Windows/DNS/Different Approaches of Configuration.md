### **Primary + Secondary DNS Zone Approach**

- **New York DNS Server** is configured as the **Primary Zone**.
- **Seattle DNS Server** is configured as the **Secondary Zone**.
- Do not forget that names of the both zones must be same in order to make connection.
##### **How It Works:**

- The **Seattle server pulls all zone data from New York** via a zone transfer.
- The data on the **Secondary server is read-only**, meaning:
    - Seattle DNS cannot create, modify, or delete DNS records.
    - It only serves records that it has received from New York.
- **Workstations** and **Servers**:
    - Use **New York DNS** as the **Preferred DNS Server**.
    - Use the **Seattle DNS** as the **Alternate DNS Server**.

##### **Benefits:**

- Ensures **redundancy and load balancing**.
- Reduces DNS query latency for Seattle clients (they can query their local server).
- If the New York DNS goes offline, **Seattle can still serve cached DNS data**.
- **Seattle automatically refreshes its data** from New York periodically (based on SOA timers: refresh, retry, expire).

### **AD-Integrated DNS Zone (AD Zone + AD Zone)**

In this setup, both the New York and Seattle DNS servers host the same DNS zone, integrated into Active Directory. This allows full read/write access on both ends.

##### **Requirements:**

- Both servers must be promoted to **Domain Controllers**.
- The DNS zone must be configured as an **Active Directory–Integrated Zone**.
- Zone data is replicated through **Active Directory replication**, not DNS zone transfers.


##### **Example Configuration:**

- Forest root domain: `company.com` (usually created on the New York server).
- Domain structure options:
    - Single domain: `company.com` for both locations.
    - Separate child domains: `newyork.company.com` and `seattle.company.com`.
Note: Using a single domain is more common unless you need administrative separation.


##### **How It Works:**

- Both servers act as **Primary** for the DNS zone.
- DNS records can be **added, modified, or deleted** on either server.
- Changes are replicated between servers using Active Directory replication.
- Replication is typically near real-time (every few seconds to minutes depending on AD site configuration).


##### **Advantages:**

- Full **redundancy**: both servers are authoritative and writable.
- **Dynamic updates** are supported on both ends.
- **Automatic synchronization** of DNS data across domain controllers.
- Simplifies DNS management across multiple sites.

##### **DNS Configuration for Clients:**

- Seattle clients: Preferred DNS = Seattle server, Alternate = New York server.
- New York clients: Preferred DNS = New York server, Alternate = Seattle server.

