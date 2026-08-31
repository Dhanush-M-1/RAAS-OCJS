#include <bits/stdc++.h>
using namespace std;
bool check(long long int a, long long int b, long long int c, long long int d) {
  map<long long int, long long int> m;
  m[a] = 1;
  if (m[b]) return false;
  m[b] = 1;
  if (m[c]) return false;
  m[c] = 1;
  if (m[d]) return false;
  m[d] = 1;
  return true;
}
void solve() {
  long long int r1, r2;
  long long int c1, c2;
  long long int d1, d2;
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  for (long long int i = 1; i <= 9; i++) {
    for (long long int j = 1; j <= 9; j++) {
      for (long long int k = 1; k <= 9; k++) {
        for (long long int l = 1; l <= 9; l++) {
          if (check(i, j, k, l)) {
            if (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 &&
                i + l == d1 && k + j == d2) {
              cout << i << " " << j << endl;
              cout << k << " " << l << endl;
              return;
            }
          }
        }
      }
    }
  }
  cout << -1;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int T;
  T = 1;
  while (T--) {
    solve();
  }
  return 0;
}
