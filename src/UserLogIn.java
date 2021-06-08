import java.util.ArrayList;

public class UserLogIn {
    public static ArrayList<UserDetails> users = new ArrayList<>();

    public static void main(String[] args) {

        fillUserData();
        userLogIn("Ganga","ga1234");
    }

    public static void fillUserData() {
        users.add(new UserDetails('1', "ganga", "jayakodi", "Ganga", "ga1234"));
        users.add(new UserDetails('2', "Tharanga", "Mahavila", "Tharanga", "th5678"));
        users.add(new UserDetails('3', "Kumudini", "", "Kumudini", "kumu1234"));
        users.add(new UserDetails('4', "kularathna", "Kariyawasam", "Kularathna", "ku1234"));
        users.add(new UserDetails('5', "Dewmi", "Gihansa", "Dewmi", "de1234"));
    }

    public static void userLogIn(String username, String password){

        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            System.out.println("Should pass the Username and password");
            return;
        }

        boolean isRegisteredUser = false;
        UserDetails loggedUser = null;

        for (UserDetails userDetails : users) {

            if(userDetails.userName.equals(username)){
                isRegisteredUser = true;

                if (userDetails.password.equals(password)){
                    System.out.println( "Hi"+' '+ capitalizeFirstLetter(userDetails.lastname)+", "+capitalizeFirstLetter(userDetails.firstName));
                    loggedUser = userDetails;
                    break;
                }
            }
        }

        if (isRegisteredUser == false){
            System.out.println("First sign up to the system");
        }

        if(isRegisteredUser == true && loggedUser == null){
            System.out.println("Your username or password is incorrect");
        }
    }

    public static String capitalizeFirstLetter(String name){

        if(name == null || name.isEmpty()){
            return null;
        }
        String firstLetter = name.substring(0,1).toUpperCase();
        name = firstLetter + name.substring(1);
        return name;
    }

    public static class UserDetails{
        public int id;
        public String firstName;
        public String lastname;
        public String userName;
        public String password;

        public UserDetails(int id, String firstName, String lastname, String userName, String password){
            this.id = id;
            this.firstName = firstName;
            this.lastname = lastname;
            this.userName = userName;
            this.password = password;
        }
    }
}
