#include <bits/stdc++.h>
using namespace std;
const int maxN = 1e5 + 100;
bool mark[maxN];
vector<pair<int, int> > adj[maxN];
int n, m;
int decompose(int v) {
  queue<int> q;
  while (q.size()) q.pop();
  for (int i = 0; i < adj[v].size(); i++) {
    int e = adj[v][i].second;
    if (!mark[e]) {
      q.push(adj[v][i].first);
      mark[e] = true;
    }
  }
  int t = q.size();
  for (int i = 0; i < t; i++) {
    int nei = q.front();
    int dc = decompose(nei);
    if (dc == -1)
      q.push(nei);
    else
      cout << v << " " << nei << " " << dc << endl;
    q.pop();
  }
  t = q.size();
  for (int i = 0; i < t - 1; i += 2) {
    cout << q.front() << " " << v << " ";
    q.pop();
    cout << q.front() << endl;
    q.pop();
  }
  if (t % 2 == 0) return -1;
  return q.back();
}
void input() {
  cin >> n >> m;
  for (int i = 0, u, v; i < m; i++) {
    cin >> u >> v;
    adj[u].push_back(make_pair(v, i));
    adj[v].push_back(make_pair(u, i));
  }
}
int main() {
  input();
  if (m & 1) {
    cout << "No solution" << endl;
    return 0;
  }
  decompose(1);
  return 0;
}
