# CodeLab
웹 기반 코딩 협업 서비스 레포지토리입니다.

## Spec
Language : Java 17

Freamework : SpringBoot 3.2.1

Build : Gradle 8.5

Database : Maria DB

## 개요
다수의 사람들이 하나의 채팅방에 접속하고, 그 안에서 소스코드를 공동으로 편집하며 컴파일하고 결과를 볼 수 있는 웹 서비스입니다.

## 전체 구조
![structure](readme/system%20structure.png)

- Spring application : 사용자 등록 및 채팅방 개설 등의 로직을 처리하고, 그 결과를 Web page로 만들어 제공합니다.

- Message broker application : 사용자의 입력을 다른 사용자에게 전파하는 구독/게시 형식의 메시지 교환을 수행합니다.

- Compile module : 사용자가 컴파일 요청을 했을 시에 현재 채팅방에서 입력하여 저장된 Source code storage에서 소스코드를 컴파일하여 그 결과를 반환합니다.

- Source code storage : 사용자로부터 컴파일 요청이 오면 현재 채팅방에 입력된 소스코드에 대해 파일로 저장하는 공간입니다.

## 시스템 실행
Docker compose가 작성되어 있고, 이를 실행하는 쉘 스크립트가 작성되어 있으므로 프로젝트의 루트에서 다음과 같이 실행할 수 있습니다.

$ start.sh

p.s 만약 CRLF로 인하여 start.sh 파일이 실행되지 않는다면 아래와 같이 sed 명령을 사용하여 개행을 제거해주시기 바랍니다.

$ sed -i 's/\r//' start.sh