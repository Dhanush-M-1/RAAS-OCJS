#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int m[2][2];
  for (int a = 1; a < 10; a++) {
    for (int b = 1; b < 10; b++) {
      for (int c = 1; c < 10; c++) {
        for (int d = 1; d < 10; d++) {
          if (a == b || a == c || a == d || b == c || b == d || c == d)
            continue;
          if (a + b != r1) continue;
          if (c + d != r2) continue;
          if (a + c != c1) continue;
          if (b + d != c2) continue;
          if (a + d != d1) continue;
          if (b + c != d2) continue;
          cout << a << " " << b << endl << c << " " << d;
          exit(0);
        }
      }
    }
  }
  cout << -1;
  fclose(stdout);
  return 0;
}
