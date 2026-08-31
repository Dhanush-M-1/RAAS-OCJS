#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int>> node[100001];
bool blocked[100000];
int partition(int v) {
  queue<int> q;
  for (int i = 0; i < node[v].size(); i++) {
    int e = node[v][i].second;
    if (blocked[e] == false) {
      blocked[e] = true;
      q.push(node[v][i].first);
    }
  }
  int t = q.size();
  for (int i = 0; i < t; i++) {
    int top = q.front();
    int neighbour = partition(top);
    if (neighbour == 0)
      q.push(top);
    else
      cout << v << " " << top << " " << neighbour << endl;
    q.pop();
  }
  t = q.size();
  for (int i = 0; i < t - 1; i += 2) {
    cout << q.front() << " " << v << " ";
    q.pop();
    cout << q.front() << endl;
    ;
    q.pop();
  }
  if (t % 2 == 0)
    return 0;
  else
    return q.front();
}
int main() {
  std::ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  if (m % 2) {
    cout << "No solution" << endl;
    return 0;
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    node[u].push_back(make_pair(v, i));
    node[v].push_back(make_pair(u, i));
  }
  memset(blocked, false, sizeof(blocked));
  partition(1);
  return 0;
}
