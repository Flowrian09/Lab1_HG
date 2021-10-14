import java.util.Scanner;


public class Lab1 {

    //methods
    //tis method selects the grades that are insufficient ( lower than 38 )
    public int[] nichtAusreichend(int [] array){
        int i = 0;
        int j = 0;
        int[] array2 = new int[array.length]; //the new array in which the insufficient grades are stored

        while (i < array.length) {

            if (array[i] >= 38){
                i++; //if a grade is above or equal to 38 we simply ignore it and move to the next one
            } else if (array[i] < 38){
                array2[j] = array[i]; // if a grade is below 38, we store it in the new array and move to the next one
                j++;
                i++;
            }
        }
        int[] RetArray = new int[j];

        for (i=0; i<j; i++){
            RetArray[i] = array2[i]; //we get rid of the empty spaces in array2 by moving everything in the RetArray (so that there are no 0 at the end)
        }
        return RetArray;
    }

    //this method calculates the average of grades
    public double average(int [] array){
        double avg = 0;

        for(int i = 0; i<array.length; i++){
            avg = avg + array[i]; //we add up every grade in the variable avg
        }
        avg = avg/ array.length; //we divide the sum of the grades to the number of grades to obtain the average

        return avg;
    }

    //this method rounds up the grades that are not insufficient and that need less than 3 points to be rounded up
    public int[] rounded (int [] array){
        int[] RoundArray = new int[array.length];

        for(int i=0; i < array.length; i++){
            int rest = array[i]%5; // we need to know in variable rest how much the grade needs to be rounded to the next multiple of 5
            if(rest != 0 && array[i] > 37 && 5 - rest < 3){ //if the grade needs to be rounded and is sufficient, we add 5 - rest to round it up
                RoundArray[i] = array[i] + 5 - rest;
            }else if (rest == 0 || array[i] < 38 || 5 - rest >= 3){ //if the grade either doesn't need to be rounded up (it already is a multiple of 5) or
                RoundArray[i] = array[i];                           //it is inufficient or it needs more than 3 point to be rounded up, it remains the same
            }
        }

        return RoundArray;
    }

    //this method returns the maximum value  (used to return max rounded grade)
    public int max (int [] array){
        int max = 0;
        Lab1 obj = new Lab1();
        int [] MaxRounded = obj.rounded(array);
        for(int i = 0; i < MaxRounded.length; i++){
            if (max < MaxRounded[i]){
                max = MaxRounded[i];
            }
        }
        return max;
    }


    //main--------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array that is to be created::");
        int size = sc.nextInt();
        int[] Noten = new int[size];
        System.out.println("Enter the elements of the array ::");

        for(int i=0; i<size; i++) {
            Noten[i] = sc.nextInt();
        }


        int option =5;
        Lab1 obj = new Lab1();

        while(option != 0) {

            System.out.println("Choose ::" +
                    "\n1 - Show the grades that are insufficient" +
                    "\n2 - Show  the average of the grades" +
                    "\n3 - Show the rounded grades" +
                    "\n4 - Show the maximum rounded grade\n" +
                    "\n0 - Exit");
            option = sc.nextInt();


            switch (option) {

                case 1:
                    System.out.println("Insufficient grades: ");
                    int[] Noten1 = obj.nichtAusreichend(Noten);

                    for (int i = 0; i < Noten1.length; i++) {
                        System.out.println(Noten1[i]);
                    }

                    break;

                case 2:
                    double avg = obj.average(Noten);
                    System.out.println("Average of grades: " + avg);
                    break;

                case 3:
                    int[] RoundedNoten = obj.rounded(Noten);
                    System.out.println("Rounded grades: ");
                    for (int i = 0; i < RoundedNoten.length; i++) {
                        System.out.println(RoundedNoten[i]);
                    }
                    break;

                case 4:

                    //int[] RoundedNotenMax = obj.rounded(Noten);
                    int max = obj.max(Noten);
                    System.out.println("Maximum of rounded grades: " + max);
                    break;

            }
        }


    }
}
