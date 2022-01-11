public class Main {
    public static void main(String[] args) {
        int vasyaAge = 14;
        int katyaAge = 14;
        int mishaAge = 14;

        int min = -1;
        int middle = -1;
        int max = -1;

        if (vasyaAge > katyaAge && vasyaAge > mishaAge) {
            max = vasyaAge;
            if (katyaAge > mishaAge) {
                middle = katyaAge;
                min = mishaAge;
            } else {
                middle = mishaAge;
                min = katyaAge;
            }
        } else if (vasyaAge < katyaAge && vasyaAge < mishaAge) {
            min = vasyaAge;
            if (katyaAge > mishaAge) {
                max = katyaAge;
                middle = mishaAge;
            } else {
                max = mishaAge;
                middle = katyaAge;
            }
        } else {
            middle = vasyaAge;
            if (katyaAge > mishaAge) {
                max = katyaAge;
                min = mishaAge;
            } else {
                max = mishaAge;
                min = katyaAge;
            }
        }

        System.out.println("Maximum: " + max + "\nMiddle: " + middle +
                "\nMinimum: " + min);
    }
}
