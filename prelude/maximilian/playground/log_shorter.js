const logs = require("./logs.json");

function REDUCED_LOG(SYSLOG_TIMESTAMP, MESSAGE) {
    this.SYSLOG_TIMESTAMP = SYSLOG_TIMESTAMP;
    this.MESSAGE = MESSAGE;
}

let array = []

logs.forEach(log => {
        
    if(log.MESSAGE.contains("Failed")){
        console.log(`\{\"${log.SYSLOG_TIMESTAMP}\"\, \"${log.MESSAGE}\"\}`);
    }
    
    if(log.MESSAGE.contains("Accepted password")){
        console.log(`\{\"${log.SYSLOG_TIMESTAMP}\"\, \"${log.MESSAGE}\"\}`);
    }

    if(log.MESSAGE.contains("Accepted publickey")){
        console.log(`\{\"${log.SYSLOG_TIMESTAMP}\"\, \"${log.MESSAGE}\"\}`);
    }
    
});

//console.log(array);
