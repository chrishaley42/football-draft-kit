#!/usr/bin/env bash

# Install mysql
if [ ! -e /etc/init/mysql.conf ]; then
  apt-get update --fix-missing
  echo "Installing MySQL 5.5..."

  cat <<EOF | sudo debconf-set-selections
mysql-server-5.5 mysql-server/root_password password password
mysql-server-5.5 mysql-server/root_password_again password password
mysql-server-5.5 mysql-server/root_password_seen true
mysql-server-5.5 mysql-server/root_password_again_seen true
EOF

  sudo apt-get -y install mysql-server-5.5 
  mysql -u root --password=password <<EOF
CREATE DATABASE IF NOT EXISTS football;
EOF
fi

# Install Java
sudo apt-get -y install openjdk-7-jdk
sudo update-alternatives --config java


# Start the application

cd /vagrant

echo "Run App..."
java -jar target/gs-spring-boot-0.1.0.jar &