#include <bits/stdc++.h>
using namespace std;
const int mx = 2e5 + 10, cut = 700;
int n, m, k, cnt[mx], lv, x[mx], y[mx], dead[mx];
vector<pair<int, int> > adj[mx];
vector<int> res;
void er(int a, int b) {
  auto it = lower_bound(adj[a].begin(), adj[a].end(), make_pair(b, 0));
  if (it->second) return;
  it->second = 1;
  cnt[a]--;
}
void f(int h) {
  if (cnt[h] >= k || dead[h]) return;
  dead[h] = 1;
  lv--;
  for (auto &it : adj[h])
    if (!it.second) er(it.first, h);
  for (auto &it : adj[h])
    if (!it.second) f(it.first);
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d%d", x + i, y + i);
    cnt[x[i]]++;
    cnt[y[i]]++;
    adj[x[i]].push_back({y[i], 0});
    adj[y[i]].push_back({x[i], 0});
  }
  for (int i = 1; i <= n; i++) sort(adj[i].begin(), adj[i].end());
  lv = n;
  for (int i = 1; i <= n; i++) f(i);
  for (int i = m; i--;) {
    res.push_back(lv);
    er(x[i], y[i]);
    er(y[i], x[i]);
    f(x[i]);
    f(y[i]);
  }
  reverse(res.begin(), res.end());
  for (auto &it : res) printf("%d\n", it);
  return 0;
}
