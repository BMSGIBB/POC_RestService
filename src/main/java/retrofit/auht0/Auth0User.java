package retrofit.auht0;

public class Auth0User {
    public String name;
    public String email;
    public String picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return String.format("USER: name -> %s, email -> %s, picture -> %s", name, email, picture);
    }
}
