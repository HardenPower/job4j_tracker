package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0D;
        int amount = 0;
        for (Pupil out : pupils) {
            for (Subject subj : out.subjects()) {
             sum += subj.score();
             amount++;
            }
        }
        return sum / amount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        for (Pupil out : pupils) {
            double sum = 0D;
            int count = 0;
            for (Subject subj : out.subjects()) {
                sum += subj.score();
                count++;
            }
            labelList.add(new Label(out.name(), sum / count));
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil out : pupils) {
            for (Subject subj : out.subjects()) {
                map.merge(subj.name(), subj.score(), Integer::sum);
            }
        }
        map.forEach((key, value) -> labelList.add(new Label(key, (double) value / pupils.size())));
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        for (Pupil out : pupils) {
            double sum = 0D;
            for (Subject subj : out.subjects()) {
                sum += subj.score();
            }
            labelList.add(new Label(out.name(), sum));
        }
        labelList.sort(Comparator.naturalOrder());
        Label label = labelList.get(labelList.size() - 1);
        return new Label(label.name(), label.score());
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil out : pupils) {
            for (Subject subj : out.subjects()) {
                map.merge(subj.name(), subj.score(), Integer::sum);
            }
        }
        map.forEach((key, value) -> labelList.add(new Label(key, value)));
        labelList.sort(Comparator.naturalOrder());
        Label label = labelList.get(labelList.size() - 1);
        return new Label(label.name(), label.score());
    }
}