com.zeabay.themovie
├── audit // Veri izleme ve denetim yapıları ------------------------------ // **Projede yok**
├── client ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Dış istemciler (frontend entegrasyonu vs.) OLMAYACAK clientler ayrı projelerde olacak
├── common ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Ortak yapılar // EKLENDİ
│   ├── core ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Temel sınıflar
│   │   ├── BaseController ++++++++++++++++++++++++++++++++++++++++++++++++ // Tüm controller'lar için temel özellikler
│   │   ├── BaseDTO +++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Tüm DTO'lar için ortak özellikler
│   │   ├── BaseEntity ++++++++++++++++++++++++++++++++++++++++++++++++++++ // Ortak JPA entity özellikleri
│   │   ├── BaseRepository ++++++++++++++++++++++++++++++++++++++++++++++++ // Ortak repository özellikleri
│   │   └── BaseService +++++++++++++++++++++++++++++++++++++++++++++++++++ // Ortak servis iş mantığı
│   ├── enums +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Enum sınıfları
│   ├── exception +++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Ortak istisnalar
│   ├── mapper ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Dönüştürücüler
│   └── util ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Yardımcı metotlar
├── configuration +++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Spring yapılandırma dosyaları
│   └── AOPConfig +++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // AOP'nin etkinleştirildiği yapılandırma dosyası
├── integration // Dış sistem entegrasyonu (API, Kafka vs.)
├── logging +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Loglama konfigürasyonları
│   ├── aspect ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // AOP ile ilgili aspect sınıfları
│   │   ├── LoggingAspect +++++++++++++++++++++++++++++++++++++++++++++++++ // Loglama işlemleri
│   │   └── SecurityAspect // Güvenlik ile ilgili işlemler
│   └── log4j // Manuel loglama yapıları (log4j, logback) ----------------- // **Projede yok**
├── message // Bildirim ve mesajlaşma ------------------------------------- // **Projede yok**
├── migration // Veritabanı migrasyonları --------------------------------- // **Projede yok**
├── modules +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Modül bazlı yapı
│   ├── film ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Örnek modül
│   ├── controller ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Film ile ilgili controller sınıfları
│   ├── dto +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Film ile ilgili DTO sınıfları
│   ├── entity ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Film ile ilgili Entity sınıfları
│   ├── exception +++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Film ile ilgili özel istisnalar
│   ├── mapper ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Film ile ilgili dönüştürücüler
│   ├── repository ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Film ile ilgili repository sınıfları
│   └── service +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ // Film ile ilgili servis sınıfları
├── security // Güvenlik yapıları
├── swagger // API dökümantasyonu (Swagger/OpenAPI)
└── test // Test sınıfları ------------------------------------------------ // **Projede yok**

TODO
//TODO
// TODO

SecurityAspect ???
Loglama kaydı ve izleme (elastic search, kibana, logstash) vs. yapılacak