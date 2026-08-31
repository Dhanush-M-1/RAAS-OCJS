#include <bits/stdc++.h>
using namespace std;
int t, m, n, k, ka;
int q[109], f;
char a[20];
int main() {
  scanf("%d%d", &t, &m);
  for (int i = 0; i < t; i++) {
    scanf("%s", a);
    if (a[0] == 'a') {
      scanf("%d", &n);
      k = f = 0;
      for (int i = 0; i < m; i++) {
        if (q[i] == 0) {
          k++;
          if (k == n) {
            printf("%d\n", ++ka);
            for (int j = i; k; k--, j--) {
              q[j] = ka;
            }
            f = 1;
            break;
          }
        } else
          k = 0;
      }
      if (f == 0) printf("NULL\n");
    } else if (a[0] == 'e') {
      f = 0;
      scanf("%d", &n);
      if (n <= 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        continue;
      }
      for (int i = 0; i < m; i++) {
        if (q[i] == n) {
          f = 1;
          q[i] = 0;
        }
      }
      if (f == 0) printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else {
      k = 0;
      for (int i = 0; i < m; i++)
        if (q[i]) q[k++] = q[i];
      while (k < m) q[k++] = 0;
    }
  }
  return 0;
}
