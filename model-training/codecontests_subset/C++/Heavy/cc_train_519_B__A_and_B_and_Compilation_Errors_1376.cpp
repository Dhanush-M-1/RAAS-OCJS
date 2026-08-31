#include <bits/stdc++.h>
using namespace std;
int a1[100010], a2[100010], a3[100010];
int n;
int main() {
  int i, j;
  while (~scanf("%d", &n)) {
    for (i = 0; i < n; i++) {
      scanf("%d", &a1[i]);
    }
    for (i = 0; i < n - 1; i++) {
      scanf("%d", &a2[i]);
    }
    for (i = 0; i < n - 2; i++) {
      scanf("%d", &a3[i]);
    }
    sort(a1, a1 + n);
    sort(a2, a2 + n - 1);
    sort(a3, a3 + n - 2);
    for (i = 0; i < n - 1; i++) {
      if (a1[i] != a2[i]) {
        printf("%d\n", a1[i]);
        break;
      }
    }
    if (i == n - 1) {
      printf("%d\n", a1[i]);
    }
    for (i = 0; i < n - 2; i++) {
      if (a2[i] != a3[i]) {
        printf("%d\n", a2[i]);
        break;
      }
    }
    if (i == n - 2) {
      printf("%d\n", a2[i]);
    }
  }
  return 0;
}
