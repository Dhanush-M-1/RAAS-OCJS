#include <bits/stdc++.h>
using namespace std;
long long int a[1000005] = {0}, b[100005] = {0}, c[100005] = {0}, n, x, y;
int main() {
  int i, h, j, k, l;
  scanf("%I64d", &n);
  for (i = 0; i < n; i++) scanf("%I64d", &a[i]);
  for (i = 0; i < n - 1; i++) scanf("%I64d", &b[i]);
  for (i = 0; i < n - 2; i++) scanf("%I64d", &c[i]);
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      x = a[i];
      break;
    }
  }
  for (i = 0; i < n - 1; i++) {
    if (c[i] != b[i]) {
      y = b[i];
      break;
    }
  }
  cout << x << endl;
  cout << y << endl;
  return 0;
}
