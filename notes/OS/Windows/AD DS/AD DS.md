Active Directory Domain System consist of
```
Forest
 └── Tree(s)
       └── Domain(s)
             └── Domain Controller(s)
                   └── OU(s), Users, Computers, Groups, etc.
```

1. **Forest**
    
    - The top-level container.
    - Defines the **schema** (object types and attributes) and **global catalog** (partial read-only copy of every domain).
    - You can have only one schema per forest, and trusts between domains in a forest are automatic and transitive.
2. **Tree**
    - A set of one or more domains that share a **contiguous namespace**.
    - Example: if your forest root is `corp.example.com`, you might add domains `us.corp.example.com` and `eu.corp.example.com`. Those together form one tree under the `corp.example.com` forest.
3. **Domain**
    - A **security and administrative boundary**.
    - Holds all your user/computer/group objects for that namespace (e.g. `eu.corp.example.com`).
    - Each domain has its own domain partition, its own password policies, its own Group Policy scope, etc.
    
4. **Domain Controller (DC)**
    - A **server** that actually hosts (replicates and serves) the database for one domain.
    - You can—and should—have multiple DCs per domain for redundancy.
    - When you “promote a server to a DC,” you’re making it a holder of that domain’s directory copy.
      
5. **Organizational Units (OUs)** and Objects
    - Inside each domain you organize users, computers, groups, and other resources into OUs for delegation and policy application.


![[Pasted image 20250615172310.png]]

### Visual Analogy

- **Forest** = the company (e.g. Veeam).
- **Tree** = a division whose name branches off the company name (e.g. Europe branch vs. Asia branch).
- **Domain** = a department within that division (e.g. `sales.eu.veeam.com` is the Europe department domain).
- **Domain Controllers** = the servers in that department that hold the department’s employee directory.
- **OUs/Objects** = the teams and individual employees and stations inside that department.


## ==DSRM Password is really important, not it down.==



## QA

§ **Why we recommended to have at least two domain controllers?**
To ensure high availability and redundancy. This way if one domain controller goes down, the users of the domain can still log in and access resources.

