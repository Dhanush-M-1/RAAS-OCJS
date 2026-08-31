#include <bits/stdc++.h>
using namespace std;
int n, d;
int main() {
  scanf("%d%d", &n, &d);
  int bal = 0;
  int ans = 0;
  long long sim = 0;
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x == 0) {
      if (bal < 0) {
        ans++;
        bal = d;
        sim += d;
      } else {
        sim = min((long long)bal, sim);
      }
    } else {
      bal += x;
      if (bal > d) sim -= bal - d, bal = d;
      if (sim < 0) {
        ans = -1;
        break;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
