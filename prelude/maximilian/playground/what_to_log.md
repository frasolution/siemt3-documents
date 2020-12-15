# what to log
"SYSLOG_TIMESTAMP" and "MESSAGE"


## sample messages

"MESSAGE": "Accepted publickey for pi from 192.168.178.55 port 44518 ssh2: RSA SHA256:sT2JJuSK34W4YBTtUbGkY5L563qw4UUX3WjIia601tk",
"MESSAGE": "Failed password for pi from 192.168.178.27 port 1035 ssh2",
"MESSAGE": "Accepted password for pi from 192.168.178.27 port 1035 ssh2",

`\"MESSAGE\": \"Accepted publickey for ${user} from 192.168.178.${final_ip} port ${port} ssh2: RSA SHA256:${key}\",`
`\"MESSAGE\": \"Failed password for ${user} from 192.168.178.${final_ip} port ${port} ssh2\",`
`\"MESSAGE\": \"Accepted password for ${user} from 192.168.178.${final_ip} port ${port} ssh2\",`
