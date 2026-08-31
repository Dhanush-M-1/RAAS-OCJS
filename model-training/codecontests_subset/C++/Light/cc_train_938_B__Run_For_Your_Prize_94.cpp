#include <bits/stdc++.h>
using namespace std;
int n;
int a[1000006];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  sort(a, a + n);
  int ans = 1000000 - a[0];
  a[n] = 1000000;
  for (int i = 0; i < n; i++) {
    ans = min(ans, max((a[i] - 1), 1000000 - a[i + 1]));
  }
  printf("%d\n", ans);
  return 0;
}
