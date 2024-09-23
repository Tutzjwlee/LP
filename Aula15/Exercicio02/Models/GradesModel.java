package Exercicio02.Models;

public class GradesModel {
    private int usernameID;
    private int subjectID;
    private float p1;
    private float p2;
    private float t1;
    private float t2;
    private float p3;
    private float p4;
    private float t3;
    private float t4;
    
    public GradesModel(int usernameID, int subjectID, float p1, float p2, float t1, float t2, float p3, float p4,
    float t3, float t4) {
        this.usernameID = usernameID;
        this.subjectID = subjectID;
        this.p1 = p1;
        this.p2 = p2;
        this.t1 = t1;
        this.t2 = t2;
        this.p3 = p3;
        this.p4 = p4;
        this.t3 = t3;
        this.t4 = t4;
    }
    
    public int getUsernameID() {
        return usernameID;
    }
    public int getSubjectID() {
        return subjectID;
    }
    public float getP1() {
        return p1;
    }
    
    public float getP2() {
        return p2;
    }
    
    public float getT1() {
        return t1;
    }
    
    public float getT2() {
        return t2;
    }
    
    public float getP3() {
        return p3;
    }
    
    public float getP4() {
        return p4;
    }
    
    public float getT3() {
        return t3;
    }
    
    public float getT4() {
        return t4;
    }
    
    
}
