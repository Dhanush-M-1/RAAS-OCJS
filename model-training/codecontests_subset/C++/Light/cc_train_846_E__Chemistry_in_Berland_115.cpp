#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const int N = 1e5 + 4;
vector<pair<int, int> > v[N];
long long dif[N];
long long limit = 1e17 + 4;
void dfs(int node, int par) {
  for (auto it : v[node]) {
    int x = it.first;
    if (x == par) continue;
    dfs(x, node);
    if (dif[x] > 0) dif[node] += dif[x];
  }
  for (auto it : v[node]) {
    int x = it.first, wt = it.second;
    if (x == par) continue;
    if (dif[x] < 0) {
      long long req = -dif[x];
      dif[x] = 0;
      if (req > (limit / wt)) {
        printf("NO");
        exit(0);
      }
      dif[node] -= (wt * req);
      if (dif[node] < -limit) {
        printf("NO");
        exit(0);
      }
    }
  }
}
int main() {
  int n;
  scanf("%d", &n);
  long long a[n + 1], b[n + 1];
  for (int i = 1; i < n + 1; i++) scanf("%lld", &b[i]);
  for (int i = 1; i < n + 1; i++) scanf("%lld", &a[i]);
  for (int i = 1; i < n + 1; i++) dif[i] = b[i] - a[i];
  for (int i = 2; i < n + 1; i++) {
    int par, wt;
    scanf("%d", &par);
    scanf("%d", &wt);
    v[i].emplace_back(par, wt);
    v[par].emplace_back(i, wt);
  }
  dfs(1, -1);
  if (dif[1] >= 0)
    printf("YES");
  else
    printf("NO");
}
