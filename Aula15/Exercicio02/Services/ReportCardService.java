package Exercicio02.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Exercicio02.Models.SubjectModel;
import Exercicio02.Repositories.GradesRepository;
import Exercicio02.Repositories.SubjectsRepository;

public class ReportCardService {
    public GradesRepository gradesRepository = new GradesRepository();
    public SubjectsRepository subjectsRepository = new SubjectsRepository();

    public Map<Integer, String> subjectsMap = new HashMap<Integer, String>();

    public void setupCardReport() {
        ArrayList<SubjectModel> subjects = subjectsRepository.GetAllSubjects();

        for (SubjectModel subjectModel : subjects) {
            subjectsMap.put(subjectModel.getId(), subjectModel.getName());
        }
    }

}
