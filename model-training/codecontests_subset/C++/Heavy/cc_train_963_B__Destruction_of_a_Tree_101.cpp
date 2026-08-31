#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int root;
int N, Fa[maxn], degree[maxn], vis[maxn] = {};
vector<int> v[maxn << 1], ans;
stack<int> s;
inline long long read() {
  long long s = 0, f = 1;
  char ch;
  for (; ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') f = -1;
  for (; ch >= '0' && ch <= '9'; ch = getchar())
    s = (s << 3) + (s << 1) + ch - '0';
  return s * f;
}
void dfs(int x, int fa) {
  s.push(x);
  for (int i = 0; i < v[x].size(); ++i) {
    if (v[x][i] == fa) continue;
    dfs(v[x][i], x);
  }
}
void Dfs(int x) {
  ans.push_back(x);
  vis[x] = 1;
  for (int i = 0; i < v[x].size(); ++i) {
    --degree[v[x][i]];
    if (v[x][i] == Fa[x] || vis[v[x][i]]) continue;
    if ((degree[v[x][i]] & 1) == 0) Dfs(v[x][i]);
  }
}
int main() {
  N = read();
  for (int i = 1; i <= N; ++i) {
    Fa[i] = read();
    if (Fa[i])
      v[i].push_back(Fa[i]), v[Fa[i]].push_back(i), ++degree[Fa[i]],
          ++degree[i];
    else
      root = i;
  }
  dfs(root, 0);
  while (!s.empty()) {
    int x = s.top();
    s.pop();
    if (!(degree[x] & 1)) Dfs(x);
  }
  if (ans.size() == N) {
    puts("YES");
    for (int i = 0; i < ans.size(); ++i) printf("%d\n", ans[i]);
  } else
    puts("NO");
}
