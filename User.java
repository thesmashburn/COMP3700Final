/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thesmashburn
 */
public class User {
    private String username;
    private String password;
    private String profilepic;
    private int usertype;
    private int userID;
    
    public User() {
        username = "";
        password = "";
        profilepic = "";
        usertype = 1;
        userID = -1;
    }
    
    public User(String userIn, String passIn, String profilepicIn, int usertypeIn) {
        username = userIn;
        password = passIn;
        profilepic = profilepicIn;
        usertype = usertypeIn;
    }
    
    public User(int idIN, String userIn, String passIn, String profilepicIn, int usertypeIn) {
        userID = idIN;
        username = userIn;
        password = passIn;
        profilepic = profilepicIn;
        usertype = usertypeIn;
    }
    
    public String getName() {
        return this.username;
    }
    
    public String getPassword() {
       return this.password;
    }
    
    public int getUserType() { return this.usertype;}
    public String getProfilePic() { return this.profilepic;}
    
    
    
    
}
