# -*- mode: ruby -*-
# vi: set ft=ruby :

def set_hostname(server)
	server.vm.provision 'shell', inline: "hostname #{server.vm.hostname}"
end

COMMON_INITIALIZER = <<EOF.freeze
	sudo yum install -y dos2unix
    cd /vagrant/provisioning_scripts/
    for file in `ls /vagrant/provisioning_scripts/common/*.sh`; do
        dos2unix $file
        chmod +x $file
        ${file}
    done
EOF

CENTOS_7_INITIALIZER = <<EOF.freeze
    cd /vagrant/provisioning_scripts/
    for file in `ls /vagrant/provisioning_scripts/centos_7/*.sh`; do
        dos2unix $file
        chmod +x $file
        ${file}
    done
EOF

PGDB_INITIALIZER = <<EOF.freeze
    cd /vagrant/provisioning_scripts/
    for file in `ls /vagrant/provisioning_scripts/pgDB/*.sh`; do
        dos2unix $file
        chmod +x $file
        ${file}
    done
EOF

APP_INITIALIZER = <<EOF.freeze
    cd /vagrant/provisioning_scripts/
    for file in `ls /vagrant/provisioning_scripts/app/*.sh`; do
        dos2unix $file
        chmod +x $file
        ${file}
    done
EOF



Vagrant.configure("2") do |config|

	config.vm.define "pgDB" do |pgDB|
		pgDB.vm.box = "bento/centos-7.2"
		pgDB.vm.hostname = "pgDB.ssapp.io"
		pgDB.vm.network "private_network", ip: "192.168.56.150", mac: "080027CBD150"
		pgDB.vm.provider "virtualbox" do |vb|
			vb.gui = false
			vb.memory = "512"
		end
		pgDB.vm.provision "shell", inline: COMMON_INITIALIZER.dup
		pgDB.vm.provision "shell", inline: CENTOS_7_INITIALIZER.dup
		pgDB.vm.provision "shell", inline: PGDB_INITIALIZER.dup
		set_hostname(pgDB)
	end
	
	config.vm.define "app" do |app|
		app.vm.box = "bento/centos-7.2"
		app.vm.hostname = "app.ssapp.io"
		app.vm.network "private_network", ip: "192.168.56.160", mac: "080027CBD160"
		app.vm.provider "virtualbox" do |vb|
        vb.gui = false
		    vb.memory = "512"
		end
		app.vm.provision "shell", inline: COMMON_INITIALIZER.dup
		app.vm.provision "shell", inline: CENTOS_7_INITIALIZER.dup
		app.vm.provision "shell", inline: APP_INITIALIZER.dup
		set_hostname(app)
	end
		
end
