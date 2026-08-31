#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 3;
int n, m, p[N], d[N];
bool vis[N];
vector<int> g[N], backw[N], vec[N];
void dfs(int x) {
  for (int i : g[x]) {
    if (p[i] == 0) {
      d[i] = d[x] + 1;
      p[i] = x;
      dfs(i);
    } else if (p[x] != i && d[x] > d[i]) {
      backw[x].push_back(i);
    }
  }
}
void solve(int x) {
  vis[x] = 1;
  for (int i : g[x]) {
    if (!vis[i]) {
      solve(i);
    }
  }
  while (vec[x].size() >= 2) {
    int a = vec[x].back();
    vec[x].pop_back();
    int b = vec[x].back();
    vec[x].pop_back();
    cout << a << ' ' << x << ' ' << b << '\n';
  }
  if (vec[x].size() == 1) {
    int a = vec[x].back();
    vec[x].pop_back();
    backw[x].push_back(a);
  }
  while (backw[x].size() >= 2) {
    int a = backw[x].back();
    backw[x].pop_back();
    int b = backw[x].back();
    backw[x].pop_back();
    cout << a << ' ' << x << ' ' << b << '\n';
  }
  if (backw[x].size() == 1) {
    int a = backw[x].back();
    backw[x].pop_back();
    cout << a << ' ' << x << ' ' << p[x] << '\n';
  } else {
    vec[p[x]].push_back(x);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  if (m % 2 == 1) {
    cout << "No solution";
    return 0;
  }
  for (int i = 0; i < m; ++i) {
    int a, b;
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
  }
  p[1] = 1;
  dfs(1);
  solve(1);
}
