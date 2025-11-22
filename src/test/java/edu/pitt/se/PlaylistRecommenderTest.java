package edu.pitt.se;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    @Test
    public void testClassify() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String result = PlaylistRecommender.classifyEnergy(list);
        assertNull(result);
        
        list.add(80);
        list.add(92);
        list.add(110);
        result = PlaylistRecommender.classifyEnergy(list);
        assertEquals("LOW", result);
        
        list.add(200);
        result = PlaylistRecommender.classifyEnergy(list);
        assertEquals("MEDIUM", result);
        
        list.add(150);
        list.add(180);
        list.add(175);
        result = PlaylistRecommender.classifyEnergy(list);
        assertEquals("HIGH", result);
    }

    @Test
    public void testValidTitle() {
        String s = "";
        boolean result = PlaylistRecommender.isValidTrackTitle(s);
        assertFalse(result);

        s = "This is a valid title";
        result = PlaylistRecommender.isValidTrackTitle(s);
        assertTrue(result);

        s = "This is not valid!";
        result = PlaylistRecommender.isValidTrackTitle(s);
        assertFalse(result);

        s = "This title is tooooooooooo long";
        result = PlaylistRecommender.isValidTrackTitle(s);
        assertFalse(result);
    }

    @Test
    public void testNormalize() {
        int result = PlaylistRecommender.normalizeVolume(-12);
        assertEquals(0, result);

        result = PlaylistRecommender.normalizeVolume(52);
        assertEquals(52, result);

        result = PlaylistRecommender.normalizeVolume(235);
        assertEquals(100, result);
    }
}
