#include <bits/stdc++.h>
using namespace std;
int a[100001], h[100001], ans = 2;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d", &a[i], &h[i]);
  for (int i = 2; i < n; i++) {
    if (a[i] - h[i] > a[i - 1])
      ans++;
    else if (a[i] + h[i] < a[i + 1])
      ans++, a[i] += h[i];
  }
  if (n == 1) return printf("1"), 0;
  printf("%d", ans);
  return 0;
}
