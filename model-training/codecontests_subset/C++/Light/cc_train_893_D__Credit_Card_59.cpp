#include <bits/stdc++.h>
using namespace std;
const int MX = 1e5 + 7;
int n, d;
int a[MX];
int main() {
  scanf("%d%d", &n, &d);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  int top = 0, base = 0, ans = 0;
  bool flag = 1;
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (top < 0) {
        ans++;
        top = d;
      }
      base = max(0, base);
    } else {
      top += a[i];
      base += a[i];
      top = min(top, d);
      if (base > d) {
        flag = 0;
        break;
      }
    }
  }
  printf("%d\n", flag ? ans : -1);
  return 0;
}
