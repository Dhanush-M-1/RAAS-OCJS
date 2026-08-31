#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const double eps = 1e-6;
const int INF = 0x3f3f3f3f;
const int maxn = 2e5 + 11;
int N, M, T, P, Q;
list<int> G[maxn];
bool ok = 1;
int deg[maxn];
bool dele[maxn];
list<int> ans;
void del(int u, int pu) {
  if (dele[u]) return;
  dele[u] = 1;
  ans.push_back(u);
  for (int v : G[u]) {
    if (v == pu) continue;
    del(v, u);
  }
}
void dfs(int u = 1, int pu = -1) {
  for (int v : G[u]) {
    if (v == pu) continue;
    dfs(v, u);
    if (dele[v]) deg[u]--;
  }
  if (deg[u] % 2 == 0) del(u, pu);
}
int main() {
  cin >> N;
  for (int i = 1, j; i <= N; i++) {
    scanf("%d", &j);
    if (j) G[i].push_back(j), G[j].push_back(i);
  }
  for (int i = 1; i <= N; i++) deg[i] = G[i].size();
  dfs();
  if (ans.size() < N)
    puts("NO");
  else {
    puts("YES");
    for (int x : ans) printf("%d\n", x);
  }
  return 0;
}
