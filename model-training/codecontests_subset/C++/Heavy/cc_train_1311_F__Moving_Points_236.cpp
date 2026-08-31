#include <bits/stdc++.h>
using namespace std;
struct FT {
  vector<long long> f;
  FT(long long n) { f.resize(n + 1, 0); }
  long long sum(long long r) {
    long long res = 0;
    for (; r >= 0; r = (r & (r + 1)) - 1) {
      res += f[r];
    }
    return res;
  }
  long long sum(long long l, long long r) { return sum(r) - sum(l - 1); }
  void upd(long long i, long long x) {
    for (; i < (long long)f.size(); i = (i | (i + 1))) f[i] += x;
  }
};
map<long long, long long> f;
signed main() {
  ios ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  vector<pair<long long, long long>> a(n);
  for (long long i = 0; i < n; i++) cin >> a[i].first;
  for (long long i = 0; i < n; i++) cin >> a[i].second, f[a[i].second] = 0;
  long long s = 0;
  for (auto u : f) f[u.first] = s++;
  sort(a.begin(), a.end());
  FT ft1(s + 1), ft2(s + 1);
  long long ans = 0;
  for (auto u : a) {
    long long x = u.first, y = u.second;
    long long v = f[y];
    long long cnt = ft1.sum(0, v);
    long long sum = ft2.sum(0, v);
    ans += x * cnt - sum;
    ft1.upd(v, 1);
    ft2.upd(v, x);
  }
  cout << ans << '\n';
}
