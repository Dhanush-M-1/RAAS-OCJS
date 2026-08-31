#include <bits/stdc++.h>
using namespace std;
template <class T>
T abs(T x) {
  return x > 0 ? x : -x;
}
int n;
int m;
int r1, r2, c1, c2, d1, d2;
int main() {
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int a = 1; a <= 9; a++)
    for (int b = 1; b <= 9; b++)
      if (a != b)
        for (int c = 1; c <= 9; c++)
          if (a != c && b != c)
            for (int d = 1; d <= 9; d++)
              if (a != d && b != d && c != d)
                if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
                    a + d == d1 && b + c == d2) {
                  printf("%d %d\n%d %d\n", a, b, c, d);
                  return 0;
                }
  printf("-1\n");
  return 0;
}
