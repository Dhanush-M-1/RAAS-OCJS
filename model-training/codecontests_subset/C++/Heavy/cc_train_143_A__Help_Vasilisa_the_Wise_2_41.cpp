#include <bits/stdc++.h>
using namespace std;
bool np(int x) {
  if (x == 0) return 0;
  if (x == 1) return 0;
  if (x == 2) return 0;
  if (x >= 3) {
    for (int i = 2; i * i <= x; i++) {
      if (i == x) continue;
      if (x % i == 0) return 0;
    }
  }
  return 1;
}
signed main() {
  int y = 0, c = -1, L, n = 0, t = 0, t1 = 0, k;
  int r1, r2, d1, d2, c1, c2;
  int gg1, gg2, gg3, gg4;
  set<char> st1;
  cin >> r2;
  cin >> r1;
  cin >> c1;
  cin >> c2;
  cin >> d1;
  cin >> d2;
  int xm = max({r1, r2, d1, d2, c1, c2});
  int xn = min({r1, r2, d1, d2, c1, c2});
  bool ok = true;
  {
    for (int g1 = 1; g1 < 10; g1++) {
      for (int g2 = 1; g2 < 10; g2++) {
        for (int g3 = 1; g3 < 10; g3++) {
          for (int g4 = 1; g4 < 10; g4++) {
            if (g1 == g2 || g1 == g3 || g1 == g4 || g2 == g3 || g3 == g4 ||
                g2 == g4)
              continue;
            if ((g1 + g2) == r2 && (g4 + g3) == r1 && (g1 + g3) == c1 &&
                (g4 + g2) == c2 && (g1 + g4) == d1 && (g3 + g2) == d2) {
              cout << g1 << " " << g2 << endl;
              cout << g3 << " " << g4 << endl;
              return 0;
            }
          }
        }
      }
    }
  }
  cout << -1 << endl;
  return 0;
}
