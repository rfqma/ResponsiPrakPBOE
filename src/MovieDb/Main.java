package MovieDb;

public class Main {
    public static void main(String[] args) {
        ViewReview vr = new ViewReview();
        ModelReview mr = new ModelReview();
        ControllerReview cr = new ControllerReview(mr, vr);
    }
}
