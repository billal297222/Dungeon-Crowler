
class StopMenu {
     boolean stoped;

    public StopMenu() {
        stoped = false;
    }
    public boolean isStoped() {
        return stoped;
    }
    public void stop() {
        stoped = !stoped;
    }
}
