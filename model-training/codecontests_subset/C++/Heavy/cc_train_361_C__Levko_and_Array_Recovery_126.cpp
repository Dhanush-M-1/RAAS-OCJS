#include <bits/stdc++.h>
using namespace std;
const int size = 5e3 + 10;
int t[size], l[size], r[size], x[size], d[size][size], res[size];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < (m); ++i)
    scanf("%d%d%d%d", &(t[i]), &(l[i]), &(r[i]), &(x[i])), r[i]--, l[i]--;
  for (int i = 0; i < (n); ++i) res[i] = 1e9;
  if (t[0] == 1) {
    for (int j = (l[0]); j <= (r[0]); ++j) {
      d[0][j] = x[0];
    }
  }
  for (int i = (1); i < (m); ++i) {
    for (int j = 0; j < (n); ++j) {
      d[i][j] = d[i - 1][j];
    }
    int a = t[i] == 1 ? l[i] : 0;
    int b = t[i] == 1 ? r[i] : n - 1;
    int v = t[i] == 1 ? x[i] : 0;
    for (int j = (a); j <= (b); ++j) {
      d[i][j] += v;
    }
  }
  for (int i = 0; i < (n); ++i) {
    for (int j = 0; j < (m); ++j) {
      if (t[j] == 2 && l[j] <= i && i <= r[j]) {
        res[i] = min(res[i], x[j] - d[j][i]);
      }
    }
  }
  for (int i = 0; i < (m); ++i) {
    if (t[i] == 2) {
      int mx = -1e9;
      for (int j = (l[i]); j <= (r[i]); ++j) {
        mx = max(mx, res[j] + d[i][j]);
      }
      if (mx != x[i]) {
        printf("NO");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 0; i < (n); ++i) printf("%d ", res[i]);
  return 0;
}
