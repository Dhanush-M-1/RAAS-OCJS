#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  int a, b, c, d, ok;
  ok = 0;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (a = 1; a <= 9; a++) {
    for (b = 1; b <= 9; b++) {
      for (c = 1; c <= 9; c++) {
        for (d = 1; d <= 9; d++) {
          if (a == b || a == c || a == d || b == c || b == d || c == d)
            continue;
          if (r1 != a + b) continue;
          if (r2 != c + d) continue;
          if (c1 != a + c) continue;
          if (c2 != b + d) continue;
          if (d1 != a + d) continue;
          if (d2 != c + b) continue;
          ok = 1;
          break;
        }
        if (ok) break;
      }
      if (ok) break;
    }
    if (ok) break;
  }
  if (ok == 0)
    puts("-1");
  else
    printf("%d %d\n%d %d\n", a, b, c, d);
  return 0;
}
