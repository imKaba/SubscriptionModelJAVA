public enum TimerType{
    ONE_MONTH(1),
    THREE_MONTH(3),
    SIX_MONTH(6),
    ONE_YEAR(12);

    private final int month;
    TimerType(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

}