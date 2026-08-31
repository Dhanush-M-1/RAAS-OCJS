#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum[105];
  int a[105];
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    if (i)
      sum[i] = sum[i - 1] + a[i];
    else
      sum[i] = a[i];
  }
  int nn = sum[n - 1] / 2;
  bool ok = false;
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (sum[j] - sum[i] == nn) {
        ok = true;
        break;
      }
    }
  }
  if (sum[n - 1] & 1) ok = false;
  if (ok)
    puts("YES");
  else
    puts("NO");
  return 0;
}
