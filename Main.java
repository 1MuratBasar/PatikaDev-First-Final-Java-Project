
/**
 * Java dilinde yazılmış olan bir mayın tarlası oyunudur.
 * Yazar: @muratbaşar
 * Kullanım: Repoyu git clone ile klonlayarak, IntelliJ IDE'sinde açabilirsiniz.
 *Sınıf ve Metot açıklamaları README.md dosyasında ilgili class larda numaralandırılarak belirtildiği şekilde açıklanmıştır.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
       // Step 1: Dışarıdan girilecek değerler ile matris boyutu belirlenmesi ve bunun 2*2 den az olmaması koşuluyla kontrol edilmesi.
        
        Scanner scan = new Scanner(System.in);
        int row=0, column=0;
        int exit=0;
        System.out.println("Mayın Tarlasına Hoşgeldiniz...");

        while (row < 2 || column < 2) {
            System.out.println("Lütfen oynamak istediğiniz satır ve sütun boyutlarını giriniz...");
            System.out.print("Satır sayısı : ");
            row = scan.nextInt();
            System.out.print("Sütun sayısı giriniz : ");
            column = scan.nextInt();
            System.out.println("===========================");
            if (row < 2 || column < 2)  {
                System.out.println("Boyutlar 2*2 den az olamaz. ");
                System.out.println ("Çıkış yapmak isterseniz 0 a basın.");
                System.out.println ("Devam etmek için 0 dan farklı bir rakama basın");
                exit = scan.nextInt();
                if (exit == 0) {
                    System.exit(2);
                }
            }

        }
        // Step 2: Step 1 tamamlandıktan sonra MineField ile MineSweeper nesnesi oluşturulması ve bu nesne ile run() metotunun  çağrılması ile oyun başlatılmıştır.
        MineField MineSpeewer = new MineField(row,column);
        MineSpeewer.run();

    }
}


