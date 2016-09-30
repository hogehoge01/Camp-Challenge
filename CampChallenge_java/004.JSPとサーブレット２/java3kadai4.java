package org.mypackage.sample;

class Main {
  public static void main(String[] args) {
      for(int i=1;i<=10;i++){
          inputProfile("Y.Sasa","19930701","hello");
      }
      if(inputProfile("Y.Sasa","19930701","hello")){
          System.out.println("この処理は正しく実行されました");
      }else{
          System.out.println("正しく実行できませんでした");
      }
  }
      public static boolean inputProfile(String inputName,String inputBirth,String inputIntroduction){
          System.out.println(inputName);
          System.out.println(inputBirth);
          System.out.println(inputIntroduction);
          return true;
      }
}