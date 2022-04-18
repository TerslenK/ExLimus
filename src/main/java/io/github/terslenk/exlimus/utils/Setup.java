package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.items.VanillaItems;


public class Setup {
    public static void setup(ExLimus el) {
        Categories.setup(el);
        Items.setup(el);
        VanillaItems.setup(el);
    }
}
