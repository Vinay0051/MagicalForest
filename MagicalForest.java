public class MagicalForest {

    public static void main(String[] args) {
        int mx=15, my=15;

        Kiddo kid = new Kiddo(4,6,mx,my,'N');
        kid.initializeForest();
        kid.displayForest();
        String commands = "LMMLMRRMML";

        for (char move: commands.toCharArray()) {
            kid.move(move);
        }
    }
}


class Direction{
    private  char currentDirection;

    public Direction(char direction){
        this.currentDirection = direction;
    }

    public char getDirection(){
        return this.currentDirection;
    }

    public void turnLeft(){
        currentDirection = "NWSE".charAt(("NWSE".indexOf(currentDirection) + 3) % 4);
    }

    public void turnRight(){
        currentDirection = "NWSE".charAt(("NWSE".indexOf(currentDirection) + 1) % 4);
    }

}

class Kiddo{
    private int x, y, mx, my;
    private Direction direction;
    private char[][] forest;

    public Kiddo(int x, int y, int mx, int my, char direction){
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
                case 'N':
                    x--;
                    break;
                case 'S':
                    x++;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
            }
        }
        forest[x][y] = 'K';

        System.out.println(String.format("Kiddo Position: x->%d, y->%d, direction->%s", x, y, direction.getDirection()));
    }
}