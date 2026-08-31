#include <bits/stdc++.h>
using namespace std;
long long int a[100100], k[100100];
int v[100100];
void solve(int n) {
  int y, j, i, m, t, p, t1, x, r, q, w;
  long long int z;
  for (i = 0; i < n; i++) scanf("%I64d", &a[i]);
  for (i = 0; i < n; i++) {
    scanf("%I64d", &z);
    a[i] -= z;
  }
  for (i = 1; i < n; i++) {
    scanf("%d%I64d", &v[i], &k[i]);
    v[i]--;
  }
  for (i = n - 1; i >= 1; i--) {
    if (a[i] < -1e18 || a[i] > 1e18) {
      printf("NO");
      return;
    }
    if (a[i] > 0) {
      a[v[i]] += a[i];
    }
    if (a[i] < 0) {
      if ((1e18) / k[i] < -a[i]) {
        printf("NO");
        return;
      }
      a[v[i]] += a[i] * k[i];
      if (a[v[i]] < -1e18 || a[v[i]] > 1e18) {
        printf("NO");
        return;
      }
    }
  }
  if (a[0] >= 0)
    printf("YES");
  else
    printf("NO");
}
int main() {
#pragma warning(disable : 4996);
  int a, b, n;
  while (scanf("%d", &n) != EOF) {
    solve(n);
    printf("\n");
  }
  return 0;
}
