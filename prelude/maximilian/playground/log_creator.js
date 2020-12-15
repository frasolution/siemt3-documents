
function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

//max 4
let user = ["zhang", "hans", "werner", "root"];

function fetch_hacker() {
    return user[getRandomInt(4)];
}

function fetch_key() {
    let key = getRandomInt(234342342343523423414234231325).toString(16);
    return key.padStart(43, 'f');
}

function fetch_port() {
    return getRandomInt(999);
}

function fetch_final_ip() {
    return getRandomInt(256)
}

function fetch_statement() {
    switch (getRandomInt(2)) {
        case 0:
            return `Accepted publickey for ${fetch_hacker()} from 192.168.178.${fetch_final_ip()} port 22 ssh2: RSA SHA256:${fetch_key()}`;
        case 1:
            return `Failed password for ${fetch_hacker()} from 192.168.178.${fetch_final_ip()} port 22 ssh2`;
    }
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function fetch_time() {

    await sleep(3000)
    let date = new Date();
    return date.getTime();
    
}

async function main() {

    let log_collection = []
    
    for (let index = 0; index < 6; index++) {
        let SYSLOG_TIMESTAMP = await fetch_time();
        let MESSAGE = fetch_statement();
        log_collection.push(JSON.stringify({SYSLOG_TIMESTAMP,MESSAGE}));
    }

    console.log(await log_collection);

}

main()
