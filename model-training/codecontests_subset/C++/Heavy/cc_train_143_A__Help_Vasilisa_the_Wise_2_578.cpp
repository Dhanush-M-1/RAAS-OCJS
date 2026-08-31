#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
char s[N];
int t[N];
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int a = 1; a <= 9; a++)
    for (int b = 1; b <= 9; b++)
      for (int c = 1; c <= 9; c++)
        for (int d = 1; d <= 9; d++) {
          if (a + b != r1) continue;
          if (c + d != r2) continue;
          if (a + c != c1) continue;
          if (b + d != c2) continue;
          if (a + d != d1) continue;
          if (b + c != d2) continue;
          if (a == b || b == c || c == d) continue;
          if (a == c || b == d) continue;
          if (a == d) continue;
          printf("%d %d\n%d %d\n", a, b, c, d);
          scanf(" ");
          exit(0);
        }
  puts("-1");
  scanf(" ");
}
