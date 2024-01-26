# Repo 
URL: https://github.com/Usmanasim11/AR-final-demo.git

# Installing Git
yum install git

# Installing wget
yum install wget

# Installing Docker
sudo yum install -y yum-utils

sudo yum-config-manager --add-repo   https://download.docker.com/linux/centos/docker-ce.repo

sudo yum install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

sudo usermod -aG docker <username>

sudo systemctl restart docker

sudo chmod 666 /var/run/docker.sock

sudo systemctl restart docker

# Installing Docker-Compose
sudo curl -L "https://github.com/docker/compose/releases/download/v2.12.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo mv /usr/local/bin/docker-compose /usr/bin/docker-compose

sudo chmod +x /usr/bin/docker-compose

# Installing Maven
sudo yum install maven

wget https://archive.apache.org/dist/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz -P /tmp

cd /tmp

sudo tar xf apache-maven-3.8.1-bin.tar.gz -C /opt

cd /opt

sudo ln -s /opt/apache-maven-3.8.1 /opt/maven

sudo vi /etc/profile.d/maven.sh

export JAVA_HOME=/usr/lib/jvm/jre-11-openjdk

M2_HOME=/opt/maven

MAVEN_HOME=/opt/maven

PATH=${M2_HOME}/bin:${PATH}

sudo chmod +x /etc/profile.d/maven.sh

source /etc/profile.d/maven.sh

#  Installing Java
sudo yum install java-11-openjdk

sudo update-alternatives --config java

# Installing Jenkins
sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat-stable/jenkins.repo

sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key

# Add required dependencies for the jenkins package
sudo yum install jenkins

sudo systemctl daemon-reload

sudo systemctl enable jenkins

sudo systemctl start jenkins

sudo systemctl status jenkins

# Installing Python3
sudo yum install python3

# Installing Node and NPM
sudo yum install -y gcc-c++ make curl

curl -sL https://rpm.nodesource.com/setup_14.x | sudo -E bash -

sudo yum remove -y nodejs npm

sudo yum clean all

sudo yum list available nodejs

sudo yum install -y nodejs



--- Jenkins Plugin ---
jacoco

sonarqube

quality gate

NodeJs

docker

docker-build-step

docker-compose

-- Jenkins tools configuration ---
1. maven
a. maven3.8.6 ->3.8.6
b. maven ->3.8.1

2. java along with the path
(path copy from mvn -v)

3. nodejs (14.)




