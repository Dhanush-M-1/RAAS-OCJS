#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 100000 + 100;
vector<int> e[N];
bool mark[N], del[N];
int n, cnt, par[N];
void destruct(int v) {
  del[v] = true;
  cout << v + 1 << endl;
  for (int i = 0; i < e[v].size(); i++) {
    int u = e[v][i];
    if (u != par[v] && !del[u]) destruct(u);
  }
}
int dfs(int v) {
  mark[v] = true;
  int s = 0, d = 0;
  for (int i = 0; i < e[v].size(); i++) {
    int u = e[v][i];
    if (!mark[u]) {
      par[u] = v;
      int x = dfs(u);
      s += x;
    }
  }
  if (s % 2) destruct(v);
  return s + 1;
}
int main() {
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (int i = 0; i < n; i++) {
    int v;
    cin >> v;
    if (v == 0) continue;
    v--;
    e[v].push_back(i);
    e[i].push_back(v);
  }
  dfs(0);
  destruct(0);
}
