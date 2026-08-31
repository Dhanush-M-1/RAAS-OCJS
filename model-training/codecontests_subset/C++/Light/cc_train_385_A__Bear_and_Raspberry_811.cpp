#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, c, max = 0, t;
  scanf("%d%d", &n, &c);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < n - 1; i++) {
    t = a[i] - c;
    if (t < 0)
      continue;
    else {
      t -= a[i + 1];
      if (t > max) max = t;
    }
  }
  printf("%d\n", max);
  return 0;
}
