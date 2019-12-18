package net.gazeplay.games.blocs2;

import net.gazeplay.GameCategories;
import net.gazeplay.GameSpec;
import net.gazeplay.GameSpecSource;
import net.gazeplay.GameSummary;
import net.gazeplay.commons.gamevariants.SquareDimensionVariantGenerator;

public class Blocs2GameSpecSource implements GameSpecSource {
    @Override
    public GameSpec getGameSpec() {
        return new GameSpec(
            GameSummary.builder().nameCode("Blocks2").gameThumbnail("data/Thumbnails/block.png").category(GameCategories.Category.ACTION_REACTION).build(),
            new SquareDimensionVariantGenerator(2, 9), new Blocs2GameLauncher());
    }
}
