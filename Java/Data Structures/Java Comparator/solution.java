//Solution
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int result = o2.score - o1.score;
        if (result == 0) {
            // if score is same comaring names
            return o1.name.compareTo(o2.name);
        }
        else {
            return result;
        }
    } 
}
