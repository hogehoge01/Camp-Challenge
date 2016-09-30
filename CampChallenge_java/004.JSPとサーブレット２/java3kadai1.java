package org.mypackage.sample;

class Main {
  public static void main(String[] args) {
      for(int i=1;i<=10;i++){
          inputProfile("Y.Sasa","19930701","hello");
      }
  }
      public static void inputProfile(String inputName,String inputBirth,String inputIntroduction){
          System.out.println(inputName);
          System.out.println(inputBirth);
          System.out.println(inputIntroduction);
      }
}