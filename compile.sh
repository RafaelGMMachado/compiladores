#---------------------------- MAIN --------------------------------
Main()
{	
	javac *.java
	java Main
	astyle --quiet output.c
}

#---------------------------- EXECUÇÃO --------------------------------
if [[  ! $(dpkg -l astyle) ]]
then
	echo -e "\033[01;31m[!] Instalando dependencias... [!]\033[0m"
	sudo apt install -y astyle;
	echo " ********************** "
	echo -e "\033[01;31m[!] Starting the Compiling process... [!]\033[0m"
	Main
	exit 0
else
	echo -e "\033[01;31m[!] Starting the Compiling process... [!]\033[0m"
	Main
	exit 0
fi
