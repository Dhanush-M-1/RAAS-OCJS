#include <bits/stdc++.h>
using namespace std;
const int M = 5e3 + 10;
struct TnT {
  int t, l, r, w;
} T[M];
long long a[M], b[M];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d%d", &T[i].t, &T[i].l, &T[i].r, &T[i].w);
  }
  for (int i = 1; i <= n; i++) {
    a[i] = 25 * 100000000000;
  }
  int flag = 0;
  for (int i = m - 1; i >= 0; i--) {
    if (T[i].t == 1) {
      for (int j = T[i].l; j <= T[i].r; j++) {
        a[j] -= T[i].w;
      }
    } else {
      for (int j = T[i].l; j <= T[i].r; j++) {
        a[j] = min(a[j], (long long)T[i].w);
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    b[i] = a[i];
  }
  for (int i = 0; i < m; i++) {
    if (T[i].t == 1) {
      for (int j = T[i].l; j <= T[i].r; j++) {
        b[j] += T[i].w;
      }
    } else {
      int count = 0;
      for (int j = T[i].l; j <= T[i].r; j++) {
        if (b[j] > T[i].w) {
          flag = 1;
          break;
        }
        if (b[j] == T[i].w) count++;
      }
      if (!count) {
        flag = 1;
        break;
      }
    }
    if (flag) break;
  }
  if (flag)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i <= n; i++) {
      a[i] = min((long long)1000000000, a[i]);
      a[i] = max((long long)-1000000000, a[i]);
      printf("%I64d ", a[i]);
    }
    printf("\n");
  }
  return 0;
}
