#include <bits/stdc++.h>
using namespace std;
int a[100005];
int b[100005];
int c[100005];
int n, x, ans1 = -1, ans2 = -1;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) scanf("%d", a + i);
  sort(a, a + n);
  for (int i = 0; i < n - 1; ++i) scanf("%d", b + i);
  sort(b, b + n - 1);
  for (int i = 0; i < n - 2; ++i) scanf("%d", c + i);
  sort(c, c + n - 2);
  for (int i = 0; i < n - 1; ++i)
    if (a[i] != b[i]) {
      ans1 = a[i];
      break;
    }
  for (int i = 0; i < n - 2; ++i)
    if (b[i] != c[i]) {
      ans2 = b[i];
      break;
    }
  if (ans1 == -1) ans1 = a[n - 1];
  if (ans2 == -1) ans2 = b[n - 2];
  printf("%d\n%d", ans1, ans2);
  return 0;
}
