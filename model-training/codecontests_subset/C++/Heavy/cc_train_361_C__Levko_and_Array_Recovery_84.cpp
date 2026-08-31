#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5 * (1e3) + 10;
long long arr[MAXN], tmp[MAXN], l[MAXN], r[MAXN], t[MAXN], num[MAXN];
int m, n;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) arr[i] = 1e9;
  for (int i = 1; i <= m; i++)
    scanf("%I64d%I64d%I64d%I64d", &t[i], &l[i], &r[i], &num[i]);
  for (int i = m; i > 0; i--) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) arr[j] -= num[i];
    } else if (t[i] == 2) {
      for (int j = l[i]; j <= r[i]; j++) {
        if (arr[j] > num[i]) arr[j] = num[i];
      }
    }
  }
  for (int i = 1; i <= n; i++) tmp[i] = arr[i];
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) tmp[j] += num[i];
    else if (t[i] == 2) {
      long long max = -1e9;
      for (int j = l[i]; j <= r[i]; j++)
        if (max < tmp[j]) max = tmp[j];
      if (max != num[i]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  for (int i = 1; i <= n; i++)
    if (arr[i] > 1e9 || arr[i] < -1e9) arr[i] = 0;
  printf("YES\n");
  for (int i = 1; i < n; i++) printf("%I64d ", arr[i]);
  printf("%I64d\n", arr[n]);
  return 0;
}
