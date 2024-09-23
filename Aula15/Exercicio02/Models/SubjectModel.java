package Exercicio02.Models;

public class SubjectModel {
    private int Id;
    

    private String Name;


    public SubjectModel(int id, String name) {
        this.Id = id;
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }
}
