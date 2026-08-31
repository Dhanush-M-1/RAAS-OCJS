#include <bits/stdc++.h>
using namespace std;
int a, b, c, d, e = 1000000 / 2, t[100005], maxx, minn = 11111111, ans;
int main() {
  scanf("%d", &a);
  for (int x = 0; x < a; x++) {
    scanf("%d", &t[x]);
    if (t[x] <= e) {
      maxx = max(t[x], maxx);
    } else {
      minn = min(t[x], minn);
    }
  }
  int u = 1e6 - minn;
  ans = max(u, maxx - 1);
  printf("%d", ans);
}
