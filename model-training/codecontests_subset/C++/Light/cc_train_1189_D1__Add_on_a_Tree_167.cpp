#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const int N = 3e5 + 5, M = 1e8 + 5, OO = 1000000;
int T, n, m;
int u, v;
int deg[N];
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    scanf("%d %d", &u, &v);
    ++deg[u], ++deg[v];
  }
  for (int i = 1; i <= n; ++i) {
    if (deg[i] == 2) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
}
