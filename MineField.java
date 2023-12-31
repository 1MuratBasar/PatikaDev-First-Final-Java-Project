import java.util.Objects;
import java.util.Random;
import  java.util.Scanner;
import  java.lang.String;
public class MineField {
    
//Step 3: Tüm MineField class ta kullanabileceğim nitelikler tanımlandı. 
//        Ayrıca, dışarıdan veri almak, random sayı üretmek, string ve object işlemler için java kütüphaneleri çağrılmıştır.
    
    int rowNumber;
    int colNumber;
    int lengthOfArray;
    String [][] map;
    String [][] userInterface;
    boolean isGame = true;

    Scanner input = new Scanner(System.in);
    Random random = new Random();
    
   //Step 4: MineField constructor metotu, bu sınıf içirisinde kullanılacak değerleri dışarıdan alabilmek için oluşturuldu.
    
    MineField(int colNumber, int rowNumber) {

        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.map = new String[rowNumber][colNumber];
        this.userInterface = new String[rowNumber][colNumber];
        this.lengthOfArray = rowNumber * colNumber;

    }

    /* Step 5: run () metotu ile oyun başlatıldı. placingMines (Step 6) ve print(map) (Step 7) metotları sırayla çalıştırıldı. Baknz Step 5 ve Step 6.
            Bu metotlar ile haritaya mayınlar yerleştirildi ve tek seferlik program amacımız doğrultusunda ekranda gösterildi. 
            isGame boolean mantıksal kontrolü ile while döngüsü içerisinde satır ve sütun değer girilmesi istendi. Girilecek değerlerin belirlenen matris 
            boyutları içerisinde olması kontrolü yapıldı. aksi durum kontrolü sağlandı.
            şartların doğru şekilde oluşması durumunda mayınların veya ekranda tüm mayınları açılıp açılmama durumu sorgulandı.
            checkMines () (Step 8) metotu ile seçilen indisin sağ, sol, üst, alt ve çapraz kontolleri yapıldı. Ayrıca köşelere denk gelme durumu kontrolü yapıldı.
            Bknz Step 8
            Aynı indisin tekrar seçilmesinin mayın sayısına ve açılan mayınlardan geri kalan sayısı etkilememesi için sayaç kontrolü yapıldı. 
            girilen değer mayın ise ya da tüm mayınlara basmadan oyun tamamlandı ise "Kazandınız/Kaybettiniz" kontrolü yapıldı.
    */
    public void run () {

        int r1 , c1, control=0;

        placingMines ();
        print (map);
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");  
        while (isGame) {
        print(userInterface);
        System.out.print("Satır giriniz : ");
        r1 = input.nextInt();
        System.out.print("Sütun giriniz : ");
        c1 = input.nextInt();
        System.out.println("===========================");


         if ((r1 > rowNumber - 1 || c1 > colNumber - 1) || (r1 < 0 || c1 < 0)) {
         System.out.println("Belirtilen matris değerler içinde değer girmelisiniz");
         } else {

               if ((!Objects.equals(map[r1][c1], "*")) && (!Objects.equals(map[r1][c1], "-"))) {
                   if (!(Objects.equals(map[r1][c1], userInterface[r1][c1]))){

                   control--;
                   System.out.println("Daha önce aynı değeri girdiniz. tekrar deneyin");
               }}
               if (!Objects.equals(map[r1][c1], "*")) {
                   checkMines(r1, c1);
                   control++;
              if (control == (lengthOfArray - (lengthOfArray / 4))) {
              System.out.println("Oyunu Kazandınız !");
              print(userInterface);
              break;
              }
              } else {
                   isGame = false;
                   System.out.println("Game over !");
             }
           }
       }
    }

   /*Step 6: placingMines metotu ile while döngüsü içerisinde girilen dizi boyutlarının 1/4 oranında dışarıdan gelen satır ve sütun değerleri aralığında
            random olarak üretilen değerler randRow ve randCol değişkenlerine atandı. bu değişkenleri map matrisinde kontrol edilerek aynı yere tekrar mayın 
            yerleştirilmemesinin kontrlü yapıldı.
    */
    
    public void placingMines () {                    
    int randomRow, randColumn;                      
    int count = 0;
    while (count !=lengthOfArray/4) {

    randomRow = random.nextInt(rowNumber);  
    randColumn=random.nextInt(colNumber);
    if (!Objects.equals(map[randomRow][randColumn], "*")){ 
    map[randomRow][randColumn] = "*";
    count++;

    }
    }
    }

     /*Step 8: Kulanıcının girdiği indis in etrafı kontol edildi. Eğer indis etrafında mayın var ise counter değeri kaç tane mayın var ise o kadar 
             arttırıldı. eğer yok ise sayaç 0 tutuldu. 
    */          
     
    public void checkMines (int r, int c){
        int counter=0;
        if (map[r][c] == null){
            //sağ
            if ((c<colNumber-1) && (Objects.equals(map[r][c + 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            //alt
            if ((r < rowNumber-1) &&(Objects.equals(map[r + 1][c], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            //üst
            if ((r>0) && (Objects.equals(map[r - 1][c], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            //sol
            if ((c>0) && (Objects.equals(map[r][c - 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            //sol üst çapraz
            if ((c>0) && (r>0) && (Objects.equals(map[r-1][c - 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            //sol alt çapraz
            if ((c>0) && (r<rowNumber-1) && (Objects.equals(map[r+1][c - 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }//sag ust capraz
            if ((r>0) && (c<colNumber-1) && (Objects.equals(map[r-1][c + 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }//sag alt capraz
            if ((r<rowNumber-1) && (c<colNumber-1) && (Objects.equals(map[r+1][c + 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }

            if (userInterface[r][c] == null){
                counter = 0;
                userInterface[r][c] = Integer.toString(counter);
            }
            }
            }
    
 /*Step 7: String dizilerde boş alanları default olarak null basıyor. map in isterleri doğrultusunda null değerler yerine "-" karakteri atandı.
         çift döndü ile bu gerçekleştirildi. 
*/    
    public void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
