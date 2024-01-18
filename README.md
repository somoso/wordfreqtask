# Word frequency

App that, when you provide it a file, it will provide a count of all the words in the text file

## Building the application

### Prerequisites

You will need:

* Java 17

It would be nice to have:

* IntelliJ IDEA

#### Extra developer info

Even though this application is quite lightweight, if you need to recreate the development environment, this was 
developed/built/tested on a Macbook Pro M1 16GB device with Sonoma 14.2.1, with Azul Zulu 17.0.4 aarch64 as the JVM, 
and IntelliJ Ultimate #IU-233.13135.103.

### Steps

In the root of the git/source code directly, run on the terminal:

```bash
mvn clean package
```

Once this is done, you should have a `target` folder. On the terminal, you should see the following:

```
AdaptavistTask-1.0-SNAPSHOT.jar
```


## Running the application

To run this application, run the following command on the terminal:

```bash
java -jar AdaptavistTask-1.0-SNAPSHOT.jar <input file>
```

For example:

<details>

```bash
soheb@Sohebs-MacBook-Pro target % java -jar AdaptavistTask-1.0-SNAPSHOT.jar /Users/soheb/Documents/Console.txt
line:136
mainccffjs:133
debug:129
signalr:128
bst:128
gmt:128
invoked:64
invoking:56
salehubgetproxybids:32
salehubgetwinningvehicles:30
salehubgetcurrentsalevehicle:29
salehublistvehicles:18
of:7
x:7
to:7
the:5
with:5
failed:4
log:4
error:4
a:4
connection:3
resource:3
status:3
server:3
timeout:3
not:3
salehubgetvehiclereserveanddamage:3
found:3
load:3
websockets:3
responded:3
transport:3
connected:3
websocket:2
state:2
salehubjoinsale:2
salehubgetantiforgerytoken:2
keep:2
request:2
alive:2
start:2
salehubgetliveuser:2
salehublistsales:2
loaded:1
subscribed:1
warning:1
id:1
bugsnag:1
websocketerror:1
opened:1
monitoring:1
starting:1
cb-db-c-aa-bfab:1
succeeded:1
changed:1
disconnecting:1
wsslivetestastonbarclaynetsignalrconnecttransportwebsocketsclientprotocolconnectiontokenzemrjljvojpozoziqhmtsqgmfttdtkbkxflchjozrbdabknfghnpixsxarjtgfisjkgmwbzayxqtehlryqtleiahxoccnplbhjupsxedjconnectiondatabbnameasalehubddtid:1
negotiating:1
httpslivetestastonbarclaynetsignalrnegotiateclientprotocolconnectiondatabbnameasalehubdd:1
endpoint:1
and:1
peer:1
now:1
client:1
initialization:1
salehub:1
live:1
on:1
mainfbacssmap:1
bootstrapmincssmap:1
mainccffjsmap:1
hub:1
transitioning:1
initiating:1
connecting:1

```
</details>