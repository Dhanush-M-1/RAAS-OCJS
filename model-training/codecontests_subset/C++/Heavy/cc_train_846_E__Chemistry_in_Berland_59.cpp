#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
long long a[120000];
long long b[120000];
vector<pair<int, long long> > eds[120000];
int n;
long long mul(long long a, long long b) {
  if (a == 0) return 0;
  if (INF / a < b) return INF;
  return a * b;
}
long long dfs1(int v) {
  long long hv = b[v];
  long long nd = a[v];
  for (auto e : eds[v]) {
    long long x = dfs1(e.first);
    if (x < 0) {
      nd = min(INF, nd + mul(-x, e.second));
    } else {
      hv += x;
    }
  }
  return hv - nd;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) scanf("%lld", b + i);
  for (int i = 0; i < n; ++i) scanf("%lld", a + i);
  for (int i = 1; i < n; ++i) {
    int x;
    long long k;
    scanf("%d%lld", &x, &k);
    --x;
    eds[x].push_back(make_pair(i, k));
  }
  long long ans = dfs1(0);
  if (ans < 0)
    cout << "NO\n";
  else
    cout << "YES\n";
  return 0;
}
