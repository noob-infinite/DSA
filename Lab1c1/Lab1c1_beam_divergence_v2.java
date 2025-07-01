package Lab1c1;

public class Lab1c1_beam_divergence_v2 {
    static void intervals(int n, int [] data) { 
        // sort then merge
        //evemathcomp
    }
    static int set_n_count(int n, int [] data) { 
        int deg[] = new int[360];
        int start_deg, end_deg;
        for (int i = 0; i < n; i+=2) {
            start_deg = data[i];
            end_deg = data[i+1];
            if (start_deg < end_deg) {
                for (int j = start_deg; j < end_deg; j++)
                    deg[j] = 1;
            } else {
                for (int j = start_deg; j < 360; j++)
                    deg[j] = 1;
                for (int j = 0; j < end_deg; j++) 
                    deg[j] = 1;
            }
        }
        int widest = 0;
        int cnt = 0;
        for (int i = 0; i < 719; i++) {
            if (deg[i % 360] == 1)
                cnt++;
            else   
                cnt = 0;
            widest = Math.max(widest,cnt);
        }
        widest = Math.min(360, widest);
        return widest;
    }
    static void demo_1() {
        int n = 3;
        int [] angles = {10,90,70,100,150,210}; 
        System.out.println(set_n_count(n, angles));
    }
    public static void main(String[] args) {
        
    }
}
