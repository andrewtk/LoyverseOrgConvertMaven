import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarStyle;

public class createSlug {

    public static void main(String[] arg) throws Exception {
        String anim = "|/-\\";
        for (int x = 0; x < 5; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(100);
        }
        //ProgressBar pb = new ProgressBar("Test", 100); // name, initial max
        ProgressBar pb = new ProgressBar("Test", 1000, ProgressBarStyle.ASCII);// if you want ASCII output style
        pb.start(); // the progress bar starts timing
        // Or you could combine these two lines like this:
//   ProgressBar pb = new ProgressBar("Test", 100).start();
        for (int x = 0; x < 1000; x++) {

            pb.step(); // step by 1
            pb.stepBy(2); // step by n
            int r= 100* x;
            r+=50;

            //pb.stepTo(x); // step directly to n

            pb.maxHint(10000);
            // reset the max of this progress bar as n. This may be useful when the program
            // gets new information about the current progress.
            // Can set n to be less than zero: this means that this progress bar would become
            // indefinite: the max would be unknown.

            pb.setExtraMessage("Reading..."); // Set extra message to display at the end of the bar
        }
        pb.stop(); // stops the progress bar


    }
}


