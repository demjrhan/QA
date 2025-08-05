![[Pasted image 20250615172814.png]]


### Default Policies coming with AD DS
![[Pasted image 20250615173135.png]]
When you install active directory by default **Default Domain Policy** and **Default Domain Controllers Policy** is created.


==Default Domain Policy== is applied for every computer and user in the domain.

==Default Domain Controllers Policy== is applied for every domain controllers.


### Altering GPOs
![[Pasted image 20250615215236.png]]

==Block Inheritance==, imagine you apply GPO to NYC OU. By default all the sub OUs like HR, Finance will also apply this GPO. But if you go to Sales and select Block Inheritance it will not allow GPO from outer scope.



==Enforce==, for instance lets say you have a GPO both in NYC and in Domain about security. In case of any conflict between these GPOs, the GPO inside of NYC will win. But if the GPO marked as enforce in Domain, this time it will win.

**This enforcement also overrides the block inheritance. If the OU has block inheritance, the enforced policy will still be accepted.**

==Security Filtering==, imagine the scenario there is inner group inside of HR OU called **Managers**. If you add a GPO to HR OU, by default it will effect all the computers and the users inside of that OU. But if you add the group **Managers** inside of the security filtering for that GPO, it will only effect to the users which belongs to that specific **Managers** group.

![[Pasted image 20250616134708.png]]

**The lower you go, more powerful GPO gets. In case of any conflict between domain-level GPO and Organizational Unit GPO, Organizational Unit GPO will win. This priority can be changed through enforcing the less powerful GPO or changing the policy inheritance.**
##### Local GPOs
Are type of gpos that you define in your own computer even though you are not joined to the domain. 
```bash
gpedit.msc
```

##### Site Level GPOs
Site is a physical location, lets say you have office in NYC and Boston.  This kind of GPOs only effecting depending on the location. This was used to change printer usage in offices. But these days there is easier way to do in group policies.


##### Domain-Level GPOs
This kind of gpo will be applied to all computers and users in your domain.

##### Organizational Unit GPOs
This kind of gpo will be applied to users or computers assigned to that Organizational Unit.