#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int n;
int rt, du[maxn], fa[maxn], vis[maxn];
vector<int> Map[maxn];
void del(int u) {
  cout << u << endl;
  for (auto v : Map[u])
    if (!vis[v]) del(v);
}
void dfs(int dq) {
  for (auto x : Map[dq]) dfs(x);
  if (!(du[dq] & 1)) {
    vis[dq] = 1;
    du[fa[dq]]--;
    del(dq);
    return;
  }
}
void work() {
  if (n % 2 == 0) {
    cout << "NO" << endl;
    for (int i = 1; i <= n; i++) {
      int x;
      cin >> x;
    }
    return;
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x == 0) {
      rt = i;
      continue;
    }
    Map[x].push_back(i);
    fa[i] = x;
    ++du[x], ++du[i];
  }
  dfs(rt);
}
int main() {
  while (cin >> n) work();
  return 0;
}
