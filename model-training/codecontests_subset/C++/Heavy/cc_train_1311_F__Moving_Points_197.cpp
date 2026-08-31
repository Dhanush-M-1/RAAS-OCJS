#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const double EPS = 1e-6;
const int INF = 0x3f3f3f3f;
const int MAXN = 200005;
int n, m;
int maps[MAXN];
long long sum[MAXN][2];
pair<long long, long long> node[MAXN];
inline long long lowbit(long long x) { return x & (-x); }
void add(long long id, long long x) {
  while (id <= m) {
    sum[id][0]++;
    sum[id][1] += x;
    id += lowbit(id);
  }
}
long long query(int id, int op) {
  long long ans = 0;
  while (id > 0) {
    ans += sum[id][op];
    id -= lowbit(id);
  }
  return ans;
}
void Solve() {
  sort(node + 1, node + n + 1);
  sort(maps + 1, maps + n + 1);
  m = unique(maps + 1, maps + n + 1) - (maps + 1);
  long long ans = 0, id = -1;
  for (int i = 1; i <= n; ++i) {
    id = lower_bound(maps + 1, maps + m + 1, node[i].second) - maps;
    ans += node[i].first * query(id, 0) - query(id, 1);
    add(id, node[i].first);
  }
  cout << ans << endl;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> node[i].first;
  for (int i = 1; i <= n; ++i) {
    cin >> node[i].second;
    maps[i] = node[i].second;
  }
  Solve();
  return 0;
}
