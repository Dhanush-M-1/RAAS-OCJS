#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 6;
int n, m, k;
int s[N], c[N];
bool vis[N];
int fir[N];
long long ans = 1e15;
void can(int u) {
  long long rep = 0;
  for (int i = 1; i <= n;) {
    if (fir[i + u] == i) {
      return;
    }
    rep += c[u];
    if (i + u > n) {
      break;
    }
    i = fir[i + u];
  }
  ans = min(ans, rep);
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d", &s[i]);
    vis[s[i] + 1] = 1;
  }
  for (int i = 1; i <= k; i++) {
    scanf("%d", &c[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (vis[i]) {
      fir[i] = fir[i - 1];
    } else {
      fir[i] = i;
    }
  }
  if (!fir[1]) {
    printf("-1\n");
    return 0;
  }
  for (int i = 1; i <= k; i++) {
    can(i);
  }
  if (ans == 1e15) {
    printf("-1\n");
  } else {
    printf("%lld\n", ans);
  }
  return 0;
}
