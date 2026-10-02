# Kitap API

Spring Boot ve MySQL kullanılarak geliştirilmiş basit bir kitap yönetim API'sidir.

## Kullanılan Teknolojiler

* Java 17
* Spring Boot 4.1.1
* Gradle
* Spring Web
* Spring Data JPA
* MySQL
* Mockito ve JUnit

## Projenin Yapısı

Projede katmanlı bir yapı kullanılmıştır:

* `entity` → Veritabanı tablolarını temsil eder.
* `repository` → Veritabanı işlemlerini gerçekleştirir.
* `service` → Uygulamanın iş mantığını yönetir.
* `controller` → HTTP isteklerini karşılar.

## Kurulum

### 1. Projeyi GitHub'dan indirin

Projeyi bilgisayarınıza klonlayın ve IntelliJ IDEA ile açın.

### 2. MySQL veritabanını oluşturun

MySQL veya DBeaver üzerinden aşağıdaki veritabanını oluşturun:

```sql
CREATE DATABASE kitap_apii;
```

### 3. Veritabanı şifresini ayarlayın

`application.properties` dosyasında veritabanı şifresi doğrudan yazılmak yerine `DB_PASSWORD` ortam değişkeninden alınır.

Örneğin IntelliJ IDEA'da çalıştırma ayarlarına `DB_PASSWORD` adında bir environment variable eklenebilir.

### 4. Uygulamayı çalıştırın

`KitapApiiApplication.java` dosyasını çalıştırın.

Uygulama varsayılan olarak:

```text
http://localhost:8080
```

adresinde çalışır.

## API Kullanımı

### Tüm kitapları listeleme

**GET**

```text
http://localhost:8080/books
```

### Kitap ekleme

**POST**

```text
http://localhost:8080/books
```

Body → raw → JSON:

```json
{
  "name": "Simyacı",
  "price": 150
}
```

### ID ile kitap getirme

**GET**

```text
http://localhost:8080/books/1
```

### Kitap silme

**DELETE**

```text
http://localhost:8080/books/1
```

## Testler

`BookServiceTest` içerisinde iki temel senaryo test edilmiştir:

* Kitap eklemenin başarılı olması
* Repository tarafında hata oluşması

Testler IntelliJ IDEA üzerinden `BookServiceTest` çalıştırılarak kontrol edilebilir.

Beklenen sonuç:

```text
BUILD SUCCESSFUL
```

## Bilinçli Tercihler

Projede controller, service ve repository katmanları birbirinden ayrılmıştır.

`BookRepository`, `JpaRepository` kullanılarak temel veritabanı işlemlerinin daha az kodla yapılmasını sağlar.

Kitap ekleme ve hata senaryolarının kontrolü için Mockito kullanılmıştır.

Veritabanı parolasının kaynak kodda açık şekilde tutulmaması için `DB_PASSWORD` ortam değişkeni kullanılmıştır.

## 5 Dakikalık Demo Akışı

1. Projenin katmanlı yapısını göster.
2. `Book` entity sınıfını göster.
3. `BookService` ve `BookController` arasındaki akışı açıkla.
4. Uygulamayı çalıştır ve MySQL bağlantısının kurulduğunu göster.
5. Postman ile kitap ekleme isteği gönder.
6. Kitabı GET isteği ile listele.
7. `BookServiceTest` çalıştır ve `BUILD SUCCESSFUL` sonucunu göster.

## Proje Akışı

İstek geldiğinde akış genel olarak şöyledir:

```text
Postman
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL
```
