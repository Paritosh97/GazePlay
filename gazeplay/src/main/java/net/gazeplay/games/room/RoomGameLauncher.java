package net.gazeplay.games.room;

import javafx.scene.Scene;
import net.gazeplay.GameContext;
import net.gazeplay.GameLifeCycle;
import net.gazeplay.GameSpec;
import net.gazeplay.commons.utils.stats.Stats;

public class RoomGameLauncher implements GameSpec.GameLauncher {

    @Override
    public Stats createNewStats(Scene scene) {
        return new RoomStats(scene);
    }

    @Override
    public GameLifeCycle createNewGame(GameContext gameContext, GameSpec.GameVariant gameVariant,
                                       Stats stats) {
        return new Room(gameContext, stats);
    }
}