#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
int n, m;
const int maxn = 3e5 + 10;
int idx[maxn];
set<int> st[maxn];
int a[maxn];
int vis[maxn];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (1); i < (n + 1); i++) {
    int x;
    scanf("%d", &x);
    a[i] = x;
    idx[x] = i;
  }
  for (int i = (0); i < (m); i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    st[x].insert(y);
    if (y == a[n]) vis[x] = 1;
  }
  for (int i = (n - 1 - 1); i >= (1); i--) {
    if (vis[a[i]] == 0) continue;
    int t = i;
    while (t < n - 1 && st[a[t]].find(a[t + 1]) != st[a[t]].end()) {
      swap(a[t], a[t + 1]);
      t++;
    }
  }
  int ans = 0;
  for (int i = (n - 1); i >= (1); i--) {
    if (vis[a[i]] == 0) break;
    ans++;
  }
  printf("%d", ans);
  return 0;
}
