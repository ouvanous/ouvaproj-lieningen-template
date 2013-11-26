#!/bin/bash

MY_APP_HOME="/srv/ouva/www/{{name}}"
MY_APP_JAR="target/{{name}}-0.1.0-SNAPSHOT-standalone.jar"
 
java -Xms512m -Xmx2048m -jar $MY_APP_HOME/$MY_APP_JAR &
echo $! > $MY_APP_HOME/tmp/pids/{{sanitized}}.pid
exit 0
