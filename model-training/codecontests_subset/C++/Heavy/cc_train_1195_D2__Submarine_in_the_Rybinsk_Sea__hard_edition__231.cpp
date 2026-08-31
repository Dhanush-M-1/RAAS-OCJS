#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(chrono::system_clock::now().time_since_epoch().count());
long long MOD = 998244353;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long i, j, k, m, n, res = 0, p10[30];
  p10[0] = 1;
  for (i = 1; i < 30; i++) {
    p10[i] = (p10[i - 1] * 10) % MOD;
  }
  cin >> n;
  vector<string> v(n);
  vector<long long> vc(20, 0);
  for (i = 0; i < n; i++) {
    cin >> v[i];
    for (j = 0; j < v[i].size(); j++) {
      v[i][j] -= '0';
    }
    vc[v[i].size()]++;
    reverse(v[i].begin(), v[i].end());
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < v[i].size(); j++) {
      for (k = 1; k <= 11; k++) {
        if (k < j + 1) {
          res += (((2 * vc[k] * p10[j + k]) % MOD) * v[i][j]) % MOD;
        }
        if (k >= j + 1) {
          res += (((11 * vc[k] * p10[j * 2]) % MOD) * v[i][j]) % MOD;
        }
        res %= MOD;
      }
    }
  }
  cout << res % MOD;
  return 0;
}
