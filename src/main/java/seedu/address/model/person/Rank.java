package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.List;

/**
 * Represents a Person's rank in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRank(String)}
 */
public class Rank {

    public static final String MESSAGE_CONSTRAINTS =
            "Rank should only be from the following list: REC, PTE, CPL, 3SG, 2LT and it should not be blank";
    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final List<String> VALID_RANKS = List.of("REC", "PTE", "CPL", "3SG", "2LT");

    public final String value;

    /**
     * Constructs a {@code Rank}.
     *
     * @param rank A valid rank.
     */
    public Rank(String rank) {
        requireNonNull(rank);
        checkArgument(isValidRank(rank), MESSAGE_CONSTRAINTS);
        value = rank;
    }

    /**
     * Returns true if a given string is a valid rank.
     */
    public static boolean isValidRank(String test) {
        return VALID_RANKS.contains(test);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.model.person.Rank // instanceof handles nulls
                && value.equals(((seedu.address.model.person.Rank) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
