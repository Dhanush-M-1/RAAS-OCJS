#include <bits/stdc++.h>
using namespace std;
using uint = unsigned int;
using ll = long long;
using ld = long double;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
void debug_out() { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << H;
  debug_out(T...);
}
template <typename T1, typename T2>
ostream &operator<<(ostream &out, const pair<T1, T2> &item) {
  out << '(' << item.first << ", " << item.second << ')';
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, const vector<T> &v) {
  for (const auto &item : v) out << item << ' ';
  return out;
}
const int N = 80;
struct Minion {
  int id, a, b;
  bool operator<(const Minion &o) const { return b < o.b; }
};
ll s[N];
bool ok[N];
int prv[N][N];
ll dp[N][N];
Minion v[N];
int main() {
  ios_base::sync_with_stdio(false);
  int t, n, k;
  for (cin >> t; t; --t) {
    cin >> n >> k;
    for (int i = 1; i <= n; ++i) cin >> v[i].a >> v[i].b, v[i].id = i;
    sort(v + 1, v + n + 1);
    for (int i = 1; i <= n; ++i) s[i] = s[i - 1] + v[i].b;
    memset(dp, -1, sizeof dp);
    dp[0][0] = 0;
    int lst = -1;
    ll ans = 0;
    for (int i = 1; i <= n; ++i)
      for (int nr = 1; nr <= i && nr <= k; ++nr) {
        for (int j = 0; j < i; ++j) {
          if (dp[j][nr - 1] < 0) continue;
          ll val = dp[j][nr - 1] + v[i].a + 1LL * v[i].b * (nr - 1) +
                   1LL * (s[i - 1] - s[j]) * (k - 1);
          if (val > dp[i][nr]) dp[i][nr] = val, prv[i][nr] = j;
        }
        if (dp[i][k] >= 0) {
          ll val = dp[i][k] + 1LL * (s[n] - s[i]) * (k - 1);
          if (val > ans) ans = val, lst = i;
        }
      }
    memset(ok, 0, sizeof ok);
    for (int i = lst, nr = k; nr; i = prv[i][nr], --nr) ok[i] = true;
    cout << 2 * n - k << '\n';
    for (int i = 1, nr = 0; nr < k - 1; ++i)
      if (ok[i]) cout << v[i].id << ' ', ++nr;
    for (int i = 1; i <= n; ++i)
      if (!ok[i]) cout << v[i].id << ' ' << -v[i].id << ' ';
    cout << v[lst].id << '\n';
  }
  return 0;
}
