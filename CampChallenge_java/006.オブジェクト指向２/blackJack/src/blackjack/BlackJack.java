/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Y.Sasa
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Dealer,Userインスタンスの生成
        Dealer d=new Dealer();
        User u=new User();
        //各手札に２枚追加
        d.setCard(d.deal());
        u.setCard(d.deal());
        //userの絵柄とエースをチェック、処理
        u.checkSuit();
        u.checkAce();
        //userがさらに引くかどうか
        while(u.checkSum()){
            u.setCard(d.hit());
        }
        //dealerの絵柄とエースをチェック、処理
        d.checkSuit();
        d.checkAce();
        //dealerがさらに引くかどうか
        while(d.checkSum()){
            d.setCard(d.hit());
        }
        //open(点数の確定～勝敗の判定)
        if(d.checkBust()&&u.checkBust()){
            System.out.println("ディーラー"+d.open()+"点");
            System.out.println("プレイヤー"+u.open()+"点");
            System.out.println("両者バスト、プレイヤーは敗北！");
        }else if(u.checkBust()){
            System.out.println("ディーラー"+d.open()+"点");
            System.out.println("プレイヤー"+u.open()+"点");
            System.out.println("プレイヤーはバスト、敗北！");
        }else if(d.checkBust()){
            System.out.println("ディーラー"+d.open()+"点");
            System.out.println("プレイヤー"+u.open()+"点");
            System.out.println("ディーラーはバスト、プレイヤーは勝利！");
        }else if(u.open()<d.open()){
            System.out.println("ディーラー"+d.open()+"点");
            System.out.println("プレイヤー"+u.open()+"点");
            System.out.println("プレイヤーは敗北！");
        }else if(u.open()>d.open()){
            System.out.println("ディーラー"+d.open()+"点");
            System.out.println("プレイヤー"+u.open()+"点");
            System.out.println("プレイヤーは勝利！");
        }else{
            System.out.println("ディーラー"+d.open()+"点");
            System.out.println("プレイヤー"+u.open()+"点");
            System.out.println("引き分け！！");
        }
    }
}