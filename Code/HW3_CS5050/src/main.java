/**
 * Created by saratkiran on 2/21/14.
 */
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
public class main {

    public static void main(String[] args) {
        for(int l =0;l<32;l++){ // Number of trails

        long startTime = System.nanoTime();    //Start the timer

        int length = 32;
        double[] p = new double[length];  // P polynomial co- efficients
        double[] q = new double[length];    // Q polynomial co- efficients

        //random double numbers generation
        random(p,-1.0,1.0,length);
        random(q,-1.0,1.0,length);


        int length_p;
        int length_q = q.length;
        length_p = p.length;

        //------------------- Uncomment this section for School book solution ----------------------------
        System.out.println("School book output:");
        double[] solution = school_book(p,q,length_p,length_q);
        System.out.println(Arrays.toString(solution));
        //------------------------------------------------------------------------------------------------

        //------------------- Uncomment this section for Three sub problem   recursive solution ----------
        System.out.println("four solution: ");
        double [] solution_re4 = four_recursive(p, q, length);
        System.out.println(Arrays.toString(solution_re4));
        //------------------------------------------------------------------------------------------------

        // ------------------- Uncomment this section for Four sub problem  recursive solution -------------
        System.out.println("three solution: ");
        double [] solution_re3 = three_recursive(p, q, length);
        System.out.println(Arrays.toString(solution_re3));
        //------------------------------------------------------------------------------------------------

        //------------------------------- NON RECURSIVE SOLUTIONS --------------------------------------------

            //------------------- Uncomment this section for Four sub problem non recursive solution ----------
            //System.out.println("four solution without recursion output:");
            //double [] solution_4 = four_dc(p,q,length_p,length_q);
            //System.out.println(Arrays.toString(solution_4));
            //------------------------------------------------------------------------------------------------

            //------------------- Uncomment this section for Three sub problem non recursive solution ---------
            //System.out.println("three solution without recursion output:");
            //double [] solution_3 = three_dc(p, q, length_p, length_q);
            //System.out.println(Arrays.toString(solution_3));
            //------------------------------------------------------------------------------------------------

        //---------------------------------------------------------------------------------------------------

        // Calculating the time it took for the program execution
        long stopTime = System.nanoTime();
        float elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime/1000000);
        }
    }
    // Generate Random Solutions
    public static void random(double[] p,double min, double max,int length )
    {
        double diff = max - min;
        for(int i=0;i<length;i++){
        p[i] = min + Math.random( ) * diff;
        }
    }
    //School Book Solution
    public static double[] school_book(double[] p,double[] q,int length_p,int length_q){
        double[] pq = new double[(length_p+length_q) - 1];

        for(int i=0;i<length_p;i++){
            for(int j=0;j<length_q;j++){
                pq[i+j] += (p[i]*q[j]);
            }
        }
        return pq;

    }
    // NON RECURSIVE four sub problem solution
    public static double[] four_dc(double[] p,double[] q,int length_p,int length_q){
        double[] pq = new double[(length_p+length_q)];

        double[] pl = Arrays.copyOfRange(p, 0, (length_p/2));
        double[] ph = Arrays.copyOfRange(p, (length_p/2), length_p);
        //System.out.println(Arrays.toString(ph));
        double[] ql = Arrays.copyOfRange(q, 0, (length_q/2));
        double[] qh = Arrays.copyOfRange(q, (length_q/2), length_q);

        double[] plql= new double[(length_p/2+length_q/2)];
        for(int i=0;i<(length_p/2);i++){
            for(int j=0;j<(length_q/2);j++){
                plql[i+j] += (pl[i]*ql[j]);
            }
        }
        //System.out.println(Arrays.toString(plql));


        double[] phqh= new double[(length_p/2+length_q/2)];
        for(int i=0;i<(length_p/2);i++){
            for(int j=0;j<(length_q/2);j++){
                phqh[i+j] += (ph[i]*qh[j]);
            }
        }
        //System.out.println(Arrays.toString(phqh));

        double[] plqh= new double[(length_p/2+length_q/2)];
        for(int i=0;i<length_p/2;i++){
            for(int j=0;j<length_q/2;j++){
                plqh[i+j] += (pl[i]*qh[j]);
            }
        }
        //System.out.println(Arrays.toString(plqh));

        double[] phql= new double[(length_p/2+length_q/2)];
        for(int i=0;i<length_p/2;i++){
            for(int j=0;j<length_q/2;j++){
                phql[i+j] += (ph[i]*ql[j]);
            }
        }
        //System.out.println(Arrays.toString(phql));
        //Adding all them up
       int mid = ((length_p+length_q)/2);
        int x=1;
        while(x<=((length_p+length_q)-1)){
            if(x <= length_p/2) {
                pq[x] = plql[x-1];
            }
            else if(x >= ((length_p/2)+1)&& x < length_p) {
                pq[x] = plql[x-1] + plqh[x - ((length_p / 2)+1)] + phql[x - ((length_p / 2)+1)];
            }
            else if (x == mid){
                pq[x] = plqh[x-((length_p/2)+1)] + phql[x-((length_p/2)+1)];
            }

            else if (x > mid && x <= ((3*(length_p)/2)-1)) {
                pq[x] = phqh[x - (mid+1)] + plqh[x - ((length_p/2)+1)] + phql[x - ((length_p/2)+1)];
            }
            else {
                pq[x] = phqh[x - (mid+1)];
            }
            x++;
        }
        //System.out.println(Arrays.toString(pq));
        return Arrays.copyOfRange(pq, 1, pq.length);

    }
    // NON RECURSIVE three sub problem solution
    public static double[] three_dc(double[] p,double[] q,int length_p,int length_q){
        double[] pq = new double[length_p+length_q];
        double[] pl = Arrays.copyOfRange(p, 0, (length_p/2));
        double[] ph = Arrays.copyOfRange(p, (length_p/2), length_p);
        //System.out.println(Arrays.toString(ph));
        double[] ql = Arrays.copyOfRange(q, 0, (length_q/2));
        double[] qh = Arrays.copyOfRange(q, (length_q/2), length_q);

        double[] plql= new double[(length_p/2+length_q/2)];
        for(int i=0;i<(length_p/2);i++){
            for(int j=0;j<(length_q/2);j++){
                plql[i+j] += (pl[i]*ql[j]);
            }
        }
        //System.out.println(Arrays.toString(plql));


        double[] phqh= new double[(length_p/2+length_q/2)];
        for(int i=0;i<(length_p/2);i++){
            for(int j=0;j<(length_q/2);j++){
                phqh[i+j] += (ph[i]*qh[j]);
            }
        }
        //System.out.println(Arrays.toString(phqh));

        double[] plandph = new double[length_p];
        double[] qlandqh = new double[length_q];

        for(int i=0;i<length_p/2;i++){
        plandph[i] = pl[i] + ph[i];
        qlandqh[i] = ql[i] + qh[i];
        }



        double[] plmulqh= new double[(length_p/2+length_q/2)];
        for(int i=0;i<(length_p/2);i++){
            for(int j=0;j<(length_q/2);j++){
                plmulqh[i+j] += (plandph[i]*qlandqh[j]);
            }
        }

        double[] plmulqh_f = new double[(length_p/2+length_q/2)];
        for (int k =0;k<length_p; k++){
            plmulqh_f[k] = plmulqh[k] -plql[k] -phqh[k];
        }

        int mid = ((length_p+length_q)/2);
        int x=1;
        while(x<=((length_p+length_q)-1)){
            if(x <= length_p/2) {
                pq[x] = plql[x-1];
            }
            else if(x >= ((length_p/2)+1)&& x < length_p) {
                pq[x] = plql[x-1] + plmulqh_f[x - ((length_p / 2)+1)];
            }
            else if (x == mid){
                pq[x] = plmulqh_f[x-((length_p/2)+1)];
            }

            else if (x > mid && x <= ((3*(length_p)/2)-1)) {
                pq[x] = phqh[x - (mid+1)] + plmulqh_f[x - ((length_p/2)+1)];
            }
            else {
                pq[x] = phqh[x - (mid+1)];
            }
            x++;
        }

        return Arrays.copyOfRange(pq, 1, pq.length);


    }

    // Recursive Divide and conqour four sub problem solution
    public static double[] four_recursive(double[] p,double[] q,int length){
        {
            //base case
            if(length == 1){
                double[] pq = new double[1];
                pq[0] = p[0]*q[0];
                return pq;
            }
            else{
                //array declarations for pl,ph,ql,qh
                double[] pq = new double[(2*length)];
                double[] pl = Arrays.copyOfRange(p, 0, (length/2));
                double[] ph = Arrays.copyOfRange(p, (length/2), length);
                //System.out.println(Arrays.toString(ph));
                double[] ql = Arrays.copyOfRange(q, 0, (length/2));
                double[] qh = Arrays.copyOfRange(q, (length/2), length);

                //recursive calls
                double[] plql = four_recursive(pl,ql,length/2);
                double[] plqh = four_recursive(pl,qh,length/2);
                double[] phql = four_recursive(ph,ql,length/2);
                double[] phqh = four_recursive(ph,qh,length/2);

                // Adding the solutions as plql + (phql+plqh)x^n/2 +phqhx^n
                int mid = ((length));
                int x=1;
                while(x<=((length*2)-1)){
                    if(x <= length/2) {
                        pq[x] = plql[x-1];
                    }
                    else if(x >= ((length/2)+1)&& x < length) {
                        pq[x] = plql[x-1] + plqh[x - ((length / 2)+1)] + phql[x - ((length / 2)+1)];
                    }
                    else if (x == mid){
                        pq[x] = plqh[x-((length/2)+1)] + phql[x-((length/2)+1)];
                    }

                    else if (x > mid && x <= ((3*(length)/2)-1)) {
                        pq[x] = phqh[x - (mid+1)] + plqh[x - ((length/2)+1)] + phql[x - ((length/2)+1)];
                    }
                    else {
                        pq[x] = phqh[x - (mid+1)];
                    }
                    x++;
                }
                //System.out.println(Arrays.toString(pq));
                return Arrays.copyOfRange(pq, 1, pq.length);

            }



        }
    }

    // Recursive Divide and conqour three sub problem solution
    public static double[] three_recursive(double[] p,double[] q,int length){

        //base case
        if(length == 1){
            double[] pq = new double[1];
            pq[0] = p[0]*q[0];
            return pq;
        }
        else{
            //array declarations for pl,ph,ql,qh
            double[] pq = new double[(2*length)];
            double[] pl = Arrays.copyOfRange(p, 0, (length/2));
            double[] ph = Arrays.copyOfRange(p, (length/2), length);
            //System.out.println(Arrays.toString(ph));
            double[] ql = Arrays.copyOfRange(q, 0, (length/2));
            double[] qh = Arrays.copyOfRange(q, (length/2), length);

            //recursive calls
            double[] plql = three_recursive(pl, ql, length / 2);
            double[] phqh = three_recursive(ph, qh, length / 2);

            // pl+ph , ql+qh
            double[] plandph = new double[length];
            double[] qlandqh = new double[length];

            for(int i=0;i<length/2;i++){
                plandph[i] = pl[i] + ph[i];
                qlandqh[i] = ql[i] + qh[i];
            }

            //recursive call - (pl+ph)(ql+qh)
            double[] plmulqh = three_recursive(plandph,qlandqh,length/2);

            // (pl+qh)(ql+qh) - plql - phqh
            double[] plmulqh_f = new double[(length)];
            for (int k =0;k<length-1; k++){
                plmulqh_f[k] = plmulqh[k] -plql[k] -phqh[k];
            }

            // Adding the solutions as plql + ((pl+ph)(ql+qh)-plql-qlqh)x^n/2 +phqhx^n

            int mid = ((length));
            int x=1;
            while(x<=((length*2)-1)){
                if(x <= length/2) {
                    pq[x] = plql[x-1];
                }
                else if(x >= ((length/2)+1)&& x < length) {
                    pq[x] = plql[x-1] + plmulqh_f[x - ((length / 2)+1)];
                }
                else if (x == mid){
                    pq[x] = plmulqh_f[x-((length/2)+1)];
                }

                else if (x > mid && x <= ((3*(length)/2)-1)) {
                    pq[x] = phqh[x - (mid+1)] + plmulqh_f[x - ((length/2)+1)];
                }
                else {
                    pq[x] = phqh[x - (mid+1)];
                }
                x++;
            }
           // System.out.println(Arrays.toString(pq));
            return Arrays.copyOfRange(pq, 1, pq.length);

        }


    }
}
