
import java.util.Scanner;
class Contact_Book{;
    public class Node{
        
        String name;
        String email;
        long phoneNumber;
        Node next;
         

    public Node(String name, Long phoneNumber, String email){
        this.name = name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.next=null;

    }
        
}

public Node head=null;
public Node tail=null;

public void Addnode(String name, long phoneNumber,String email){
    
    Node newNode = new Node(name, phoneNumber, email);
    // Make the new Node the head if head=null;

    if(head==null){
       head=newNode;
       tail=newNode;
    }
    else{
        tail.next=newNode;
        tail=newNode;
    }
    

}

public void deletenode(String nameTobeDleeted){
    if(head==null){
        System.out.println("The List is Empty");
        return;
    }
    if(head.name.equals(nameTobeDleeted)){//use equals method so that the entire string gets compared to the name
            head=head.next;

            System.out.println("\nThe following contact has been successfuly deleted: ");
            System.out.println("Name: "+head.name);
            System.out.println("Phone Number: " + head.phoneNumber);
            System.out.println("Email: " + head.email);
            return;//
    }
    Node prevNode=head;//previosus node
    Node CurrentSearchedName=head.next;//next to the previous node(or second node in each iteration)
    while(CurrentSearchedName!=null && !CurrentSearchedName.name.equals(nameTobeDleeted)){ 
        prevNode=CurrentSearchedName;
        //7
    //How it works example
    /*
     list=7 names
    3rd=4thname
    4thname=5th
    */
        CurrentSearchedName=CurrentSearchedName.next;
       

    }
    if(CurrentSearchedName==null){
        System.out.println("Name was not found");
        return;
    }
    System.out.println("The following contact has been sucessfully  deleted: ");
    System.out.println("Name: " + CurrentSearchedName.name);
    System.out.println("Phone Number: " + CurrentSearchedName.phoneNumber);
    System.out.println("Email: " + CurrentSearchedName.email);
    prevNode.next=CurrentSearchedName.next;
    /*
     3rd.next: 4th=5th
     List:
     3
     5
     */

    }
    public void SearchName(String searchedname){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.name.equals(searchedname)){
            System.out.println("The info of the contact you searched for: ");
            System.out.println("Name: "+head.name);
            System.out.println("Phone Number: " + head.phoneNumber);
            System.out.println("Email: " + head.email);
          
            return;
        }
        
        Node nameToSearch=head.next;
        while(nameToSearch!=null){
            if(nameToSearch.name.equals(searchedname)){
                System.out.println("The info of the contact you searched for: ");
                System.out.println("Name: "+nameToSearch.name);
                System.out.println("Phone Number : " + nameToSearch.phoneNumber);
                System.out.println("Email: " + nameToSearch.email);
                return;
            }
            nameToSearch=nameToSearch.next;
               
        }
        if(nameToSearch==null){
            System.out.println("Wrong input. Search again");
        }
    }
    public void searchEmail(String Specificemail){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        
        boolean emailfound = false;
        Node emailsearch=head;
        while(emailsearch!=null){
            if(emailsearch.email.equals(Specificemail)){
           
            System.out.println("The Email address You Searched For is : "+emailsearch.email);
            emailfound=true;
            break;
            }
            emailsearch=emailsearch.next;
        }
        if (!emailfound) {
        System.out.println("The email address you searched for is not found: it is either not in the list or has been deleted");

        }


    }
  




public void printlist(){//
    Node current=head;
     
    if(head==null){
        System.out.println("The list is empty");
        return;
    }
     System.out.println("\nThe Following Contact Information Has Been Saved: ");
     int i=0;
   while(current!=null){
    //print each node by incrementing pointer
    i=i+1;

    System.out.println("Contact: "+(i)+"\nName: "+current.name+"  Phone Number: "+current.phoneNumber+" "+"  Email Adress: "+current.email+" ");
    current=current.next;
   }

   }
   public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       Contact_Book newlist = new Contact_Book();
       
       
       while(true){
           System.out.println("*******************************************");
           System.out.println(
        "(A)dd More Contacts\n(S)earch name(including info associated with the name such as phone number and email)\n(D)elete name\n(Q)uit\n(P)print the list\n(E)Email Search");
           System.out.println("*******************************************");
           System.out.print("Enter a Command(A/P/D/Q/S/E): ");
           char option = scn.next().charAt(0);
           if(option!='A'&&option!='S'&&option != 'D'&&option != 'P'&&option != 'Q'&&option != 'E'){
            System.out.println("Wrong input. Please make sure the letter is uppercase");
           }
           if (option == 'S') {
               scn.nextLine();
               System.out.print("Enter the name you wanna to search: ");
               String nname = scn.nextLine();
               newlist.SearchName(nname);

           }
           if (option == 'D') {
               scn.nextLine();
               System.out.print("Enter the name you want to delete: ");
               String name = scn.nextLine();
               newlist.deletenode(name);

           }
           if (option == 'Q') {
               System.out.println("Thanks for using this program");
               System.exit(0);
           }
           if (option == 'P') {
               newlist.printlist();

           }
           if (option == 'E') {
               scn.nextLine();
               System.out.print("Type the email you want to search correctly: ");
               String Email = scn.nextLine();
               newlist.searchEmail(Email);
           }
           if(option=='A'){
               System.out.print("How many contacts do you want to create: ");
               int size = scn.nextInt();
               scn.nextLine(); // the leftover newline to be consumed so that the user gets prompted to enter a command

               for (int i = 1; i <= size; i++) {
                   System.out.println("Enter the contact info for Person: " + (i));
                   System.out.println("Enter name: ");

                   String name = scn.nextLine();
                   System.out.println("Enter Phone number: ");
                   Long phoneNumber = scn.nextLong();
                   scn.nextLine(); //
                   System.out.println("Enter email: ");
                   String email = scn.nextLine();
                   newlist.Addnode(name, phoneNumber, email);

               }

           }

       }

   }

}
      