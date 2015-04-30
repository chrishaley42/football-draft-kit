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

# Install Maven
# Need to check for maven somehow first.
sudo apt-get -y install maven
# Start the application

cd /vagrant

echo "Building war..."
mvn -q jetty:run