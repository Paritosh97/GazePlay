package net.gazeplay.games.memory;

import net.gazeplay.GameCategories;
import net.gazeplay.GameSpec;
import net.gazeplay.GameSummary;
import net.gazeplay.gameslocator.GameSpecSource;

public class OpenMemoryGameSpecSource implements GameSpecSource {
    @Override
    public GameSpec getGameSpec() {
        return new GameSpec(new GameSummary("OpenMemory", "data/Thumbnails/openMemory.png",
            GameCategories.Category.ACTION_REACTION), new OpenMemoryGameVariantGenerator(), new OpenMemoryGameLauncher());
    }
}