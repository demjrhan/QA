``` bash
Resolve-DnsName google.com # or nslookup google.com

Get-DnsClientCache # or ipconfig /displaydns
Clear-DnsClientCache # or ipconfig /flushdns

Get-DnsServerZone -> prints all zones
Get-DnsServerResourceRecord -ZoneName veeam.com -> Gets all records.
Get-DnsServerResourceRecord -ZoneName veeam.com -RRType A -> Gets only A record type.

```
```bash
Get-DhcpServerv4Scope -> Gets all scopes

#Add scope
Add-DhcpServerv4Scope -Name "QA" -StartRange 192.168.22.1 -EndRange 192.168.22.254 -SubnetMask 255.255.255.0

#Add exclusion
Add-DhcpServerv4ExclusionRange -ScopeId 192.168.22.0 -StartRange 192.168.22.1 -EndRange 192.168.22.10

Remove-DhcpServerv4Scope -ScopeId 192.168.22.0

Get-DhcpServerv4Lease -ScopeId 192.168.22.0

```
```bash
Get-WindowsFeature 
Get-WindowsFeature|more #for pagination

Install-WindowsFeature DHCP -IncludeManagementTools
Install-WindowsFeature DNS -IncludeManagementTools

Uninstall-WindowsFeature DHCP
Uninstall-WindowsFeature DNS
```

```
nslookup -type=NS google. a.root-servers.net
```


```bash
Test-NetConnection -ComputerName <DNS ADRESS> -Port 53
```
Command above is used to check if the DNS port is open. Addition to this you can also go to the path to check that if the services on bottom is running.
![[Pasted image 20250626154302.png]]

```
Network and Internet Settings -> Windows Firewall -> Advanced Settings -> Inbound Rules
```

