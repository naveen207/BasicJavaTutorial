package com.naveen.basicjava;

import com.naveen.basicjava.Friend.Friend;
import com.naveen.basicjava.hobby.Hobby;


import java.io.*;
import java.util.ArrayList;

public class Main {

    //List of data to draw from hobby & friend
    ArrayList<Hobby> hobbies= new ArrayList<>();
    ArrayList<Friend> friends= new ArrayList<>();

    //Variables about myself

    String myName="Naveen";
    int myAge=30;
    Hobby[] myhobbies= new Hobby[2];
    Friend[] myfriends= new Friend[2];

    //Method to create data
    public void createData(){
        inputHobbies();
        inputFriends();
        myhobbies[0]= hobbies.get(2);
        myhobbies[1]=hobbies.get(0);
        myfriends[0]=friends.get(1);
        myfriends[1]=friends.get(0);
    }

    //method to create all hobbies
    private void inputHobbies() {
        hobbies.add(new Hobby("Football", " Ground"));
        hobbies.add(new Hobby("Swimming", "Community pool"));
        hobbies.add(new Hobby("cricket", "field"));
        hobbies.add(new Hobby("playing Piano", "house"));

    }
  //method to create all friends
    private void inputFriends() {
        Hobby[] yashHobbies= {hobbies.get(2)};
        friends.add(new Friend("Yash",29,yashHobbies));
        Hobby[] ratnHobbies= {hobbies.get(0)};
        friends.add(new Friend("Ratn", 31, ratnHobbies));
    }

    //Serialize data
    public void saveData(){
        //Massive Object to store all our objects
        ArrayList<Object> data= new ArrayList<Object>();
        data.add(myName);
        data.add(myAge);
        data.add(myhobbies);
        data.add(myfriends);
    //Alwayas do serialization in try & catch
        try{
            FileOutputStream fileOut= new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data.ser");
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    //Deserialize data
      public void loadData(){
        //create an arrayList to store deserialized objects
      ArrayList<Object> deser=  new ArrayList<Object>();
      try{
          FileInputStream fileIn= new FileInputStream("data.ser");
          ObjectInputStream in=new ObjectInputStream(fileIn);
          deser= (ArrayList<Object>) in.readObject();
          in.close();
          fileIn.close();
      }catch(IOException | ClassNotFoundException i){
          i.printStackTrace();
      }

      String retrivedName=(String)deser.get(0);
      int retrivedAge=(int)deser.get(1);

      Hobby[] retrivedHobbies=(Hobby[])deser.get(2);
      Friend[] retrivedfriends= (Friend[])deser.get(3);

      //Print everything to console
          System.out.println("My Name: "+retrivedName);
          System.out.println("My Age: "+retrivedAge);
          for(int i=0;i<retrivedHobbies.length;i++){
              System.out.println("Hobby: "+i +" "+ retrivedHobbies[i].getName()+" at "+ retrivedHobbies[i].getLocation());
          }
          for(int i=0;i<retrivedfriends.length;i++){
              System.out.println("My friend : "+retrivedfriends[i].getName()+" is of age : "+retrivedfriends[i].getAge());
              for(int j=0;j<retrivedfriends[i].getHobbies().length;j++){
                  System.out.println("My friend "+ retrivedfriends[i].getName()+" has hobbies: "+ retrivedfriends[i].getHobbies()[j].getName()+
                          " at : "+ retrivedfriends[i].getHobbies()[j].getLocation());
              }
          }
         // System.out.println("My Hobbies: "+retrivedHobbies);
         // System.out.println("My friends: "+retrivedfriends);

      }
}
