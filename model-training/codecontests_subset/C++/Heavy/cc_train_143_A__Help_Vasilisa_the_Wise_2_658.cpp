#include <bits/stdc++.h>
const int Inf = 2e9;
long long LINF = (long long)4e18;
using namespace std;
int r1, r2, c1, c2, d1, d2;
bool ok(int i, int j, int k, int l) {
  if (i + j != r1) return false;
  if (k + l != r2) return false;
  if (i + k != c1) return false;
  if (j + l != c2) return false;
  if (i + l != d1) return false;
  if (j + k != d2) return false;
  return true;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (i == j) continue;
          if (i == k) continue;
          if (i == l) continue;
          if (j == k) continue;
          if (j == l) continue;
          if (k == l) continue;
          if (!ok(i, j, k, l)) continue;
          cout << i << ' ' << j << '\n';
          cout << k << ' ' << l << '\n';
          return 0;
        }
      }
    }
  }
  cout << -1;
  return 0;
}
