#include <bits/stdc++.h>
using namespace std;
int n, a[100010], b[100010], c[100010];
int main(int argc, char* argv[]) {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  sort(a, a + n);
  for (int i = 0; i < n - 1; i++) scanf("%d", &b[i]);
  sort(b, b + n - 1);
  for (int i = 0; i < n - 2; i++) scanf("%d", &c[i]);
  sort(c, c + n - 2);
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      printf("%d\n", a[i]);
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (b[i] != c[i]) {
      printf("%d\n", b[i]);
      break;
    }
  }
  return 0;
}
