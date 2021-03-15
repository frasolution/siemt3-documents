# key algorithms

## log

```
Dec 9 22:02:04 dlserve sshd[1140]: Accepted publickey for pi from 192.168.178.58 port 49639 ssh2: RSA SHA256:QjWehkVjDMN4OcaZE7QV5/dVaJw9M4mPI8++JP+15KI
```

The important part is the ssh2: ${algo}:${fingerprint}

## thread

-   this can indicate an external person not familiar with our setup trying to access out network
-   this also can be a person running an old and unsecure setup

## suverity

The Suverity of this is a medium since either way this indicates a problem with our network

## Data to log
    - username => we see which user we should notify to update their setup
    - algo used => admins can deduct the age of the key or the degree to which the key is out of date
    - fingerprint => admins maybe want to deactivate key

## threshold
    - green = each event