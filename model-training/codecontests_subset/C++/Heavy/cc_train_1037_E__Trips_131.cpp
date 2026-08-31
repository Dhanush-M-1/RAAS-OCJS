#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
vector<pair<int, int> > e;
set<pair<int, int> > f;
vector<int> adj[MAXN];
int n, m, k, deg[MAXN], num;
bool kicked[MAXN];
vector<int> ans;
int main() {
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 0; i < m; ++i) {
    int u, v;
    scanf("%d %d", &u, &v);
    e.push_back(pair<int, int>(u, v));
    f.insert(pair<int, int>(u, v));
    adj[u].push_back(v);
    adj[v].push_back(u);
    deg[u]++;
    deg[v]++;
  }
  num = n;
  queue<int> q;
  for (int i = 1; i <= n; ++i) {
    if (deg[i] < k) {
      q.push(i);
    }
  }
  while (!q.empty()) {
    int top = q.front();
    q.pop();
    if (kicked[top]) continue;
    kicked[top] = true;
    num--;
    for (int j : adj[top])
      if (f.count(pair<int, int>(top, j)) + f.count(pair<int, int>(j, top)) ==
          1) {
        deg[j]--;
        f.erase(pair<int, int>(j, top));
        f.erase(pair<int, int>(top, j));
        if (deg[j] < k) {
          q.push(j);
        }
      }
  }
  reverse(e.begin(), e.end());
  for (pair<int, int> i : e) {
    ans.push_back(num);
    if (f.count(i) == 0) continue;
    deg[i.first]--;
    deg[i.second]--;
    f.erase(i);
    queue<int> q;
    if (deg[i.first] < k && !kicked[i.first]) q.push(i.first);
    if (deg[i.second] < k && !kicked[i.second]) q.push(i.second);
    while (!q.empty()) {
      int top = q.front();
      q.pop();
      if (kicked[top]) continue;
      kicked[top] = true;
      num--;
      for (int j : adj[top])
        if (f.count(pair<int, int>(top, j)) + f.count(pair<int, int>(j, top)) ==
            1) {
          deg[j]--;
          f.erase(pair<int, int>(j, top));
          f.erase(pair<int, int>(top, j));
          if (deg[j] < k) {
            q.push(j);
          }
        }
    }
  }
  reverse(ans.begin(), ans.end());
  for (int i : ans) printf("%d\n", i);
}
