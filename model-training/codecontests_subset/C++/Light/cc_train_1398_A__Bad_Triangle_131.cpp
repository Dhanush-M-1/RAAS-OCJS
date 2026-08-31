#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n;
    scanf("%d", &n);
    int a[n + 1];
    for (int i = 0; i < n; i++) {
      scanf("%d", &a[i]);
    }
    if (a[0] + a[1] > a[n - 1]) {
      printf("-1\n");
      continue;
    } else {
      printf("%d %d %d\n", 1, 2, n);
    }
  }
  return 0;
}
