# Read me first and read me completely!

This is your repository for the personal exercises on exercise rounds 1-7. For doing the exercises you need to have Git and Node.js installed.
For installing Node.js there are a few options:
- Vagrant: use the Vagrant environment with the Vagrant files provided in this repository. Vagrant can use them to create and run a development environment with appropriate tools on your machine, including both Node.js and MongoDB. MongoDB will be used in the later exercises. Read more under the heading "Using Vagrant to create and run a development environment on your machine"
    - Note: Vargrant is for x86 machines only. If you are rocking a non-x86 chip (I'm looking at you, Apple silicon), then Vagrant is not for you. Normally, we would recommend you to choose Docker, but since that is the topic of a different course, we can't officially recommend (or rather, support) that.
- Azure Labs: you can access remotely a fully provisioned virtual machine and enjoy the tools preconfigured. The downside is, that you'll be working over the network. To get started, install X2GO client (`sudo apt-get install x2goclient`, or [X2Go client downloads page](https://wiki.x2go.org/doku.php)). Newer macOS versions will require that you install [X11](https://www.xquartz.org/), as well. Once those have finished installing, you can read more under the heading "Azure Labs".
- Local installs: you can install Node.js to your machine using the packages from Node.js pages. Read more under the heading "Direct install of Node to your own machine"

## Using Vagrant to create and run a development environment on your machine
From [Vagrants Introduction](https://www.vagrantup.com/intro):
>Vagrant is a tool for building and managing virtual machine environments in a single workflow. With an easy-to-use workflow and focus on automation, Vagrant lowers development environment setup time, increases production parity, and makes the "works on my machine" excuse a relic of the past.

To start using Vagrant on your machine, first install the needed software

- install VirtualBox, which is used by Vagrant. [Virtualbox downloads](https://www.virtualbox.org/wiki/Downloads)
- install Vagrant. [Vagrant downloads](https://www.vagrantup.com/downloads)

After you have successfully installed both VirtualBox and Vagrant, you get to set up and access the virtual environment by using files in this repository. This repository has a _Vagrantfile_ file in its root folder, and _/vagrant_ folder, which holds _provision.sh_ file which is called from the _Vagrantfile_. You should read through these files, but you don't (and shouldn't) edit them.

In the root directory of this repository where the _Vagrantfile_ is, first run this command in your console:

`vagrant help`

This will list the available Vagrant commands. We will only be using a few of them in the following steps and in this course.

Next, start the configuration and setting up of the virtual environment with this command

`vagrant up`

This will take a looong time to complete, as it fetches an image of Ubuntu for the virtual machine, and runs all the installation steps defined in _provision.sh_.

After the vagrant up command has completed, you can connect to the running virtual environment with this command:

`vagrant ssh`

Now you should be in your virtual environment. All the files in the repository are linked in the directory _/webdev1_ of your virtual environment. You can access this folder with the command 
    _cd /webdev1_

Ports 3000 for Node and 27017 for MongoDB are open from the virtual environment to the same port numbers of the host system (your computer's operating system). So, if you run a Node server in your virtual environment on port 3000, you can access it from the host system with your browser using the address _localhost:3000_.

Use command `vagrant halt` to shut down the machine (when not logged in with ssh)

Use command `vagrant destroy` to delete the whole virtual machine   

If you get an error: symlink error, error -71, etc. with vagrant, use the parameter --no-bin-links.
Check https://github.com/npm/npm/issues/7308 and http://perrymitchell.net/article/npm-symlinks-through-vagrant-windows/

## Azure Labs

The university has procured some Azure Labs virtual machines for several programming courses. You can log in to [labs.azure.com](https://labs.azure.com/), click the toggle switch of your virtual machine where it says "stopped" to boot it up, and click on the connect icon next to the toggle switch and choose "connect via SSH" to see the machine's full URL. Copy that and run X2Go.

In the X2Go client, choose "new session", fill in the server URL (copied in the previous step), and set the SSH port. Currently, it's `5004`, but we'll let you know if that changes.

Make sure to set the session type to `XFCE` in the dropdown.

This session information gets saved, so you won't need to fill in these details upon every connection. During the first connection, you may be informed, that you are connecting to a server you have not connected to before and whether you trust its key.

X2Go is not the only available remote desktop client. If you find a more preferred one with `XFCE` support, the same instructions should work with that, as well.

## Direct install of Node to your own machine
Direct installation of Node.js is instructed in the Handson video which is available in Plussa first lecture week course materials. Shortly summarized:

In *Linux* you can install Node with the following commands in your console:

`node -v`

`curl -sL https://raw.githubusercontent.com/creationix/nvm/v0.35.3/install.sh -o install_nvm.sh`

`bash install_nvm.sh`

`source ~/.profile`

`nvm install 14.9.0`

`nvm use 14.9.0`

`node -v`

In *Windows*, you can follow [Microsoft's own instructions for Node installation](https://docs.microsoft.com/en-us/windows/nodejs/setup-on-windows).


## Exercises

The exercises for the first exercise round are already in your personal course GitLab repository. They are copied to your local working directory when you clone the repo. Exercises for the other upcoming exercise rounds must be pulled from the course upstream, see Plussa exercise "Setting upstream".

The general procedure
- pull the instructions from the course upstream (not necessary in the first exercise round). Directories holding the exercises are of the format `exercises/XX_desc` where XX is the exercise round number
- do the exercises
- save the required files to your repository: git add FILE; git commit -m "message" FILE; git push
- submit your GitLab repository SSH URL to Plussa
- Plussa automatically grades your submission and gives you feedback

## Support for exercises 
Available in courses Teams area, and its channels for each exercise round.