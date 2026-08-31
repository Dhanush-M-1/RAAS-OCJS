#include <bits/stdc++.h>
using namespace std;
const int MAX = (int)1e5 + 5;
int r1, r2, c1, c2, d1, d2;
int a = -1, b = -1, c = -1, d = -1;
void gen() {
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (i + j == r1 and k + l == r2 and i + k == c1 and j + l == c2 and
              i + l == d1 and j + k == d2 and (i != j) and (i != k) and
              (i != l) and (j != k) and (j != l) and (k != l)) {
            a = i;
            b = j;
            c = k;
            d = l;
            break;
          }
          if (a != -1 or b != -1 or c != -1 or d != -1) break;
        }
        if (a != -1 or b != -1 or c != -1 or d != -1) break;
      }
      if (a != -1 or b != -1 or c != -1 or d != -1) break;
    }
    if (a != -1 or b != -1 or c != -1 or d != -1) break;
  }
}
void solve() {
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  gen();
  if (a != -1 or b != -1 or c != -1 or d != -1)
    cout << a << " " << b << endl << c << " " << d;
  else
    cout << -1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve();
  cout << "\n";
  return 0;
}
