#### Forwarder
A DNS server to which queries are forwarded when the local DNS server cannot resolve them. Commonly used to forward external queries (e.g., to 8.8.8.8) to reduce load and centralize internet name resolution.

#### Conditional Forwarder
A specific type of forwarder that handles queries for particular domain names (e.g., forward all .branch.local queries to a specific internal DNS server). Useful for resolving names between different internal domains or forests.
