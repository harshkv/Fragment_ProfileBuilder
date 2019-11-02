package com.example.fragment_profilebuilder;

public class Profile {
    String fname,lname, studentid, rbvalue, flag;
    int imageid;

    @Override
    public String toString() {
        return "Profile{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", studentid='" + studentid + '\'' +
                ", rbvalue='" + rbvalue + '\'' +
                ", flag='" + flag + '\'' +
                ", imageid=" + imageid +
                '}';
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public Profile() {

    }

    public String getFname() {
        return fname;
    }



    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getRbvalue() {
        return rbvalue;
    }

    public void setRbvalue(String rbvalue) {
        this.rbvalue = rbvalue;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


}
