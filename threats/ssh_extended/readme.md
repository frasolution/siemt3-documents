# SSH Extended

## Long term checking For dictionary attack/brtue force

-   User login succ vs fail chart -> create ratio kpi
-   Check for fails for each user in a specific amount of time -> to detect if any user was hit by a very high amount.
    -> use cfs lfd
    https://securitytrails.com/blog/mitigating-ssh-based-attacks-top-15-best-security-practices#one0-block-ssh-brute-force-attacks-automatically:~:text=On%20this%20post%2C%20we%20mentioned%20ways,is%20to%20block%20the%20offending%20IPs.

## Login for root and users

-   if root login is deactivated an atempted login could signalized an outside thread

## Unwanted Ssh Key algorithms

-   if someone atempts to login with an SSH key that was generated with the wrong methos this could be an outside thread

## unknown user

-   if user does not exist

## unwanted ip addresses

-   lets assume we want users to login only via vpn or the local network, so a user trying or succeding to login from the outside is a bad omen
