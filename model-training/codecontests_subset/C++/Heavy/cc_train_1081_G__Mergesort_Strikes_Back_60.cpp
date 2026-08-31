#include <bits/stdc++.h>
using namespace std;
int MOD;
int inv(long long int n) {
  long long int r = 1;
  int e = MOD - 2;
  while (e > 0) {
    if (e & 1) r *= n, r %= MOD;
    e >>= 1;
    n *= n, n %= MOD;
  }
  return r;
}
map<int, int> occ;
vector<pair<int, int> > v;
int findSizes(int s, int h) {
  if ((h == 1) || (s == 1))
    occ[s]++;
  else
    findSizes(s / 2, h - 1), findSizes((s + 1) / 2, h - 1);
  return 0;
}
int main() {
  int n, k;
  cin >> n >> k >> MOD;
  findSizes(n, k);
  for (auto it = occ.begin(); it != occ.end(); it++) v.push_back(*it);
  int i, j;
  long long int ans = 0;
  for (i = 0; i < v.size(); i++) {
    long long int x = ((long long int)v[i].first * (v[i].first - 1)) % MOD;
    x *= inv(4), x %= MOD;
    ans += v[i].second * x, ans %= MOD;
  }
  for (i = 0; i < v.size(); i++) {
    for (j = i; j < v.size(); j++) {
      long long int o = ((long long int)v[i].second * v[j].second) % MOD;
      if (i == j)
        o = ((long long int)v[i].second * (v[i].second - 1) / 2) % MOD;
      for (k = 2; k <= v[i].first + v[j].first; k++) {
        long long int c = (inv(2) - inv(k) + MOD) % MOD;
        c *= o, c %= MOD;
        ans += c * (min(k - 1, v[i].first) - max(k - v[j].first, 1) + 1),
            ans %= MOD;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
