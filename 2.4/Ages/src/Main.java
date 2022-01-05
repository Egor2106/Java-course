public class Main {
    public static void main(String[] args) {
        int vasyaAge = 14;
        int katyaAge = 14;
        int mishaAge = 14;

        int min = -1;
        int middle = -1;
        int max = -1;

        if (vasyaAge != katyaAge && vasyaAge != mishaAge && katyaAge != mishaAge) {

            if (vasyaAge > katyaAge && vasyaAge > mishaAge)
                max = vasyaAge;
            else if ((vasyaAge > katyaAge && vasyaAge < mishaAge) || (vasyaAge < katyaAge && vasyaAge > mishaAge))
                middle = vasyaAge;
            else
                min = vasyaAge;

            if (katyaAge > vasyaAge && katyaAge > mishaAge)
                max = katyaAge;
            else if ((katyaAge > vasyaAge && katyaAge < mishaAge) || (katyaAge < vasyaAge && katyaAge > mishaAge))
                middle = katyaAge;
            else
                min = katyaAge;

            if (mishaAge > katyaAge && mishaAge > vasyaAge)
                max = mishaAge;
            else if ((mishaAge > katyaAge && mishaAge < vasyaAge) || (mishaAge < katyaAge && mishaAge > vasyaAge))
                middle = mishaAge;
            else
                min = mishaAge;
        } else {
            if (vasyaAge == katyaAge && vasyaAge > mishaAge) {
                min = mishaAge;
                middle = vasyaAge;
                max = katyaAge;
            } else if (vasyaAge == katyaAge && vasyaAge < mishaAge){
                min = vasyaAge;
                middle = katyaAge;
                max = mishaAge;
            } else if (vasyaAge == mishaAge && vasyaAge > katyaAge) {
                min = katyaAge;
                middle = vasyaAge;
                max = mishaAge;
            } else if (vasyaAge == mishaAge && vasyaAge < katyaAge){
                min = vasyaAge;
                middle = mishaAge;
                max = katyaAge;
            } else if (mishaAge == katyaAge && vasyaAge > mishaAge) {
                min = mishaAge;
                middle = katyaAge;
                max = vasyaAge;
            } else if (mishaAge == katyaAge && vasyaAge < mishaAge) {
                min = vasyaAge;
                middle = katyaAge;
                max = mishaAge;
            } else if (mishaAge == katyaAge && vasyaAge == mishaAge) {
                min = vasyaAge;
                middle = katyaAge;
                max = mishaAge;
            }
        }

        System.out.println("Minimal age: " + min + "\nMiddle age: " +
                middle + "\nMaximum age: " + max);
    }
}
