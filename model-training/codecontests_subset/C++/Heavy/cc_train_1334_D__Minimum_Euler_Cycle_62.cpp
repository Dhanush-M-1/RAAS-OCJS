#include <bits/stdc++.h>
using namespace std;
long long t, n, l, r, q;
int main() {
  scanf("%lld", &t);
  while (t--) {
    scanf("%lld%lld%lld", &n, &l, &r);
    long long now = 0;
    q = n - 1;
    bool flag = 0;
    for (int i = 1; i < n - 1; i++) {
      if (now + (n - i) * 2 >= l) {
        q = i;
        break;
      }
      now += 2 * (n - i);
    }
    for (int i = q; i <= n - 1; i++) {
      for (int j = i + 1; j <= n; j++) {
        now++;
        if (now > r) break;
        if (now >= l) printf("%d ", i);
        now++;
        if (now > r) break;
        if (now >= l) printf("%d ", j);
      }
      if (now > r) break;
    }
    now++;
    if (l <= now && now <= r) printf("%d ", 1);
    printf("\n");
  }
  return 0;
}
