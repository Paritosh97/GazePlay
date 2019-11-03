package net.gazeplay.games.math101;

import net.gazeplay.GameCategories;
import net.gazeplay.GameSpec;
import net.gazeplay.GameSpecSource;
import net.gazeplay.GameSummary;

public class Math101SubstractionGameSpecSource implements GameSpecSource {
    @Override
    public GameSpec getGameSpec() {
        return new GameSpec(
            GameSummary.builder().nameCode("Math101: Substraction").gameThumbnail("data/Thumbnails/math101.png").category(GameCategories.Category.LOGIC).description("MathDescSub").build(),
            new Math101SubstractionGameVariantGenerator(), new MathGameLauncher(MathGameType.SUBTRACTIONPOS));
    }
}
