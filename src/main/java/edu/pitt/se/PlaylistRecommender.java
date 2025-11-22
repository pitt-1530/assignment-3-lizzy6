package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.isEmpty()){
            return null;
        }
        int total = 0;
        for (int bpm : bpms) {
            total += bpm;
        }
        int average = total / bpms.size();
        if (average >= 140){
            return "HIGH";
        }
        else if (average >= 100){
            return "MEDIUM";
        }
        else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        for (char c : title.toCharArray()){
            if (!Character.isLetter(c) && c != ' '){
                return false;
            }
        }
        if (title.length() > 0 && title.length() <= 30){
            return true;
        }
        return false;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb < 0){
            return 0;
        }
        else if (volumeDb > 100){
            return 100;
        }
        else {
            return volumeDb;
        }
    }
}
