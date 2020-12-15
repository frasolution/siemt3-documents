# plan
what to do
-  deserialize line by line 
    - read line https://www.journaldev.com/709/java-read-file-line-by-line 
    - parse line generically to object https://www.baeldung.com/gson-deserialization-guide
    - check if meets ssh login via pass (fail/pass), key (fail/pass)
    - create sshlog event
        - on event create
            - check if pass or fail
                - if fail create fail event
                    - on fail event
                        - check if over count over 