## 마이크로 서비스 샘플 사이트(MicroService Sample Site)

이 프로젝트는 Spring Cloud Config 서버의 설정을 참조하여
Service Registry(Eureka Server) 와 Gateway(Spring Cloud Gateway) 의 조합으로 서비스들을 구성한 샘플 사이트입니다.

### Spring Cloud Config Server : *config project*
한 곳에서 전체 서버의 설정을 모두 담고 관리하는 서버입니다.
Git과 연결하여 사용할 수도 있고, Local Repository에 저장하여 관리할 수 있습니다.

### Spring Cloud Gateway : *gateway project*
Web Client의 직접적인 요청을 받아 Service Registry에 특정 서비스에 대한 처리를 요청합니다.
여러 이기종 Client 들로부터의 요청을 처리할 수 있습니다.
Gateway에서 Clent 에 대한 보안 설정, 권한 등을 체크하고 actuator를 이용해 Config Server에서 변경된 설정을 가져옵니다.

### Eureka Server(Service Registry) : *serviceregistry project*
Gateway에서 들어온 요청을 이미 등록되어 있는 클라이언트 서버 정보를 이용하여 요청을 처리하는 서버입니다.
EnableDiscoveryClient 어노테이션이 기입되고 인스턴스에 대한 설정이 잡혀있는 서버가 기동되면 
Eureka Server에서 해당 서비스를 주기적으로 살아있는지에 대한 정보를 확인하게 됩니다.
해당 서비스에 대한 요청이오면 서비스가 살아있는지 여부를 확인하여 요청을 처리하여 회신합니다.
Service Registry가 포함된 pattern의 경우, 
Client와 통신하는 Gateway에 서비스 내부에 대한 ip 정보를 가지고 있지 않아 보안에 유리합니다.

### Eureka Client(Service Server) : *book project, users project*

REST API 형식으로 구성된 Client 서버로서, Service 간, 혹은 Service Registry-Service 간에 요청을 받아 처리합니다.
Client 에는 EurekaDiscoveryClient 어노테이션이 필요하며, 
해당 서비스의 인스턴스 아이디와 Service Registry에 대한 서버 정보에 대한 설정이 필요합니다.
Client는 지속적오로 Eureka Server에 HeartBeat을 보내어 서비스가 사용가능한 상태임을 송신합니다.
만약 Client 서버가 정상종료되거나 설정된 주기 내에 Heartbeat을 보내지 않으면 Eureka Server는 해당 Client를 등록해제합니다.