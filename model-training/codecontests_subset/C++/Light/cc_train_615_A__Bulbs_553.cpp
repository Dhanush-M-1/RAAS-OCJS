#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[105] = {0}, m, n, k, i, b;
  scanf("%d %d", &m, &n);
  for (i = 0; i < m; i++) {
    scanf("%d", &k);
    for (int j = 0; j < k; j++) {
      scanf("%d", &b);
      a[b]++;
    }
  }
  for (i = 1; i <= n; i++) {
    if (a[i] == 0) {
      printf("NO\n");
      break;
    }
  }
  if (i == n + 1) printf("YES\n");
}
