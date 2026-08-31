#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, sr, sl, eu, ele;
  cin >> t;
  while (t--) {
    int n;
    scanf("%d", &n);
    getchar();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        char c = getchar();
        if (i == 1 && j == 2) sr = c - '0';
        if (i == 2 && j == 1) sl = c - '0';
        if (i == n - 1 && j == n) eu = c - '0';
        if (i == n && j == n - 1) ele = c - '0';
      }
      getchar();
    }
    int tot = sr + sl + eu + ele;
    int a = 0, f[2], l[2];
    if (tot == 0 || tot == 4) {
      a = 2;
      f[0] = 1, f[1] = 2;
      l[0] = 2, l[1] = 1;
    } else if (tot == 2) {
      if (sr != sl) {
        if (sr == eu) {
          a = 2;
          f[0] = 2, l[0] = 1;
          f[1] = n - 1, l[1] = n;
        } else {
          a = 2;
          f[0] = 1, l[0] = 2;
          f[1] = n - 1, l[1] = n;
        }
      }
    } else {
      if (sr == sl) {
        if (eu == sl) {
          a = 1;
          f[0] = n - 1;
          l[0] = n;
        } else {
          a = 1;
          f[0] = n;
          l[0] = n - 1;
        }
      } else {
        if (eu == sl) {
          a = 1;
          f[0] = 2;
          l[0] = 1;
        } else {
          a = 1;
          f[0] = 1;
          l[0] = 2;
        }
      }
    }
    printf("%d\n", a);
    for (int i = 0; i < a; i++) {
      printf("%d %d\n", f[i], l[i]);
    }
  }
  return 0;
}
