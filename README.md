Transmission RPC Java
=====================

Java implementation of the Transmission RPC API.


## Note
This API is still under development and it needs lots of cleanup. When the code is cleaned up the API will be provided through a Maven repository.

## Maven
The project is available on a Maven repository. See: [https://github.com/stil4m/maven-repository](https://github.com/stil4m/maven-repository)

## Functionality

| Command              | Implemented                                  |
| -------------------- |:--------------------------------------------:|
| torrent-start        | <span style="color: green">YES</span>        |
| torrent-start-now    | <span style="color: green">YES</span>        |
| torrent-stop         | <span style="color: green">YES</span>        |
| torrent-verify       | <span style="color: green">YES</span>        |
| torrent-reannounce   | <span style="color: green">YES</span>        |
| torrent-set          | <span style="color: red">NO</span>           |
| torrent-get          | <span style="color: orange">PARTIALLY</span> |
| torrent-add          | <span style="color: orange">PARTIALLY</span> |
| torrent-remove       | <span style="color: green">YES</span>        |
| torrent-set-location | <span style="color: red">NO</span>           |
| torrent-rename-path  | <span style="color: red">NO</span>           |
| session-set          | <span style="color: red">NO</span>           |
| session-get          | <span style="color: red">NO</span>           |
| session-stats        | <span style="color: green">YES</span>        |
| blocklist-update     | <span style="color: red">NO</span>           |
| port-test            | <span style="color: red">NO</span>           |
| session-close        | <span style="color: red">NO</span>           |
| queue-move-top       | <span style="color: red">NO</span>           |
| queue-move-up        | <span style="color: red">NO</span>           |
| queue-move-down      | <span style="color: red">NO</span>           |
| queue-move-bottom    | <span style="color: red">NO</span>           |
| free-space           | <span style="color: red">NO</span>           |
