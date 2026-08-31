#include <bits/stdc++.h>
using namespace std;
const long long md = 1e9 + 7;
const int xn = 2e5 + 10;
const int xm = 5e5;
const int SQ = 750;
const int sq = 1e3 + 10;
const long long inf = 1e18 + 10;
long long power(long long a, long long b) {
  return (!b ? 1
             : (b & 1 ? a * power(a * a % md, b / 2) % md
                      : power(a * a % md, b / 2) % md));
}
int n;
map<int, int> mp;
pair<long long, long long> X[xn];
long long x[xn], v[xn], PS[xn], t[xn], ans;
void Get(int l, int r, int ind) {
  for (int i = l; i <= r;) {
    if (i % SQ == 0 && i + SQ - 1 <= r) {
      ans -= PS[i / SQ] - x[ind] * t[i / SQ];
      i += SQ;
    } else {
      if (v[i] <= v[ind]) ans += x[ind] - x[i];
      i++;
    }
  }
}
void Update(int ind) {
  PS[ind / SQ] += x[ind];
  t[ind / SQ]++;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i];
  for (int i = 0; i < n; i++) cin >> v[i];
  for (int i = 0; i < n; i++) X[i] = {x[i], v[i]};
  sort(X, X + n);
  for (int i = 0; i < n; i++)
    x[i] = X[i].first, v[i] = X[i].second, swap(X[i].first, X[i].second),
    mp[x[i]] = i;
  sort(X, X + n);
  for (int i = 0; i < n; i++) {
    Get(0, mp[X[i].second] - 1, mp[X[i].second]);
    Update(mp[X[i].second]);
  }
  cout << ans << '\n';
  return 0;
}
