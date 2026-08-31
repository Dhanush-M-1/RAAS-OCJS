#include <bits/stdc++.h>
using namespace std;
int v[100005];
int s[100005];
int maxx[100005];
int main() {
  int n, d, i, sold, creditare, ok = 0;
  scanf("%d%d", &n, &d);
  for (i = 1; i <= n; i++) {
    scanf("%d", &v[i]);
    s[i] = s[i - 1] + v[i];
    maxx[i] = -1000000000;
  }
  maxx[n + 1] = -1000000000;
  for (i = n; i > 0; i--) maxx[i] = max(maxx[i + 1], s[i]);
  sold = 0;
  creditare = 0;
  for (i = 1; i <= n; i++) {
    if (v[i] == 0) {
      if (sold < 0) {
        creditare++;
        if (d < maxx[i] - s[i - 1])
          ok = 1;
        else
          sold = d - (maxx[i] - s[i - 1]);
      }
    } else
      sold += v[i];
    if (sold > d) ok = 1;
  }
  if (ok == 1)
    printf("-1");
  else
    printf("%d", creditare);
  return 0;
}
