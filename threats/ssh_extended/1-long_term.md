# SSH_Dictionary

#log 

"wrong passwords"

```
Nov 16 17:51:32 max-Aspire-XC600 sshd[28623]: Failed password for max from 192.168.178.46 port 34404 ssh2
```

The important part is Failed password

## thread

An attacker might try to iterate through commonly used passwords on a user account to obtain access to a remote system and furter invade the system from this point on. 
we are aim to check for a long term behaviour in a future version.

## suverity

this can be on all levels depending on the threshold

## Data to log
    - username => to see which user gets attacked
    - ip => to possibly have data on the attacker
    - (do not discriminate on hostname because attacks might be on multiple systems)

## threshold
    - yellow = 5 failed passwords per user
    - red = 2 overall yellow events in the past 10 minutes
