# unwanted ip addresses (range)

## log

```
Dec 9 22:02:04 dlserve sshd[1140]: Accepted publickey for pi from 192.168.178.58 port 49639 ssh2: RSA SHA256:QjWehkVjDMN4OcaZE7QV5/dVaJw9M4mPI8++JP+15KI
```

The important part is the from ${ip} port ${port}

## thread with suverity

-   user does not follow or guidelines -> leading to a possibly insecure network -> low to medium suverity
-   external unwanted thrid party might be trying to access our network -> medium to high priority
    => these threads should be making considerable noise (alarm an admin) if they happen multiple times especially type 2, since type 1 might just be a user forgetting to use a vpn

## Data to log
    - ip => we want to see from where the user logs in
    - hostname => we wanna see which system they access
    - username => we wanna see which user does violate policy (possibly check for breach)

## threshold
    - yellow : each event
    - red : 1 per minute
