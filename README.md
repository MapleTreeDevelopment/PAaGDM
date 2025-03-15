PAaGDM
Player Authentication and Game Data Management


Argon2 encryption is being used for password authentication


Default config file:

    ./filestore/config.gdb
    
    Host:                           localhost
    User:                           root
    Password:                       
    Database:                       auth_server
    Authentication data table:      user_auth
    Gamedata table:                 user_gamedata

The auth_server SQL file is present in the root of the project. 
Filename is auth_server.sql - There is a test user in the user_auth table. The password for the test user is encrypted using Argon2.
The decrypted clear text password for the user is test. This can be used for testing purposes.
