#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5 * 1e5 + 10;
long long t[MAXN], l[MAXN], r[MAXN], num[MAXN];
long long add[MAXN], pre[MAXN];
int m, n;
inline long long min(long long a, long long b) {
  if (a < b) return a;
  return b;
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) pre[i] = 1e9;
  for (int i = 1; i <= m; i++)
    scanf("%I64d%I64d%I64d%I64d", &t[i], &l[i], &r[i], &num[i]);
  memset(add, 0, sizeof(add));
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) add[j] += num[i];
    } else if (t[i] == 2) {
      for (int j = l[i]; j <= r[i]; j++) {
        pre[j] = min(pre[j], num[i] - add[j]);
      }
    }
  }
  memset(add, 0, sizeof(add));
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) add[j] += num[i];
    } else if (t[i] == 2) {
      int ma = -1e9;
      for (int j = l[i]; j <= r[i]; j++) {
        if (ma < pre[j] + add[j]) ma = pre[j] + add[j];
      }
      if (ma != num[i]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i < n; i++) printf("%I64d ", pre[i]);
  printf("%d\n", pre[n]);
  return 0;
}
