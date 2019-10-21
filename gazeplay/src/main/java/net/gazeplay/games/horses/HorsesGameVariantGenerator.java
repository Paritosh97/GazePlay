package net.gazeplay.games.horses;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.gazeplay.GameSpec;

import java.util.Set;

public class HorsesGameVariantGenerator implements GameSpec.GameVariantGenerator {
    @Override
    public Set<GameSpec.GameVariant> getVariants() {
        return Sets.newLinkedHashSet(Lists.newArrayList(

            new GameSpec.IntGameVariant(2, "2 players"),
            new GameSpec.IntGameVariant(3, "3 players"), new GameSpec.IntGameVariant(4, "4 players")

        ));
    }
}