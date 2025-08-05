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