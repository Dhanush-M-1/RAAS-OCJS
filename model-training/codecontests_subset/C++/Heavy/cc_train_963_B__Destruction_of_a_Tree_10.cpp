#include <bits/stdc++.h>
using namespace std;
int n, p[200003], edge[200003], cnt[200003], level[200003];
vector<int> ve, g[200003];
bool sudah[200003], ya[200003], yy[200003];
void dfs(int now) {
  ya[now] = true;
  ve.push_back(now);
  for (int i : g[now]) {
    if (ya[i]) continue;
    dfs(i);
  }
}
void aa(int now) {
  yy[now] = true;
  for (int i : g[now]) {
    if (yy[i]) continue;
    level[i] = level[now] + 1;
    aa(i);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
    g[p[i]].push_back(i);
    if (p[i] == 0) continue;
    edge[i]++;
    edge[p[i]]++;
    cnt[p[i]]++;
  }
  for (int i = 1; i <= n; i++) {
    if (p[i] == 0) aa(i);
  }
  priority_queue<pair<int, int>> q;
  for (int i = 1; i <= n; i++) {
    if (!cnt[i]) {
      q.push({level[i], i});
      sudah[i] = true;
    }
  }
  while (!q.empty()) {
    auto now = q.top();
    q.pop();
    if (edge[now.second] % 2 == 0) {
      if (!ya[now.second]) {
        dfs(now.second);
        edge[p[now.second]]--;
      }
    }
    if (!sudah[p[now.second]] && p[now.second] != 0) {
      q.push({level[p[now.second]], p[now.second]});
      sudah[p[now.second]] = true;
    }
  }
  if (ve.size() != n) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (int i : ve) cout << i << endl;
}
