#include <bits/stdc++.h>
using namespace std;
int n, c, a[110], maxn, maxx;
inline void Init() {
  scanf("%d%d", &n, &c);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
}
inline void solve() {
  Init();
  for (int i = 1; i <= n - 1; i++) {
    int tmp = a[i] - c - a[i + 1];
    maxn = max(maxn, tmp);
  }
  printf("%d\n", maxn);
}
int main() {
  solve();
  return 0;
}
