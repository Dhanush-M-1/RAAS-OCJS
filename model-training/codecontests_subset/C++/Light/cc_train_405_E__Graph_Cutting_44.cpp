#include <bits/stdc++.h>
double pi = acos(-1);
using namespace std;
vector<int> g[100010];
bool visited[100010];
map<pair<int, int>, int> blocked;
int get(int u) {
  if (visited[u]) return -1;
  visited[u] = true;
  stack<int> unpaired;
  vector<int> vs;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    if (!blocked.count(pair<int, int>(u, v)) &&
        !blocked.count(pair<int, int>(v, u))) {
      vs.push_back(v);
      blocked[pair<int, int>(u, v)];
      blocked[pair<int, int>(v, u)];
    }
  }
  if (!vs.size()) return -1;
  for (int i = 0; i < vs.size(); i++) {
    int v = vs[i];
    int res = get(v);
    if (res != -1) {
      printf("%d %d %d\n", u + 1, v + 1, res + 1);
    } else {
      unpaired.push(v);
    }
  }
  while (unpaired.size()) {
    if (unpaired.size() == 1) return unpaired.top();
    printf("%d ", unpaired.top() + 1);
    unpaired.pop();
    printf("%d ", u + 1);
    printf("%d\n", unpaired.top() + 1);
    unpaired.pop();
  }
  return -1;
}
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  if (m % 2 == 1) {
    cout << "No solution" << endl;
    return 0;
  }
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    a--, b--;
    g[a].push_back(b);
    g[b].push_back(a);
  }
  get(0);
  return 0;
}
