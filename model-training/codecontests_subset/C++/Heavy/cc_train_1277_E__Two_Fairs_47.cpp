#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
using namespace std;
vector<unsigned long long> p;
vector<unsigned long long> r;
vector<unsigned long long> c;
unsigned long long cnt = 0;
void MakeSet(unsigned long long x) {
  p[x] = x;
  r[x] = 0;
  c[x] = 1;
}
unsigned int Find(unsigned long long x) {
  return (x == p[x] ? x : p[x] = Find(p[x]));
}
void Union(unsigned long long x, unsigned long long y) {
  if ((x = Find(x)) == (y = Find(y))) return;
  if (r[x] < r[y]) {
    p[x] = y;
    c[y] += c[x];
    --cnt;
  } else {
    p[y] = x;
    c[x] += c[y];
    --cnt;
    if (r[x] == r[y]) ++r[x];
  }
}
void solve() {
  unsigned long long n, m, a, b;
  cin >> n >> m >> a >> b;
  cnt = n - 2;
  p = vector<unsigned long long>(n + 1);
  r = vector<unsigned long long>(n + 1);
  c = vector<unsigned long long>(n + 1);
  for (unsigned long long i = (0); i < (n); i++) {
    MakeSet(i + 1);
  }
  unordered_map<unsigned long long, unordered_set<unsigned long long>> g;
  for (unsigned long long i = (0); i < (m); i++) {
    unsigned long long v1, v2;
    cin >> v1 >> v2;
    if (v1 == a && v2 != b)
      g[a].insert(v2);
    else if (v1 == b && v2 != a)
      g[b].insert(v2);
    if (v2 == a && v1 != b)
      g[a].insert(v1);
    else if (v2 == b && v1 != a) {
      g[b].insert(v1);
    }
    if (v1 == a || v1 == b || v2 == a || v2 == b) continue;
    Union(v1, v2);
  }
  if (cnt == 1) {
    cout << 0 << endl;
    return;
  }
  unordered_map<unsigned long long, pair<bool, bool>> flag;
  for (const auto& v : g[a]) {
    flag[Find(v)].first = true;
  }
  for (const auto& v : g[b]) {
    flag[Find(v)].second = true;
  }
  unsigned long long cnt_a = 0, cnt_b = 0;
  for (const auto& [v, has] : flag) {
    const auto& [has_a, has_b] = has;
    if (has_a && !has_b)
      cnt_a += c[v];
    else if (has_b && !has_a)
      cnt_b += c[v];
  }
  cout << cnt_a * cnt_b << endl;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  unsigned long long n;
  cin >> n;
  while (n-- > 0) {
    solve();
  }
  return 0;
}
