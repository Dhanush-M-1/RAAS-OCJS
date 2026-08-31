#include <bits/stdc++.h>
bool ch[5000] = {0};
bool ex, ans = true;
int a[5000] = {0}, b[5000] = {0};
int c[5000][5000] = {0}, ccnt[5000] = {0};
int count[5000] = {0};
int n, m, cnt = 0;
int main() {
  int i, j, k;
  int t, l, r, d;
  scanf("%d%d", &n, &m);
  for (i = 0; i < m; i++) {
    scanf("%d%d%d%d", &t, &l, &r, &d);
    if (t == 1) {
      for (j = l - 1; j < r; j++) b[j] += d;
    } else {
      cnt++;
      ex = false;
      for (j = l - 1; j < r; j++) {
        if (!ch[j]) {
          a[j] = d - b[j];
          c[j][0] = cnt, ccnt[j] = 1;
          count[cnt]++;
          ch[j] = true;
          ex = true;
        } else {
          if (a[j] > d - b[j]) {
            for (k = 0; k < ccnt[j]; k++) {
              count[c[j][k]]--;
              if (count[c[j][k]] == 0) {
                ans = false;
                break;
              }
            }
            if (!ans) break;
            a[j] = d - b[j];
            c[j][0] = cnt, ccnt[j] = 1;
            count[c[j][0]]++;
            ex = true;
          } else if (a[j] == d - b[j]) {
            c[j][ccnt[j]++] = cnt;
            count[cnt]++;
            ex = true;
          }
        }
      }
      if (!ex || !ans) {
        ans = false;
        break;
      }
    }
  }
  if (!ans) {
    printf("NO");
  } else {
    printf("YES\n");
    for (i = 0; i < n; i++) printf("%d ", a[i]);
  }
  return 0;
}
