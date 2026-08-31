#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
double fRand(double fMin, double fMax) {
  double f = (double)rand() / RAND_MAX;
  return fMin + f * (fMax - fMin);
}
template <class T>
T min(T a, T b, T c) {
  return min(a, min(b, c));
}
template <class T>
T max(T a, T b, T c) {
  return max(a, max(b, c));
}
int n, f[200005], d[200005], deg[200005], par[200005];
bool ok[200005], avail[200005];
vector<int> g[200005];
set<pair<int, int> > s;
void prep(int u) {
  if (deg[u] % 2 == 0) s.insert(make_pair(d[u], u));
  for (int v : g[u]) {
    if (v == par[u]) continue;
    par[v] = u;
    d[v] = d[u] + 1;
    prep(v);
  }
}
void DFS(int u) {
  printf("%d\n", u);
  avail[u] = false;
  s.erase(make_pair(d[u], u));
  for (int v : g[u]) {
    --deg[v];
    if (avail[v]) {
      if (deg[v] % 2 == 0)
        s.insert(make_pair(d[v], v));
      else
        s.erase(make_pair(d[v], v));
    }
  }
  for (int v : g[u]) {
    if (!avail[v] || v == par[u]) continue;
    DFS(v);
  }
}
int main() {
  scanf("%d", &n);
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  for (int u = (1); u <= (n); ++u) {
    int p;
    scanf("%d", &p);
    if (p != 0) {
      g[p].push_back(u);
      g[u].push_back(p);
    }
  }
  for (int u = (1); u <= (n); ++u) deg[u] = (int)g[u].size();
  prep(1);
  puts("YES");
  memset(avail, true, sizeof avail);
  while (!s.empty()) {
    int u = s.rbegin()->second;
    DFS(u);
  }
  return 0;
}
