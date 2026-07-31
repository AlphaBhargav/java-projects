import java.util.Scanner;

public class BGK {

    static int id[] = new int[100];
    static int amount[] = new int[100];
    static int totalIncome[] = new int[100];
    static String category[] = new String[100];
    static String description[] = new String[100];
    static int i = 0;

    static Scanner bgk = new Scanner(System.in);

    public static void main(String[] args) {

          System.out.println("===========================");
          System.out.println("BGK SMART EXPENSIVE TRACKER");
          System.out.println("===========================");

          System.out.print("1.addincome \n 2.viewincome \n 3.addexpense \n 4.viewbalance \n 5.deletetransaction \n 6.exit \n ");

          System.out.print("enter your choice:");
          int n = bgk.nextInt();

          switch(n)
          {
             case 1 : addincome();
                      break;
             case 2 : viewincome();
                      break;
             case 3 : addexpense();
                      break;
             case 4 : viewbalance();
                      break;
             case 5 : deletetransaction();
                      break;
             case 6 : exit();
                      break;

          }
    }

    static void addincome()
    {
        System.out.print("--------- ADD INCOME --------");

        System.out.print("\nenter transaction id :\n ");
        id[i] = bgk.nextInt();
        System.out.print("enter amount : \n");
        totalIncome[i] = bgk.nextInt();
        bgk.nextLine();
        System.out.print("enter category :\n ");
        category[i] = bgk.nextLine();
        System.out.print("enter description : ");
        description[i] = bgk.nextLine();
        System.out.print("Income Added Successfully\n");
        i++;

    }
    static void viewincome()
    {
        int j;
        if(i == 0)
        {
            System.out.println("No income records found.");
            return;
        }
       else
        {
        for(j=0;j<i;j++)
        {
         System.out.println("--------- VIEW INCOME --------");
         System.out.println("Transaction ID : \n" + id[j]);
         System.out.println("Amount : \n" + totalIncome[j]);
         System.out.println("Category : \n" + category[j]);
         System.out.println("Description : \n" + description[j]);
       }
     }
    }
    static void addexpense()
    {
        System.out.println("--------- ADD EXPENSE --------");

        System.out.print("enter transaction id : ");
        id[i] = bgk.nextInt();
        System.out.println("enter amount : ");
        amount[i] = bgk.nextInt();
        bgk.nextLine();
        System.out.println("enter category : ");
        category[i] = bgk.nextLine();
        System.out.println("enter description : ");
        description[i] = bgk.nextLine();

        System.out.print("Expense Added Successfully\n");
         i++;
    }

    static void viewbalance() {
        int income=0;
        int expense=0;

        System.out.println("--------- ACCOUNT BALANCE --------");
        int j;
        for (j = 0; j < i; j++) {
            income += totalIncome[j];
            expense += amount[j];
        }
       System.out.println("Total Income : " + income);
       System.out.println("Total Expense : " + expense);
       System.out.println("Balance : " + (income - expense));
    }
static void deletetransaction() {

    System.out.println("--------- DELETE TRANSACTION --------");
    System.out.print("Enter transaction ID: ");
    int id1 = bgk.nextInt();

    for (int j = 0; j < i; j++) {

        if (id[j] == id1) {

            for (int k = j; k < i - 1; k++) {
                id[k] = id[k + 1];
                amount[k] = amount[k + 1];
                totalIncome[k] = totalIncome[k + 1];
                category[k] = category[k + 1];
                description[k] = description[k + 1];
            }

            i--;
            System.out.println("Transaction Deleted Successfully");
            return;
        }
    }

    System.out.println("Transaction Not Found.");
}

static void exit() {
    System.out.println("Thanks for using BGK SMART EXPENSE TRACKER");
}
}



