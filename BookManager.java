import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookManager {

    public void addBook(String title, String author, String isbn, int publishedYear, String genre, int copiesAvailable) {
        String query = "INSERT INTO Books (Title, Author, ISBN, PublishedYear, Genre, CopiesAvailable) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, isbn);
            preparedStatement.setInt(4, publishedYear);
            preparedStatement.setString(5, genre);
            preparedStatement.setInt(6, copiesAvailable);
            preparedStatement.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public void listBooks() {
        String query = "SELECT * FROM Books";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Book ID: " + resultSet.getInt("BookID") +
                        ", Title: " + resultSet.getString("Title") +
                        ", Author: " + resultSet.getString("Author") +
                        ", ISBN: " + resultSet.getString("ISBN") +
                        ", Published Year: " + resultSet.getInt("PublishedYear") +
                        ", Genre: " + resultSet.getString("Genre") +
                        ", Copies Available: " + resultSet.getInt("CopiesAvailable"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving books: " + e.getMessage());
        }
    }
}