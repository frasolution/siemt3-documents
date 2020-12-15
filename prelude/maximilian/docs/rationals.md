# The ssh problem

## defining a failure

### what is a failure
output "attacker"
```
max@max-aspire-xc600's password:
Received disconnect from 192.168.178.55 port 22:2: Too many authentication failures 
Disconnected from 192.168.178.55 port 22
```

log "admin"     
```
Nov 16 17:51:32 max-Aspire-XC600 sshd[28623]: Failed password for max from 192.168.178.46 port 34404 ssh2
```

### what is not a failure
- when setup for sshkey only logins (as per usual) and you are not listed in "authorized_keys"  
output "attacker"    
```
max@max-aspire-xc600: Permission denied (publickey).
```  
   
log "admin"   
```
Nov 16 17:39:16 max-Aspire-XC600 sshd[27732]: Connection closed by authenticating user max 192.168.178.46 port 34394 [preauth]
```   

## defining too many failures
- we are (ab)using builtin tools from sshd
- reciveing a log with disconnect becuase of authentication failure    
### example
```
Nov 16 17:51:34 max-Aspire-XC600 sshd[28623]: error: maximum authentication attempts exceeded for max from 192.168.178.46 port 34404 ssh2 [preauth]
```
