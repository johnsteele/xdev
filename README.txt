xdev (Next Generation Developer) is an Eclipse RCP based IDE.

In addition to housing the framework and build code, this project also serves as an incubator for other xdev sub-component projects.

Framework 
	- xdev-platform
Sub-component projects include:
	- xdev-wiki
	- xdev-remotespace
	- xdev-aws-ec2


xdev-remotespace:
	Application for managing Eclipse installations, workspaces, and deployments.

 Key Features Include:
 # Eclipse Installation Management
  - Distributions can be uploaded and downloaded.
  - Distributions can be installed and deployed
    remotely (using JNLP).
 # Source Code Management
  - Remote and local resource management.
  - Remote and local workspace settings.
  - Interop with git repositories.
 # Build 
  - Remote and local build.
    + Remote build enables developer to build code without
      having the compiler and libraries local.
    + When building, code can be located locally, remotely,
      or both.
 # Deployment
  - Local and remote (using JNLP).
 # Dashboard
  - View
    + Sanboxes/Workspaces
    + Eclipse Installations
    + Installed JRE Installations
    + Activity
