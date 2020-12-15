
#task looking for failure
## grep for 
"authentication failure"
"Message" -"Failed password for ${user} from ${externalip}"  and so on

## identification
"__CURSOR"
-All kind of timestamps-



alternative use /var/log/auth.log
"sshd[905]: Failed password for pi from 192.168.178.27 port 1035 ssh2"


#bonus /var/log/auth.log    -> can check for sudoers
"sudo:      git : user NOT in sudoers "

# key vectors
## message
    - gives full info to system admins
    - if parsebale info changes there is a fallback
time and date   
    - staff needs to know when does the incident occour and infor on how often it happens
user
    - check which user will be acessed
    - preemptively inform user and gain confirmation that the user didn't just forget password
offending requesting IP adress 
    - nail down potential thread
hostname - offenting requested IP adress
    - nail down target of the "attack"
