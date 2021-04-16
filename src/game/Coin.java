package game;

public enum Coin {
    HEAD,TAIL;


    @Override
    public String toString() {
        return String.valueOf(this.name().charAt(0));
    }

}
