package net.gazeplay.stats;

import javafx.scene.Scene;
import net.gazeplay.commons.utils.games.DateUtils;
import net.gazeplay.commons.utils.games.Utils;
import net.gazeplay.commons.utils.stats.SavedStatsInfo;
import net.gazeplay.commons.utils.stats.Stats;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ShootGamesStats extends Stats {

    public ShootGamesStats(final Scene scene) {
        super(scene);
        setAccidentalShotPreventionPeriod(100);
    }

    @Override
    public SavedStatsInfo saveStats() throws IOException {
        super.saveStats();

        final File infoStatsFile = createInfoStatsFile();
        try (PrintWriter out = new PrintWriter(infoStatsFile, StandardCharsets.UTF_8)) {
            out.print("Date");
            out.print(',');
            out.print("Time");
            out.print(',');
            out.print("Total Time");
            out.print(',');
            out.print("Nb Goals");
            out.print(',');
            out.print("Length");
            out.print(',');
            out.print("Average Length");
            out.print(',');
            out.print("Standard Deviation");
            out.print(',');
            out.print("Uncounted Shots");
            out.print(',');
            for (int i = 0; i < getNbGoalsToReach(); i++) {
                out.print("shot ");
                out.print(i);
                out.print(",");
            }
            out.println();

            out.print(DateUtils.todayCSV());
            out.print(',');
            out.print(DateUtils.timeNow());
            out.print(',');
            out.print(computeTotalElapsedDuration());
            out.print(',');
            out.print(getNbGoalsToReach());
            out.print(',');
            out.print(getRoundsTotalAdditiveDuration());
            out.print(',');
            out.print(computeRoundsDurationAverageDuration());
            out.print(',');
            out.print(computeRoundsDurationStandardDeviation());
            out.print(',');
            out.print(getNbUnCountedGoalsReached());
            out.print(',');
            printLengthBetweenGoalsToString(out);
            out.println();

            out.flush();
        }
        return null;
    }

}
