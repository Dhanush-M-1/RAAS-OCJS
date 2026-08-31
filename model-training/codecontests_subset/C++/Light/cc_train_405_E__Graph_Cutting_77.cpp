#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000 * 100 + 5;
int n, m, t = -1;
vector<pair<int, int> > adj[MAXN];
bool mark[MAXN];
void DMP(int v) {
  queue<int> q;
  while (!q.empty()) {
    q.pop();
  }
  for (int i = 0; i < adj[v].size(); i++) {
    if (!mark[adj[v][i].second]) {
      q.push(adj[v][i].first);
      mark[adj[v][i].second] = true;
    }
  }
  int siz = q.size();
  for (int i = 0; i < siz; i++) {
    int u = q.front();
    DMP(u);
    if (t == -1)
      q.push(u);
    else
      cout << v + 1 << " " << u + 1 << " " << t + 1 << endl;
    q.pop();
  }
  int s = q.size();
  for (int i = 0; i < s - 1; i += 2) {
    cout << q.front() + 1 << " ";
    q.pop();
    cout << v + 1 << " ";
    cout << q.front() + 1 << endl;
    q.pop();
  }
  if (s % 2 == 0)
    t = -1;
  else
    t = q.back();
  return;
}
int main() {
  cin >> n >> m;
  for (int i = 0, u, v; i < m; i++) {
    cin >> u >> v;
    u--;
    v--;
    adj[u].push_back(make_pair(v, i));
    adj[v].push_back(make_pair(u, i));
  }
  if (m % 2 == 1) {
    cout << "No solution" << endl;
    return 0;
  }
  DMP(0);
  return 0;
}
