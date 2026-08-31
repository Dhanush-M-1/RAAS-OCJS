#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
using ll = long long;
int n, m, top;
vector<int> v[N];
ll a[N], val[N];
int deg[N], p[N], vis[N], id[N], mx;
queue<int> q;
void toposort() {
  for (int i = 1; i <= n; i++)
    if (!deg[i]) q.push(i);
  while (!q.empty()) {
    int nd = q.front();
    q.pop();
    p[++top] = nd;
    for (auto &i : v[nd])
      if (!--deg[i]) q.push(i);
  }
  for (int i = n; i > 0; --i) {
    int x = p[i];
    for (auto &j : v[x]) vis[id[j]] = 1;
    while (vis[id[x]]) ++id[x];
    val[id[x]] ^= a[x];
    mx = max(mx, id[x]);
    for (auto &j : v[x]) vis[id[j]] = 0;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= m; i++) {
    int q, w;
    cin >> q >> w;
    v[q].push_back(w);
    ++deg[w];
  }
  toposort();
  int pos = -1;
  for (int i = 0; i <= mx; i++)
    if (val[i]) pos = i;
  if (pos == -1) {
    puts("LOSE");
    return 0;
  }
  cout << "WIN" << endl;
  for (int i = 1; i <= n; i++)
    if (id[i] == pos) {
      if ((val[id[i]] ^ a[i]) > a[i]) continue;
      a[i] ^= val[id[i]];
      val[id[i]] = 0;
      for (auto &j : v[i]) a[j] ^= val[id[j]], val[id[j]] = 0;
    }
  for (int i = 1; i <= n; i++) printf("%lld ", a[i]);
  return 0;
}
