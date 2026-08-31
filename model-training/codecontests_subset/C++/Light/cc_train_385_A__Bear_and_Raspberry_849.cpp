#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, c, ans = 0;
  scanf("%d%d", &n, &c);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < n - 1; i++) {
    ans = max(a[i] - a[i + 1] - c, ans);
  }
  printf("%d\n", ans);
  return 0;
}
