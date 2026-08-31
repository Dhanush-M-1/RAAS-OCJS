
import java.util.*;
import java.util.function.Consumer;

class Node {
    int pattern;
    int notZero;
    boolean max;

    Node apply(Consumer<Node> lambda) {
        lambda.accept(this);
        return this;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        int k = s.nextInt();

        int length = n.length();


        int[][] dp0 = {};
        int[][] dp1 = {};

        List<Node> state = Collections.emptyList();
        for (int i = 0; i < length; i++) {
            final int digit = n.charAt(i) - '0';
            if (i == 0) {
                state = new ArrayList<>();
                // 最大値君
                state.add(new Node().apply(self -> {
                    self.max = true;
                    self.notZero = 1;
                    self.pattern = 1;
                }));
                // 真中らぁら
                if(digit>1) {
                    state.add(new Node().apply(self -> {
                        self.max = false;
                        self.notZero = 1;
                        self.pattern = digit - 1;
                    }));
                }
                // わがなはぜろ
                state.add(new Node().apply(self -> {
                    self.max = false;
                    self.notZero = 0;
                    self.pattern = 1;
                }));

            } else {
                List<Node> next = new ArrayList<>();
                int[] tmp=new int[1000];
                for (Node node : state) {
                    if (node.max) {
                        // up
                        next.add(new Node().apply(self -> {
                            self.max = true;
                            self.pattern = node.pattern;
                            self.notZero = node.notZero+((digit==0)?0:1);
                        }));
                        // まなか
                        if(digit>1){
                            tmp[node.notZero+1]+=(node.pattern * (digit - 1));
                        }
                        if(digit>0){
                            //zero
                            tmp[node.notZero]+=(node.pattern );

                        }
                    } else {
                        //1-9
                        tmp[node.notZero+1]+=(node.pattern * 9);
                        // 0
                        tmp[node.notZero]+=(node.pattern );
                    }
                }
                for (int j = 0; j <tmp.length ; j++) {
                    final int jj=j;
                    if(tmp[j]<1)continue;
                    next.add(new Node().apply(self -> {
                        self.max = false;
                        self.pattern = tmp[jj];
                        self.notZero = jj;
                    }));
                }
                state = next;
            }
        }
        int ans= state.stream().filter(self -> self.notZero == k).map(self -> self.pattern).reduce(0, (p, q) -> p + q);
        System.out.println(ans);

    }
}