https://portal.azure.com/#home

| **Series**   | **Description**                              | **Reasoning**                          |
| ------------ | -------------------------------------------- | -------------------------------------- |
| **B**        | Burstable VMs, low-cost, scale as needed     | Great for lab/testing, very affordable |
| **Dsv3/Dv3** | Balanced CPU/memory, standard for many tasks | Reliable for general QA testing        |
| **DSv2/Dv2** | Older gen, still suitable for OS labs        | Good for compatibility testing         |

You can allocate:

- **2–4 GB RAM per VM**
- **1–2 vCPUs**
- **60–80 GB disk** (for Server installs)

![[Pasted image 20250612220330.png]]
#### M**NAT (Network Address Translation)**  
What happens: Your VM shares your host computer’s internet connection.

- Your VM gets a private IP from VMware's virtual NAT.
- Useful for:
    - Internet access (downloads, updates)
    - Basic Active Directory, DNS, DHCP testing on one VM
- Limitation: You can’t simulate a real network with a router or real external devices.  
    Use this when starting out and installing roles.



#### **Bridged Networking**  
What happens: Your VM acts like a real device on your actual network.

- Gets an IP from your router or LAN DHCP.
- Can ping real PCs, join real domains, etc.
- Great for advanced scenarios, like:
    - Making your VM act as a real DHCP server for other devices
    - Testing if your DNS works in a real environment  
        Use this when you're confident and want realistic testing.


#### **Host-Only Networking**  
What happens: The VM is placed in a private network shared only with your host.

- No internet access.
- The VM can communicate with:
    - Your host machine
    - Other VMs on the same host-only network
- VMware provides a virtual DHCP server (unless you disable it).
- Great for building an isolated lab:
    - Server VM running DHCP, DNS, and AD
    - Client VM receiving configuration from the server  
        Use this for safe, isolated multi-VM testing.

![[Pasted image 20250612220530.png]]
![[Pasted image 20250612220807.png]]
#### Virtual Disk Types

| Type     | Performance    | OS Support             | Use Case                               | Why use / not use?                    |
| -------- | -------------- | ---------------------- | -------------------------------------- | ------------------------------------- |
| **IDE**  | ❌ Very slow    | ✅ All OSes             | Very old systems (e.g., XP)            | Obsolete, avoid unless required       |
| **SCSI** | ✅ Good         | ✅ All Windows          | Default in older VMware versions       | Reliable, but slower than NVMe        |
| **SATA** | ✅ Good         | ✅ All Windows          | Mid-range speed for desktops           | OK choice, but not the fastest        |
| **NVMe** | ✅✅ Very Fast ✅ | ✅ Windows Server 2016+ | Modern high-performance disk interface | Best for speed and future-proofing ✅✅ |

![[Pasted image 20250612220832.png]]
#### Select a Disk

When creating a new virtual machine in VMware, the virtual hard disk is what the guest operating system will treat as its local storage—just like a real physical drive. This step defines how that virtual disk will be created or attached.

##### 1. Create a New Virtual Disk (Most Common Choice)

**What happens:**  
VMware creates a new virtual hard disk file (`.vmdk`) stored on your host system. This virtual disk acts as the main storage drive for the guest OS.

**Why it’s preferred in learning and production:**

- Ensures a clean installation environment.
- Provides full control over size, location, and format.
- Allows the virtual disk to be easily moved, copied, or backed up.
   

**Interview Tip:**  
“In most VM deployments, I create a new virtual disk to ensure no leftover configurations exist from older VMs. It also allows me to allocate storage based on the needs of the server role I’m planning—for example, more space for a file server, less for a DHCP server.”

##### 2. Use an Existing Virtual Disk

**Use Case:**

- Attaching a previously created `.vmdk` file for testing preinstalled environments or cloning a base image in a lab automation pipeline.
- Common in enterprise environments where standard images are deployed to multiple VMs.

**Risks:**

- Configuration mismatches if the disk was tied to different virtual hardware.
- Potential security risks if sensitive data remains on the disk.

**Interview Tip:**  
“I’d use this when working with base images in test automation pipelines, but I’d validate the hardware compatibility and OS activation state before proceeding.”

##### 3. Use a Physical Disk (Advanced/Uncommon)

**What happens:**  
The VM gains direct access to a host partition or disk, also known as raw disk mapping.

**Why it’s rarely used:**

- Requires administrator privileges and detailed knowledge of the host’s disk structure.
- Direct access can lead to data corruption if not handled correctly.
- Not supported in all host environments (especially on encrypted or dual-boot systems).

**Valid use cases:**

- Dual-boot environments.
- Forensics or hardware performance testing.

**Interview Tip:**  
“This is something I’d only consider in a niche scenario like forensic image analysis or hardware testing, and even then, I’d ensure the VM has read-only access to safeguard the host data.”





#### Network Adapter

NAT -> connects to the router of VM, not visible on LAN, connects internet via host.
Bridge -> connects to the internet directly and acts like actual device and visible on LAN.