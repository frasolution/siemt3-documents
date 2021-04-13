# SSH_Root

## log

```
Dec 9 23:46:48 dlserve sshd[1310]: Failed publickey for root from 192.168.178.58 port 51304 ssh2: RSA SHA256:QjWehkVjDMN4OcaZE7QV5/dVaJw9M4mPI8++JP+15KI
```

The important part here is the user should equal root

## thread

-   we do not want anyone to login to root since they would have full access
-   root is a default open user therefore we need to keep track of this
-   a user trying to acess user does not know our network

## suverity

I'd say this is a low to medium priority event that will be leading nowhere since we have this deactivated anyway.

## Data to log
    - ip address => track each single offense (possibly offers a way to trace back login attempts)

## threshold
    - green = each event
    - yellow = 1 per minute