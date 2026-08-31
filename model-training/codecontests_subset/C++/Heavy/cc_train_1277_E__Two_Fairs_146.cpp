#include <bits/stdc++.h>
using namespace std;
void swap(long long &a, long long &b) {
  auto tm = a;
  a = b;
  b = tm;
}
const long long mod = 1000000009;
const long long mod2 = 998244353;
const long long INF = (1LL << 20) - 1;
const long long N = 2e5 + 25;
long long n, m, a, b;
vector<long long> v[N];
set<long long> c, d;
bool vt[N];
void dfs1(long long x) {
  vt[x] = 1;
  for (auto &(i) : (v[x])) {
    if (i == b) {
      c.insert(x);
      continue;
    }
    if (vt[i] == 0) dfs1(i);
  }
}
void dfs2(long long x) {
  vt[x] = 1;
  for (auto &(i) : (v[x])) {
    if (i == a) {
      d.insert(x);
      continue;
    }
    if (vt[i] == 0) dfs2(i);
  }
}
void bheja_fry() {
  c.clear();
  d.clear();
  cin >> n >> m >> a >> b;
  for (long long(i) = (0); (i) < (n + 1); ++(i)) {
    v[i].clear();
    vt[i] = 0;
  }
  long long x, y;
  for (long long(i) = (0); (i) < (m); ++(i)) {
    cin >> x >> y;
    v[x].push_back(y);
    v[y].push_back(x);
  }
  long long ct1 = 0, ct2 = 0;
  dfs1(a);
  for (long long(i) = (0); (i) < (n + 1); ++(i)) vt[i] = 0;
  dfs2(b);
  queue<long long> q;
  for (auto &(i) : (v[b])) {
    if (c.find(i) == c.end()) q.push(i);
  }
  for (long long(i) = (0); (i) < (n + 1); ++(i)) vt[i] = 0;
  vt[b] = 1;
  while (!q.empty()) {
    x = q.front();
    q.pop();
    if (vt[x]) continue;
    ct1++;
    vt[x] = 1;
    for (auto &(i) : (v[x])) {
      if (vt[i] == 0) q.push(i);
    }
  }
  for (auto &(i) : (v[a])) {
    if (d.find(i) == d.end()) q.push(i);
  }
  for (long long(i) = (0); (i) < (n + 1); ++(i)) vt[i] = 0;
  vt[a] = 1;
  while (!q.empty()) {
    x = q.front();
    q.pop();
    if (vt[x]) continue;
    ct2++;
    vt[x] = 1;
    for (auto &(i) : (v[x])) {
      if (vt[i] == 0) q.push(i);
    }
  }
  cout << ct1 * ct2;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  cin >> t;
  for (long long(i) = (1); (i) < (t + 1); ++(i)) {
    bheja_fry();
    if (i < t) cout << "\n";
  }
  return 0;
}
