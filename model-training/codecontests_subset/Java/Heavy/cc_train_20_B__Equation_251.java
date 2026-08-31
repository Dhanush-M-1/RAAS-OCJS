    // package Practice1;

    import java.util.Scanner;

    public class CF020B {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int A = s.nextInt();
            int B = s.nextInt();
            int C = s.nextInt();
            if(!((A == 0) && (B == 0) && (C == 0))) {
                if (A == 0) {
                    if (B != 0 && C != 0) {
                        double ans = (C * -1.0) / B;
                        System.out.println(1);
                        System.out.println(ans);
                    } else if (B != 0) {
                        System.out.println(1);
                        System.out.println(0);
                    } else  {
                        System.out.println(0);
                    }
                } else if (B == 0) {
                    if (C <= 0) {
                        System.out.println(1);
                        double ans = (C * -1.0) / A;
                        if(ans == 0){
                            ans = 0;
                        }
                        ans = Math.sqrt(ans);
    //                System.out.println(a/ns);
                        System.out.println(ans);
                    } else {
                        System.out.println(0);
                    }
                } else if (C == 0) {
                    System.out.println(2);
                    double ans = (B * -1.0) / A;
                    if (ans > 0) {
                        System.out.println(0);
                        System.out.println(ans);
                    } else {
                        System.out.println(ans);
                        System.out.println(0);
                    }
                } else {
                    double a = A, b = B, c = C;
                    double root1, root2;

                    double determinant = (b * b) - (4 * a * c);

                    // condition for real and different roots
                    if(determinant > 0) {
                        root1 = (-b + Math.sqrt(determinant)) / (2 * a);
                        root2 = (-b - Math.sqrt(determinant)) / (2 * a);

                        System.out.println(2);
                        if(root1 < root2) {
                            System.out.println(root1);
                            System.out.println(root2);
                        }else{
                            System.out.println(root2);
                            System.out.println(root1);
                        }
                    }
                    // Condition for real and equal roots
                    else if(determinant == 0) {
                        root1 = root2 = -b / (2 * a);
                        System.out.println(1);
                        System.out.println(root1);
                    }
                    // If roots are not real
                    else {
    //                double realPart = -b / (2 *a);
    //                double imaginaryPart = Math.sqrt(-determinant) / (2 * a);
    //
                        System.out.println(0);
    //                System.out.format("root1 = %.2f+%.2fi and root2 = %.2f-%.2fi", realPart, imaginaryPart, realPart, imaginaryPart);
                    }
                }
            } else {
                System.out.println(-1);
            }

        }
    }
