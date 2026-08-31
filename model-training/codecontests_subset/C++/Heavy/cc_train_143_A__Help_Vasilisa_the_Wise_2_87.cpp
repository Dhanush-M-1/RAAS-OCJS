#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2, A, B, C, D;
int main() {
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (A = 1; A <= 9; ++A)
    for (B = 1; B <= 9; ++B)
      for (C = 1; C <= 9; ++C)
        for (D = 1; D <= 9; ++D)
          if (A + B == r1 && C + D == r2 && A + C == c1 && B + D == c2 &&
              A + D == d1 && B + C == d2) {
            set<int> s;
            s.insert(A);
            s.insert(B);
            s.insert(C);
            s.insert(D);
            if (s.size() == 4) {
              printf("%d %d\n%d %d\n", A, B, C, D);
              return 0;
            }
          }
  puts("-1");
  return 0;
}
