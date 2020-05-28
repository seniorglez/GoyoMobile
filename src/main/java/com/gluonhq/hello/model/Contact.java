package com.gluonhq.hello.model;



/**POJO that represents a contact of your contact list or an unknown user which is texting you.
 *
 */
public class Contact implements Comparable<Contact>{

    /**
     * A String which represents the name of the contact
     */
    private String name;

    /**
     * A String which represents the Telegram alias of the contact
     */
    private String alias;
    /**
     * A String which represents the phone of the contact.
     */
    private String phone;

    /**
     * A String which represents the Telegram bio of the contact.
     */
    private String bio;

    /**
     * A String which represents the name of the file of the contact picture.
     */
    private String avatar;

    /**
     * @param name A String which represents the name of the contact
     * @param alias A String which represents the Telegram alias of the contact
     * @param phone A String which represents the phone of the contact. Could be null.
     * @param bio A String which represents the Telegram bio of the contact.
     * @param avatar A String which represents the name of the file of the contact picture.
     */
    public Contact(String name, String alias, String phone, String bio, String avatar) {
        this.name = name;
        this.alias = alias;
        this.phone = phone;
        this.bio = bio;
        this.avatar = avatar;
    }


    /** Compares two Contacts throw comparing its name strings lexicographically, ignoring case differences.
     * @param o the Contact to be compared
     * @return a negative integer, zero, or a positive integer as the specified Contact name is greater than, equal to, or less than this Contact name, ignoring case considerations.
     */
    @Override
    public int compareTo(Contact o) {
            return this.name.compareToIgnoreCase(((Contact) o).getName());
    }

    @Override
    public String toString() {
        return getName();
    }

    //Getter && Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
