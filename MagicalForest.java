import java.util.Arrays;
import java.util.List;

public class MagicalForest {

    public static void main(String[] args) {
        int mx=15, my=15;

        Kiddo kid = new Kiddo(4,6,mx,my,"N");
        kid.initializeForest();
        kid.displayForest();
        String commands = "LMMLMRRMML";

        for (char move: commands.toCharArray()) {
            kid.move(move);
        }
    }
}


class Direction{
    private  String currentDirection;
    private final List<String> directions = Arrays.asList("N", "NE", "E", "SE", "S", "SW", "W", "NW");

    public Direction(String direction){
        this.currentDirection = direction;
    }

    public String getDirection(){
        return this.currentDirection;
    }

    public void turnLeft(){
//        currentDirection = "NWSE".charAt(("NWSE".indexOf(currentDirection) + 3) % 4);
        int index = directions.indexOf(currentDirection);
        currentDirection = directions.get((index + directions.size() - 1) % directions.size());
    }

    public void turnRight(){
//        currentDirection = "NWSE".charAt(("NWSE".indexOf(currentDirection) + 1) % 4);
        int index = directions.indexOf(currentDirection);
        currentDirection = directions.get((index + directions.size() -1) % directions.size());
    }


}

class Kiddo{
    private int x, y, mx, my;
    private Direction direction;
    private char[][] forest;

    public Kiddo(int x, int y, int mx, int my, String direction){
        this.x = x;
        this.y = y;
        this.direction = new Direction(direction);
        this.forest = new char[mx][my];
        this.mx = mx;
        this.my = my;
    }

    public void initializeForest(){
        for (int i=0; i<mx; i++){
            for (int j=0; j<my; j++){
                this.forest[i][j] = '.';
            }
        }
        this.forest[x][y] = 'K';
    }

    public void displayForest(){
        for (int i=0; i<mx; i++){
            for (int j=0; j<my; j++){
                System.out.print(forest[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void move(char command){
        forest[x][y] = '.';

        if (command == 'L'){
            direction.turnLeft();
        }
        else if (command == 'R'){
            direction.turnRight();
        }
        else if (command == 'M'){
            switch (direction.getDirection()){
                case "N":
                    if (x>0) x--;
                    break;
                case "NE":
                    if (x>0 && y<my-1){
                        x--;  y++;
                    }
                case "E":
                    if (y<my-1) y++;
                    break;
                case "SE":
                    if (y<my-1 && x<mx-1){
                        x++; y++;
                    }
                    break;
                case "S":
                    if (x<mx-1) x++;
                    break;
                case "SW":
                    if (x<mx-1 && y>0){
                        x++; y--;
                    }
                case "W":
                    if (y>0) y--;
                    break;
                case "NW":
                    if (x>0 && y>0){
                        x--;  y--;
                    }
            }
        }
        forest[x][y] = 'K';

        System.out.printf("Kiddo Position: x->%d, y->%d, direction->%s%n", x, y, direction.getDirection());
    }
}