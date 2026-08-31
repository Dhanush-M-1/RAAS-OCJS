#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, d, a[100009];
  scanf("%d%d", &n, &d);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int ans = 0;
  int Min = 0, Max = 0;
  for (int i = 0; i < n; i++) {
    if (!a[i]) {
      if (Min < 0) Min = 0;
      if (Max < 0) {
        ans++;
        Max = d;
      }
    } else {
      Min += a[i];
      Max += a[i];
      if (Max > d) Max = d;
      if (Min > d) {
        printf("-1\n");
        return 0;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
