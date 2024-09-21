package dev.bedless.ezPrivateMessages.config;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CString extends Object {

    private String init;

    private CString(Object object) {
        this.init = object.toString();
    }

    /* fromObject()
     * @return New CString Object
     * @param Object object
     */
    public static CString fO(Object object) {
        return new CString(object);
    }

    /* fromString()
     * @return New CString Object
     * @param String object
     */
    public static CString fS(String object) {
        return fO(object);
    }

    public CString replace(String placeholder, Object content) {
        try {
            init = init.replace(placeholder, content.toString());
            return this;
        } catch (Exception ignored) {
            return this;
        }
    }

    public CString replaceIgnoreCase(String placeholder, Object content) {
        try {
            init = init.replaceAll("(?i)" + Pattern.quote(placeholder), Matcher.quoteReplacement(content.toString()));
            return this;
        } catch (Exception ignored) {
            return this;
        }
    }

    public CString replace(Placeholder placeholder, Object content) {
        return replace(placeholder.placeholder, content);
    }

    public CString replaceIgnoreCase(Placeholder placeholder, Object content) {
        return replaceIgnoreCase(placeholder.placeholder, content);
    }

    public CString replacePAPI(Player player) {
        if (player == null) return this;
        init = PlaceholderAPI.setPlaceholders(player, init);
        return this;
    }

    @Override
    public String toString() {
        return init;
    }

    /* toStringTranslated()
     * @return String with color codes translated
     */
    public String toStringT() {
        try {
            return ChatColor.translateAlternateColorCodes('&', init);
        } catch (Exception ignored) {
            return init;
        }
    }

    public CString translate() {
        init = ChatColor.translateAlternateColorCodes('&', init);
        return this;
    }

    public enum Placeholder {
        PREFIX("%prefix%"),
        RECEIVER("%receiver%"),
        SENDER("%sender%"),
        MESSAGE("%message%"),
        UNDEFINED("%any%");

        private String placeholder;

        Placeholder(String placeholder) {
            this.placeholder = placeholder;
        }

        public static Placeholder getPlaceholder(String placeholder) {
            for (Placeholder p : Placeholder.values()) {
                if (p.placeholder.equalsIgnoreCase(placeholder)) {
                    return p;
                }
            }
            return UNDEFINED;
        }
    }
}