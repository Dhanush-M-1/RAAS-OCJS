#include <bits/stdc++.h>
using namespace std;
bool debug = false;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
long long ln, lk, lm;
int a[5105], b[5105];
int t[5105], l[5105], r[5105], x[5105];
int main() {
  scanf("%d%d", &n, &m);
  for (int(i) = 0; (i) < (int)(5105); (i)++) b[i] = (1e9);
  for (int(i) = 1; (i) <= (int)(m); (i)++) {
    scanf("%d%d%d%d", t + i, l + i, r + i, x + i);
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) a[j] += x[i];
    } else {
      for (int j = l[i]; j <= r[i]; j++) b[j] = min(b[j], x[i] - a[j]);
    }
  }
  memset(a, 0, sizeof a);
  for (int(i) = 1; (i) <= (int)(m); (i)++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) a[j] += x[i];
    } else {
      int mm = -((1e9));
      for (int j = l[i]; j <= r[i]; j++) mm = max(mm, b[j] + a[j]);
      if (mm != x[i]) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int(i) = 1; (i) <= (int)(n); (i)++) printf("%d ", b[i]);
  return 0;
}
