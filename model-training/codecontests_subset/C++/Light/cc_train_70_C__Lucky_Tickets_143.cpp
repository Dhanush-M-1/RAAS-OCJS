#include <bits/stdc++.h>
using namespace std;
const int N = 100000 + 7;
const int M = 300;
const int mod = 999983;
const int inf = 1e9 + 7;
const double pi = acos(-1);
const int maxn = N * 2;
const double PI = acos(-1);
int rev(int x) {
  int nw = 0;
  while (x) {
    nw = nw * 10 + (x % 10);
    x /= 10;
  }
  return nw;
}
int gcd(int u, int v) { return (u == 0) ? v : gcd(v % u, u); }
map<pair<int, int>, int> st;
map<pair<int, int>, int> pre;
int n, m, w;
pair<int, int> get(int u) {
  int v = rev(u);
  int d = gcd(u, v);
  u /= d;
  v /= d;
  return make_pair(u, v);
}
void solve() {
  cin >> n >> m >> w;
  for (int i = 1; i <= m; i++) {
    st[get(i)]++;
  }
  long long ans = (long long)inf * inf;
  long long cur = 0;
  int l = -1, r = -1;
  for (int i = 1; i <= n; i++) {
    int u = i, v = rev(i);
    int d = gcd(u, v);
    u /= d;
    v /= d;
    pre[make_pair(v, u)]++;
    cur += st[make_pair(v, u)];
    while (m > 0 && cur - pre[get(m)] >= w) {
      cur -= pre[get(m)];
      st[get(m)]--;
      m--;
    }
    if (cur >= w && (long long)i * m < ans) {
      l = i;
      r = m;
      ans = min(ans, (long long)l * r);
    }
  }
  if (l == -1)
    puts("-1");
  else
    cout << l << " " << r;
}
int main() {
  int T = 1;
  for (int i = (1); i < (T + 1); i++) {
    solve();
  }
}
