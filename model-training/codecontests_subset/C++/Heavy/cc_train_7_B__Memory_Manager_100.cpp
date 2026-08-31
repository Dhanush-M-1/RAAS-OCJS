#include <bits/stdc++.h>
using namespace std;
char c[20];
int t, m, a[210], b[210], k, n;
int main() {
  scanf("%d%d", &t, &m);
  getchar();
  for (int i1 = 0; i1 < t; i1++) {
    cin >> c;
    if (c[0] == 'a') {
      scanf("%d", &n);
      int i = 0, d = 0, j = 0;
      while (j < m && d < n)
        if (a[j] > 0) {
          i = j + b[j];
          d = 0;
          j = i;
        } else {
          d++;
          j++;
        }
      if (d == n) {
        k++;
        printf("%d\n", k);
        a[i] = k;
        b[i] = n;
      } else
        printf("NULL\n");
      getchar();
    }
    if (c[0] == 'e') {
      scanf("%d", &n);
      int i = 0;
      while (i < m && a[i] != n) i++;
      if (a[i] == n && n != 0) {
        a[i] = 0;
        b[i] = 0;
      } else
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      getchar();
    }
    if (c[0] == 'd') {
      int i = 0, z = 0;
      while (i < m)
        if (a[i] > 0) {
          a[z] = a[i];
          b[z] = b[i];
          if (i != z) {
            a[i] = 0;
            b[i] = 0;
          }
          i += b[z];
          z += b[z];
        } else
          i++;
    }
  }
  return 0;
}
