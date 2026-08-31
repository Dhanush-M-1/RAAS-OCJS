#include <bits/stdc++.h>
using namespace std;
int n;
int a[109];
int ans;
int s;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    s += a[i];
    ans = max(ans, a[i]);
  }
  for (;; ans++) {
    if (ans * n - s > s) {
      printf("%d", ans);
      return 0;
    }
  }
  return 0;
}
