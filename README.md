# SprintBoot-Angular-bootstrap-Sonarqube
Desarrollo Prueba Técnica 3TI

## Pre-Requisitos
- NodeJs (v. 12.18.3)
- NPM (v. 6.14.6)
- Angular CDN (v. 1.2.21)
- Bootstrap CDN (v. 5.0.0)
- Docker (v. 19.03.11)
- SonarQube (v. 7.9.5)
- OpenJDK (v.11.0.7)
- Maven (v. 3.5.2)
- Sprint Tool Suite 4 (v. 4.8.1) 
- Clone de este Repositorio 

## Orden de Instalación
### NodeJs (v. 12.18.3)
```sh
$ sudo apt install nodejs
$ node -v
```
###  NPM (v. 6.14.6)
```sh
$ sudo apt install npm
$ npm -v
```
### Angular CDN (v. 1.2.21)
```sh
$ sudo npm install -g @angular/cli
$ ng --version
```
### Docker (v. 19.03.11)
Se instala Docker para crear imagen de SonarQube
```sh
$ sudo apt-get remove docker docker-engine docker.io
$ sudo apt install docker.io
$ sudo systemctl start docker
$ sudo systemctl enable docker
$ docker -v
```
### SonarQube (v. 7.9.5)
```sh
$ docker run -d --name 9000:9000 -p 9092:9092 sonarqube
$ docker logs -f sonarqube
```
### OpenJDK (v.11.0.7)
```sh
$ sudo apt-get install openjdk-11-jre openjdk-11-jdk
$ java -version
```
### Maven (v. 3.5.2)
```sh
$ sudo apt install maven
$ mvn -version
```
### Sprint Tool Suite 4 (v. 4.8.1) 
Descargar la Suite desde:
https://download.springsource.com/release/STS4/4.8.1.RELEASE/dist/e4.17/spring-tool-suite-4-4.8.1.RELEASE-e4.17.0-linux.gtk.x86_64.tar.gz
```sh
$ sudo gzip -d spring-tool-suite-4-4.8.1.RELEASE-e4.17.0-linux.gtk.x86_64.tar.gz
$ sudo tar -xvf spring-tool-suite-4-4.8.1.RELEASE-e4.17.0-linux.gtk.x86_64.tar
$ sudo mv sts-4.8.1.RELEASE/  /opt/
```
### Clone de este Repositorio 
```sh
$ git clone https://github.com/mariofribla/SprintBoot-Angular-bootstrap-Sonarqube.git
```
Una ves clonado el repositorio, importe el proyecto en Spring Tool Suite 4.

## Configuración SonarQube
Para configurar SonarQube en la Spring Suite, debes editar el archivo pom.xml y agregar las siguientes lineas:
```sh
<dependency>
	<groupId>org.sonarsource.scanner.maven</groupId>
		<artifactId>sonar-maven-plugin</artifactId>
	<version>3.2</version>
</dependency>

	<profiles>
		<profile>
			<id>sonar</id>
			<activation>
				<activeByDefault>true</activeByDefault>
			</activation>
			<properties>
				<!-- Optional URL to server. Default value is http://localhost:9000 -->
				<sonar.host.url>
					http://<IP_Docker>:9000
				</sonar.host.url>
				<sonar.login>
					admin
				</sonar.login>
				<sonar.password>
					admin
				</sonar.password>
			</properties>
		</profile>
	</profiles>
```
Para ejeuctar SonarQube, te debes ubicar en el directorio de tu proyecto y ejeuctar Maven:
```sh
$ mvn sonar:sonar
```
# 
# 
##Mario Fribla

