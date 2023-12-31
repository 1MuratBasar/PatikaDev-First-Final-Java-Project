# PatikaDev-First-Final-Java-Project
Text Based Mine Sweeper Project

Java Dilinde Yazılmış Terminal Üzerinden Oynanan bir Mayın Tarlası Oyunu
Java dilinde yazılmış, basit bir terminal oyunudur. Oyun, daha önceden yeri belirlenmiş olan mayın tarlasını oynamak üzerine kurulmuştur.

Kullanım
Repoyu "git clone" komutu ile yerel bilgisayarınıza klonlayın.
Kopyalanan repoyu IntelliJ IDE vasıtasıyla açın.
Main sınıfında kodu çalıştırarak oyunu oynayın.

Step by step işlem adımları;

Step 1: Dışarıdan girilecek değerler ile matris boyutu belirlenmesi ve bunun 2*2 den az olmaması koşuluyla kontrol edilmesi.
Step 2: Step 1 tamamlandıktan sonra MineField ile MineSweeper nesnesi oluşturulması ve bu nesne ile run() metotunun  çağrılması ile oyun başlatılmıştır.
Step 3: Tüm MineField class ta kullanabileceğim nitelikler tanımlandı.Ayrıca, dışarıdan veri almak, random sayı üretmek, string ve object işlemler için java kütüphaneleri çağrılmıştır.
Step 4: MineField constructor metotu, bu sınıf içirisinde kullanılacak değerleri dışarıdan alabilmek için oluşturuldu.
Step 5: run () metotu ile oyun başlatıldı. placingMines (Step 6) ve print(map) (Step 7) metotları sırayla çalıştırıldı. Baknz Step 5 ve Step 6. Bu metotlar ile haritaya mayınlar yerleştirildi ve tek seferlik program amacımız doğrultusunda ekranda gösterildi. isGame boolean mantıksal kontrolü ile while döngüsü içerisinde satır ve sütun değer girilmesi istendi. Girilecek değerlerin belirlenen matris boyutları içerisinde olması kontrolü yapıldı. aksi durum kontrolü sağlandı. şartların doğru şekilde oluşması durumunda mayınların veya ekranda tüm mayınları açılıp açılmama durumu sorgulandı. checkMines () (Step 8) metotu ile seçilen indisin sağ, sol, üst, alt ve çapraz kontolleri yapıldı. Ayrıca köşelere denk gelme durumu kontrolü yapıldı. Bknz Step 8. Aynı indisin tekrar seçilmesinin mayın sayısına ve açılan mayınlardan geri kalan sayısı etkilememesi için sayaç kontrolü yapıldı. Girilen değer mayın ise ya da tüm mayınlara basmadan oyun tamamlandı ise "Kazandınız/Kaybettiniz" kontrolü yapıldı.
Step 6: placingMines metotu ile while döngüsü içerisinde girilen dizi boyutlarının 1/4 oranında dışarıdan gelen satır ve sütun değerleri aralığında random olarak üretilen değerler randRow ve randCol değişkenlerine atandı. bu değişkenleri map matrisinde kontrol edilerek aynı yere tekrar mayın 
yerleştirilmemesinin kontrlü yapıldı.
Step 7: String dizilerde boş alanları default olarak null basıyor. map in isterleri doğrultusunda null değerler yerine "-" karakteri atandı. Çift döndü ile bu gerçekleştirildi. 
Step 8: Kulanıcının girdiği indis in etrafı kontol edildi. Eğer indis etrafında mayın var ise counter değeri kaç tane mayın var ise o kadar arttırıldı. Eğer yok ise sayaç 0 tutuldu. 
