#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > adj[200000];
int nxt[200000];
bool v[200000];
vector<int> cycle;
void dfs(int now) {
  v[now] = true;
  while (nxt[now] < adj[now].size()) {
    nxt[now]++;
    dfs(adj[now][nxt[now] - 1].first);
  }
  cycle.push_back(now);
}
void dfs2(int now) {
  v[now] = true;
  for (int i = 0; i < adj[now].size(); i++) {
    int to = adj[now][i].first;
    if (!v[to]) {
      dfs2(to);
    }
  }
}
vector<int> rev(vector<int> a) {
  vector<int> b;
  for (int i = a.size() - 1; i >= 0; i--) {
    b.push_back(a[i]);
  }
  return b;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, s;
  cin >> n >> s;
  vector<int> li;
  vector<int> all;
  for (int i = 0; i < n; i++) {
    nxt[i] = 0;
    v[i] = false;
    int x;
    cin >> x;
    li.push_back(x);
    all.push_back(x);
  }
  sort(all.begin(), all.end());
  map<int, int> m;
  int zone[n];
  int point = 0;
  for (int i = 0; i < n; i++) {
    if (i > 0 && all[i] == all[i - 1]) {
      continue;
    }
    for (int j = i; j < n && all[i] == all[j]; j++) {
      zone[j] = point;
    }
    m[all[i]] = point;
    point++;
  }
  for (int i = 0; i < n; i++) {
    int to = m[li[i]];
    if (to == zone[i]) {
      continue;
    }
    adj[zone[i]].push_back(make_pair(to, i + 1));
  }
  vector<vector<int> > ids;
  map<pair<int, int>, int> m2;
  int point2 = 0;
  for (int i = 0; i < point; i++) {
    for (int j = 0; j < adj[i].size(); j++) {
      int ind = -1;
      if (m2.find(make_pair(i, adj[i][j].first)) != m2.end()) {
        ind = m2[make_pair(i, adj[i][j].first)];
      } else {
        m2[make_pair(i, adj[i][j].first)] = point2;
        ind = point2++;
        vector<int> x;
        ids.push_back(x);
      }
      ids[ind].push_back(adj[i][j].second);
    }
  }
  int comp = 0;
  for (int i = 0; i < point; i++) {
    if (!v[i] && adj[i].size() > 0) {
      dfs2(i);
      comp++;
    }
  }
  for (int i = 0; i < point; i++) {
    v[i] = false;
  }
  vector<vector<int> > ans;
  int tot = 0;
  for (int i = 0; i < point; i++) {
    if (v[i] || adj[i].size() == 0) {
      continue;
    }
    cycle.clear();
    dfs(i);
    cycle.pop_back();
    cycle = rev(cycle);
    tot += (int)cycle.size();
    vector<int> c2;
    for (int j = 0; j < cycle.size(); j++) {
      int nxt = (j + 1) % cycle.size();
      int ind = m2[make_pair(cycle[j], cycle[nxt])];
      c2.push_back(ids[ind].back());
      ids[ind].pop_back();
    }
    ans.push_back(c2);
  }
  for (int i = 0; i < point; i++) {
    assert(nxt[i] == adj[i].size());
  }
  if (tot > s) {
    cout << -1 << endl;
    return 0;
  }
  int should = ans.size();
  int red = (s - tot) - 2;
  int comb = 0;
  if (red > 0) {
    comb = min(red + 2, comp);
  }
  if (comb > 1) {
    vector<vector<int> > lis;
    int sz = ans.size();
    for (int i = 1; i <= comb; i++) {
      lis.push_back(ans.back());
      ans.pop_back();
    }
    vector<int> l1;
    vector<int> l2;
    for (int i = lis.size() - 1; i >= 0; i--) {
      for (int j = 0; j < lis[i].size(); j++) {
        l1.push_back(lis[i][j]);
      }
    }
    for (int i = 0; i < lis.size(); i++) {
      l2.push_back(lis[i][0]);
    }
    ans.push_back(l1);
    ans.push_back(l2);
  }
  cout << ans.size() << endl;
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i].size() << endl;
    cout << ans[i][0];
    for (int j = 1; j < ans[i].size(); j++) {
      cout << " " << ans[i][j];
    }
    cout << endl;
  }
}
