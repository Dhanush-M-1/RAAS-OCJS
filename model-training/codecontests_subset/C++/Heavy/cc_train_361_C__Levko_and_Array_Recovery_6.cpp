#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, m, t[5005], l[5005], r[5005], d[5005], add[5005], maxi[5005],
      ans[5005], temp, inf = 1000000000;
  scanf("%lld %lld", &n, &m);
  for (long long int i = 1; i <= n; i++) {
    add[i] = 0;
    maxi[i] = inf;
  }
  for (long long int i = 0; i < m; i++) {
    scanf("%lld %lld %lld %lld", &t[i], &l[i], &r[i], &d[i]);
    if (t[i] == 1)
      for (long long int j = l[i]; j <= r[i]; j++) add[j] += d[i];
    else
      for (long long int j = l[i]; j <= r[i]; j++)
        maxi[j] = min(maxi[j], d[i] - add[j]);
  }
  for (long long int i = 1; i <= n; i++) ans[i] = maxi[i];
  for (long long int i = 0; i < m; i++) {
    if (t[i] == 1)
      for (long long int j = l[i]; j <= r[i]; j++) maxi[j] += d[i];
    else {
      temp = -inf;
      for (long long int j = l[i]; j <= r[i]; j++) temp = max(temp, maxi[j]);
      if (temp != d[i]) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (long long int i = 1; i <= n; i++) {
    if (i > 1) putchar(' ');
    printf("%lld", ans[i]);
  }
  puts("");
  return 0;
}
