package com.abhisheksingh.polymorphismchallenge;

public class Main {
    public static void main(String[] args) {

            Movie movie = randomMovie();
        System.out.println("Movie name ---> " + movie.getName() +"\n" +
                             "Plot of the movie ----> " + movie.plot() + "\n");
//Here how polymorphism works is that the method plot is one , but it has a lot nof different functionalities

    }

    public static Movie randomMovie(){
        int randomNumber = (int) (Math.random() * 5) + 1;
//        System.out.println("Random number is generated " + randomNumber );
        return switch (randomNumber) {
            case 1 -> new Jaws();
            case 2 -> new IndependenceDay();
            case 3 -> new MazeRunner();
            case 4 -> new StarWars();
            case 5 -> new Fractured();
            default -> null;
        };
    }
}

class Movie {
    private final String name ;

    public String getName() {
        return name;
    }

    public Movie(String name) {
        this.name = name;
    }

    public String plot(){
       return  "No plot here";
    }
}

class Jaws extends Movie{
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark eats humans";
    }
}

class IndependenceDay extends Movie{
    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "An alien attack to planet earth";
    }
}

class MazeRunner extends Movie{
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Some kids try to escape a maze";
    }
}
class StarWars extends Movie{
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial Forces try to take over the universe ";
    }
}
class Fractured extends Movie{
    public Fractured() {
        super("Fractured");
    }

    @Override
    public String plot() {
        return "A psychological thriller ";
    }
}

