#include <bits/stdc++.h>
using namespace std;
int n, w;
int a[1005];
bool vis[1005];
int b[1005];
int p;
int l;
void dfs(int x) {
  vis[x] = true;
  l++;
  if (x == 0) return;
  dfs(a[x]);
}
int ff;
int m = 0;
int t = 0;
int c[1005];
bool rt[1005];
bool rr[1005];
int main() {
  scanf("%d%d", &n, &w);
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    a[x] = i;
    if (x == 0) rr[i] = true;
  }
  for (int i = 1; i <= n; i++) {
    if (rr[i]) {
      ff = 0;
      if (vis[w] == false) ff = 1;
      l = 0;
      dfs(i);
      if (ff == 1 && vis[w] == true) {
        t = l;
        continue;
      }
      p++;
      b[p] = l - 1;
    }
  }
  l = 0;
  dfs(w);
  l = t - l;
  l++;
  m = 1;
  c[m] = 0;
  for (int i = 1; i <= p; i++) {
    int tmp = m;
    for (int j = 1; j <= tmp; j++) {
      if (rt[c[j] + b[i]]) continue;
      m++;
      c[m] = c[j] + b[i];
      rt[c[j] + b[i]] = true;
    }
  }
  for (int i = 1; i <= m; i++) rt[c[i]] = true;
  for (int i = 0; i <= n; i++) {
    if (rt[i]) {
      printf("%d\n", i + l);
    }
  }
  return 0;
}
