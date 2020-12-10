# unkown users

## log

```
Dec 9 22:01:56 dlserve sshd[1138]: Disconnecting invalid user hans 192.168.178.58 port 49638: Too many authentication failures [preauth]
```

The important part here is invalid user ${user}

## thread

-   This indicates that an unauthorized user
    -   unauthorized users sometimes try common names
    -   having repeated retries from the some ip addresses with default names like admin or sysadmin (optional)
-   A user could be entering their won username wrong a few times, we require a threshold

## suverity

low til medium except a certain threshold has been reached or an abnormal limit has been reached.
