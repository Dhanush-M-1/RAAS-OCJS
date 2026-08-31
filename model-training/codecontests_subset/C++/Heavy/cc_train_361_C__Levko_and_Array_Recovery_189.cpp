#include <bits/stdc++.h>
using namespace std;
int num[5000], flag[5000], a[5000], b[5000], c[5000], te[5000];
int main() {
  int n, m;
  while (scanf("%d %d", &n, &m) != EOF) {
    int i, j;
    for (i = 0; i <= n; i++) num[i] = 1000000009;
    for (i = 1; i <= m; i++)
      scanf("%d %d %d %d", &flag[i], &a[i], &b[i], &c[i]);
    for (i = m; i >= 1; i--) {
      if (flag[i] == 1) {
        for (j = a[i]; j <= b[i]; j++) {
          if (num[j] != 1000000009) num[j] -= c[i];
        }
      } else {
        for (j = a[i]; j <= b[i]; j++) {
          num[j] = min(num[j], c[i]);
        }
      }
    }
    for (i = 1; i <= n; i++) te[i] = num[i];
    for (i = 1; i <= m; i++) {
      if (flag[i] == 1) {
        for (j = a[i]; j <= b[i]; j++) te[j] += c[i];
      } else {
        int temp = te[a[i]];
        for (j = a[i] + 1; j <= b[i]; j++) temp = max(temp, te[j]);
        if (temp != c[i]) break;
      }
    }
    if (i <= m) {
      printf("NO\n");
    } else {
      printf("YES\n");
      for (i = 1; i <= n; i++) {
        if (i != 1) printf(" ");
        if (num[i] == 1000000009) num[i] -= 1000000;
        printf("%d", num[i]);
      }
    }
    printf("\n");
  }
  return 0;
}
