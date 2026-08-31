#include <bits/stdc++.h>
using namespace std;
int n, m, k, cnt;
struct Edge {
  int u, v;
};
vector<Edge> vE;
vector<int> ans;
const int maxN = 2 * 100000 + 1;
set<int> edge[maxN];
set<int> nodes;
queue<int> Q;
int do_remove() {
  while (!Q.empty()) {
    int s = Q.front();
    Q.pop();
    if (edge[s].size() < k) {
      for (auto iter1 = edge[s].begin(); iter1 != edge[s].end(); iter1++) {
        int t = *iter1;
        edge[t].erase(s);
        if (edge[t].size() < k) Q.push(t);
      }
      edge[s].clear();
      auto iter = nodes.find(s);
      if (iter != nodes.end()) nodes.erase(iter);
    };
  }
  return nodes.size();
}
int main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= n; i++) nodes.insert(i);
  cnt = n;
  for (int i = 0; i < m; i++) {
    int s, t;
    cin >> s >> t;
    vE.push_back(Edge{s, t});
    edge[s].insert(t);
    edge[t].insert(s);
  }
  for (int i = 1; i <= n; i++)
    if (edge[i].size() < k) Q.push(i);
  int ret = do_remove();
  ans.push_back(ret);
  for (int i = vE.size() - 1; i >= 1; i--) {
    int s = vE[i].u;
    int t = vE[i].v;
    edge[s].erase(t);
    edge[t].erase(s);
    Q.push(s);
    Q.push(t);
    int ret = do_remove();
    ans.push_back(ret);
  }
  for (int i = ans.size() - 1; i >= 0; i--) {
    cout << ans[i] << endl;
  }
  return 0;
}
