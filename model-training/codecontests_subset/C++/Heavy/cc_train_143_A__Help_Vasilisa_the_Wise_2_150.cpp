#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long mod1 = 998244353;
const long long inf = 1e18;
long long r1, r2, c1, c2, d1, d2;
void solve() {
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (long long i = (1); i < (10); i++)
    for (long long j = (1); j < (10); j++)
      for (long long k = (1); k < (10); k++)
        for (long long l = (1); l < (10); l++) {
          set<long long> s;
          s.insert({i, j, k, l});
          if (s.size() == 4 && i + j == r1 && k + l == r2 && i + k == c1 &&
              j + l == c2 && i + l == d1 && j + k == d2) {
            cout << i << " " << j << '\n' << k << " " << l;
            return;
          }
        }
  cout << -1;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
