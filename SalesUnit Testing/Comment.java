
/**
 * Write a description of class Comment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Comment {
    private String author;
    private String text;
    private int rating; // rating between 1 and 5
    private int upvotes;
    private int downvotes;

    /**
     * Constructor to create a new comment.
     */
    public Comment(String author, String text, int rating) {
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.upvotes = 0; // initially 0 upvotes
        this.downvotes = 0; // initially 0 downvotes
    }

    /**
     * Return the author of the comment.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Return the full text of the comment.
     */
    public String getText() {
        return text;
    }

    /**
     * Return the rating of the comment.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Return the upvote count for this comment.
     */
    public int getUpvotes() {
        return upvotes;
    }

    /**
     * Return the downvote count for this comment.
     */
    public int getDownvotes() {
        return downvotes;
    }

    /**
     * Return the total vote count (upvotes - downvotes).
     */
    public int getVoteCount() {
        return upvotes - downvotes;
    }

    /**
     * Increment the upvote count by 1.
     */
    public void upvote() {
        upvotes++;
    }

    /**
     * Increment the downvote count by 1.
     */
    public void downvote() {
        downvotes++;
    }

    /**
     * Return the full details of the comment as a string.
     * This includes the author, rating, text, upvotes, and downvotes.
     */
    public String getFullDetails() {
        return "Author: " + author + "\n" +
               "Rating: " + rating + "\n" +
               "Comment: " + text + "\n" +
               "Upvotes: " + upvotes + "  Downvotes: " + downvotes;
    }
}