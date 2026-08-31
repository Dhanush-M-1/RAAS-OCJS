#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5, M = 1e9 + 9;
const double PI = acos(-1);
int n, dest[N];
vector<int> v[N], ans;
void go(int u, int p) {
  dest[u] = 1;
  ans.push_back(u);
  for (int i = 0; i < v[u].size(); i++) {
    int x = v[u][i];
    if (x != p && !dest[x]) go(x, u);
  }
}
int dfs(int u, int p) {
  int cnt = 0;
  for (int i = 0; i < v[u].size(); i++) {
    int x = v[u][i];
    if (x != p) cnt ^= dfs(x, u);
  }
  if (p != -1) cnt ^= 1;
  if (!cnt) go(u, p);
  return cnt;
}
int main() {
  scanf("%d", &n);
  for (int a, i = 0; i < n; i++) {
    scanf("%d", &a);
    if (a) v[--a].push_back(i), v[i].push_back(a);
  }
  if (!(n & 1)) return puts("NO"), 0;
  dfs(0, -1);
  puts("YES");
  for (int i = 0; i < n; i++) printf("%d\n", ans[i] + 1);
}
