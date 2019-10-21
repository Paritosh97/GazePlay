package net.gazeplay.games.soundsoflife;

import net.gazeplay.GameCategories;
import net.gazeplay.GameSpec;
import net.gazeplay.GameSummary;
import net.gazeplay.gameslocator.GameSpecSource;

public class SavanaGameSpecSource implements GameSpecSource {
    @Override
    public GameSpec getGameSpec() {
        return new GameSpec(
            GameSummary.builder().nameCode("Savanna").gameThumbnail("data/Thumbnails/savana.png").category(GameCategories.Category.ACTION_REACTION).build(),
            new SavannaGameLauncher());
    }
}