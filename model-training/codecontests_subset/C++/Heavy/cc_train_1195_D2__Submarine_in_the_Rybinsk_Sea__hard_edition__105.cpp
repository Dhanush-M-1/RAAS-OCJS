#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  const int mod = 998244353;
  auto solve = [&](string s1, string s2) {
    long long p = 1;
    int p1 = int(s1.size()) - 1;
    int p2 = int(s2.size()) - 1;
    long long ret = 0;
    while (true) {
      if (0 <= p2) {
        ret += 1LL * p * (s2[p2--] - '0');
        ret %= mod;
        p = (p * 10) % mod;
      } else {
        while (0 <= p1) {
          ret += 1LL * p * (s1[p1--] - '0');
          ret %= mod;
          p = (p * 10) % mod;
        }
        break;
      }
      swap(s1, s2);
      swap(p1, p2);
    }
    return ret;
  };
  vector<vector<int> > fl(11, vector<int>(11, 0));
  vector<vector<int> > fr(11, vector<int>(11, 0));
  vector<int> vis(11, 0);
  for (int i = 0; i < n; i++) {
    string si;
    cin >> si;
    string l = "";
    for (int it = 1; it < 11; it++) {
      l += "0";
      int z = solve(l, si);
      fr[it][int(si.size())] += z;
      if (fr[it][int(si.size())] >= mod) fr[it][int(si.size())] -= mod;
    }
    vis[int(si.size())] += 1;
    string r = "";
    for (int it = 1; it < 11; it++) {
      r += "0";
      int z = solve(si, r);
      fl[int(si.size())][it] += z;
      if (fl[int(si.size())][it] >= mod) fl[int(si.size())][it] -= mod;
    }
  }
  long long ans = 0;
  for (int l = 1; l < 11; l++) {
    if (vis[l] == 0) continue;
    for (int r = 1; r < 11; r++) {
      if (vis[r] == 0) continue;
      long long add = (1LL * vis[r] * fl[l][r] + 1LL * vis[l] * fr[l][r]) % mod;
      ans += add;
      if (ans >= mod) ans -= mod;
    }
  }
  cout << ans << '\n';
  return (0);
}
