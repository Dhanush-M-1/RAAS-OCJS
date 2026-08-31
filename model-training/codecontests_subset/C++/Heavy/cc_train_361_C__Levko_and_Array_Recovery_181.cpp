#include <bits/stdc++.h>
using namespace std;
int dod[5005], t[5005];
int bylo[5005][4];
int main() {
  int n, m, a, b, c, d, e, f, g, h;
  scanf("%d%d", &n, &m);
  for (a = 1; a <= n; a++) t[a] = 1000000000;
  for (g = 0; g < m; g++) {
    scanf("%d%d%d%d", &a, &b, &c, &d);
    bylo[g][0] = a;
    bylo[g][1] = b;
    bylo[g][2] = c;
    bylo[g][3] = d;
    if (a == 1) {
      for (e = b; e <= c; e++) dod[e] += d;
    } else {
      for (e = b; e <= c; e++) t[e] -= max(0, t[e] + dod[e] - d);
    }
  }
  for (a = 1; a <= n; a++) dod[a] = 0;
  for (g = 0; g < m; g++) {
    a = bylo[g][0];
    b = bylo[g][1];
    c = bylo[g][2];
    d = bylo[g][3];
    if (a == 1) {
      for (e = b; e <= c; e++) dod[e] += d;
    } else {
      f = 0;
      for (e = b; e <= c; e++) {
        if (dod[e] + t[e] == d) f = 1;
        if (dod[e] + t[e] > d) break;
      }
      if (f == 0 || e <= c) break;
    }
  }
  if (g < m)
    printf("NO");
  else {
    printf("YES\n");
    for (a = 1; a <= n; a++) printf("%d ", t[a]);
  }
  return 0;
}
