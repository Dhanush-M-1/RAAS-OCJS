#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> M;
map<pair<int, int>, int>::iterator it, it1;
vector<int> graph[100005];
int dis[100005], visited[100005];
int main() {
  long long x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  int m;
  cin >> m;
  long long a, b, c;
  int cnt = 0;
  for (int i = 0; i < m; i++) {
    cin >> a >> b >> c;
    for (int j = b; j <= c; j++) {
      it = M.find(make_pair(a, j));
      if (it == M.end()) M[make_pair(a, j)] = (++cnt);
    }
  }
  int x, y, z, t;
  for (it = M.begin(); it != M.end(); ++it) {
    x = it->first.first;
    y = it->first.second;
    t = it->second;
    it1 = M.find(make_pair(x - 1, y - 1));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
    it1 = M.find(make_pair(x - 1, y));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
    it1 = M.find(make_pair(x - 1, y + 1));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
    it1 = M.find(make_pair(x, y - 1));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
    it1 = M.find(make_pair(x, y + 1));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
    it1 = M.find(make_pair(x + 1, y - 1));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
    it1 = M.find(make_pair(x + 1, y));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
    it1 = M.find(make_pair(x + 1, y + 1));
    if (it1 != M.end()) {
      z = it1->second;
      graph[t].push_back(z);
    }
  }
  queue<int> q;
  int src, dst;
  src = M[make_pair(x1, y1)];
  dst = M[make_pair(x2, y2)];
  q.push(src);
  visited[src] = 1;
  dis[src] = 0;
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int i = 0; i < graph[u].size(); i++) {
      if (!visited[graph[u][i]]) {
        visited[graph[u][i]] = 1;
        dis[graph[u][i]] = dis[u] + 1;
        q.push(graph[u][i]);
      }
    }
  }
  if (dis[dst] == 0)
    cout << -1;
  else
    cout << dis[dst];
  return 0;
}
