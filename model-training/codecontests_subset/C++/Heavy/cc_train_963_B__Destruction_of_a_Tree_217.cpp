#include <bits/stdc++.h>
using namespace std;
const int maxn = 200000 + 10;
vector<int> graph[maxn];
int N, sz[maxn];
void init(int u, int p) {
  sz[u] = 1;
  for (auto &v : graph[u]) {
    if (v == p) continue;
    init(v, u);
    sz[u] += sz[v];
  }
}
void getRes(int u, int p) {
  for (auto &v : graph[u]) {
    if (v == p) continue;
    if (!(sz[v] & 1)) getRes(v, u);
  }
  cout << u << '\n';
  for (auto &v : graph[u]) {
    if (v == p) continue;
    if (sz[v] & 1) getRes(v, u);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> N;
  for (int i = 0; i < N; i++) {
    int v;
    cin >> v;
    if (!v) continue;
    graph[i + 1].push_back(v);
    graph[v].push_back(i + 1);
  }
  if (!(N & 1)) {
    cout << "NO\n";
    return 0;
  }
  init(1, 1);
  cout << "YES\n";
  getRes(1, 1);
  return 0;
}
