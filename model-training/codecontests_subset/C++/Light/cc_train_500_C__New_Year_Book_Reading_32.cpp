#include <bits/stdc++.h>
using namespace std;
int d[2100], l[2000], vi[2000], cc[2000], cnt;
int main() {
  int n, t, i, j, k, m;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; ++i) scanf("%d", &d[i]);
  for (i = 0; i < m; ++i) scanf("%d", &l[i]);
  for (i = 0; i < m; ++i) {
    if (vi[l[i]] == 0) {
      vi[l[i]]++;
      cc[cnt++] = l[i];
    }
  }
  int sum = 0, z = 0;
  for (i = 0; i < m; ++i) {
    z = 0;
    for (j = 0; j < cnt; ++j) {
      if (cc[j] == l[i]) break;
      z += d[cc[j]];
    }
    sum += z;
    for (k = j; k > 0; --k) cc[k] = cc[k - 1];
    cc[0] = l[i];
  }
  cout << sum << endl;
  return 0;
}
