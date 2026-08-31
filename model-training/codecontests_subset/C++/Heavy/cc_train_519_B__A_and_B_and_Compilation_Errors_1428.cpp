#include <bits/stdc++.h>
using namespace std;
int n, a[100010], x1, x2, b[100010];
int main() {
  scanf("%d", &n);
  memset(a, 0x7fffffff, sizeof(a));
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a, a + n);
  memset(b, 0x7fffffff, sizeof(b));
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &b[i]);
  }
  sort(b, b + n - 1);
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      x1 = a[i];
      break;
    }
  }
  memset(a, 0x7fffffff, sizeof(a));
  for (int i = 0; i < n - 2; i++) scanf("%d", &a[i]);
  sort(a, a + n - 2);
  for (int i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      x2 = b[i];
      break;
    }
  }
  printf("%d\n%d\n", x1, x2);
  return 0;
}
