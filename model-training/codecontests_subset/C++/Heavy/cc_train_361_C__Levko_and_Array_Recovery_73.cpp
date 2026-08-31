#include <bits/stdc++.h>
int main() {
  int n, m;
  int M[5050] = {0}, R[5050] = {0}, Q[5050][4] = {0};
  int t, l, r, d;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) R[i] = 1000000000;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &t, &l, &r, &d);
    Q[i][0] = t, Q[i][1] = l, Q[i][2] = r, Q[i][3] = d;
    if (t == 1)
      for (int j = l; j <= r; j++) M[j] += d;
    else {
      for (int j = l; j <= r; j++)
        if (R[j] > d - M[j]) R[j] = d - M[j];
    }
  }
  for (int i = 1; i <= n; i++) M[i] = 0;
  bool flag = false;
  for (int i = 1; i <= m; i++) {
    l = Q[i][1], r = Q[i][2], d = Q[i][3];
    if (Q[i][0] == 1)
      for (int j = l; j <= r; j++) M[j] += d;
    else {
      int j;
      for (j = l; j <= r; j++)
        if (R[j] == d - M[j]) break;
      if (j > r) {
        flag = true;
        break;
      }
    }
  }
  printf("%s\n", flag ? "NO" : "YES");
  if (!flag) {
    for (int i = 1; i <= n; i++) printf("%d ", R[i]);
  }
}
