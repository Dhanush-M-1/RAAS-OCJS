#include <bits/stdc++.h>
template <typename T>
inline T const &MAX(T const &a, T const &b) {
  return a > b ? a : b;
}
template <typename T>
inline T const &MIN(T const &a, T const &b) {
  return a < b ? a : b;
}
inline void add(long long &a, long long b) {
  a += b;
  if (a >= 1000000007) a -= 1000000007;
}
inline void sub(long long &a, long long b) {
  a -= b;
  if (a < 0) a += 1000000007;
}
inline long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
inline long long qp(long long a, long long b) {
  long long ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % 1000000007;
    a = a * a % 1000000007, b >>= 1;
  }
  return ans;
}
inline long long qp(long long a, long long b, long long c) {
  long long ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % c;
    a = a * a % c, b >>= 1;
  }
  return ans;
}
using namespace std;
const double eps = 1e-8;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const int N = 200000 + 10, maxn = 1000000 + 10, inf = 0x3f3f3f3f;
int ans[N], d[N];
bool vis[N];
vector<pair<int, int> > v[N];
set<pair<int, int> > s;
pair<int, int> p[N];
void gao(int x) {
  auto y = s.lower_bound(make_pair(d[x], x));
  if (y != s.end()) {
    s.erase(y);
    d[x]--;
    s.insert(make_pair(d[x], x));
  }
}
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    v[a].push_back(make_pair(b, i)), v[b].push_back(make_pair(a, i));
    d[a]++, d[b]++;
    p[i] = make_pair(a, b);
  }
  for (int i = 1; i <= n; i++) s.insert(make_pair(d[i], i));
  for (int i = m; i >= 1; i--) {
    while (s.size() > 0 && (s.begin())->first < k) {
      int te = s.begin()->second;
      s.erase(s.begin());
      for (int i = 0; i < v[te].size(); i++) {
        if (vis[v[te][i].second]) continue;
        gao(v[te][i].first);
        vis[v[te][i].second] = 1;
      }
    }
    ans[i] = s.size();
    if (vis[i] == 1) continue;
    gao(p[i].first), gao(p[i].second);
    vis[i] = 1;
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
