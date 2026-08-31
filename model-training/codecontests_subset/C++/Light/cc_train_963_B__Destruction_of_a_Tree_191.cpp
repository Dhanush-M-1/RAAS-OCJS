#include <bits/stdc++.h>
using namespace std;
vector<long long> v[200005];
long long sz[200005];
long long vis[200005];
void pnt(long long n) {
  long long i, j;
  vis[n] = 1;
  long long len = v[n].size();
  for (i = 0; i < len; i++) {
    if (!vis[v[n][i]]) pnt(v[n][i]);
    sz[n] += sz[v[n][i]];
  }
}
void dfs(long long n) {
  long long i, j;
  long long len = v[n].size();
  for (i = 0; i < len; i++) {
    if (sz[v[n][i]] % 2 == 0) dfs(v[n][i]);
  }
  printf("%lld\n", n);
  for (i = 0; i < len; i++) {
    if (sz[v[n][i]] % 2 == 1) dfs(v[n][i]);
  }
}
int main() {
  long long i, j, n, m, t, src;
  for (i = 1; i <= 200000; i++) sz[i] = 1;
  scanf("%lld", &t);
  if (t % 2 == 0) {
    printf("NO\n");
    return 0;
  }
  printf("YES\n");
  for (i = 1; i <= t; i++) {
    scanf("%lld", &n);
    if (n == 0)
      src = i;
    else
      v[n].push_back(i);
  }
  pnt(src);
  dfs(src);
}
