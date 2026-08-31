#include <bits/stdc++.h>
using namespace std;
inline void file() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  if (0) {
    freopen(".in", "r", stdin);
    freopen(".out", "w", stdout);
  }
}
const clock_t MAXT = (100 * CLOCKS_PER_SEC) / 1000;
const int PX[4] = {0, 0, 1, -1}, PY[4] = {-1, 1, 0, 0}, N = 1e5 + 10, INF = 1e9;
const long long INFL = 1e18, MOD = 1e9 + 7;
const long double EPS = 1e-6;
long long a[N];
int n, p[N];
vector<pair<long long, long long> > g[N];
inline bool check(long long c, long long a, long long b) {
  return fabs((long double)a * b + c) > 1e18;
  return a > (INFL - c + b - 1) / b;
}
void dfs(int v, int pred, long long c = 1) {
  p[v] = pred;
  for (pair<long long, long long> i : g[v])
    if (i.first != pred) dfs(i.first, v, i.second);
  if (a[v] > 0) c = 1;
  if (check(a[pred], a[v], c)) {
    cerr << "zaranie\n";
    cout << "NO\n";
    exit(0);
  }
  a[pred] += a[v] * c;
}
int main() {
  file();
  long long x, k;
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i];
  for (int i = 1; i <= n; ++i) {
    cin >> x;
    a[i] -= x;
  }
  for (int i = 2; i <= n; ++i) {
    cin >> x >> k;
    g[x].push_back(make_pair(i, k));
  }
  dfs(1, 0);
  if (a[0] >= 0)
    cout << "YES\n";
  else
    cout << "NO\n";
}
