import java.util.Scanner;

public class MovieSolution {
    public static void main(String[] args) {
        Movie[] movie = new Movie[4];
        String search;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < movie.length; i++) {
            String movieName = sc.nextLine();
            String producingCompany = sc.nextLine();
            String genre = sc.nextLine();
            int budget = sc.nextInt();
            sc.nextLine();

            movie[i] = new Movie(movieName, producingCompany, genre, budget);
        }

        search = sc.nextLine();
        sc.close();

        Movie[] newMovie = budgetForGivenMovie(movie, search);

        for (int i = 0; i < newMovie.length; i++) {
            if (newMovie[i].getBudget() > 80000000) {
                System.out.println("High Budget Movie");
            } else {
                System.out.println("Low budget movie");
            }
        }
    }

    private static Movie[] budgetForGivenMovie(Movie[] t, String genre) {
        int c = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i].getGenre().equals(genre)) {
                c++; // only count total searches genre
            }
        }

        int b = 0;
        Movie[] m = new Movie[c];
        for (int i = 0; i < t.length; i++) {
            if (t[i].getGenre().equals(genre)) {
                m[b] = t[i];
                b++;
            }
        }
        return m;

    }

}

/* ______________________________________________________________ */

class Movie {
    private String movieName;
    private String prducingCompany;
    private String genre;
    private int budget;

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getProducingCompany() {
        return this.prducingCompany;
    }

    public void setProducingCompany(String producingCompany) {
        this.prducingCompany = producingCompany;
    }

    // genre
    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // budget
    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    // Constructor
    public Movie(String movieName, String producingCompany, String genre, int budget) {
        super();
        this.movieName = movieName;
        this.prducingCompany = producingCompany;
        this.genre = genre;
        this.budget = budget;
    }
}
