#include <bits/stdc++.h>
using namespace std;
int a[100005];
int main() {
  int n, d, maxval, minval, cnt;
  scanf("%d %d", &n, &d);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
  }
  maxval = 0, minval = 0;
  cnt = 0;
  for (int i = 1; i <= n; ++i) {
    if (!a[i]) {
      if (minval < 0) minval = 0;
      if (maxval < 0) {
        maxval = d;
        cnt++;
      }
    } else {
      minval += a[i];
      maxval += a[i];
      if (minval > d) {
        puts("-1");
        return 0;
      }
      if (maxval > d) {
        maxval = d;
      }
    }
  }
  printf("%d\n", cnt);
  return 0;
}
