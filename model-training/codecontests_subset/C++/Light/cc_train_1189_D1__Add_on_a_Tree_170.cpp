#include <bits/stdc++.h>
using namespace std;
int deg[100005];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    deg[u]++;
    deg[v]++;
  }
  for (int i = 1; i <= n; i++) {
    if (deg[i] == 2) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
  return 0;
}
